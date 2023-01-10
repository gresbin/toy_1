package com.example.toy1.dto.article;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@ApiModel(value = "ArticleListDto", description = "게시글 리스트 Dto")
public class ArticleListDto {
    List<ArticleDto> list;

    public static ArticleListDto from (List<ArticleDto> articleList){
        return ArticleListDto.builder()
                .list(articleList)
                .build();
    }
}
