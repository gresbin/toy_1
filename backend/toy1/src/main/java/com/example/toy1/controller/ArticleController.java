package com.example.toy1.controller;

import com.example.toy1.dto.article.ArticleListDto;
import com.example.toy1.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/articleList")
    @ApiOperation(value = "게시글 리스트 조회", notes = "게시글 리스트를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ArticleListDto.class)
    })
    public ResponseEntity<?> getArticleList(){
        return new ResponseEntity<>(articleService.getArticleList(), HttpStatus.OK);
    }


}
