<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.exam.article.Dto.ArticleDto" %>

<%
    List<ArticleDto> articleDtoList = (List<ArticleDto>)request.getAttribute("articleDtoList");
%>

<h1>게시물 리스트</h1>

<ul>
    <% for ( ArticleDto article : articleDtoList ) { %>
    <li><%=article.getId()%>. <%=article.getTitle()%></li>
    <% } %>
</ul>