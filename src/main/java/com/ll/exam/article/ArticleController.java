package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.Dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    private ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void showList(Rq rq) {
        List<ArticleDto> articleDtoList = articleService.getList();

        rq.setAttr("articleDtoList", articleDtoList);
        rq.view("/usr/article/list");
    }

    public void showWrite(Rq rq) {
        rq.view("/usr/article/write");
    }

    public void doWrite(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        long id = articleService.write(title, body);
    }

}
