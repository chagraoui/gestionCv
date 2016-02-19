package com.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CV {
	
	private int age;
	private String name;
	private String certif;
	private String adresse;
	private String mail;
	private String studies;
	private Set<String> skills;
	private String num;
	private List<Map.Entry<String, Integer>> keywords;
	
	private BufferedReader in;
	
	
	public CV() throws IOException {
		this.in= new BufferedReader(new FileReader("cvMehdi.txt"));
		this.age=GetAge.age(in);
		
		this.in= new BufferedReader(new FileReader("cvMehdi.txt"));
		this.certif=GetCertif.certif(in);
		
		this.in= new BufferedReader(new FileReader("cvMehdi.txt"));
		this.name=GetName.name(in);
		
		this.in= new BufferedReader(new FileReader("cvMehdi.txt"));
		this.adresse=GetLocation.location(in);
		
		this.in= new BufferedReader(new FileReader("cvMehdi.txt"));
		this.mail=GetMail.mail(in);
		
		this.in= new BufferedReader(new FileReader("cvMehdi.txt"));
		this.studies=GetStudies.studies(in);
		
		this.in= new BufferedReader(new FileReader("cvMehdi.txt"));
		this.skills=GetSkills.skills(in);
		
		this.in= new BufferedReader(new FileReader("cvMehdi.txt"));
		this.num=GetPhoneNum.num(in);
		
		this.in= new BufferedReader(new FileReader("cvMehdi.txt"));
		this.keywords=GetOccurrence.occ(in);
		
		
		
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
