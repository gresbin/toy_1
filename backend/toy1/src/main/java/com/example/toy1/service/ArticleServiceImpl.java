package com.example.toy1.service;

import com.example.toy1.dto.article.ArticleDto;
import com.example.toy1.dto.article.ArticleListDto;
import com.example.toy1.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;

    @Override
    public List<ArticleDto> getArticleList() {
        List<ArticleDto> list = articleRepository.findAll().stream().map(m-> ArticleDto.from(m))
                .collect(Collectors.toList());
        return list;
    }
}
