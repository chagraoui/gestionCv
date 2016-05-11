package org.tritux.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Inscription implements Serializable {

	private String nom;
	//private String prenom;
	private String email;
	private int age;
	private String adresse;
	private Long tel;
	private String sexe;
	private String login;
	private String password;
	private String role;
	private Collection<Exeprience> experiences = new ArrayList<Exeprience>();
	private Collection<Diplomes> diplomes = new ArrayList<Diplomes>();
	private Collection<Certification> certifications = new ArrayList<Certification>();
	private Collection<Technolgie> technologies = new ArrayList<Technolgie>();

	public Collection<Exeprience> getExperiences() {
		return experiences;
	}

	public Collection<Technolgie> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Collection<Technolgie> technologies) {
		this.technologies = technologies;
	}

	public void setExperiences(Collection<Exeprience> experiences) {
		this.experiences = experiences;
	}

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

	/**
	 * @return the prenom
	 */
//	public String getPrenom() {
//		return prenom;
//	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
//	public void setPrenom(String prenom) {
//		this.prenom = prenom;
//	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the tel
	 */
	public Long getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(Long tel) {
		this.tel = tel;
	}

	/**
	 * @return the sexe
	 */
	public String getSexe() {
		return sexe;
	}

	/**
	 * @param sexe
	 *            the sexe to set
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection<Diplomes> getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(Collection<Diplomes> diplomes) {
		this.diplomes = diplomes;
	}

	public Collection<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(Collection<Certification> certifications) {
		this.certifications = certifications;
	}

	public Inscription(String nom, String email, int age,
			String adresse, Long tel, String sexe, String login,
			String password, String role, Collection<Exeprience> experiences,
			Collection<Diplomes> diplomes,
			Collection<Certification> certifications,
			Collection<Technolgie> technologies) {
		super();
		this.nom = nom;
	//	this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.adresse = adresse;
		this.tel = tel;
		this.sexe = sexe;
		this.login = login;
		this.password = password;
		this.role = role;
		this.experiences = experiences;
		this.diplomes = diplomes;
		this.certifications = certifications;
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		return "Inscription ["
				+ (nom != null ? "nom=" + nom + ", " : "")
				//+ (prenom != null ? "prenom=" + prenom + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ "age="
				+ age
				+ ", "
				+ (adresse != null ? "adresse=" + adresse + ", " : "")
				+ "tel="
				+ tel
				+ ", "
				+ (sexe != null ? "sexe=" + sexe + ", " : "")
				+ (login != null ? "login=" + login + ", " : "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (role != null ? "role=" + role + ", " : "")
				+ (experiences != null ? "experiences=" + experiences + ", "
						: "")
				+ (diplomes != null ? "diplomes=" + diplomes + ", " : "")
				+ (certifications != null ? "certifications=" + certifications
						+ ", " : "")
				+ (technologies != null ? "technologies=" + technologies : "")
				+ "]";
	}

}
