<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<h1>게시글 작성</h1>
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
<form method="post" onsubmit="ArticleSave__submitForm(this); return false;">
    <div>
        <span>제목</span>
        <div>
            <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요">
        </div>
    </div>

    <div>
        <span>내용</span>
        <div>
            <input title="body" type="text" maxlength="3000" placeholder="내용을 입력해주세요">
        </div>
    </div>

    <div>
        <span>작성</span>
        <div>
            <input type="submit" value="작성" >
        </div>
    </div>
</form>
</body>
</html>