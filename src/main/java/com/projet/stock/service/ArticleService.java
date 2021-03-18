package com.projet.stock.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.stock.entites.Article;
import com.projet.stock.exception.RessourceNotFoundException;
import com.projet.stock.repository.ArticleRepository;

import java.util.Optional;

@Service
public class ArticleService {

	@Autowired 
	ArticleRepository articleRepository ; 
	
	//get All Articles 
	public List <Article> getAllArticle(){
		System.out.print("Get all Fourniseurs");
		
		List<Article> articles = new ArrayList<Article>();
		articleRepository.findAll().forEach(articles ::add);
		return articles;
		}
	//getArticle par id 
	public ResponseEntity<Article> getArticleById(Long id) throws RessourceNotFoundException {
		Article Article = articleRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("Article not found"));
	 return ResponseEntity.ok().body(Article);
	}
	//ajouter Artcile
	public Article saveArticle(Article Article) {
		return this.articleRepository.save(Article);
	}
	
	
	//delete Article
	public Map<String,Boolean > delateFourniseurs (Long id) throws RessourceNotFoundException {
		Article Article = articleRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("Article not found"));
			
		articleRepository.delete(Article);
		Map<String , Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	//modifier Article 
	
	public ResponseEntity<Article> updateFourniseur(Long id,Article Article) {
		System.out.print("Update Fourniseur");
		
		 Optional<Article> ArticleInfo = articleRepository.findById(id);
		 
		 if(ArticleInfo.isPresent()) {
			 Article article = ArticleInfo.get();
			 article.setCode(Article.getCode());
			 article.setLibelle(Article.getLibelle());
			 article.setPa(Article.getPa());
			 article.setTva(Article.getTva());
			 article.setFdec(Article.getFdec());
			 article.setPv(Article.getPv());
			 article.setStkinit(Article.getStkinit());
			 article.setStock(Article.getStock());
			 article.setImage(Article.getImage());
			 article.setId_cat(Article.getId_cat());
			 article.setId_scat(Article.getId_scat());
			 
			 return new ResponseEntity<>(articleRepository.save(Article),HttpStatus.OK);
		 }else 
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	}
}
	
