package com.github.triploit.npp5.run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.github.triploit.npp5.other.CompileCode;
import com.github.triploit.npp5.other.Err;

@SuppressWarnings("resource")
public class Parser 
{
	private String code;
	private String filename;
	private boolean doenc;
	private boolean rfne;
	private String outfile;

	public Parser(String filename, boolean doenc, String outfile, boolean rfne) throws IOException
	{
		this.doenc = doenc;
		this.outfile = outfile;
		this.filename = filename;
		this.rfne = rfne;
	}
	
	public String getRawCode()
	{
		return this.code;
	}
	
	public void setRawCode(String code)
	{
		this.code = code;
	}
	
	public void parseAll() throws IOException
	{
		if (this.rfne)
		{
		    if ((!filename.endsWith(".ny5") && !filename.endsWith(".nct5")))
		    {
			Err.printErr("[ ERR ]:[ PARSER ]:[ FILE ]:[ FALSENAME ] Die Datei muss auf \".ny5\"/\".nct5\" enden!");
			System.exit(0);
		    }
		}
		
		code = "";
		try 
		{
			BufferedReader br = new BufferedReader((new FileReader((new File(filename)))));		
			String line;
			//int i = 0;
			
			if (doenc)
			{
				outfile = outfile.replace("ny5", "nct5");
				
				BufferedWriter bw = new BufferedWriter((new FileWriter((outfile))));
				CompileCode cc = new CompileCode("");
				cc.initStrings();
				
				while ((line = br.readLine()) != null)
				{
					//i++;
					if (doenc)
					{
						cc.setCode(line);
						line = cc.encryptCode()+"\n";
						
						bw.write(line);
						//System.out.print(i+"\t"+line);
						line = cc.decryptCode()+"\n";
					}
					code += line;			
				}
				bw.close();
				System.out.println("[ SYS ]:[ COMPILE ]:[ ENCRYPT ] Fertig!");
				System.exit(0);
			}
			else
			{
				CompileCode cc = new CompileCode("");
				cc.initStrings();
				
				while ((line = br.readLine()) != null)
				{
					cc.setCode(line);
					line = cc.decryptCode()+"\n";
					code += line;		
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			Err.printErr("[ ERR ]:[ PARSER ]:[ FILE ]:[ NOTFOUND] Konnte Datei nicht finden!");
			System.exit(0);
		}
	}
}
