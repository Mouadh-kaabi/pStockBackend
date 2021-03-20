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
import com.projet.stock.entites.Client;
import com.projet.stock.exception.RessourceNotFoundException;
import com.projet.stock.repository.ClientRepository;

@Service
public class ClientService {

	
	@Autowired
	ClientRepository clientRepository ; 
	
	//get All Client 
		public List <Client> getAllClient(){
			System.out.print("Get all Client");
			
			List<Client> clients = new ArrayList<Client>();
			clientRepository.findAll().forEach(clients ::add);
			return clients;
			}
		//getClient par id 
		public ResponseEntity<Client> getClientById(Long id) throws RessourceNotFoundException {
			Client Client = clientRepository.findById(id).
					orElseThrow(()-> new RessourceNotFoundException("Client not found"));
		 return ResponseEntity.ok().body(Client);
		}
		//ajouter Client
		public Client saveClient(Client Client) {
			return this.clientRepository.save(Client);
		}
		
		
		//delete Article
		public Map<String,Boolean > delateClient (Long id) throws RessourceNotFoundException {
			Client Client = clientRepository.findById(id).
					orElseThrow(()-> new RessourceNotFoundException("Client not found"));
				
			clientRepository.delete(Client);
			Map<String , Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
		//modifier Article 
		
		public ResponseEntity<Client> updateClient(Long id,Client Client) {
			System.out.print("Update Fourniseur");
			
			 Optional<Client> ClientInfo = clientRepository.findById(id);
			 
			 if(ClientInfo.isPresent()) {
				 Client client = ClientInfo.get();
				 client.setCode(Client.getCode());
				 client.setLibelle(Client.getLibelle());
				 client.setAdresse(Client.getAdresse());
				 client.setAssuj(Client.getAssuj());
				 client.setEmail(Client.getEmail());
				 client.setContact(Client.getContact());
				 client.setMatfisc(Client.getMatfisc());
				 client.setTel(Client.getTel());
				 client.setTimbre(Client.getTimbre());
				 client.setSolde(Client.getSolde());
				 client.setSolde_init(Client.getSolde_init());
				 client.setPwd(Client.getPwd());
				 client.setLogin(Client.getLogin());
				 
				 return new ResponseEntity<>(clientRepository.save(Client),HttpStatus.OK);
			 }else 
			 {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 }
		}
}
