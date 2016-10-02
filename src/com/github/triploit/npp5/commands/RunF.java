package com.github.triploit.npp5.commands;

import java.io.IOException;
import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.other.LangVars;

public class RunF 
{
	public static void func(List<String> args) throws IOException
	{
//		System.out.println("RUNF gefunden!");			
//		
//		for (int i = 0; i < args.size(); i++)
//		{
//			System.out.println("\t["+i+"] "+args.get(i));
//		}
		
		LangVars lv = Main.getLangVars();
		
		for (int i = 0; i < lv.getFunctionList().size(); i++)
		{
			//System.out.println("["+i+"] \""+lv.getFunctionList().get(i).getName()+"\"");
			
			if (!lv.getFunctionList().get(i).getName().equals(args.get(1)))
			{
			}
			else
			{
				//Function f = new Function(lv.getFunctionByName(args.get(1)).getName(), lv.getFunctionByName(args.get(1)).getCommands());
				lv.getFunctionList().get(i).runFunction();
				return;
			}
		}

		System.out.println("[ ERR ]:[ RUNF ]:[ NOTFOUND:"+args.get(1)+" ] Funktion nicht gefunden!");
		System.exit(0);
	}
}
