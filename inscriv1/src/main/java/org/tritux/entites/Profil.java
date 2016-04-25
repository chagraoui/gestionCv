package org.tritux.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Profil implements Serializable {

	@Id
	@GeneratedValue
	private Long IdCv;
	private String nom;
	private String prenom;
	private String email;
	private int age;
	private String adresse;
	private int tel;
	private String sexe;
	
	@OneToMany(targetEntity = Exeprience.class, mappedBy = "profil", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Exeprience> experiences = new ArrayList<Exeprience>();
	
	@OneToMany(targetEntity = Diplomes.class, mappedBy = "profilDip", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Diplomes> diplomes = new ArrayList<Diplomes>();
	
	@OneToMany(targetEntity = Certification.class, mappedBy = "profil_id_certif", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Certification> certifications = new ArrayList<Certification>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Technolgie> technologies = new ArrayList<Technolgie>();
	
	
	/**
	 * @return the idCv
	 */
	public Long getIdCv() {
		return IdCv;
	}
	/**
	 * @param idCv the idCv to set
	 */
	public void setIdCv(Long idCv) {
		IdCv = idCv;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
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
	 * @param age the age to set
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
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the tel
	 */
	public int getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(int tel) {
		this.tel = tel;
	}
	/**
	 * @return the sexe
	 */
	public String getSexe() {
		return sexe;
	}
	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	/**
	 * @return the experiences
	 */
	public Collection<Exeprience> getExperiences() {
		return experiences;
	}
	/**
	 * @param experiences the experiences to set
	 */
	@JsonSetter 
	public void setExperiences(Collection<Exeprience> experiences) {
		this.experiences = experiences;
	}

	public Profil() {
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
	public Collection<Technolgie> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(Collection<Technolgie> technologies) {
		this.technologies = technologies;
	}
	public Profil(String nom, String prenom, String email, int age,
			String adresse, int tel, String sexe,
			Collection<Exeprience> experiences, Collection<Diplomes> diplomes,
			Collection<Certification> certifications,
			Collection<Technolgie> technologies) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.adresse = adresse;
		this.tel = tel;
		this.sexe = sexe;
		this.experiences = experiences;
		this.diplomes = diplomes;
		this.certifications = certifications;
		this.technologies = technologies;
	}
	
	
}
