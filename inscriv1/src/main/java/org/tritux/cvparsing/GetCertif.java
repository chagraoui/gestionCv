package org.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.tritux.entites.Certification;

public class GetCertif {

	public static ArrayList certif(BufferedReader in) throws IOException {
		
		ArrayList<Certification> re = new ArrayList<Certification>();
		
		String str=null;
		try {
			while ((str = in.readLine()) != null) {

				int x = (str.indexOf("Cert"));
				if (x > 0) {
					Certification c =new Certification();
					c.setNomCertif(str);
					re.add(c);
				}
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		in.close();
	return re;
	}

}
