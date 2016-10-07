package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.other.LangVars;

public class DoDeleteVariable 
{
	public static void func(List<String> args, boolean docc)
	{
		LangVars lv = Main.getLangVars();
		
		if (lv.findLVariableByName(args.get(1)))
		{
		    if (docc)
			System.out.println("[ WARN ]:[ DELVAR ] Hier können keine Variablen gelöscht werden!");
		    else
			lv.delLVariableByName(args.get(1));
		}
		else
		{
			System.out.println("[ ERR ]:[ DEL ]:[ VAR ]:[ NOTFOUND ] Konnte die Variable \""+args.get(1)+"\" nicht finden!");
			System.exit(0);
		}
	}
}
