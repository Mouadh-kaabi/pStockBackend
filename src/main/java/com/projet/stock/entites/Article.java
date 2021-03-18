package com.projet.stock.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	private String code ; 
	private String libelle  ;
	private float pa ; 
	private int tva ; 
	private int fdec; 
	private float pv ; 
	private float stkinit ; 
	private float stock ;
	
	private String image ; 
	private long id_cat ; 
	private Long id_scat ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public float getPa() {
		return pa;
	}
	public void setPa(float pa) {
		this.pa = pa;
	}
	public int getTva() {
		return tva;
	}
	public void setTva(int tva) {
		this.tva = tva;
	}
	public int getFdec() {
		return fdec;
	}
	public void setFdec(int fdec) {
		this.fdec = fdec;
	}
	public float getPv() {
		return pv;
	}
	public void setPv(float pv) {
		this.pv = pv;
	}
	public float getStkinit() {
		return stkinit;
	}
	public void setStkinit(float stkinit) {
		this.stkinit = stkinit;
	}
	public float getStock() {
		return stock;
	}
	public void setStock(float stock) {
		this.stock = stock;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getId_cat() {
		return id_cat;
	}
	public void setId_cat(long id_cat) {
		this.id_cat = id_cat;
	}
	public Long getId_scat() {
		return id_scat;
	}
	public void setId_scat(Long id_scat) {
		this.id_scat = id_scat;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(long id, String code, String libelle, float pa, int tva, int fdec, float pv, float stkinit,
			float stock, String image, long id_cat, Long id_scat) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.pa = pa;
		this.tva = tva;
		this.fdec = fdec;
		this.pv = pv;
		this.stkinit = stkinit;
		this.stock = stock;
		this.image = image;
		this.id_cat = id_cat;
		this.id_scat = id_scat;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", code=" + code + ", libelle=" + libelle + ", pa=" + pa + ", tva=" + tva
				+ ", fdec=" + fdec + ", pv=" + pv + ", stkinit=" + stkinit + ", stock=" + stock + ", image=" + image
				+ ", id_cat=" + id_cat + ", id_scat=" + id_scat + "]";
	}

	
	
}
