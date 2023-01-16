package com.example.toy1.service;

import com.example.toy1.domain.Article;
import com.example.toy1.domain.User;
import com.example.toy1.dto.article.ArticleDto;
import com.example.toy1.dto.article.ArticleListDto;
import com.example.toy1.dto.article.ArticleRequestDto;
import com.example.toy1.dto.exception.user.UserNotFoundException;
import com.example.toy1.repository.ArticleRepository;
import com.example.toy1.repository.UserRepository;
import com.example.toy1.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;
    private final UserService userService;

    @Override
    public List<ArticleDto> getArticleList() {
        List<ArticleDto> list = articleRepository.findAll().stream().map(m-> ArticleDto.from(m))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public void createArticle(ArticleRequestDto articleRequestDto) {
        User user = userService.getMyInfo();
        Article article = Article.builder()
                .title(articleRequestDto.getTitle())
                .content(articleRequestDto.getContent())
                .tag(articleRequestDto.getTag())
                .view(0)
                .user(user)
                .build();
        articleRepository.save(article);
    }

    @Override
    public void updateArticle(Long uid, ArticleRequestDto articleRequestDto) {
        Optional<Article> article = articleRepository.findById(uid);
        if(article.isPresent()){
            if(article.get().getUser() == userService.getMyInfo()){
                Article newArticle = Article.builder()
                        .uid(uid)
                        .title(articleRequestDto.getTitle())
                        .content(articleRequestDto.getContent())
                        .tag(articleRequestDto.getTag())
                        .view(article.get().getView())
                        .user(userService.getMyInfo())
                        .upDate(LocalDateTime.now())
                        .build();
                articleRepository.save(newArticle);
            }

        }
    }
}
