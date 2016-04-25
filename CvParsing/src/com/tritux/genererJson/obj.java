package com.tritux.genererJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tritux.cvparsing.CV;

public class obj {
	
	private int age;
	private String name;
	private String certif;
	private String adresse;
	private String mail;
	private ArrayList<String> studies;
	private String num;
	private Set<String> skills;
	
	private HashMap<String, Integer> keywords;
	
	
	//constructeur de la classe obj qui prend en parametre le nom du cv
	//et construit un objet CV
	public obj(String cv) throws IOException{
		CV c = new CV(cv);
		this.age=c.getAge();
		this.name=c.getName();
		this.certif=c.getCertif();
		this.adresse=c.getAdresse();
		this.mail=c.getMail();
		this.studies=c.getStudies();
		this.num=c.getNum();
		this.skills=c.getSkills();
		this.keywords=c.getKeywords();
	}
}
