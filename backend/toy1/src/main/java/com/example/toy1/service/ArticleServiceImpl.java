package com.example.toy1.service;

import com.example.toy1.domain.Article;
import com.example.toy1.domain.User;
import com.example.toy1.dto.article.ArticleDto;
import com.example.toy1.dto.article.ArticleRequestDto;
import com.example.toy1.dto.exception.article.PostNotFoundException;
import com.example.toy1.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        String regDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()).toString();
        Article article = Article.builder()
                .title(articleRequestDto.getTitle())
                .content(articleRequestDto.getContent())
                .tag(articleRequestDto.getTag())
                .regDate(regDate)
                .view(0)
                .user(user)
                .build();
        articleRepository.save(article);
    }

    @Override
    public void updateArticle(Long uid, ArticleRequestDto articleRequestDto) {
        Optional<Article> article = articleRepository.findById(uid);
        if(article.isPresent()){
            String upDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()).toString();
            if(article.get().getUser() == userService.getMyInfo()){
                Article newArticle = Article.builder()
                        .uid(uid)
                        .title(articleRequestDto.getTitle())
                        .content(articleRequestDto.getContent())
                        .tag(articleRequestDto.getTag())
                        .view(article.get().getView())
                        .user(userService.getMyInfo())
                        .upDate(upDate)
                        .build();
                articleRepository.save(newArticle);
            }

        }
    }

    @Override
    public ArticleDto getArticle(Long uid) {
        Article article = articleRepository.findById(uid).orElseThrow(PostNotFoundException::new);

        return ArticleDto.from(article);
    }
}
