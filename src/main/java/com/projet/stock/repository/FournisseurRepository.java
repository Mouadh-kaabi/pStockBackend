package com.projet.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.stock.entites.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}
