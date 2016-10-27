package com.github.triploit.npp5;

import java.io.File;
import java.io.IOException;

import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;
import com.github.triploit.npp5.other.Updater;
import com.github.triploit.npp5.run.Init;
import com.github.triploit.npp5.run.Parser;
import com.github.triploit.npp5.run.Tokenizer;

public class Main 
{
	private static LangVars lv = new LangVars();
	private static String version = "161027j";
	private static String fname = "";
	private static boolean cpp = false;
	private static boolean endf = true;
	private static boolean beginf = true;
	
	public static void main(String[] args)
	{	
		System.out.println(">>\tNypp Intepreter/Compiler (V"+getVersion()+") \n");
		
		Updater ud = new Updater();
		ud.findFile("ver.txt");
		ud.getLocalServerFile();
		ud.equalsVersion();
		
		Init init = new Init();
		init.initializeLanguage();
		init.initialSystemVariables();
		
		if (args.length < 1)
		{
		    System.out.println( "[ ERR ]:[ SYS ]:[ USE ]:[ ARGUMENTS ] Fehlende Argumente! Bitte so nutzen:\n\t"+
		    		">>  nypp -r <Datei>\n\t"+
		    		">>  nypp -c <EingabeDatei> <AusgabeDatei>.nct5\n\t"+
		    		">>  nypp -h\n\t"+
		    		">>  nypp --help");
		}
		
		
		try 
		{
			
//			else if (args[0].equalsIgnoreCase("-e") || args[0].equalsIgnoreCase("--editor"))
//			{
//				GUI g = new GUI(args[1]);
//				g.startGUI();
//			}else if (args[0].equalsIgnoreCase("-sys") || (args[0].equalsIgnoreCase("-cc") && args[1].equalsIgnoreCase("-sys")))

			if (args[0].equalsIgnoreCase("-h") || args[0].equalsIgnoreCase("--help"))
    			{
    			    System.out.println(">>\tHelp");
    			    System.out.println("\t>> -r [Datei]                       >> Datei ausführen");
    			    System.out.println("\t>> -c [EinabeDatei] [AusgabeDatei]  >> EingabeDatei wird in AusgabeDatei \n\t\tumgewandelt und verschüsselt");
    			    System.out.println("\n\t>> -cc [Datei]                      >> Datei in C++ umwandeln");
    			    System.out.println("\t>> -sys -cc [Datei]                 >> Datei in Binär kompilieren >> nur Linux und MacOS");
    			}
    			else if (args.length == 3 && (args[1].equalsIgnoreCase("-cc") && args[0].equalsIgnoreCase("-sys")) || (args[1].equalsIgnoreCase("-sys") && args[0].equalsIgnoreCase("-cc")))
    			{
    			    
    			    	fname = args[2];
    			    	String cppfname = fname.replace(".ny5", ".cpp").replace(".nct5", ".cpp");
    			    	String binname = cppfname.replace(".cpp", "");
    				cpp = true;
    				    	
    				Parser p = new Parser(args[2], false, "", true);
    				p.parseAll();
    				Tokenizer tok = new Tokenizer(p);
    					
    				tok.doTokenize();
    				tok.executeCode();

    			        try
				{
       				    Process cc = Runtime.getRuntime().exec("g++ -o "+binname+" "+cppfname);
				    System.out.println("[ SYS ]:[ COMPILE ]:[ SOURE ]:[ G++ ] Kompiliere...");
				    cc.waitFor();

				    System.out.println("[ FERTIG ]\n\n[ SYS ]:[ COMPILE ]:[ SOURE ] Entferne Datei...");
				    File f = new File(cppfname);
				    f.delete();
				    
				    System.out.println("[ FERTIG ]");
				} 
    			        catch (InterruptedException e)
				{
				    // TODO Auto-generated catch block
				    e.printStackTrace();
				}
					
			}
			else if (args[0].equalsIgnoreCase("-cc"))
			{
			    	fname = args[1];
			    	cpp = true;
			    	
				Parser p = new Parser(args[1], false, "", true);
				p.parseAll();
				Tokenizer tok = new Tokenizer(p);
				
				tok.doTokenize();
				tok.executeCode();
			}
			else if (args[0].equalsIgnoreCase("-c") || args[0].equalsIgnoreCase("--compile"))
			{
				System.out.println("[ NYPP ] Compiling...");
				try
				{
    				fname = args[1];
    				Parser p = new Parser(args[1], true, args[2], true);
    				p.parseAll();
    				Tokenizer tok = new Tokenizer(p);
    				
    				tok.doTokenize();
    				tok.executeCode();
				}
				catch(IndexOutOfBoundsException ex)
				{
					Err.printErr("[ ERR ]:[ SYS ]:[ USE ]:[ ARGUMENTS ] Fehlende Argumente! Bitte so nutzen:\n\t>>  nypp -c <Eingabedatei> <Ausgabedatei>");
					System.exit(0);
				}
			}
			else if (args[0].equalsIgnoreCase("-u"))
			{
			    // https://raw.githubusercontent.com/Triploit-org/ny-5/master/jar/ny++.jar
			}
			
			else if (args[0].equalsIgnoreCase("-r"))
			{
			    	fname = args[1];
				Parser p = new Parser(args[1], false, "", true);
				p.parseAll();
				Tokenizer tok = new Tokenizer(p);
				
				tok.doTokenize();
				tok.executeCode();
			}
			else
			{
			    System.out.println( "[ ERR ]:[ SYS ]:[ USE ]:[ ARGUMENTS ] Fehlende Argumente! Bitte so nutzen:\n\t"+
				    		">>  nypp -r <Datei>\n\t"+
				    		">>  nypp -c <EingabeDatei> <AusgabeDatei>.nct5\n\t"+
				    		">>  nypp -h"+
				    		">>  nypp --help");

			}
		}
		catch (IOException e) 
		{
			Err.printErr("[ ERR ] Konnte Datei nicht finden! Wurde eine Datei angegeben?\n\n ->->-> Java-Error:");
			e.printStackTrace();
			System.exit(0);
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
		    System.out.println( "[ ERR ]:[ SYS ]:[ USE ]:[ ARGUMENTS ] Fehlende Argumente! Bitte so nutzen:\n\t"+
		    		">>  nypp -r <Datei>\n\t"+
		    		">>  nypp -c <EingabeDatei> <AusgabeDatei>.nct5\n\t"+
		    		">>  nypp -h"+
		    		">>  nypp --help");
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

	public static boolean isEnd()
	{
	    return endf;
	}
	
	public static void setEnd()
	{
	    if (endf)
		endf = false;
	    else
		endf = true;
	}

	public static boolean isBegin()
	{
	    return beginf;
	}
	
	public static void setBegin()
	{
	    if (beginf)
		beginf = false;
	    else
		beginf = true;
	}
}
