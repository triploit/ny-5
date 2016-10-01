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
		System.out.println("DEFF");
		LangVars lv = Main.getLangVars();
		
		Function f = new Function(args.get(1), args.get(2));
		Function f1 = new Function(lv.getFunctionByName(args.get(1)).getName(), lv.getFunctionByName(args.get(1)).getCommands());
		
		if (!f1.getName().equals("[NotFound]"))
		{
			System.out.println("[ ERR ]:[ DEFF ]:[ ALREADYDEFINED:"+args.get(1)+" ] Funktion wurde schon definiert!");
			System.exit(0);
		}
		else
		{
			lv.addFunction(f);
		}
	}
}
