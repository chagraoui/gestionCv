package com.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.IOException;

public class GetCertif {

	public static String certif(BufferedReader in) throws IOException {
		

		String str=null;
		try {
			while ((str = in.readLine()) != null) {

				int x = (str.indexOf("Cert"));
				if (x > 0) {
					return str;
				}
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		in.close();
	return str;
	}

}
