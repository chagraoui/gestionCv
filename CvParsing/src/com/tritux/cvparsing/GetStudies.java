package com.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetStudies {

	public static String studies(BufferedReader in) throws IOException {
		
	
		BufferedReader lp = new BufferedReader(new FileReader("nivEtude.txt"));
		ArrayList<String> tab, pays;
		String res="";
		tab = new ArrayList<String>();
		pays = new ArrayList<String>();

		String str;
		while ((str = in.readLine()) != null) {

			tab.add(str);
		}
		while ((str = lp.readLine()) != null) {

			pays.add(str);
		}
		in.close();
		lp.close();
		for (String elem : tab) {
			for (String ele : pays) {
				int x = ((elem.toLowerCase()).indexOf(ele));
				if (x > 0) {
					res=res +" "+ele;
				}
			}
		}
	return res;
	}
}
