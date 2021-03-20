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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.stock.entites.Scategorie;
import com.projet.stock.exception.RessourceNotFoundException;
import com.projet.stock.service.ScategorieService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ScategorieController {

	
	@Autowired
	ScategorieService scategorieService ;

	@GetMapping("/scategories")
	public List<Scategorie> getAllScategorie() {
		return scategorieService.getAllScategorie();
	}
	@GetMapping("/scategories/{id}")
	public ResponseEntity<Scategorie> getScategorieById(@PathVariable (value = "id")Long id) throws RessourceNotFoundException {
		return scategorieService.getScategorieById(id);
	}
	@PostMapping("/scategories/add")
	public Scategorie saveScategorie(@RequestBody Scategorie Scategorie) {
		return scategorieService.saveScategorie(Scategorie);
	}

	@DeleteMapping("/deletescategories/{id}")
	public Map<String, Boolean> delateScategorie(@PathVariable (value = "id")Long id) throws RessourceNotFoundException {
		return scategorieService.delateScategorie(id);
	}

	public ResponseEntity<Scategorie> updateScategorie(@PathVariable (value = "id") Long id,@RequestBody Scategorie Scategorie) {
		return scategorieService.updateScategorie(id, Scategorie);
	} 
	
}
