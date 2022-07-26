package com.ll.exam.article;

import com.ll.exam.article.Dto.ArticleDto;

import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public long write(String title, String body) {
        return articleRepository.write(title, body);
    }

    public List<ArticleDto> getList() {
        return articleRepository.getList();
    }
}
