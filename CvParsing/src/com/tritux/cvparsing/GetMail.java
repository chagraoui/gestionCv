package com.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetMail {

	private static Pattern pattern;
	private static Matcher matcher;
	private static String str;
	private static String email;
	static String line = null;

	private static final String EMAIL_PATTERN = "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";

	public static String mail(BufferedReader in) throws IOException {

		

		// *********************** email *************************

		while ((str = in.readLine()) != null) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(str);
			while (matcher.find()) {
				email = matcher.group();
			}

		}
		// *******************************************************
		
		in.close();
		return email;
	}

}
