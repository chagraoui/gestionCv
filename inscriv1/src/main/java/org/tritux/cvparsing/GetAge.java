package org.tritux.cvparsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAge {
	private static final String AGE_PATTERN1 = "[0-9]{2}\\/[0-9]{2}\\/[0-9]";
	private static final String AGE_PATTERN2 = "[0-9]+-[0-9]+-[0-9]+";
	
	public static int age(BufferedReader in) throws IOException {

		String str = in.readLine();
		int res = 0;

		boolean notFind = true;
		
		int numline=0;
		
			while (((str = in.readLine()) != null) && (notFind == true)&&(numline<15)) {
					
				Pattern pattern = Pattern.compile(AGE_PATTERN1);
				Matcher matcher1 = pattern.matcher(str);
				
				Pattern pattern2 = Pattern.compile(AGE_PATTERN2);
				Matcher matcher2 = pattern2.matcher(str);
				
				// verifier si age existe 
				int x = (str.indexOf("ans"));
				if (x > 0) {
					String var="0";
					try{
					var=str.substring(x-3,x-1);
					}catch(java.lang.StringIndexOutOfBoundsException e)
					{
						//System.out.println(str);
					}
					//System.out.println(str);
					//System.out.println(var);	
					try{
						res = Integer.parseInt(var);
					}catch (java.lang.NumberFormatException e){
						//System.out.println(res);
					}
						notFind=false;
					
				}
				
				//verfier format date exp 12/2/1991
				if (matcher1.find()) {
					String year[] = str.split("/");
					String var=year[2].substring(0,4);
					int y = Integer.parseInt(var);
					Calendar c = Calendar.getInstance();
					int yearCurent = c.get(Calendar.YEAR);
					notFind = false;
					//System.out.println(yearCurent - y);
					return yearCurent - y;
				}
			
				
				//verfier format date exp 12-26-1991
				if (matcher2.find()) {
					
					String year[] = str.split("-");
					String var=year[2].substring(0,4);
					int y = Integer.parseInt(var);
					Calendar c = Calendar.getInstance();
					int yearCurent = c.get(Calendar.YEAR);
					notFind = false;
					//System.out.println(yearCurent - y);
					return yearCurent - y;
				}
			numline++;
			}
			in.close();
			return res;
		
	}
}
