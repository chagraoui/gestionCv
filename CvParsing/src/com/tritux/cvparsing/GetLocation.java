package com.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetLocation {

	public static String location(BufferedReader in) throws IOException {
		 
		BufferedReader lp = new BufferedReader(new FileReader("listpays.txt"));
		ArrayList<String> tab, pays, adress;

		tab = new ArrayList<String>();
		pays = new ArrayList<String>();
		adress = new ArrayList<String>();
		
		String str;
		while ((str = in.readLine()) != null) {

			tab.add(str);

		}

		while ((str = lp.readLine()) != null) {
			pays.add(str);
		}
		in.close();
		lp.close();
		
		String res="";
		for (String elem : tab) {
			for (String ele : pays) {
				int x = ((elem.toLowerCase()).indexOf(ele));
				if (x > 0) {
					res= ele;
				}
			}
		}
			return res;
		
	}
}