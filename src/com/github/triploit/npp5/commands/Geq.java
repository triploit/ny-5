package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.LangVars;
import com.github.triploit.npp5.run.CommandGetter;

public class Geq {
	public static int func(List<String> args, boolean docc)
	{

//		System.out.println("GEQ gefunden!");
		
		LangVars lv = Main.getLangVars();
		Variable var = new Variable(lv.getLVariableByName(args.get(1)).getName(), lv.getLVariableByName(args.get(1)).getValue());
		Variable val = new Variable(lv.getLVariableByName(args.get(2)).getName(), lv.getLVariableByName(args.get(2)).getValue());
		String marke = args.get(3);
		
		try
		{
			if (!var.getName().equals("[NotFound]"))
			{
				if (val.getName().equals("[NotFound]"))
				{
					System.out.println("[ ERR ]:[ GEQ ]:[ VAL/VAR2 ]:[ NOTFOUND:"+args.get(2)+" ] Konnte die Variable nicht finden!");
					System.exit(0);
				}
				if (docc)
			    	    lv.addCCode("if ("+var.getName()+" >= "+val.getName()+")\n\tgoto "+marke);
			    	else
				{
					if (Integer.parseInt(var.getValue().getValue().toString()) > Integer.parseInt(val.getValue().getValue().toString()))
					{
//					    if (docc)
//						lv.addCCode("if ("+var.getName()+" >= "+val.getName()+")\n\tgoto "+marke);
//					    else
						return lv.getGotoIntByName(marke);
					}			
				}
			}
			else
			{
				System.out.println("[ ERR ]:[ GEQ ]:[ VAR ]:[ NOTFOUND:"+var.getName()+" ] Konnte die Variable nicht finden!");
				System.exit(0);
			}
		}
		catch(Exception ex)
		{
			if (!var.getName().equals("[NotFound]"))
			{
				if (val.getName().equals("[NotFound]"))
				{
					System.out.println("[ ERR ]:[ GEQ ]:[ VAL/VAR2 ]:[ NOTFOUND:"+args.get(2)+" ] Konnte die Variable nicht finden!");
					System.exit(0);
				}
				else
				{
					if (var.getValue().getValue().toString().length() > val.getValue().getValue().toString().length())
					{
					    if (docc)
						lv.addCCode("if ("+var.getName()+".size() >= "+val.getName()+".size())\n\tgoto "+marke);
					    else
						return lv.getGotoIntByName(marke);
					}			
				}
			}
			else
			{
				System.out.println("[ ERR ]:[ GEQ ]:[ VAR ]:[ NOTFOUND:"+var.getName()+" ] Konnte die Variable nicht finden!");
				System.exit(0);
			}
			//System.out.println("[ ERR ]:[ GEQ ]:[ VAR ]:[ FALSETYPE:"+var.getName()+"&"+val.getName()+" ] Falscher Typ der beiden Variablen!");
		}
		
		return CommandGetter.getJ();
	}
}
