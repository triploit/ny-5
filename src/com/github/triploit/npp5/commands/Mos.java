package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;

public class Mos
{
	public static void func(List<String> args, boolean docc)
	{
		// System.out.println("MOS gefunden!");
		//
		// for (int i = 0; i < args.size(); i++)
		// {
		// System.out.println("\t["+i+"] "+args.get(i));
		// }
		
		LangVars lv = Main.getLangVars();
		Variable val = new Variable(lv.getLVariableByName(args.get(1)).getName(), new Value(args.get(1)));
		
		Variable var = new Variable(lv.getLVariableByName(args.get(2)).getName(),
				lv.getLVariableByName(args.get(2)).getValue());
		
		if (var.getName().equals("[NotFound]") || !lv.findLVariableByName(var.getName()))
		{
			Err.printErr("[ ERR ]:[ MOS ]:[ NOTFOUND:" + var.getName() + " ] Variable konnte nicht gefunden werden!");
			System.exit(0);
		}
		else
		{
			
			if (docc)
			{
				lv.addCCode(var.getName() + " = " + val.getValue().getValue().toString());
				return;
			}
			
			if (!val.getValue().isNumeric() && val.getValue().isString() && !var.getValue().isNumeric())
			{
				lv.getLVariableByName(args.get(2)).setValue(val.getValue());
			}
			else
			{
				Err.printErr("[ ERR ]:[ MOS ]:[ VALUE ] Der eingegebene Wert ist kein String oder die Variable ist kein String!");
				System.exit(0);
			}
		}
	}
}
