package com.projet.stock.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.projet.stock.entites.Article;
import com.projet.stock.entites.Categorie;
import com.projet.stock.exception.RessourceNotFoundException;
import com.projet.stock.repository.CategorieRepository;

@Service
public class CategorieService {
	
	@Autowired
	CategorieRepository categorieRepository ; 
	
	//get All Categorie
	public List <Categorie> getAllCategorie(){
		System.out.print("Get all Categorie");
		
		List<Categorie> categories = new ArrayList<Categorie>();
		categorieRepository.findAll().forEach(categories ::add);
		return categories;
		}
	//getCategorie par id 
	public ResponseEntity<Categorie> getCategorieById(Long id) throws RessourceNotFoundException {
		Categorie Categorie = categorieRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("Categorie not found"));
	 return ResponseEntity.ok().body(Categorie);
	}
	//ajouter Categorie
	public Categorie saveArticle(Categorie Categorie) {
		return this.categorieRepository.save(Categorie);
	}
	
	
	//delete Article
	public Map<String,Boolean > delateCategorie (Long id) throws RessourceNotFoundException {
		Categorie Categorie = categorieRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("Article not found"));
			
		categorieRepository.delete(Categorie);
		Map<String , Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	//modifier Categorie 
		public Categorie updateCategorie(Categorie categorie) {
			if (categorie.getId() != 0) {
				Categorie cat = categorieRepository.findById(categorie.getId()).get();
				if (cat != null) {
					categorieRepository.save(categorie);
				}
			}
			return categorie;
		}
}
