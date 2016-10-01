package com.github.triploit.npp5.commands;

import java.io.IOException;
import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Function;
import com.github.triploit.npp5.other.LangVars;

public class RunF 
{
	public static void func(List<String> args) throws IOException
	{
		LangVars lv = Main.getLangVars();
		Function f = new Function(lv.getFunctionByName(args.get(1)).getName(), lv.getFunctionByName(args.get(1)).getCommands());
		
		if (f.getName().equals("[NotFound]"))
		{
			System.out.println("[ ERR ]:[ RUNF ]:[ NOTFOUND:"+args.get(1)+" ] Funktion nicht gefunden!");
			System.exit(0);
		}
		else
		{
			f.runFunction();
		}
	}
}
