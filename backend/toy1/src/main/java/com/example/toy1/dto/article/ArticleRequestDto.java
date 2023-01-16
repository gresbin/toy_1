package com.example.toy1.dto.article;

import com.example.toy1.domain.Article;
import com.example.toy1.domain.User;
import com.example.toy1.domain.enums.ArticleTag;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@ApiModel(value = "ArticleRequestDto", description = "게시글 작성 요청 Dto")
public class ArticleRequestDto {
    @ApiModelProperty(name = "title")
    private String title;
    @ApiModelProperty(name = "content")
    private String content;
    @ApiModelProperty(name = "tag")
    private ArticleTag tag;

}
