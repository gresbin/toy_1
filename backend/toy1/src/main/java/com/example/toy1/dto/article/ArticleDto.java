package com.example.toy1.dto.article;

import com.example.toy1.domain.Article;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@Builder
@ApiModel(value = "ArticleResponseDto",description = "게시글 정보 Dto")
public class ArticleDto {
    private long uid;
    private String title;
    private String date;
    private String tag;
    private int view;
    private String nickname;

    public static ArticleDto from(Article article){
        String theDate;
        if( article.getUpDate() == null ){
            theDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(article.getRegDate()).toString();
        } else {
            theDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(article.getUpDate()).toString();
        }

        return ArticleDto.builder()
                .uid(article.getUid())
                .title(article.getTitle())
                .date(theDate)
                .tag(article.getTag().toString())
                .view(article.getView())
                .nickname(article.getUser().getNickname())
                .build();
    }
}
