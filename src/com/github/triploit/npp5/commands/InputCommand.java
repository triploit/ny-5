package com.github.triploit.npp5.commands;

import java.util.List;
import java.util.Scanner;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;

public class InputCommand 
{
	@SuppressWarnings("resource")
	public static void func(List<String> args, boolean docc)
	{
		LangVars lv = Main.getLangVars();
		Variable v = lv.getLVariableByName(args.get(1));
		
		if (!v.getName().equals("[NotFound]"))
		{
		    Scanner s = new Scanner(System.in);
		    String in = "";
		    
		    if (docc == false)
		    {
			s = new Scanner(System.in);
		    	in = s.nextLine();
		    }
			
		    Value vs = new Value(in);
			
		    if (v.getValue().isNumeric() && v.isNumeric() && vs.isNumeric()) // GET INT
		    {
			if (docc)
			{
				lv.addCCode("cin >> "+v.getName());
				return;
			}
			else
			    v.setValue((new Value(Integer.parseInt(in))));
		    }
		    else if (v.getValue().isString() && !v.isNumeric() && vs.isString()) // STRING = INT
		    {
			if (docc)
			{
				lv.addCCode("getline(cin, "+v.getName()+")");
				return;
			}
			else
			    v.setValue((new Value(in)));
		    }
		    else if (!v.getValue().isString() && v.isNumeric() && vs.isString()) // INT = STRING
		    {
			if (docc)
			{
				lv.addCCode("cin >> "+v.getName());
				return;
			}
			else
			    v.setValue((new Value(in.length())));
		    }
		    else if (v.getValue().isString() && !v.isNumeric() && !vs.isString()) // GET STRING
		    {
			if (docc)
			{
				lv.addCCode("getline(cin, "+v.getName()+")");
				return;
			}
			else
			{
        			vs.setString(true);
        			vs.setNumeric(false);
        			v.setValue(vs);
			}
		    }
		    else
		    {
			Err.printErr("[ ERR ]:[ INP ]:[ VAL ]:[ SETVALUE:"+v.getName()+"="+vs.getValue().toString()+" ] Die Eingabe hat nicht zum Typ der Variable gepasst!");
			System.exit(0);
		    }
		}
		else
		{
			Err.printErr("[ ERR ]:[ INP ]:[ VAR ]:[ NOTFOUND ] Variable \""+args.get(1)+"\" konnte nicht gefunden werden!");
			System.exit(0);
		}
	}
}
