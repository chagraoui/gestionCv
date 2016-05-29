package com.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CV {
	
	//private Long id;
	private int age;
	private String name;
	private String certif;
	//private List<String>certif;
	//private String gender;
	private String adresse;
	private String mail;
	private ArrayList<String> studies;
	private Set<String> skills;
	private String num;
	private HashMap<String, Integer> keywords;
	//private Map <string,integer> experience;
	
	
	private BufferedReader in;
	
	
	public CV(String cv) throws IOException {
		this.in= new BufferedReader(new FileReader(cv));
		this.age=GetAge.age(in);
		
		this.in= new BufferedReader(new FileReader(cv));
		this.certif=GetCertif.certif(in);
		
		this.in= new BufferedReader(new FileReader(cv));
		this.name=GetName.name(in);
		
		this.in= new BufferedReader(new FileReader(cv));
		this.adresse=GetLocation.location(in);
		
		this.in= new BufferedReader(new FileReader(cv));
		this.mail=GetMail.mail(in);
		
		this.in= new BufferedReader(new FileReader(cv));
		this.studies=GetStudies.studies(in);
		
		this.in= new BufferedReader(new FileReader(cv));
		this.skills=GetSkills.skills(in);
		
		this.in= new BufferedReader(new FileReader(cv));
		this.num=GetPhoneNum.num(in);
		
		this.in= new BufferedReader(new FileReader(cv));
		this.keywords=GetOccurrence.occ(in);
		
		
		
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
	public String getName() {
		return name;
	}


	/**
	 * @return the certif
	 */
	public String getCertif() {
		return certif;
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
	public String getMail() {
		return mail;
	}


	/**
	 * @return the studies
	 */
	public ArrayList<String> getStudies() {
		return studies;
	}


	/**
	 * @return the skills
	 */
	public Set<String> getSkills() {
		return skills;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CV [age=" + age + ", name=" + name + ", certif=" + certif
				+ ", adresse=" + adresse + ", mail=" + mail + ", studies="
				+ studies + ", skills=" + skills + ", num=" + num
				+ ", keywords=" + keywords + "]";
	}
	

	

	
	
	
	
	
	

}
