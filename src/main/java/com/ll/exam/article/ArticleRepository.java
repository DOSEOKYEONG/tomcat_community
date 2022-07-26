package com.ll.exam.article;

import com.ll.exam.article.Dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private static List<ArticleDto> articleDtoList;
    private static long lastId;

    static {
        articleDtoList = new ArrayList<>();
        lastId = 0;
    }
    public ArticleRepository() {
    }

    public long write(String title, String body) {
        long id = ++lastId;
        ArticleDto articleDto = new ArticleDto(id, title, body);
        articleDtoList.add(articleDto);

        return id;
    }

    public List<ArticleDto> getList() {
        return articleDtoList;
    }
}
