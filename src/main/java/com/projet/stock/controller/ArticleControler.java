package com.projet.stock.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.stock.entites.Article;
import com.projet.stock.exception.RessourceNotFoundException;
import com.projet.stock.service.ArticleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ArticleControler {
	@Autowired
	ArticleService articleService ;
	
	@GetMapping("/article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable (value = "id")Long id) throws RessourceNotFoundException {
		return articleService.getArticleById(id);
	}
	@PostMapping("/add")
	public Article saveArticle(@RequestBody Article Article) {
		return articleService.saveArticle(Article);
	}
	 @DeleteMapping("/article/{id}")
	 public Map<String, Boolean> delateArticle(@PathVariable (value = "id") Long id) throws RessourceNotFoundException {
			return articleService.delateArticle(id);
		}

	 @PutMapping("/articles/{id}")
	public ResponseEntity<Article> updateFourniseur(@PathVariable (value = "id")Long id,@RequestBody Article Article) {
		return articleService.updateFourniseur(id, Article);
	}
	
	@GetMapping("/articles")
	public List<Article> getAllArticle() {
		return articleService.getAllArticle();
	} 
	

}
