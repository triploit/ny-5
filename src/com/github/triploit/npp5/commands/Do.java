package com.github.triploit.npp5.commands;

import java.util.List;
import java.util.Scanner;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.LangVars;

public class Do 
{
	@SuppressWarnings("resource")
	public static void func(List<String> args)
	{
//		System.out.println("DO gefunden!");			
//		
//		for (int i = 0; i < args.size(); i++)
//		{
//			System.out.println("\t["+i+"] "+args.get(i));
//		}
		
		String fun = args.get(1);
		LangVars lv = Main.getLangVars();
		
		Variable v = lv.getLVariableByName(args.get(2));
		
		if (!v.getName().equals("[NotFound]"))
		{
			if (fun.equalsIgnoreCase("out"))
			{
				System.out.print(v.getValue().getValue());
			}
			else if (fun.equalsIgnoreCase("in"))
			{
				Scanner s = new Scanner(System.in);
				String in = "";
				
				Value vs = new Value(s.nextLine());
				
				if (v.getValue().isNumeric() && v.isNumeric() && vs.isNumeric())
				{
					v.setValue((new Value(in.length())));
				}
				else if (v.getValue().isString() && !v.isNumeric() && vs.isString())
				{
					v.setValue((new Value(in)));
				}
				else
				{
					System.out.println("[ ERR ] Die Eingabe hat nicht zum Typ der Variable gepasst!");
					System.exit(0);
				}
			}
		}
		else
		{
			System.out.println("[ OUT ] Variable \""+args.get(2)+"\" konnte nicht gefunden werden!");
			System.exit(0);
		}
		
	}
}
