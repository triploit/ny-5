package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.other.LangVars;

public class DoDeleteVariable 
{
	public static void func(List<String> args)
	{
		LangVars lv = Main.getLangVars();
		
		if (lv.findLVariableByName(args.get(1)))
		{
			lv.delLVariableByName(args.get(1));
		}
		else
		{
			System.out.println("[ ERR ]:[ DEL ]:[ VAR ]:[ NOTFOUND ] Konnte die Variable \""+args.get(1)+"\" nicht finden!");
			System.exit(0);
		}
	}
}
