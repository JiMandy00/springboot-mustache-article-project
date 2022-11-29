package com.mustache.article.controller;

import com.mustache.article.dto.ArticleDto;
import com.mustache.article.entity.Article;
import com.mustache.article.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/new")
    public String createPage() {
        return "articles/new";
    }

    @PostMapping("")
    public String add(ArticleDto articleDto) {
        log.info(articleDto.getTitle());
        return ""; // 임시
    }

    @GetMapping("/{id}")
    public String selectString(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);
        if (!optArticle.isEmpty()) {
            model.addAttribute("article", optArticle.get());
            return "articles/show";
        } else {
            return "articles/error";
        }
    }

}
