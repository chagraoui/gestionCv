package org.tritux.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exeprience implements Serializable {
	@Id
	@GeneratedValue
	private Long idExp;
	private int nbrAnsExp;
	private String domaine;
	@ManyToOne
	@JoinColumn(name = "profil_id")
	@JsonIgnore
	private Profil profil;

	/**
	 * @return the idExp
	 */
	public Long getIdExp() {
		return idExp;
	}

	/**
	 * @param idExp
	 *            the idExp to set
	 */
	public void setIdExp(Long idExp) {
		this.idExp = idExp;
	}

	/**
	 * @return the nbrAnsExp
	 */
	public int getNbrAnsExp() {
		return nbrAnsExp;
	}

	/**
	 * @param nbrAnsExp
	 *            the nbrAnsExp to set
	 */
	public void setNbrAnsExp(int nbrAnsExp) {
		this.nbrAnsExp = nbrAnsExp;
	}

	/**
	 * @return the domaine
	 */
	public String getDomaine() {
		return domaine;
	}

	/**
	 * @param domaine
	 *            the domaine to set
	 */
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Exeprience(int nbrAnsExp, String domaine) {
		super();
		this.nbrAnsExp = nbrAnsExp;
		this.domaine = domaine;
	}

	public Exeprience() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exeprience(int nbrAnsExp, String domaine, Profil profil) {
		super();
		this.nbrAnsExp = nbrAnsExp;
		this.domaine = domaine;
		this.profil = profil;
	}
}
