package com.github.triploit.npp5.other;

import java.io.IOException;
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
	private List<Function> fs = new ArrayList<Function>();

	
	public List<Function> getFunctionList()
	{
		return this.fs;
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
		System.out.println("[ ERR ]:[ GOTO ]:[ NOTFOUND:\""+name+"\" ] Konnte Sprungmarke nicht finden!");
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
		System.out.println("[ ERR ]:[ GOTO ]:[ NOTFOUND:\""+name+"\" ] Konnte Sprungmarke nicht finden!");
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
		//System.out.println("[ ERR ]:[ FUNCTION ]:[ NOTFOUND:\""+name+"\" ] Konnte Funktion nicht finden!");
		//System.exit(0);
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
		//System.out.println("[ ERR ]:[ FUNCTION ]:[ NOTFOUND:\""+name+"\" ] Konnte Funktion nicht finden!");
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
