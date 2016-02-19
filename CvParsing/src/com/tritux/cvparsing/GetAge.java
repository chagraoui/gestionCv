package com.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAge {
	private static final String Name_PATTERN1 = "[0-9]+-[0-9]+-[0-9]+";

	public static  int age(BufferedReader in) throws IOException {

		
		String str = in.readLine();
		int res=0;
		
		boolean notFind = true;
		while (((str = in.readLine()) != null) && (notFind == true)) {
			Pattern pattern = Pattern.compile(Name_PATTERN1);
			Matcher matcher1 = pattern.matcher(str);
			// System.out.println(str);

			int x = (str.indexOf("ans"));
			if (x > 0) {
				notFind = false;
				String s = str.substring(0, 2);
				res=Integer.parseInt(s);
				System.out.println(res);
			}
			if (matcher1.find()) {
				String year[] = str.split("-");
				int y = Integer.parseInt(year[2]);
				Calendar c = Calendar.getInstance();
				int yearCurent = c.get(Calendar.YEAR);
				notFind = false;
				return yearCurent - y;
			}
		}
		in.close();
	return res;
	}
}
