package org.tritux.entites;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
@DiscriminatorValue("recruteur")
public class Recruteur extends User implements Serializable  {
	
	private String nomRecruteur;
	private String ServiceRecruteur;
	/**
	 * @return the nomRecruteur
	 */
	public String getNomRecruteur() {
		return nomRecruteur;
	}
	/**
	 * @param nomRecruteur the nomRecruteur to set
	 */
	public void setNomRecruteur(String nomRecruteur) {
		this.nomRecruteur = nomRecruteur;
	}
	/**
	 * @return the serviceRecruteur
	 */
	public String getServiceRecruteur() {
		return ServiceRecruteur;
	}
	/**
	 * @param serviceRecruteur the serviceRecruteur to set
	 */
	public void setServiceRecruteur(String serviceRecruteur) {
		ServiceRecruteur = serviceRecruteur;
	}
	public Recruteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recruteur(String login, String password, String role) {
		super(login, password, role);
		// TODO Auto-generated constructor stub
	}
	public Recruteur(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}
	public Recruteur(String login, String password, String role,
			String nomRecruteur, String serviceRecruteur) {
		super(login, password, role);
		this.nomRecruteur = nomRecruteur;
		ServiceRecruteur = serviceRecruteur;
	}
	
	

}
