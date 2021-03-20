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

import com.projet.stock.entites.Client;
import com.projet.stock.exception.RessourceNotFoundException;
import com.projet.stock.service.ClientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	ClientService clientService ;

	@GetMapping("/clients")
	public List<Client> getAllClient() {
		return clientService.getAllClient();
	}

	@GetMapping("/client/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable (value = "id")  Long id) throws RessourceNotFoundException {
		return clientService.getClientById(id);
	}
	@PostMapping("/client/add")
	public Client saveClient(@RequestBody Client Client) {
		return clientService.saveClient(Client);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> delateClient(@PathVariable (value = "id")Long id) throws RessourceNotFoundException {
		return clientService.delateClient(id);
	}

	@PutMapping("/updateclinet/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable (value = "id")Long id,@RequestBody Client Client) {
		return clientService.updateClient(id, Client);
	} 
	
	

}
