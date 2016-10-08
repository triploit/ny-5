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
	private boolean docc;
//	private String lsj = "";
	private int gti;
	private int lgti;
	private static int j = 0;
	
	public CommandGetter(List<String> cmds, List<Command> lcommands, boolean docc)
	{
		this.lcommands = lcommands;
		this.cmds = cmds;
		this.docc = docc;
	}
	
	public void execute() throws IOException
	{
		LangVars lv = Main.getLangVars();
		lv.addCCodeRaw("#include <stdio.h>\n#include <stdlib.h>\n#include <iostream>\n#include <string.h>\nusing namespace std;\n\nint main()\n{\n");
		//System.out.println("[ NYPP ] Execute...\n");
		int lj = 0;
		
		for (j = 0; j < cmds.size(); j++)
		{		
			if (cmds.get(j).equals(";") && (j+1) < cmds.size())
					j++;
			
			if (cmds.get(j).startsWith("{") && cmds.get(j).endsWith("}"))
			{
			    lv.addCCodeRaw(cmds.get(j).replace("}", "").replace("{", "")+":");
			}
//			System.out.println("[ CMD ] "+cmds.get(j));
//			if (cmds.get(j).startsWith("{") && cmds.get(j).endsWith("}"))
//			{
//				System.out.println("[ GOTO ] Sprungmarke definieren: "+cmds.get(j));
//			}
			
			if (cmds.get(j).equals("@") && (j+1) < cmds.size())
			{
				System.out.println("");
				lv.addCCode("cout << endl");
			}
			    
			for (int i = 0; i < this.lcommands.size() && (j+1) < cmds.size(); i++)
			{				
			    
				if (j < cmds.size() && cmds.get(j).equalsIgnoreCase(lcommands.get(i).getName()))
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
						//lsj = args.get(1);
						lv.addCCode("goto "+args.get(1));
						//lv.addCCodeRaw("gtXcD"+gti+":");
						gti++;
						lgti = gti;
					    }
					    else
					    {
						lj = j;						
						j = lv.getGotoIntByName(args.get(1));
					    }
					}
					else if (name.equalsIgnoreCase("return"))
					{
					    if (docc)
					    {
						System.out.println("[ ERR ]:[ GOTO ]:[ RETURN ]:[ CANTUSE ] Kann den Return-Befehl nicht hier verwenden!");
					    }
					    else
					    {
						j = lj;
					    }
					}
					else if (name.equalsIgnoreCase("say"))
					{
					    if (docc)
					    	lv.addCCode("printf(\""+args.get(1)+"\")");
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
//					else if (name.equalsIgnoreCase("ddm"))
//					{
//						DoDeleteMarke.func(args, docc);
//					}
//					else if (name.equalsIgnoreCase("ddv"))
//					{
//						DoDeleteVariable.func(args, docc);
//					}
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
//					else if (name.equalsIgnoreCase("pf"))
//					{
//						Pf.func(args);
//					}
					else if (name.equalsIgnoreCase("runf"))
					{
						RunF.func(args, docc);
					}
					else if (name.equalsIgnoreCase("deff"))
					{
					    if (!docc)
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
			
//			if (!((j+1) < cmds.size()))
//			    System.exit(0);
		}
		
		if (docc)
		{
		    	lv.addCCodeRaw("\nreturn 0;\n\n}");
        		    
        	    	//lv.writeCCode();
		    	System.out.println("[ SYS ]:[ COMPILE ]:[ SOURE ]:[ GENERATE ] Generiere Code...");
        	    	String txt = lv.ccodeToString();
        	    	lv.writeFile(Main.getFileName(), txt);
        	    	
        	    	System.out.println("[ FERTIG ]\n");
		}
	}
	
	public static int getJ()
	{
		return j;
	}
}
