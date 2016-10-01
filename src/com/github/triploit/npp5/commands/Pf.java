package com.github.triploit.npp5.commands;

import java.io.IOException;
import java.util.List;

import com.github.triploit.npp5.run.Parser;
import com.github.triploit.npp5.run.Tokenizer;

public class Pf 
{
	public static void func(List<String> args) throws IOException
	{
		Parser p = null;
		System.out.println("# "+args.get(1));
		
		try {
			p = new Parser(args.get(1), false, "");
		} catch (IOException e) {
			System.out.println("[ ERR ]:[ PF ] Konnte Datei nicht finden!");
			System.exit(0);
		}
		
		Tokenizer tok = new Tokenizer(p);
		
		tok.doTokenize();
		tok.executeCode();
	}
}
