package com.github.triploit.npp5.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser 
{
	private String code;
	
	@SuppressWarnings("resource")
	public Parser(String filename) throws IOException
	{
		if (!(filename.endsWith(".ny5") || filename.endsWith(".nypp5") || filename.endsWith(".n5")))
		{
			System.out.println("[ ERR ]:[ PARSER ]:[ FILE ]:[ FALSENAME ] Die Datei muss auf \".ny5\", \".n5\" oder \".nypp5\" enden!");
			System.exit(0);
		}
		
		code = "";
		try 
		{
			BufferedReader br = new BufferedReader((new FileReader((new File(filename)))));
			String line;
			
			while ((line = br.readLine()) != null)
			{
				code += line + "\n";
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("[ ERR ]:[ PARSER ]:[ FILE ]:[ NOTFOUND] Konnte Datei nicht finden!");
			System.exit(0);
		}
	}
	
	public String getRawCode()
	{
		return this.code;
	}
}
