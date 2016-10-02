package com.github.triploit.npp5.commands;

import java.io.IOException;
import java.util.List;

import com.github.triploit.npp5.run.Parser;
import com.github.triploit.npp5.run.Tokenizer;

public class Pf 
{
	public static void func(List<String> args) throws IOException
	{
		Parser p;
		System.out.println("# "+args.get(1));
		
		try 
		{
			p = new Parser(args.get(1), false, "");		
			Tokenizer tok = new Tokenizer(p);
			
			tok.doTokenize();
			tok.executeCode();
		} 
		catch (IOException e) 
		{
			System.out.println("[ ERR ]:[ PF ]:[ FILE ]:[ FILENOTFOUND:"+args.get(1)+" ] Konnte Datei nicht finden!");
			System.exit(0);
		}
	}
}
