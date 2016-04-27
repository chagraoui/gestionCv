package org.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.tritux.entites.Certification;
import org.tritux.entites.Diplomes;

public class CV {

	
	private int age;
	private String nom;
	private ArrayList<Certification>certifications;
	private String adresse;
	private String email;
	private ArrayList<Diplomes> diplomes;
	private Set<String> technologies;
	private String tel;
	private HashMap<String, Integer> keywords;
	// private Map <string,integer> experience;

	private BufferedReader in;

	public CV(String cv) throws IOException {
		this.in = new BufferedReader(new FileReader(cv));
		this.age = GetAge.age(in);

		this.in = new BufferedReader(new FileReader(cv));
		this.certifications = GetCertif.certif(in);

		this.in = new BufferedReader(new FileReader(cv));
		this.nom = GetName.name(in);

		this.in = new BufferedReader(new FileReader(cv));
		this.adresse = GetLocation.location(in);

		this.in = new BufferedReader(new FileReader(cv));
		this.email = GetMail.mail(in);

		this.in = new BufferedReader(new FileReader(cv));
		this.diplomes = GetStudies.studies(in);

		this.in = new BufferedReader(new FileReader(cv));
		this.technologies = GetSkills.skills(in);

		this.in = new BufferedReader(new FileReader(cv));
		this.tel = GetPhoneNum.num(in);

		this.in = new BufferedReader(new FileReader(cv));
		this.keywords = GetOccurrence.occ(in);

	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the name
	 */
	public String getnom() {
		return nom;
	}



	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @return the mail
	 */
	public String getemail() {
		return email;
	}

	/**
	 * @return the studies
	 */
	public ArrayList<Diplomes> getdiplomes() {
		return diplomes;
	}

	/**
	 * @return the skills
	 */
	public Set<String> gettechnologies() {
		return technologies;
	}

	/**
	 * @return the num
	 */
	public String getTel() {
		return tel;
	}

	public ArrayList<Certification> getCertifications() {
		return certifications;
	}

	/**
	 * @return the keywords
	 */
	public HashMap<String, Integer> getKeywords() {
		return keywords;
	}

	@Override
	public String toString() {
		return "CV [age="
				+ age
				+ ", "
				+ (nom != null ? "nom=" + nom + ", " : "")
				+ (certifications != null ? "certifications=" + certifications
						+ ", " : "")
				+ (adresse != null ? "adresse=" + adresse + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (diplomes != null ? "diplomes=" + diplomes + ", " : "")
				+ (technologies != null ? "technologies=" + technologies + ", "
						: "") + (tel != null ? "tel=" + tel + ", " : "")
				+ (keywords != null ? "keywords=" + keywords + ", " : "")
				+ (in != null ? "in=" + in : "") + "]";
	}
	
}
