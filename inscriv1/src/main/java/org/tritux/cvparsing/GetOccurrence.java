package org.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class GetOccurrence {

	@SuppressWarnings("resource")
	public static HashMap<String, Integer> occ(BufferedReader in) throws IOException {
		// *********************Load Stop Words***************

		List<String> StopWords = new ArrayList<String>();

		BufferedReader in1 = null;
		try {
			in1 = new BufferedReader(new FileReader("stopWords.txt"));
			String str;
			while ((str = in1.readLine()) != null) {
				StopWords.add(str.toLowerCase());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// *********************Load CV***************

		
		String line = new String();

		String[] words = new String[1000];
		List<String> fileword = new ArrayList<String>();
		// String fileword = new String("");


			while ((line = in.readLine()) != null) {
				words = line.split("[ \n\t\r.,;+-/:!?(){}]");
				for (int i = 0; i < words.length; i++) {
					fileword.add(words[i].toLowerCase().replaceAll("\\d", "")
							.replaceAll("ï‚·", ""));
				}
			}
		

		// ******************Remove Stop Words from cv********************
		fileword.removeAll(StopWords);
		// ******************Calculate the occurrence using hashmap******************
		final Map<String, Integer> map = new HashMap<String, Integer>();

		for (int j = 0; j < fileword.size(); j++) {
			String key = fileword.get(j);

			if (key.length() > 0) {
				if (map.get(key) == null) {
					map.put(key, 1);
				}

				else {
					int value = map.get(key).intValue();
					value++;
					map.put(key, value);
				}
			}
		}

		// Ajout des entrÃ©es de la map Ã  une liste
		
		
		final List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(
				map.entrySet());
		
		HashMap<String, Integer> ht=new HashMap<String, Integer>();
		for (final Entry<String, Integer> entry : entries) {
			//System.out.println(entry.getValue() + "\t" + entry.getKey());
			if(entry.getValue()>2)
			ht.put(entry.getKey(), entry.getValue());
		}
		
		/*Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
			public int compare(final Entry<String, Integer> e2,
					final Entry<String, Integer> e1) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});*/
		
	return  ht;
	}
}
