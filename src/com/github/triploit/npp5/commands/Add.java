package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.LangVars;

public class Add 
{
	public static void func(List<String> args)
	{
		LangVars lv = Main.getLangVars();
		Variable var = new Variable(lv.getLVariableByName(args.get(1)).getName(), lv.getLVariableByName(args.get(1)).getValue());
		Variable val = new Variable(lv.getLVariableByName(args.get(2)).getName(), lv.getLVariableByName(args.get(2)).getValue());
		
		if (!var.getName().equals("[NotFound]"))
		{
			if (val.getName().equals("[NotFound]"))
			{
				val = new Variable("NF", new Value(args.get(2)));
				lv.getLVariableByName(var.getName()).addValue(val.getValue().getValue());
			}
			else
			{
				lv.getLVariableByName(var.getName()).addValue(val.getValue().getValue());			
			}
		}
		else
		{
			System.out.println("[ ERR ]:[ ADD ]:[ VAR ]:[ NOTFOUND:"+var.getName()+" ] Konnte die Variable nicht finden!");
		}
	}
}
