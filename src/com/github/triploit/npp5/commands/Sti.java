package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;

public class Sti
{
	public static void func(List<String> args, boolean docc)
	{
//		 System.out.println("STI gefunden!");
//		
//		 for (int i = 0; i < args.size(); i++)
//		 {
//		 System.out.println("\t["+i+"] "+args.get(i));
//		 }

		LangVars lv = Main.getLangVars();
		Variable val = new Variable(lv.getLVariableByName(args.get(1)).getName(), new Value(args.get(1)));
		Variable var = new Variable(lv.getLVariableByName(args.get(2)).getName(),
				lv.getLVariableByName(args.get(2)).getValue());
		
		if (var.getName().equals("[NotFound]") || !lv.findLVariableByName(var.getName()))
		{
			Err.printErr("[ ERR ]:[ STI ]:[ NOTFOUND:" + var.getName() + " ] Variable konnte nicht gefunden werden!");
			System.exit(0);
		}
		else
		{
			if (!val.getName().equals("[NotFound]") && lv.findLVariableByName(val.getName()) && val.getValue().isString())
			{
				if (lv.getLVariableByName(args.get(1)).getValue().isNumeric())
				{
					val.getValue().setNumeric(true);
					val.getValue().setString(false);
				}
				
				val.setValue(new Value(lv.getLVariableByName(args.get(1)).getValue().getValue()));
			}
				
			if (docc)
			{
				if (val.getName().equals("[NotFound]") || !lv.findLVariableByName(val.getName()))
					lv.addCCode(var.getName() + " = (char) " + val.getValue().getValue().toString());
				else 
					lv.addCCode(var.getName() + " = (char) " + val.getName());
					
				return;
			}
			
			if (val.getValue().isNumeric() && !val.getValue().isString() && !var.getValue().isNumeric())
			{
				int x = (int) val.getValue().getValue();				
				lv.getLVariableByName(args.get(2)).setValue(new Value(Character.toString((char) x)));
			}
			else
			{
				Err.printErr("[ ERR ]:[ STI ]:[ VALUE ] Der angegebene Wert (A1) ist kein Integer oder die Variable (A2) ist kein String!");
				System.exit(0);
			}
		}
	}
}
