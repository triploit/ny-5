package com.github.triploit.npp5.run;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Command;
import com.github.triploit.npp5.commands.*;
import com.github.triploit.npp5.other.*;

public class CommandGetter
{
	private List<Command> lcommands = new ArrayList<Command>();
	private List<String> cmds = new ArrayList<String>();
	
	private boolean docc;
	private static int j = 0;
	private static int line = 1;
	
	private int gti;
	private int lgti;
	
	public CommandGetter(List<String> cmds, List<Command> lcommands, boolean docc)
	{
		this.lcommands = lcommands;
		this.cmds = cmds;
		this.docc = docc;
	}
	
	public void execute() throws IOException
	{
		if (docc && !docc)
			System.out.println(lgti);
		
		LangVars lv = Main.getLangVars();
		
		if (docc && Main.isBegin())
		{
			lv.addCCodeRaw(
					"#include <stdio.h>\n#include <stdlib.h>\n#include <time.h>\n#include <iostream>\n#include <string.h>\nusing namespace std;\n"
							+ "\n" + "int getOS()\n" + "{\n" + "#ifdef _WIN32\n" + "\treturn 1;\n" + "#elif _WIN64\n"
							+ "\treturn 1;\n" + "#elif __unix || __unix__\n" + "\treturn 3;\n"
							+ "#elif __APPLE__ || __MACH__\n" + "\treturn 2;\n" + "#elif __linux__\n" + "\treturn 3;\n"
							+ "#elif __FreeBSD__\n" + "\treturn 2;\n" + "#else\n" + "\treturn 4;\n" + "#endif\n"
							+ "} \n\n" + "\nint main()\n{");
			
			lv.addCCode("srand(time(NULL));\n\tint _rnd = rand() % 10000;\n\tint _fos = getOS()");
			lv.addCCodeRaw("");
			Main.setBegin();
		}
		
		// System.out.println("[ NYPP ] Execute...\n");
		// int lj = 0;
		
		for (j = 0; j < cmds.size(); j++)
		{
			if (cmds.get(j).equals(";") && (j + 1) < cmds.size())
				j++;
			
			if (cmds.get(j).equals("+[DN3:F0:1NE7") && (j + 1) < cmds.size())
			{
				j++;
				line++;
			}
			
			if (cmds.get(j).startsWith("{") && cmds.get(j).endsWith("}"))
			{
				lv.addCCodeRaw(" ");
				lv.addCCodeRaw(cmds.get(j).replace("}", "").replace("{", "") + ":");
			}
			
			if (cmds.get(j).equals("@") && (j + 1) < cmds.size())
			{
				System.out.println("");
				lv.addCCode("cout << endl");
			}
			
			for (int i = 0; i < this.lcommands.size() && (j + 1) < cmds.size(); i++)
			{
				
				if (j < cmds.size() && cmds.get(j).equalsIgnoreCase(lcommands.get(i).getName()))
				{
					// System.out.println("[I:"+j+"] "+cmds.get(j));
					
					List<String> args = new ArrayList<String>();
					for (int x = 0; x <= lcommands.get(i).getArgCount() && j < cmds.size(); x++)
					{
						args.add(cmds.get(j));
						j++;
					}
					
					String sem = cmds.get(j);
					if (!sem.equals(";") && !sem.equals(""))
					{
						Err.printErr("[ ERR ]:[ PARSE ]:[ EXECUTE ]:[ CODE:\"" + sem
								+ "\" ] Erwartetes Semikolon an Stelle " + j + " Zeile " + line + "!");
						System.exit(0);
					}
					
					String name = lcommands.get(i).getName();
					
					if (name.equalsIgnoreCase("mov"))
					{
						Mov.func(args, docc);
					}
					else if (name.equalsIgnoreCase("wt"))
					{
						Sleep.func(args, docc);
					}
					else if (name.equalsIgnoreCase("prv"))
					{
						PrintValue.func(args, docc);
					}
					else if (name.equalsIgnoreCase("inp"))
					{
						InputCommand.func(args, docc);
					}
					else if (name.equalsIgnoreCase("defi"))
					{
						DefInt.func(args, docc);
					}
					else if (name.equalsIgnoreCase("defs"))
					{
						DefString.func(args, docc);
					}
					else if (name.equalsIgnoreCase("eq"))
					{
						j = Eq.func(args, docc);
					}
					else if (name.equalsIgnoreCase("neq"))
					{
						j = Neq.func(args, docc);
					}
					else if (name.equalsIgnoreCase("geq"))
					{
						j = Geq.func(args, docc);
					}
					else if (name.equalsIgnoreCase("leq"))
					{
						j = Leq.func(args, docc);
					}
					else if (name.equalsIgnoreCase("gt"))
					{
						if (docc)
						{
							lv.addCCode("goto " + args.get(1));
							gti++;
							lgti = gti;
						}
						else
						{
							//lj = j;
							j = lv.getGotoIntByName(args.get(1));
						}
					}
					// else if (name.equalsIgnoreCase("return"))
					// {
					// if (docc)
					// {
					// Err.printErr("[ ERR ]:[ GOTO ]:[ RETURN ]:[ CANTUSE ]
					// Kann den Return-Befehl nicht hier verwenden!");
					// }
					// else
					// {
					// j = lj;
					// }
					// }
					else if (name.equalsIgnoreCase("say"))
					{
						if (docc)
							lv.addCCode("printf(\"" + args.get(1) + "\")");
						else
							System.out.print(args.get(1));
					}
					else if (name.equalsIgnoreCase("end"))
					{
						if (Main.isCpp() && docc)
						{
							lv.addCCode("exit(0)");
						}
						
						if (!docc)
							System.exit(0);
					}
					else if (name.equalsIgnoreCase("add"))
					{
						Add.func(args, docc);
					}
					else if (name.equalsIgnoreCase("rem"))
					{
						Rem.func(args, docc);
					}
					else if (name.equalsIgnoreCase("div"))
					{
						Div.func(args, docc);
					}
					else if (name.equalsIgnoreCase("mul"))
					{
						Mul.func(args, docc);
					}
					else if (name.equalsIgnoreCase("mod"))
					{
						Mod.func(args, docc);
					}
					else if (name.equalsIgnoreCase("moi"))
					{
						Moi.func(args, docc);
					}
					else if (name.equalsIgnoreCase("mos"))
					{
						Mos.func(args, docc);
					}
					else if (name.equalsIgnoreCase("sti"))
					{
						Sti.func(args, docc);
					}
					// else if (name.equalsIgnoreCase("runf"))
					// {
					// j = j + 2;
					// RunF.func(args, docc);
					// }
					// else if (name.equalsIgnoreCase("deff"))
					// {
					// if (!docc || docc)
					// DefFunction.func(args);
					// }
					else
					{
						Err.printErr("[ ERR ]:[ COMMANDGETTER:" + name + " ] Befehl \"" + lcommands.get(i).getName()
								+ "\" wurde noch keiner Funktion zugewiesen :(!");
					}
				}
			}
		}
		
		if (docc && Main.isEnd())
		{
			lv.addCCodeRaw("\nreturn 0;\n\n}");
			
			// lv.writeCCode();
			System.out.println("[ SYS ]:[ COMPILE ]:[ SOURE ]:[ GENERATE ] Generiere Code...");
			String txt = lv.ccodeToString();
			lv.writeFile(Main.getFileName(), txt);
			
			System.out.println("[ FERTIG ]\n");
			Main.setEnd();
		}
	}
	
	public static int getJ()
	{
		return j;
	}
	
	public static int getLine()
	{
		return line;
	}
}
