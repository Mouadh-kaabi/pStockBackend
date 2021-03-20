package com.projet.stock.controller;

import java.util.List;
import java.util.Map;

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

import com.projet.stock.entites.Categorie;
import com.projet.stock.exception.RessourceNotFoundException;
import com.projet.stock.service.CategorieService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategorieController {

	
	@Autowired
	CategorieService categorieService ;
	
	

	@GetMapping("/categories")
	public List<Categorie> getAllCategorie() {
		return categorieService.getAllCategorie();
	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<Categorie> getCategorieById(@PathVariable (value = "id") Long id) throws RessourceNotFoundException {
		return categorieService.getCategorieById(id);
	}

	@PostMapping("/addcategorie")
	public Categorie saveArticle(@RequestBody Categorie Categorie) {
		return categorieService.saveArticle(Categorie);
	}
	@DeleteMapping("/categorie/{id}")
	public Map<String, Boolean> delateCategorie(@PathVariable (value = "id")Long id) throws RessourceNotFoundException {
		return categorieService.delateCategorie(id);
	}
	
	@PutMapping("/updatecategorie/{id}")
	public ResponseEntity<Categorie> updateCategorie(@PathVariable (value = "id") Long id,@RequestBody Categorie Categorie) {
		return categorieService.updateCategorie(id, Categorie);
	}
	
	
}
