package com.github.triploit.npp5;

import java.io.IOException;

import com.github.triploit.npp5.Objects.Command;
import com.github.triploit.npp5.other.LangVars;
import com.github.triploit.npp5.other.Updater;
import com.github.triploit.npp5.run.Parser;
import com.github.triploit.npp5.run.Tokenizer;

public class Main 
{
	private static LangVars lv = new LangVars();
	private static String version = "16108e";
	private static String fname = "";
	private static boolean cpp = false;
	
	public static void main(String[] args)
	{	
		System.out.println(">>\tNypp Intepreter/Compiler (V"+getVersion()+") \n");
		
		Updater ud = new Updater();
		ud.findFile("ver.txt");
		ud.getLocalServerFile();
		ud.equalsVersion();
		
		if (args.length < 1)
		{
			System.out.println("[ ERR ]:[ SYS ]:[ USE ]:[ ARGUMENTS ] Fehlende Argumente! Bitte so nutzen:\n\t>>  nypp <Datei>\n\t>>  nypp -c <EingabeDatei> <AusgabeDatei>.nct5");
		}
		
		Command mov = new Command("mov", 2);
		lv.addLCommands(mov);
		
		Command eq = new Command("eq", 3);
		lv.addLCommands(eq);
		Command leq = new Command("leq", 3);
		lv.addLCommands(leq);
		Command neq = new Command("neq", 3);
		lv.addLCommands(neq);
		Command geq = new Command("geq", 3);
		
		lv.addLCommands(geq);
		Command defi = new Command("defi", 2);
		lv.addLCommands(defi);
		Command defs = new Command("defs", 2);
		
		Command deff = new Command("deff", 2);
		lv.addLCommands(deff);
		Command runf = new Command("runf", 1);
		lv.addLCommands(runf);
		
		Command wt = new Command("wt", 1);
		lv.addLCommands(wt);
		
		lv.addLCommands(defs);
		Command prv = new Command("prv", 1);
		lv.addLCommands(prv);
		Command inp = new Command("inp", 1);
		lv.addLCommands(inp);
		Command gt = new Command("gt", 2);
		lv.addLCommands(gt);
		Command say = new Command("say", 1);
		lv.addLCommands(say);
		
		Command end = new Command("end", 0);
		lv.addLCommands(end);
		Command rtrn = new Command("return", 0);
		lv.addLCommands(rtrn);
		
//		Command ddm = new Command("ddm", 1);
//		lv.addLCommands(ddm);
//		Command ddv = new Command("ddv", 1);
//		lv.addLCommands(ddv);
		
		Command div = new Command("div", 2);
		lv.addLCommands(div);
		Command mul = new Command("mul", 2);
		lv.addLCommands(mul);
		Command add = new Command("add", 2);
		lv.addLCommands(add);
		Command rem = new Command("rem", 2);
		lv.addLCommands(rem);
		Command mod = new Command("mod", 2);
		lv.addLCommands(mod);
		
		Command pf = new Command("pf", 1);
		lv.addLCommands(pf);
		
//		lv.getFunctionList().add(CommandFunctionPointers._do);
//		lv.getFunctionList().add(CommandFunctionPointers.mov);
//		lv.getFunctionList().add(CommandFunctionPointers.Eq);
//		lv.getFunctionList().add(CommandFunctionPointers.defi);
//		lv.getFunctionList().add(CommandFunctionPointers.defs);
		
		try 
		{
			if (args[0].equalsIgnoreCase("-c") || args[0].equalsIgnoreCase("--compile"))
			{
				System.out.println("[ NYPP ] Compiling...");
				try
				{
        				fname = args[1];
        				Parser p = new Parser(args[1], true, args[2]);
        				p.parseAll();
        				Tokenizer tok = new Tokenizer(p);
        				
        				tok.doTokenize();
        				tok.executeCode();
				}
				catch(IndexOutOfBoundsException ex)
				{
					System.out.println("[ ERR ]:[ SYS ]:[ USE ]:[ ARGUMENTS ] Fehlende Argumente! Bitte so nutzen:\n\t>>  nypp -c <Eingabedatei> <Ausgabedatei>");
					System.exit(0);
				}
			}
//			else if (args[0].equalsIgnoreCase("-e") || args[0].equalsIgnoreCase("--editor"))
//			{
//				GUI g = new GUI(args[1]);
//				g.startGUI();
//			}
			else if (args[0].equalsIgnoreCase("-cc"))
			{
			    	fname = args[1];
			    	cpp = true;
			    	
				Parser p = new Parser(args[1], false, "");
				p.parseAll();
				Tokenizer tok = new Tokenizer(p);
				
				tok.doTokenize();
				tok.executeCode();
			}
			else if (args[0].equalsIgnoreCase("-sys"))
			{
        			if (args[1].equalsIgnoreCase("-cc"))
        			{
        			    	fname = args[2];
        			    	String cppfname = fname.replace(".ny5", ".cpp").replace(".nct5", ".cpp");
        			    	String binname = cppfname.replace(".cpp", "");
        				cpp = true;
        				    	
        				Parser p = new Parser(args[2], false, "");
        				p.parseAll();
        				Tokenizer tok = new Tokenizer(p);
        					
        				tok.doTokenize();
        				tok.executeCode();
        				
        				Process cc = Runtime.getRuntime().exec("g++ -o "+binname+" "+cppfname);
        				Process rm = Runtime.getRuntime().exec("rm "+cppfname);
        				
        			        try
					{
					    System.out.println("[ SYS ]:[ COMPILE ]:[ SOURE ]:[ G++ ] Kompiliere...");
					    cc.waitFor();
					    System.out.println("[ FERTIG ]\n\n[ SYS ]:[ COMPILE ]:[ SOURE ] Entferne Datei...");
					    rm.waitFor();
					    System.out.println("[ FERTIG ]");
					} catch (InterruptedException e)
					{
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					}
					
        			}
			}
			else
			{
			    	fname = args[0];
				Parser p = new Parser(args[0], false, "");
				p.parseAll();
				Tokenizer tok = new Tokenizer(p);
				
				tok.doTokenize();
				tok.executeCode();
			}
		} 
		catch (IOException e) 
		{
			System.out.println("[ ERR ] Konnte Datei nicht finden! Wurde eine Datei angegeben?\n\n ->->-> Java-Error:");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static String getVersion()
	{
	    return version;
	}

	public static LangVars getLangVars()
	{
		return lv;		
	}
	
	public static String getFileName()
	{
	    return fname;
	}
	
	public static boolean isCpp()
	{
	    return cpp;
	}
}
