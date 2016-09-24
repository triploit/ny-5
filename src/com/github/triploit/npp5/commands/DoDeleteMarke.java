package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.other.LangVars;

public class DoDeleteMarke 
{
	public static void func(List<String> args)
	{
		LangVars lv = Main.getLangVars();
		
		if (lv.findGotoByName(args.get(1)))
		{
			lv.delGotoByName(args.get(1));
		}
		else
		{
			System.out.println("[ ERR ]:[ DEL ]:[ GOTO ]:[ NOTFOUND ] Konnte die Sprungmarke \""+args.get(1)+"\" nicht finden!");
		}
	}
}
