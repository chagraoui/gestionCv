package org.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CV {

	// private Long id;
	private int age;
	private String nom;
	private String certifications;
	 //private List<String>certifications;
	// private String gender;
	private String adresse;
	private String email;
	private ArrayList<String> diplomes;
	private Set<String> technologies;
	private String num;
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
		this.num = GetPhoneNum.num(in);

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
	 * @return the certif
	 */
	public String getcertifications() {
		return certifications;
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
	public ArrayList<String> getdiplomes() {
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
	public String getNum() {
		return num;
	}

	/**
	 * @return the keywords
	 */
	public HashMap<String, Integer> getKeywords() {
		return keywords;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CV [age=" + age + ", name=" + nom + ", certif=" + certifications
				+ ", adresse=" + adresse + ", mail=" + email + ", studies="
				+ diplomes + ", skills=" + technologies + ", num=" + num
				+ ", keywords=" + keywords + "]";
	}

}
