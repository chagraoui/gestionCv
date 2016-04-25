package org.tritux.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Certification {
	
	@Id
	@GeneratedValue
	private Long idCertif;
	private String nomCertif;
	@ManyToOne
	@JoinColumn(name = "prof_id_certif")
	@JsonIgnore
	private Profil profil_id_certif;
	public Long getIdCertif() {
		return idCertif;
	}
	public void setIdCertif(Long idCertif) {
		this.idCertif = idCertif;
	}
	public String getNomCertif() {
		return nomCertif;
	}
	public void setNomCertif(String nomCertif) {
		this.nomCertif = nomCertif;
	}
	public Profil getProfil_id_certif() {
		return profil_id_certif;
	}
	public void setProfil_id_certif(Profil profil_id_certif) {
		this.profil_id_certif = profil_id_certif;
	}
	public Certification(String nomCertif, Profil profil_id_certif) {
		super();
		this.nomCertif = nomCertif;
		this.profil_id_certif = profil_id_certif;
	}
	public Certification() {
		super();
		// TODO Auto-generated constructor stub
	}
}
