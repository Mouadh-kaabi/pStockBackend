package com.projet.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.stock.entites.Article;

public interface ArticleRepository extends JpaRepository<Article,Long> {

}
