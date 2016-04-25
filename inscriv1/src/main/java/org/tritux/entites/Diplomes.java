package org.tritux.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Diplomes {

	@Id
	@GeneratedValue
	private Long idDiplome;
	private String nom;
	private int dateObtention;
	@ManyToOne
	@JoinColumn(name = "prof_id")
	@JsonIgnore
	private Profil profilDip;

	public Long getIdDiplome() {
		return idDiplome;
	}

	public void setIdDiplome(Long idDiplome) {
		this.idDiplome = idDiplome;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDateObtention() {
		return dateObtention;
	}

	public void setDateObtention(int dateObtention) {
		this.dateObtention = dateObtention;
	}

	public Profil getProfilDip() {
		return profilDip;
	}

	public void setProfilDip(Profil profilDip) {
		this.profilDip = profilDip;
	}

	public Diplomes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diplomes(String nom, int dateObtention, Profil profilDip) {
		super();
		this.nom = nom;
		this.dateObtention = dateObtention;
		this.profilDip = profilDip;
	}
}