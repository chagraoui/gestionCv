package org.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParsingCv {

	public static void main(String[] args) throws IOException {
	
		BufferedReader in;
			
//			in= new BufferedReader(new FileReader("cvConverti/cv9.txt"));
//			int age =GetAge.age(in);
//			System.out.println(age);
//			
//			in= new BufferedReader(new FileReader("cvMehdi.txt"));
//			String cert =GetCertif.certif(in);
//			System.out.println(cert);
//			
//			in= new BufferedReader(new FileReader("cvMehdi.txt"));
//			String adresse =GetLocation.location(in);
//			System.out.println(adresse);
//			
//			in= new BufferedReader(new FileReader("cvMehdi.txt"));
//			String mail =GetMail.mail(in);
//			System.out.println(mail);
//			
//			in= new BufferedReader(new FileReader("cvMehdi.txt"));
//			String name=GetName.name(in);
//			System.out.println(name);
//			
//			in= new BufferedReader(new FileReader("cvMehdi.txt"));
//			String num=GetPhoneNum.num(in);
//			System.out.println(num);
//			
//			in= new BufferedReader(new FileReader("cvMehdi.txt"));
//			Set<String> comp=GetSkills.skills(in);
//			System.out.println(comp);
//			
			in= new BufferedReader(new FileReader("cvMehdi.txt"));
			ArrayList<String> studie=GetStudies.studies(in);
			System.out.println(studie);
//			
//			in= new BufferedReader(new FileReader("cvMehdi.txt"));
//			HashMap<String, Integer> ooc=GetOccurrence.occ(in);
//			System.out.println(ooc);
	
	}

}
