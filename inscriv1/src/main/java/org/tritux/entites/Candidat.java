package org.tritux.entites;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("candidat")
public class Candidat extends User implements Serializable {

	@OneToOne
	private Profil profil;

	/**
	 * @return the profil
	 */
	public Profil getProfil() {
		return profil;
	}

	/**
	 * @param profil
	 *            the profil to set
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Candidat [" + (profil != null ? "profil=" + profil : "") + "]";
	}

	
}
