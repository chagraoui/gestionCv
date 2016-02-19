package com.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GetSkills {

	public static Set<String> skills(BufferedReader in) throws IOException {

		ArrayList<String> cv = new ArrayList<String>();
		ArrayList<String> competence = new ArrayList<String>();
		// we are using set instead of list to remove duplicated skills
		Set<String> listComp = new HashSet<String>();
		try {
			 
			BufferedReader lp = new BufferedReader(new FileReader(
					"competences.txt"));

			String str;
			while ((str = in.readLine()) != null) {

				cv.add(str);

			}
			while ((str = lp.readLine()) != null) {

				competence.add(str);

			}
			in.close();
			lp.close();

			for (String elem : cv) {
				for (String elem1 : competence) {
					int x = ((elem.toLowerCase()).indexOf(elem1));
					if (x > 0) {
						listComp.add(elem1);
					}
				}
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listComp;
	}
}
