package com.github.triploit.npp5.commands;

import java.io.IOException;
import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Function;
import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;
import com.github.triploit.npp5.run.Parser;
import com.github.triploit.npp5.run.Tokenizer;

public class RunF 
{
	public static void func(List<String> args, boolean docc) throws IOException
	{
//		System.out.println("RUNF gefunden!");			
//		
//		for (int i = 0; i < args.size(); i++)
//		{
//			System.out.println("\t["+i+"] "+args.get(i));
//		}
		
		LangVars lv = Main.getLangVars();
		
		for (int i = 0; i < lv.getFunctionList().size(); i++)
		{
			//System.out.println("["+i+"] \""+lv.getFunctionList().get(i).getName()+"\" ?? "+args.get(1));
			
			if (lv.getFunctionList().get(i).getName().equals(args.get(1)))
			{
			    Function f = lv.getFunctionList().get(i);			    
			    Parser p = new Parser("", false, "", false);
			    
			    p.setRawCode(f.getCommands());
			    Tokenizer t = new Tokenizer(p);			    
			    //System.out.println("[[\n"+t.getParser().getRawCode()+"\n]]");
			    
			    t.doTokenize();
			    t.executeCode();
			    return;
			}
			
		}

		Err.printErr("[ ERR ]:[ RUNF ]:[ NOTFOUND:"+args.get(1)+" ] Funktion nicht gefunden!");
		System.exit(0);
	}
}
