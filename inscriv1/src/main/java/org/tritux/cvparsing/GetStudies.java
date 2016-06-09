package org.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.tritux.entites.Diplomes;

public class GetStudies {

	private static final String Anne_PATTERN = "[0-9]";

	public static ArrayList<Diplomes> studies(BufferedReader in)
			throws IOException {

		BufferedReader lp = new BufferedReader(new FileReader("nivEtude.txt"));

		ArrayList<String> tab, nivEtude;
		String res = "";

		tab = new ArrayList<String>();
		nivEtude = new ArrayList<String>();

		// remplir le arraylist tab par le cv .text
		String str;
		while ((str = in.readLine()) != null) {
			tab.add(str);
		}

		// remplir le arraylist niv par les defferents niveau d etude
		while ((str = lp.readLine()) != null) {

			nivEtude.add(str);
		}
		in.close();
		lp.close();

		// re array list de Diplomes

		ArrayList<Diplomes> re = new ArrayList<Diplomes>();

		for (String elem : tab) {
			for (String ele : nivEtude) {

				int x = ((elem.toLowerCase()).indexOf(ele));
				ele.toLowerCase();
				elem.toLowerCase();
				if (x > 0) {
					System.out.println(ele);
				
					// on verifie si il existe deja dans le arrayList ou pas
					boolean exist=false;
					for (Diplomes di:re){
						if (di.getNom()==ele)
							exist=true;
					} 
					
					if (!exist) {
						System.out.println(exist);
						Diplomes d = new Diplomes();
						d.setNom(ele);
						String[] parts = elem.split(" ");
						for (String date : parts) {
							try {
								int r = Integer.parseInt(date);
								// System.out.println(r);
								d.setDateObtention(r);
							} catch (java.lang.NumberFormatException e) {
								// System.out.println(res);
							}
						}
						// System.out.println("***********************");

						// d.setDateObtention();
						re.add(d);
						System.out.println(d);
					}
				}
			}
		}
		return re;
	}
}
