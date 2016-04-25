package org.tritux.entites;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Offre {

	@Id
	@GeneratedValue
	private Long idOffre;
	private String titreOffre;
	private String descOffre;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Technolgie> technologiesOffre = new ArrayList<Technolgie>();

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

	
}
