package org.tritux.entites;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Technolgie {
	
	@Id
	@GeneratedValue
	private Long idTechno;
	
	private String nomTechno;
	
	@ManyToMany(mappedBy = "technologies", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Collection<Profil> profils = new ArrayList<Profil>();
	
	@ManyToMany(mappedBy = "technologiesOffre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Collection<Offre> offres = new ArrayList<Offre>();
	
	
	public Collection<Offre> getOffres() {
		return offres;
	}

	public void setOffres(Collection<Offre> offres) {
		this.offres = offres;
	}

	public Long getIdTechno() {
		return idTechno;
	}

	public void setIdTechno(Long idTechno) {
		this.idTechno = idTechno;
	}

	public String getNomTechno() {
		return nomTechno;
	}

	public void setNomTechno(String nomTechno) {
		this.nomTechno = nomTechno;
	}

	public Technolgie(String nomTechno) {
		super();
		this.nomTechno = nomTechno;
	}



	public Technolgie(Long idTechno, String nomTechno) {
		super();
		this.idTechno = idTechno;
		this.nomTechno = nomTechno;
	}
	public Technolgie() {
		// TODO Auto-generated constructor stub
	}

	public Technolgie(String nomTechno, Collection<Profil> profils) {
		super();
		this.nomTechno = nomTechno;
		this.profils = profils;
	}

	public Collection<Profil> getProfils() {
		return profils;
	}

	public void setProfils(Collection<Profil> profils) {
		this.profils = profils;
	}

	@Override
	public String toString() {
		return "Technolgie ["
				+ (idTechno != null ? "idTechno=" + idTechno + ", " : "")
				+ (nomTechno != null ? "nomTechno=" + nomTechno : "") + "]";
	}
	
	

}
