package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;
import com.github.triploit.npp5.run.CommandGetter;

public class Eq 
{
	public static int func(List<String> args, boolean docc)
	{
//		System.out.println("EQ gefunden!");
		
		LangVars lv = Main.getLangVars();
		Variable var = new Variable(lv.getLVariableByName(args.get(1)).getName(), lv.getLVariableByName(args.get(1)).getValue());
		Variable val = new Variable(lv.getLVariableByName(args.get(2)).getName(), lv.getLVariableByName(args.get(2)).getValue());
		String marke = args.get(3);
		
		if (!var.getName().equals("[NotFound]"))
		{
			if (val.getName().equals("[NotFound]"))
			{
				Err.printErr("[ ERR ]:[ EQ ]:[ VAL/VAR2 ]:[ NOTFOUND:"+args.get(2)+" ] Konnte die Variable nicht finden!");
				System.exit(0);
			}
			else
			{
			    	if (docc)
			    	    lv.addCCode("if ("+var.getName()+" == "+val.getName()+")\n\t\tgoto "+marke);
			    	else if (var.getValue().getValue().toString().equals(val.getValue().getValue().toString()))
				{
			    	    return lv.getGotoIntByName(marke);
				}			
			}
		}
		else
		{
			Err.printErr("[ ERR ]:[ EQ ]:[ VAR ]:[ NOTFOUND:"+var.getName()+" ] Konnte die Variable nicht finden!");
			System.exit(0);
		}
		
		return CommandGetter.getJ();
	}

}
