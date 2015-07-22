package com.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Anagrams {

	private String sortWord(String string) {
		char[] arr = string.toCharArray();
		Arrays.sort(arr);
		string=String.valueOf(arr);
		return string;
	}

	public HashMap<String,String> process(String filePath) throws IOException {
		 
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String fileContent = "";
    	HashMap<String, String> map = new HashMap<String, String>();
		
		while ((fileContent = reader.readLine()) != null) {
			
			String textToProcess = fileContent;	
			String sort = sortWord(textToProcess);
			
			if (map.containsKey(sort)) {
				String append = map.get(sort) + "--" + textToProcess;
				map.put(sort, append);
			}else {
				map.put(sort, textToProcess);
			}
		}
		return map;
	}
}

public class MainClass
{
	public static void main(String[] args) throws IOException
	{
		Anagrams anagrams=new Anagrams();
		if (args.length==0){
			System.out.println("file path should be given in command line arguements");
		}else {
		HashMap<String, String> map=anagrams.process(args[0]);
	
		Set<String> keys=map.keySet();
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			
			String data = map.get(string);
			if(data.contains("--")) {	
					System.out.println(data);
			}
		}
		}
	}
}
