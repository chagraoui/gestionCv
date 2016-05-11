package org.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetName {

	private static final String Name_PATTERN1 = "[A-Z]+ +[A-Z]+";
	private static final String Name_PATTERN2 = "[A-Z]*[a-z]+ +[A-Z]*[a-z]+";

	public static String name(BufferedReader in) throws IOException {

		int numline = 1;
		String res = "";
		boolean NoFind = true;

		while ((numline < 7) && (NoFind)) {

			String str = in.readLine();
			Pattern pattern = Pattern.compile(Name_PATTERN1);
			Pattern pattern2 = Pattern.compile(Name_PATTERN2);

			Matcher matcher1 = pattern.matcher(str);
			Matcher matcher2 = pattern2.matcher(str);

			while ((matcher1.find()) || (matcher2.find())) {
				// modifier matcher.group
				if (matcher1.find()) {
					// String nom = matcher1.group();
					res = str;
					NoFind = false;
				} else {
					// nom= matcher2.group();
					res = str;
					NoFind = false;
				}

			}
			numline++;
		}

		in.close();
		return res;
	}
}