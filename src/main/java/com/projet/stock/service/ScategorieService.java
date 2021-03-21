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

import com.projet.stock.entites.Categorie;
import com.projet.stock.entites.Scategorie;
import com.projet.stock.exception.RessourceNotFoundException;
import com.projet.stock.repository.CategorieRepository;
import com.projet.stock.repository.ScategorieRepository;

@Service
public class ScategorieService {


	
	@Autowired
	ScategorieRepository scategorieRepository ; 
	//get All Categorie
	public List <Scategorie> getAllScategorie(){
		System.out.print("Get all Scategorie");
		
		List<Scategorie> scategories = new ArrayList<Scategorie>();
		scategorieRepository.findAll().forEach(scategories ::add);
		return scategories;
		}
	//getCategorie par id 
	public ResponseEntity<Scategorie> getScategorieById(Long id) throws RessourceNotFoundException {
		Scategorie Scategorie = scategorieRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("Categorie not found"));
	 return ResponseEntity.ok().body(Scategorie);
	}
	//ajouter Categorie
	public Scategorie saveScategorie(Scategorie Scategorie) {
		return this.scategorieRepository.save(Scategorie);
	}
	
	
	//delete Article
	public Map<String,Boolean > delateScategorie (Long id) throws RessourceNotFoundException {
		Scategorie Scategorie = scategorieRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("Scategorie not found"));
			
		scategorieRepository.delete(Scategorie);
		Map<String , Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	//modifier Categorie 
	/*	public Categorie updateCategorie(Categorie categorie) {
			if (categorie.getId() != 0) {
				Categorie cat = categorieRepository.findById(categorie.getId()).get();
				if (cat != null) {
					categorieRepository.save(categorie);
				}
			}
			return categorie;
		}*/
	
	public ResponseEntity<Scategorie> updateScategorie(Long id,Scategorie Scategorie) {
		System.out.print("Update Scategorie");
		
		 Optional<Scategorie> ScategorieInfo = scategorieRepository.findById(id);
		 
		 if(ScategorieInfo.isPresent()) {
			 Scategorie scategorie = ScategorieInfo.get();
			 scategorie.setCode(Scategorie.getCode());
			 scategorie.setLibelle(Scategorie.getLibelle());
			 scategorie.setId_cat(Scategorie.getId_cat());
			
			 return new ResponseEntity<>(scategorieRepository.save(Scategorie),HttpStatus.OK);
		 }else 
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	}

}
