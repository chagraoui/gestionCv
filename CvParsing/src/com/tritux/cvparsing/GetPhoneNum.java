package com.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetPhoneNum {

	public static String num(BufferedReader in) throws IOException {

	
		String str = in.readLine();

		boolean NoFind = true;
		String res=null;
		while (((str = in.readLine()) != null) && (NoFind)) {
			String out = str.replaceAll("\\s", "");
			Pattern pattern = Pattern.compile("\\d{8,}");
			Matcher matcher = pattern.matcher(out);

			if (matcher.find()) {

				res=matcher.group(0);
				NoFind = false;

			}

		}
		
		in.close();
		return res;
	}
}