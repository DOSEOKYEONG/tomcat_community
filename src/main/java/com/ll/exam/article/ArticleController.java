package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.Dto.ArticleDto;

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
        ArticleDto articleDto = articleService.findById(id);
        rq.setAttr("article", articleDto);
        rq.view("usr/article/detail");
    }

    public void showDetail(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.appendBody("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.appendBody("해당 글이 존재하지 않습니다");
            return;
        }

        rq.setAttr("article", articleDto);
        rq.view("usr/article/detail");
    }

    public void doDelete(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);
        if (id == 0) {
            rq.appendBody("번호를 입력해주세요.");
            return;
        }

        id = articleService.delete(id);
        if (id == 0) {
            rq.appendBody("해당 게시글이 존재하지 않습니다.");
        } else {
            rq.appendBody("%d번 게시물이 삭제 되었습니다.".formatted(id));
        }
    }

    public void showModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);
        if (id == 0) {
            rq.appendBody("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        rq.setAttr("articleDto", articleDto);
        rq.view("usr/article/modify");
        System.out.println(articleDto.toString());
    }

    public void doModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        if (id == 0) {
            rq.appendBody("번호를 입력해주세요.");
            return;
        }

        articleService.modify(id, title, body);

        ArticleDto articleDto = articleService.findById(id);

        rq.setAttr("article", articleDto);
        rq.view("usr/article/detail");
    }
}
