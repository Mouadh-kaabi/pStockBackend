package com.projet.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.stock.entites.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
