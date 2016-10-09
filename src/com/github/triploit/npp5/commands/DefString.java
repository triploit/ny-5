package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;

public class DefString 
{
	public static void func(List<String> args, boolean docc)
	{
//		System.out.println("DEFS gefunden!");	
//		
//		for (int i = 0; i < args.size(); i++)
//		{
//			System.out.println("\t["+i+"] "+args.get(i));
//		}
		
		String vname = args.get(1);
		String tvn = vname.substring(0, 1);
		
		if (LangVars.isNumeric(tvn))
		{
			Err.printErr("[ ERR ]:[ DEFS ]:[ DEFINEVAR ]:[ NAME:"+vname+" ] Der Name einer Variable darf nicht mit einer Zahl beginnen!");
			System.exit(0);
		}
		
		String vvalue = args.get(2);
		
		if (vvalue.equals("[n]"))
		{
			vvalue = "";
		}
		
		if (LangVars.isNumeric(vvalue))
		{
			Err.printErr("[ ERR ]:[ DEFS ]:[ ISNUMERIC ] Der Wert entspricht nicht dem Typen!");
			System.exit(0);
		}
		
		Variable v = new Variable(vname, new Value(vvalue));
		v.setNumeric(false);
		LangVars lv = Main.getLangVars();
		
		if (docc)
		    lv.addCCode("string "+v.getName()+" = \""+v.getValue().getValue()+"\"");
		lv.addLVariable(v);
	}
}
