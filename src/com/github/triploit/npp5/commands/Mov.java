package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.*;
import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;

public class Mov 
{
	public static void func(List<String> args, boolean docc)
	{
//		System.out.println("MOV gefunden!");	
//		
//		for (int i = 0; i < args.size(); i++)
//		{
//			System.out.println("\t["+i+"] "+args.get(i));
//		}
		
		LangVars lv = Main.getLangVars();
		Variable val = new Variable(lv.getLVariableByName(args.get(1)).getName(), lv.getLVariableByName(args.get(1)).getValue());;
		Variable var = new Variable(lv.getLVariableByName(args.get(2)).getName(), lv.getLVariableByName(args.get(2)).getValue());
		
		
		
		if (var.getName().equals("[NotFound]") || !lv.findLVariableByName(var.getName()))
		{
			Err.printErr("[ ERR ]:[ MOV ]:[ NOTFOUND:"+var.getName()+" ] Variable konnte nicht gefunden werden!");
			System.exit(0);
		}
		else
		{
		    
		    	if (docc)
		    	{
		    	    	lv.addCCode(var.getName()+" = "+val.getName());
				return;
		    	}
		    	
			if (val.getName().equals("[NotFound]")  || !lv.findLVariableByName(val.getName()))
			{
				val = new Variable("NF", new Value(args.get(1)));
				
				if (!lv.getLVariableByName(args.get(2)).testValue(val.getValue()))
				{
				    System.out.println("\n\t[ ERR ]:[ MOV ]:[ NOTFOUND:"+var.getName()+" ] Variable konnte nicht gefunden werden!\n>> ODER <<\n\t"+"[ ERR ]:[ SYS ]:[ VAR ]:[ SETVALUE ] Der Wert passt nicht zum Typ!");
				    System.exit(0);
				}
			}
			else
			{
				lv.getLVariableByName(args.get(2)).setValue(val.getValue());				
			}
		}
	}
}
