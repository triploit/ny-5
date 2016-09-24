package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.*;
import com.github.triploit.npp5.other.LangVars;

public class Mov 
{
	public static void func(List<String> args)
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
		
		if (var.getName().equals("[NotFound]"))
		{
			System.out.println("[ ERR ]:[ MOV ]:[ NOTFOUND:"+var.getName()+" ] Variable konnte nicht gefunden werden!");
		}
		else
		{
			if (val.getName().equals("[NotFound]"))
			{
				val = new Variable("NF", new Value(args.get(1)));
				lv.getLVariableByName(args.get(2)).setValue(val.getValue());
			}
			else
			{
				lv.getLVariableByName(args.get(2)).setValue(val.getValue());				
			}
		}
	}
}
