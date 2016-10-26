package com.github.triploit.npp5.commands;

import java.io.IOException;
import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Function;
import com.github.triploit.npp5.other.LangVars;

public class DefFunction 
{
	public static void func(List<String> args) throws IOException
	{
		String args2 = args.get(2);
		
		if (args2.endsWith("]]"))
		{
			args2 = args2.substring(0, args2.length()-2);
		}
		
		System.out.println("DEFF gefunden!");		
		
		for (int i = 0; i < args.size(); i++)
		{
			if (i == 2)
				System.out.println("\t["+i+"] "+args2);
			else
				System.out.println("\t["+i+"] "+args.get(i));
		}
		
		//System.out.println("DEFF");
		LangVars lv = Main.getLangVars();
		Function f;
		//Function f1 = new Function(lv.getFunctionByName(args.get(1)).getName(), lv.getFunctionByName(args.get(1)).getCommands());
		
		if (lv.findFunctionByName(args.get(1)))
		{
			System.out.println("[ ERR ]:[ DEFF ]:[ ALREADYDEFINED:"+args.get(1)+" ] Funktion wurde schon definiert!");
			//System.exit(0);
		}
		else
		{
			f = new Function(args.get(1), args2);
			lv.addFunction(f);
		}
	}
}
