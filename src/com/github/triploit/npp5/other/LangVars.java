package com.github.triploit.npp5.other;

import java.util.ArrayList;
import java.util.List;

import com.github.triploit.npp5.Objects.Command;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;

public class LangVars 
{
	private List<Command> lcommands = new ArrayList<Command>();
	private List<Variable> lvars = new ArrayList<Variable>();
	private static List<Function> flist;
	private List<String> gtv = new ArrayList<String>();

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
	
	public List<Command> getLCommands() 
	{
		return lcommands;
	}
	
	public static List<Function> getFunctionList()
	{
		return flist;
	}
	
	public static interface Function 
	{
        void runFunction(List<String> args);
        String getName();
        void setName(String s);
    }
	
	
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
