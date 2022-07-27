<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.exam.article.Dto.ArticleDto" %>

<%
    ArticleDto article = (ArticleDto) request.getAttribute("articleDto");
%>

<h1>게시물 수정페이지</h1>

<script>
    function ArticleSave__submitForm(form){
        form.title.value.trim();
        form.body.value.trim();
        if (form.title.value.length == 0) { // 제목 검사
            alert("제목을 입력해주세요");
            form.title.focus();
            return;
        }
        if (form.body.value.length == 0) { // 내용 검사
            alert("내용을 입력해주세요");
            form.body.focus();
            return;
        }
        form.submit();
    }
</script>
<form method="POST" onsubmit="ArticleSave__submitForm(this); return false;">
    <div>
        <span>번호 : <%=article.getId()%></span>
    </div>
    <div>
        <span>제목</span>
        <div>
            <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요" value=<%=article.getTitle()%>>
        </div>
    </div>

    <div>
        <span>내용</span>
        <div>
            <input name="body" type="text" maxlength="3000" placeholder="내용을 입력해주세요" value=<%=article.getBody()%>>
        </div>
    </div>

    <div>
        <span>수정</span>
        <div>
            <input type="submit" value="수정" >
        </div>
    </div>
</form>
</body>
</html>