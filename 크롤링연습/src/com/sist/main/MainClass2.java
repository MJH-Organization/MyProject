package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.*;
import com.sist.dao.*;
import com.sist.vo.*;

public class MainClass2 {
	private Connection conn;
	private PreparedStatement ps;
	
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    	FoodDAO dao=FoodDAO.newInstance();
	  	for(int i=1; i<=347;i++)
	  	{
	  		try {
	  			System.out.println("======================"+i+" 번째 페이지 =====================");
		  		Document doc=Jsoup.connect("https://www.menupan.com/restaurant/bestrest/bestrest.asp?page="+i+"&trec=8655&pt=rt").get();
//		  		System.out.println(doc);
		  		Elements links=doc.select("div.rankingList p.listName a");
		  		Document doc2;
		  		for(Element el:links)
		  		{
			  		try {
//			  			System.out.println("-----------------------------------------------");
			  			String href="https://www.menupan.com"+el.attr("href");
//			  			System.out.println(href);
			  			doc2=Jsoup.connect(href).get();
			  			FoodVO vo=new FoodVO();
			  			String name=doc2.selectFirst("dl.restName dd.name").text();
//			  			System.out.println(name.substring(0,name.indexOf("[")).trim());
			  			vo.setName(name.substring(0,name.indexOf("[")).trim());
			  			String type=doc2.selectFirst("dl.restType dd.type").text();
//			  			System.out.println(type);
			  			vo.setType(type);
			  			String phone=doc2.selectFirst("dl.restTel dd.tel1").text();
//			  			System.out.println(phone);
			  			vo.setPhone(phone);
			  			String address=doc2.selectFirst("dl.restAdd dd.add1").text();
//			  			System.out.println(address);
			  			vo.setAddress(address);
			  			String score=doc2.selectFirst("dl.restGrade span.total").text();
//			  			System.out.println(score);
			  			vo.setScore(Double.parseDouble(score));
			  			Elements themeEls=doc2.select("dl.restTheme dd.Theme a");
			  			String theme="";
			  			for(Element themeEl:themeEls)
			  			{
			  				theme += themeEl.text()+",";
			  			}
			  			if (themeEls.size()>0)
			  			{
				  			theme=theme.substring(0,theme.length()-1);
			  			}
			  			else
			  			{
			  				theme=" ";
			  			}
//			  			System.out.println(theme);
			  			vo.setTheme(theme);
			  			String price=doc2.selectFirst("dl.restMood div.restPrice p.price").text();
//			  			System.out.println(price);
			  			vo.setPrice(price);
	
			  			String poster="";
			  			String images="";
			  			Elements imgEls=doc2.select("div.areaThumbnail a img");
			  			Element img;
			  			for(int j=0; j<imgEls.size();j++)
			  			{
			  				img=doc2.selectFirst("div.areaThumbnail img#restphoto_img_"+j);
			  				if(img!=null)
			  				{
			  					if(j==0)
			  					{
			  						poster=img.attr("src");
			  						images+=img.attr("src");
			  					}
			  					else
			  					{
			  						images+="|"+img.attr("src");
			  					}
			  				}
			  				else
			  				{
			  					break;
			  				}
			  			}
//			  			System.out.println(poster);
			  			vo.setPoster(poster);
//			  			System.out.println(images);
			  			vo.setImages(images);
			  			
			  			String time=doc2.selectFirst("div.infoTable dd.txt2").text();
//			  			System.out.println(time);
			  			vo.setTime(time);
			  			Elements parkingEls=doc2.select("div.infoTable ul.tableLR dl");
			  			String parking="";
			  			for(Element parkingEl:parkingEls)
			  			{
			  				if(parkingEl.selectFirst("dt")==null)
			  				{
			  					continue;
			  				}
			  				if("주차".equals(parkingEl.selectFirst("dt").text()))
							{
								parking=parkingEl.selectFirst("dd").text();
								break;
							}
			  			}
//			  			System.out.println(parking);
			  			vo.setParking(parking);
			  			String content=doc2.selectFirst("div.infoTable ul.tableBottom div#info_ps_f").text();
//			  			System.out.println(content);
			  			vo.setContent(content);
			  			dao.insertFoodData(vo);
//			  			System.out.println("-----------------------------------------------");
			  		}catch(Exception ex) 
			  		{ 
			  			ex.printStackTrace();
			  		}
		  		}
		  		System.out.println("======================"+i+" 번째 페이지 =====================");
		  	}catch(Exception ex) 
	  		{ 
	  			ex.printStackTrace();
	  		}
	  	}
    }

}
