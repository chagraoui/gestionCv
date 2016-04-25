package org.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.tritux.entites.Diplomes;

public class GetStudies {

	public static ArrayList<Diplomes> studies(BufferedReader in) throws IOException {

		BufferedReader lp = new BufferedReader(new FileReader("nivEtude.txt"));
		
		ArrayList<String> tab, nivEtude;
		String res = "";
		tab = new ArrayList<String>();
		nivEtude = new ArrayList<String>();

		String str;
		while ((str = in.readLine()) != null) {

			tab.add(str);
		}
		while ((str = lp.readLine()) != null) {

			nivEtude.add(str);
		}
		in.close();
		lp.close();
		ArrayList<Diplomes> re = new ArrayList<Diplomes>();
		
		for (String elem : tab) {
			for (String ele : nivEtude) {
				int x = ((elem.toLowerCase()).indexOf(ele));
				if (x > 0) {
					if (re.indexOf(ele)==-1)
					{
						Diplomes d=new Diplomes();
						d.setNom(ele);
					re.add(d);}	
				}
			}
		}
		return re;
	}
}
