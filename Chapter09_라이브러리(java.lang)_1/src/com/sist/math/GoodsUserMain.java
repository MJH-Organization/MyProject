package com.sist.math;

public class GoodsUserMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 객체 생성
        GoodsDAO dao=GoodsDAO.newInstance();    // 싱글톤 패턴
        // newInstance(), getInstance()
        // Calendar cal=Calendar.getInstance();
        int count=dao.goodsTotalPage();
        int totalpage=(int)(Math.ceil(count/15.0));
        System.out.println("총페이지: " + totalpage);
    }

}

