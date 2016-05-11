package org.tritux.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("candidat")
public class Candidat extends User implements Serializable {

	@OneToOne
	private Profil profil;

	public Candidat(String login, String password, String role,
			Collection<Offre> listCandidatures) {
		super(login, password, role);
		this.listCandidatures = listCandidatures;
	}

	@ManyToMany(mappedBy = "listCandidatureOffre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Collection<Offre> listCandidatures = new ArrayList<Offre>();

	public Collection<Offre> getListCandidatures() {
		return listCandidatures;
	}

	public void setListCandidatures(Collection<Offre> listCandidatures) {
		this.listCandidatures = listCandidatures;
	}

	public Profil getProfil() {
		return profil;
	}

	public Candidat(String login, String password, String role, Profil profil,
			Collection<Offre> listCandidatures) {
		super(login, password, role);
		this.profil = profil;
		this.listCandidatures = listCandidatures;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidat(String login, String password, String role) {
		super(login, password, role);
		// TODO Auto-generated constructor stub
	}

	public Candidat(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}

	public Candidat(String login, String password, String role, Profil profil) {
		super(login, password, role);
		this.profil = profil;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Candidat [" + (profil != null ? "profil=" + profil : "") + "]";
	}

}
