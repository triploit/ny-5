package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.LangVars;

public class Mul {
	public static void func(List<String> args, boolean docc)
	{
		LangVars lv = Main.getLangVars();
		Variable var = new Variable(lv.getLVariableByName(args.get(1)).getName(), lv.getLVariableByName(args.get(1)).getValue());
		Variable val = new Variable(lv.getLVariableByName(args.get(2)).getName(), lv.getLVariableByName(args.get(2)).getValue());
		
		if (!var.getName().equals("[NotFound]"))
		{
			if (val.getName().equals("[NotFound]"))
			{
				val = new Variable("NF", new Value(args.get(2)));
				
				if (!lv.getLVariableByName(args.get(2)).testValue(val.getValue()))
				{
				    System.out.println("\n\t[ ERR ]:[ MUL ]:[ NOTFOUND:"+var.getName()+" ] Variable konnte nicht gefunden werden!\n>> ODER <<\n\t"+"[ ERR ]:[ SYS ]:[ VAR ]:[ SETVALUE ] Der Wert passt nicht zum Typ!");
				    System.exit(0);
				}

				if (docc)
				    lv.addCCode(var.getName()+"= "+var.getName()+" * "+val.getName());
				else
					lv.getLVariableByName(var.getName()).mulValue(val.getValue().getValue());
			}
			else
			{
				if (docc)
				    lv.addCCode(var.getName()+"= "+var.getName()+" * "+val.getName());
				else
				    lv.getLVariableByName(var.getName()).mulValue(val.getValue().getValue());			
			}
		}
		else
		{
			System.out.println("[ ERR ]:[ MUL ]:[ VAR ]:[ NOTFOUND:"+var.getName()+" ] Konnte die Variable nicht finden!");
			System.exit(0);
		}
	}
}
