package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;

public class DoDeleteMarke 
{
	public static void func(List<String> args, boolean docc)
	{
		LangVars lv = Main.getLangVars();
		
		if (lv.findGotoByName(args.get(1)))
		{
		    if (docc)
			System.out.println("[ WARN ]:[ DELGOTO ] Hier können keine Sprungmarken gelöscht werden!");
		    else
			lv.delGotoByName(args.get(1));
		}
		else
		{
			Err.printErr("[ ERR ]:[ DEL ]:[ GOTO ]:[ NOTFOUND ] Konnte die Sprungmarke \""+args.get(1)+"\" nicht finden!");
			System.exit(0);
		}
	}
}
