package com.github.triploit.npp5.other;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.github.triploit.npp5.Objects.Command;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.Objects.Function;

public class LangVars 
{
	private List<Command> lcommands = new ArrayList<Command>();
	private List<Variable> lvars = new ArrayList<Variable>();
	private List<String> gtv = new ArrayList<String>();
	private List<String> ccode = new ArrayList<String>();
	private List<Function> fs = new ArrayList<Function>();
	private String curf = "";

	public List<Function> getFunctionList()
	{
		return this.fs;
	}
	
	public void addCCode(String code)
	{
	    ccode.add("\t"+code+";");
	}
	
	public void addCCodeRaw(String code)
	{
	    ccode.add(code);
	}
	
	public String ccodeToString()
	{
	    String code = "";
	    
	    for (int i = 0; i < ccode.size(); i++)
	    {
		code += (ccode.get(i));
	    }
	    
	    return code;
	}
	
	public String curFile()
	{
	    return curf;
	}
	
	public void setCurFile(String n)
	{
	    curf = n;
	}
	
	public void writeFile(String filename, String txt) throws IOException
	{
//	    try
//	    {		
	    	filename = filename.replace(".ny5", ".cpp");
	    	filename = filename.replace(".nct5", ".cpp");
		FileWriter fw = new FileWriter(filename);
		BufferedWriter bw = new BufferedWriter(fw);
		//BufferedWriter bw = new BufferedWriter(new FileWriter());
				
		for (int i = 0; i < ccode.size(); i++)
		{
		    bw.write(ccode.get(i)+"\n");
		}
		
		bw.close();
		
//	    } 
//	    catch (IOException e)
//	    {
//		System.out.println("[ DBERR ]:[ WARN ] Bitte diesen Java Error ignorieren und den Ersteller der Sprache kontaktieren!");
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	    }
	}
	
	public void writeCCode()
	{
	    for (int i = 0; i < ccode.size(); i++)
	    {
		System.out.println(""+ccode.get(i));
	    }
	}
	
	public int getGotoIntByName(String name)
	{
		for (int i = 0; i < gtv.size(); i++)
		{
			String[] nm = gtv.get(i).split("~");
			int x = Integer.parseInt(nm[1]);
			String s = nm[0];
			
			if (s.equals(name))
				return x;
		}
		Err.printErr("[ ERR ]:[ GOTO ]:[ NOTFOUND:\""+name+"\" ] Konnte Sprungmarke nicht finden!");
		System.exit(0);
		return 0;
	}
	
	public String getGotoByName(String name)
	{
		for (int i = 0; i < gtv.size(); i++)
		{
			String[] nm = gtv.get(i).split("~");
			String s = nm[0];
			
			if (s.equals(name))
				return s;
		}
		Err.printErr("[ ERR ]:[ GOTO ]:[ NOTFOUND:\""+name+"\" ] Konnte Sprungmarke nicht finden!");
		System.exit(0);
		return "[NotFound]";
	}
	
	public boolean findGotoByName(String name)
	{
		for (int i = 0; i < gtv.size(); i++)
		{
			String[] nm = gtv.get(i).split("~");
			String s = nm[0];
			
			if (s.equals(name))
				return true;
		}
		return false;
	}	
	
	public boolean delGotoByName(String name)
	{
		for (int i = 0; i < gtv.size(); i++)
		{
			String[] nm = gtv.get(i).split("~");
			String s = nm[0];
			
			if (s.equals(name))
			{
				gtv.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void addGotoValue(String gtvn)
	{
		gtv.add(gtvn);
	}
	
	public void addFunction(Function f)
	{
		fs.add(f);
	}
	
	public Function getFunctionByName(String name) throws IOException
	{
		for (int i = 0; i < fs.size(); i++)
		{
			String s = fs.get(i).getName();
			
			if (s.equals(name))
				return fs.get(i);
		}
		
		Err.printErr("[ ERR ]:[ FUNCTION ]:[ NOTFOUND:\""+name+"\" ] Konnte Funktion nicht finden!");
		System.exit(0);
		
		return (Function) (new Function("[NotFound]", "[<FUNKTION NICHT GEFUNDEN>]"));
	}
	
	public boolean findFunctionByName(String name) throws IOException
	{
		for (int i = 0; i < fs.size(); i++)
		{
			String s = fs.get(i).getName();
			//System.out.println("S: "+s);
			
			if (s.equals(name))
				return true;
		}
		//Err.printErr("[ ERR ]:[ FUNCTION ]:[ NOTFOUND:\""+name+"\" ] Konnte Funktion nicht finden!");
		//System.exit(0);
		return false;
	}
	
	public List<Command> getLCommands() 
	{
		return lcommands;
	}
	
//	public static interface Function 
//	{
//        void runFunction(List<String> args);
//        String getName();
//        void setName(String s);
//		String getCommands();
//    }
	
	
	public void addLCommands(Command lcommand) 
	{
		this.lcommands.add(lcommand);
	}
	
	public Command getLCommandByName(String name)
	{
		for (int i = 0; i < lcommands.size(); i++)
		{
			if (name.equals(lcommands.get(i).getName()))
			{
				return lcommands.get(i);
			}
		}
		
		return (new Command("[NotFound]", 0));
	}
	
	public List<Variable> getLVariables()
	{
		return lvars;
	}
	
	public void addLVariable(Variable v)
	{
		lvars.add(v);
	}
	
	public Variable getLVariableByName(String name)
	{
		for (int i = 0; i < lvars.size(); i++)
		{
			if (name.equals(lvars.get(i).getName()))
			{
				return lvars.get(i);
			}
		}
		return (new Variable("[NotFound]", new Value("<Konnte nicht gefunden werden!>")));
	}
	
	public boolean delLVariableByName(String name)
	{
		for (int i = 0; i < lvars.size(); i++)
		{
			if (name.equals(lvars.get(i).getName()))
			{
				lvars.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean findLVariableByName(String name)
	{
		for (int i = 0; i < lvars.size(); i++)
		{
			if (name.equals(lvars.get(i).getName()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");
	}
	
}
