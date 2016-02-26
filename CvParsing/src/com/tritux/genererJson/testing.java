package com.tritux.genererJson;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class testing {
    public static void main(String[] args) throws IOException {    	
    	
    	for (int i = 1; i <=100 ; i++) {
    		
    	String oout = "cvConverti/cv" + i + ".txt";
    	System.out.println(oout);
    	
    	obj x = new obj(oout);
   	   	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	
    	// convert java object to JSON format,
    	// and returned as JSON formatted string
    	String json = gson.toJson(x);
    	//System.out.println(json);
   

    	try {
    		//write converted json data to a file named "cv.json"
    		FileWriter writer = new FileWriter("cvJson/cv"+i+".json");
    		writer.write(json);
    		writer.write("\r\n");
    		writer.close();

    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	}

    	// pour tester sur un fichier json 
    	
    	
//    	obj x=new obj("cvMehdi.txt");
//    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
//    	String json = gson.toJson(x);
//     	System.out.println(json);
    	
    }
}