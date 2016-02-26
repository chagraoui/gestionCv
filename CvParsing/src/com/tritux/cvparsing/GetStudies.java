package com.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetStudies {

	public static ArrayList<String> studies(BufferedReader in) throws IOException {

		BufferedReader lp = new BufferedReader(new FileReader("nivEtude.txt"));
		ArrayList<String> tab, pays;
		String res = "";
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
		ArrayList<String> re = new ArrayList<String>();
		
		for (String elem : tab) {
			for (String ele : pays) {
				int x = ((elem.toLowerCase()).indexOf(ele));
				if (x > 0) {
					if (re.indexOf(ele)==-1)
					{
					re.add(ele);}	
				}
			}
		}
		return re;
	}
}
