package com.github.triploit.npp5.commands;

import java.util.List;
import java.util.Scanner;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.LangVars;

public class InputCommand {
	@SuppressWarnings("resource")
	public static void func(List<String> args)
	{
		LangVars lv = Main.getLangVars();
		
		Variable v = lv.getLVariableByName(args.get(1));
		
		if (!v.getName().equals("[NotFound]"))
		{
			Scanner s = new Scanner(System.in);
			String in = s.nextLine();
			
			Value vs = new Value(in);
			
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
				System.out.println("[ ERR ]:[ INP ]:[ VAL ]:[ SETVALUE ] Die Eingabe hat nicht zum Typ der Variable gepasst!");
				System.exit(0);
			}
		}
		else
		{
			System.out.println("[ ERR ]:[ INP ]:[ VAR ]:[ NOTFOUND ] Variable \""+args.get(1)+"\" konnte nicht gefunden werden!");
		}
	}
}
