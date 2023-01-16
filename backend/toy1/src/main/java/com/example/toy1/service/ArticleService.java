package com.example.toy1.service;

import com.example.toy1.dto.article.ArticleDto;
import com.example.toy1.dto.article.ArticleRequestDto;

import java.util.List;

public interface ArticleService {

    List<ArticleDto> getArticleList();

    void createArticle(ArticleRequestDto articleRequestDto);

    void updateArticle(Long uid, ArticleRequestDto articleRequestDto);
}
