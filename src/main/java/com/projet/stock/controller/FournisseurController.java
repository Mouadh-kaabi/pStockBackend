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

import com.projet.stock.entites.Fournisseur;
import com.projet.stock.exception.RessourceNotFoundException;
import com.projet.stock.repository.FournisseurRepository;
import com.projet.stock.service.FournisseurService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FournisseurController {

	
	@Autowired
	FournisseurService fournisseurService ;

	@GetMapping("/fournisseurs")
	public List<Fournisseur> getAllFournisseur() {
		return fournisseurService.getAllFournisseur();
	}

	@GetMapping("/fournisseur/{id}")
	public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable (value = "id")Long id) throws RessourceNotFoundException {
		return fournisseurService.getFournisseurById(id);
	}

	@PostMapping("/fournisseur/add")
	public Fournisseur saveFournisseur(@RequestBody Fournisseur Fournisseur) {
		return fournisseurService.saveFournisseur(Fournisseur);
	}

	@DeleteMapping("/deletefournisseur{id}")
	public Map<String, Boolean> delateFournisseur(@PathVariable (value = "id")Long id) throws RessourceNotFoundException {
		return fournisseurService.delateFournisseur(id);
	}

	public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable(value = "id") Long id, @RequestBody Fournisseur Fournisseur) {
		return fournisseurService.updateFournisseur(id, Fournisseur);
	}
	
}
