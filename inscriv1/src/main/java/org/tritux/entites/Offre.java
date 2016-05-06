package org.tritux.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Offre implements Serializable {

	@Id
	@GeneratedValue
	private Long idOffre;
	private String titreOffre;
	private String descOffre;
	@ManyToOne()
	private Recruteur deposeur;
	
	public Long getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(Long idOffre) {
		this.idOffre = idOffre;
	}

	@JoinTable(name = "technoligie_par_offre")
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Collection<Technolgie> technologiesOffre = new ArrayList<Technolgie>();
	
	@JoinTable(name = "postuler")
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Collection<Candidat> listCandidatureOffre = new ArrayList<Candidat>();
	
	public Collection<Candidat> getListCandidatureOffre() {
		return listCandidatureOffre;
	}

	public void setListCandidatureOffre(Collection<Candidat> listCandidatureOffre) {
		this.listCandidatureOffre = listCandidatureOffre;
	}

	public Recruteur getDeposeur() {
		return deposeur;
	}

	public void setDeposeur(Recruteur deposeur) {
		this.deposeur = deposeur;
	}

	public String getTitreOffre() {
		return titreOffre;
	}

	public void setTitreOffre(String titreOffre) {
		this.titreOffre = titreOffre;
	}

	public String getDescOffre() {
		return descOffre;
	}

	public void setDescOffre(String descOffre) {
		this.descOffre = descOffre;
	}

	public Collection<Technolgie> getTechnologiesOffre() {
		return technologiesOffre;
	}

	public void setTechnologiesOffre(Collection<Technolgie> technologiesOffre) {
		this.technologiesOffre = technologiesOffre;
	}

	public Offre() {
		// TODO Auto-generated constructor stub
	}

	public Offre(String titreOffre, String descOffre,
			Collection<Technolgie> technologiesOffre) {
		super();
		this.titreOffre = titreOffre;
		this.descOffre = descOffre;
		this.technologiesOffre = technologiesOffre;
	}

	public Offre(Long idOffre, String titreOffre, String descOffre,
			Recruteur deposeur, Collection<Technolgie> technologiesOffre,
			Collection<Candidat> listCandidatureOffre) {
		super();
		this.idOffre = idOffre;
		this.titreOffre = titreOffre;
		this.descOffre = descOffre;
		this.deposeur = deposeur;
		this.technologiesOffre = technologiesOffre;
		this.listCandidatureOffre = listCandidatureOffre;
	}	
	
}
