package com.projet.stock.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fournisseur")
public class Fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	private String code ; 
	private String libelle  ;
	private String contact ;
	private String adresse ;
	
	private String tel ;
	private String email ;
	private String matfisc ;
	private String assuj ;
	private String timbre ;
	private float solde_init ;
	private float solde ;
	
	public Fournisseur(long id, String code, String libelle, String contact, String adresse, String tel, String email,
			String matfisc, String assuj, String timbre, float solde_init, float solde) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.contact = contact;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.matfisc = matfisc;
		this.assuj = assuj;
		this.timbre = timbre;
		this.solde_init = solde_init;
		this.solde = solde;
	}
	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", code=" + code + ", libelle=" + libelle + ", contact=" + contact
				+ ", adresse=" + adresse + ", tel=" + tel + ", email=" + email + ", matfisc=" + matfisc + ", assuj="
				+ assuj + ", timbre=" + timbre + ", solde_init=" + solde_init + ", solde=" + solde + "]";
	}
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatfisc() {
		return matfisc;
	}
	public void setMatfisc(String matfisc) {
		this.matfisc = matfisc;
	}
	public String getAssuj() {
		return assuj;
	}
	public void setAssuj(String assuj) {
		this.assuj = assuj;
	}
	public String getTimbre() {
		return timbre;
	}
	public void setTimbre(String timbre) {
		this.timbre = timbre;
	}
	public float getSolde_init() {
		return solde_init;
	}
	public void setSolde_init(float solde_init) {
		this.solde_init = solde_init;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
}
