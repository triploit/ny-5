package com.github.triploit.npp5.run;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Command;
import com.github.triploit.npp5.commands.*;
import com.github.triploit.npp5.other.LangVars;

public class CommandGetter 
{
	private List<Command> lcommands = new ArrayList<Command>();
	private List<String> cmds = new ArrayList<String>();
	private static int j = 0;
	
	public CommandGetter(List<String> cmds, List<Command> lcommands)
	{
		this.lcommands = lcommands;
		this.cmds = cmds;
	}
	
	public void execute() throws IOException
	{
		//System.out.println("[ NYPP ] Execute...\n");
		int lj = 0;
		
		for (j = 0; j < cmds.size(); j++)
		{		
			if (cmds.get(j).equals(";"))
					j++;
//			System.out.println("[ CMD ] "+cmds.get(j));
//			if (cmds.get(j).startsWith("{") && cmds.get(j).endsWith("}"))
//			{
//				System.out.println("[ GOTO ] Sprungmarke definieren: "+cmds.get(j));
//				LangVars lv = Main.getLangVars();
//				lv.addGotoValue(cmds.get(j).replace("{", "").replace("}", "")+"^"+j);
//			}
			
			if (cmds.get(j).equals("@"))
				System.out.println("");
			
			for (int i = 0; i < this.lcommands.size(); i++)
			{				
				if (cmds.get(j).equalsIgnoreCase(lcommands.get(i).getName()))
				{
					List<String> args = new ArrayList<String>();
					for (int x = 0; x <= lcommands.get(i).getArgCount() && j < cmds.size(); x++)
					{
						args.add(cmds.get(j));
						j++;
					}
					
//					for (int z = 0; z < LangVars.getFunctionList().size(); z++)
//					{
					String name = lcommands.get(i).getName();
						
					if (name.equalsIgnoreCase("mov"))
					{
						Mov.func(args);
					}
					else if (name.equalsIgnoreCase("prv"))
					{
						PrintValue.func(args);
					}
					else if (name.equalsIgnoreCase("inp"))
					{
						InputCommand.func(args);
					}
					else if (name.equalsIgnoreCase("defi"))
					{
						DefInt.func(args);
					}
					else if (name.equalsIgnoreCase("defs"))
					{
						DefString.func(args);
					}
					else if (name.equalsIgnoreCase("eq"))
					{
						j = Eq.func(args);
					}
					else if (name.equalsIgnoreCase("neq"))
					{
						j = Neq.func(args);
					}
					else if (name.equalsIgnoreCase("geq"))
					{
						j = Geq.func(args);
					}
					else if (name.equalsIgnoreCase("leq"))
					{
						j = Leq.func(args);
					}
					else if (name.equalsIgnoreCase("gt"))
					{
						LangVars lv = Main.getLangVars();
						lj = j;
						
						j = lv.getGotoIntByName(args.get(1));
					}
					else if (name.equalsIgnoreCase("return"))
					{
						j = lj;
					}
					else if (name.equalsIgnoreCase("say"))
					{
						System.out.print(args.get(1));
					}
					else if (name.equalsIgnoreCase("end"))
					{
						System.exit(0);
					}
					else if (name.equalsIgnoreCase("ddm"))
					{
						DoDeleteMarke.func(args);
					}
					else if (name.equalsIgnoreCase("ddv"))
					{
						DoDeleteVariable.func(args);
					}
					else if (name.equalsIgnoreCase("add"))
					{
						Add.func(args);
					}
					else if (name.equalsIgnoreCase("rem"))
					{
						Rem.func(args);
					}
					else if (name.equalsIgnoreCase("div"))
					{
						Div.func(args);
					}
					else if (name.equalsIgnoreCase("mul"))
					{
						Mul.func(args);
					}
					else if (name.equalsIgnoreCase("mod"))
					{
						Mod.func(args);
					}
//					else if (name.equalsIgnoreCase("pf"))
//					{
//						Pf.func(args);
//					}
					else if (name.equalsIgnoreCase("runf"))
					{
						RunF.func(args);
					}
					else if (name.equalsIgnoreCase("deff"))
					{
						DefFunction.func(args);
					}
					else
					{
						System.out.println("[ ERR ]:[ COMMANDGETTER:"+name+" ] Befehl \""+lcommands.get(i).getName()+"\" wurde noch keiner Funktion zugewiesen :(!");
					}
						
//						if (lcommands.get(i).getName().equalsIgnoreCase(LangVars.getFunctionList().get(z).getName()))
//						{
//							LangVars.getFunctionList().get(z).runFunction(args);
//						}
//					}
				}
			}
		}
	}
	
	public static int getJ()
	{
		return j;
	}
}
