package com.tritux.genererJson;

import java.io.IOException;
import com.google.gson.Gson;
import com.tritux.cvparsing.CV;


public class yo {
    public static void main(String[] args) throws IOException {

	
    CV c = new CV();
    System.out.println(c);
	
	Gson gson = new Gson();

	// convert java object to JSON format,
	// and returned as JSON formatted string
	String json = gson.toJson(c);
	System.out.println(json);

    }
}