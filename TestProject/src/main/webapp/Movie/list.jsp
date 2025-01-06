<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.movie.*"%>
<%
	MovieSystem ms=new MovieSystem();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<%
			String curpage=request.getParameter("curpage");
			Movie[] movies=ms.movieListData(Integer.valueOf(curpage));
			for(Movie ma:movies)
			{
				
				out.println("<li>"+ma.no+"."+ma.title+"</li>");
			}
		%>
	</ul>

</body>
</html>