package org.tritux.entites;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User implements Serializable {

	private String nom;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String login, String password, String role) {
		super(login, password, role);
		// TODO Auto-generated constructor stub
	}

	public Admin(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}

	public Admin(String login, String password, String role, String nom) {
		super(login, password, role);
		this.nom = nom;
	}

}
