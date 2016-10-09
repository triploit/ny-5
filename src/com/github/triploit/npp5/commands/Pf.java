package com.github.triploit.npp5.commands;

import java.io.IOException;
import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;
import com.github.triploit.npp5.run.Parser;
import com.github.triploit.npp5.run.Tokenizer;

public class Pf 
{
	public static void func(List<String> args) throws IOException
	{
		Parser p;	
		LangVars lv = Main.getLangVars();
		
		try 
		{
			p = new Parser(args.get(1), false, "", false);
			p.parseAll();
			Tokenizer tok = new Tokenizer(p);
			lv.setCurFile(args.get(1));
			
			tok.doTokenize();
			tok.executeCode();
			return;
		} 
		catch (Exception e) 
		{
			Err.printErr("[ ERR ]:[ PF ]:[ FILE ]:[ FILENOTFOUND:"+args.get(1)+" ] Konnte Datei nicht finden!");
			System.exit(0);
		}
	}
}
