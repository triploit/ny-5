package com.github.triploit.npp5.commands;

import java.util.List;
import java.util.Scanner;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.LangVars;

public class InputCommand 
{
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
			
		    if (v.getValue().isNumeric() && v.isNumeric() && vs.isNumeric()) // GET INT
		    {
			v.setValue((new Value(Integer.parseInt(in))));
			lv.addCCode("cin >> "+v.getName());
		    }
		    else if (v.getValue().isString() && !v.isNumeric() && vs.isString()) // STRING = INT
		    {
			v.setValue((new Value(in)));
			lv.addCCode("cin >> "+v.getName());
		    }
		    else if (!v.getValue().isString() && v.isNumeric() && vs.isString()) // INT = STRING
		    {
			v.setValue((new Value(in.length())));
			lv.addCCode("cin >> "+v.getName()+"");
		    }
		    else if (v.getValue().isString() && !v.isNumeric() && !vs.isString()) // GET STRING
		    {
			vs.setString(true);
			vs.setNumeric(false);
			v.setValue(vs);
			lv.addCCode("cin >> "+v.getName()+"");
		    }
		    else
		    {
			System.out.println("[ ERR ]:[ INP ]:[ VAL ]:[ SETVALUE:"+v.getName()+"="+vs.getValue().toString()+" ] Die Eingabe hat nicht zum Typ der Variable gepasst!");
			System.exit(0);
		    }
		}
		else
		{
			System.out.println("[ ERR ]:[ INP ]:[ VAR ]:[ NOTFOUND ] Variable \""+args.get(1)+"\" konnte nicht gefunden werden!");
			System.exit(0);
		}
	}
}
