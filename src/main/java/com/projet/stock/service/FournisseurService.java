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

import com.projet.stock.entites.Fournisseur;
import com.projet.stock.exception.RessourceNotFoundException;
import com.projet.stock.repository.FournisseurRepository;

@Service
public class FournisseurService {

	
	@Autowired
	FournisseurRepository fournisseurRepository ;
	//get All Fournisseur 
			public List <Fournisseur> getAllFournisseur(){
				System.out.print("Get all Fournisseur");
				
				List<Fournisseur> Fournisseurs = new ArrayList<Fournisseur>();
				fournisseurRepository.findAll().forEach(Fournisseurs ::add);
				return Fournisseurs;
				}
			//getFournisseur par id 
			public ResponseEntity<Fournisseur> getFournisseurById(Long id) throws RessourceNotFoundException {
				Fournisseur Fournisseur = fournisseurRepository.findById(id).
						orElseThrow(()-> new RessourceNotFoundException("Fournisseur not found"));
			 return ResponseEntity.ok().body(Fournisseur);
			}
			//ajouter Fournisseur
			public Fournisseur saveFournisseur(Fournisseur Fournisseur) {
				return this.fournisseurRepository.save(Fournisseur);
			}
			
			
			//delete fournisseur
			public Map<String,Boolean > delateFournisseur (Long id) throws RessourceNotFoundException {
				Fournisseur Fournisseur = fournisseurRepository.findById(id).
						orElseThrow(()-> new RessourceNotFoundException("Fournisseur not found"));
					
				fournisseurRepository.delete(Fournisseur);
				Map<String , Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return response;
			}
			//modifier Article 
			
			public ResponseEntity<Fournisseur> updateFournisseur(Long id,Fournisseur Fournisseur) {
				System.out.print("Update Fourniseur");
				
				 Optional<Fournisseur> FournisseurInfo = fournisseurRepository.findById(id);
				 
				 if(FournisseurInfo.isPresent()) {
					 Fournisseur fournisseur = FournisseurInfo.get();
					 fournisseur.setCode(Fournisseur.getCode());
					 fournisseur.setLibelle(Fournisseur.getLibelle());
					 fournisseur.setAdresse(Fournisseur.getAdresse());
					 fournisseur.setAssuj(Fournisseur.getAssuj());
					 fournisseur.setEmail(Fournisseur.getEmail());
					 fournisseur.setContact(Fournisseur.getContact());
					 fournisseur.setMatfisc(Fournisseur.getMatfisc());
					 fournisseur.setTel(Fournisseur.getTel());
					 fournisseur.setTimbre(Fournisseur.getTimbre());
					 fournisseur.setSolde(Fournisseur.getSolde());
					 fournisseur.setSolde_init(Fournisseur.getSolde_init());
					
					 
					 return new ResponseEntity<>(fournisseurRepository.save(Fournisseur),HttpStatus.OK);
				 }else 
				 {
					 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				 }
			}
}
