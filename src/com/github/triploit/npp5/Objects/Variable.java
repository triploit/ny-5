package com.github.triploit.npp5.Objects;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;

public class Variable 
{
	
	private String name;
	private Value value;	
	private boolean num;
	private boolean writable = true;
	
	public boolean isWritable()
	{
	    return writable;
	}

	public void setWritable(boolean writable)
	{
	    this.writable = writable;
	}

	@SuppressWarnings("static-access")
	public Variable(String name, Value v)
	{
		String names = name.substring(0,1);
		if (Main.getLangVars().isNumeric(names) || name.contains("[") || name.contains("]") || name.contains("(") || name.contains(")") || name.contains("{") || name.contains("}") || name.contains(" ") || name.contains("\"") || name.contains(",") || name.contains(";") || name.contains(":") || name.contains(".") || name.contains("!") || name.contains("§") || name.contains("$"))
		{
		    if (name.equals("[NotFound]"))
		    {
			//System.out.println("[ ERR ]:[ INP ]:[ VAR ]:[ NOTFOUND ] Variable \""+name+"\" konnte nicht gefunden werden!");
		    }
		    else
		    {
			System.out.println("[ ERR ]:[ VAR ]:[ DEFN ]:[ ILLEGALCHARACTERIN:"+name+" ] Eine Variable darf nur aus Buchstaben bestehen!");
			System.exit(0);
		    }
		}
			
		this.name = name;
		this.value = v;
	}
	
	public Value getValue() {
		return value;
	}

	public void setValue(Value value) 
	{
	    if (writable)
	    {
		if (value.isNumeric() && this.value.isNumeric())
		{
		    	this.value = value;
		}
		else if (value.isString() && this.value.isString())
		{
			this.value = value;
		}
		else
		{
			Err.printErr("[ ERR ]:[ SYS ]:[ VAR ]:[ SETVALUE ] Der Wert \""+value.getValue()+"\" passt nicht zum Typ! "+this.value.isString()+" "+this.value.isNumeric());			
			System.exit(0);
		}
	    }
	    else
	    {
		Err.printErr("[ ERR ]:[ SYS ]:[ VAR ]:[ NAME:"+name+" ]:[ SETVALUE ] Diese Variable kann nicht bearbeitet werden!");
	    }
	}
	
	public boolean testValue(Value value) 
	{
	    if (writable)
	    {
		if (value.isNumeric() && this.value.isNumeric())
		{
		    	return true;
		}
		else if (value.isString() && this.value.isString())
		{
			return true;
		}
		else
		{
			return false;
		}
	    }
	    else
	    {
		Err.printErr("[ ERR ]:[ SYS ]:[ VAR ]:[ NAME:"+name+" ]:[ SETVALUE ] Diese Variable kann nicht bearbeitet werden!");
		return false;
	    }
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return this.name;
	}
	
	public boolean isNumeric()
	{
		return num;
	}
	
	public void setNumeric(boolean b)
	{
	    if (writable)
	    {
		num = b;
		value.setNumeric(b);
	    }
	    else
	    {
		Err.printErr("[ ERR ]:[ SYS ]:[ VAR ]:[ NAME:"+name+" ]:[ SETVALUE ] Diese Variable kann nicht bearbeitet werden!");
	    }
	}
	
	public void addValue(Object o)
	{
	    if (writable)
	    {
		int vi;
		
		String vs;
		String sc = o.toString();		
		
		if (LangVars.isNumeric(sc) && num)
		{
			vi = Integer.parseInt(sc);
			value = new Value(Integer.parseInt(value.getValue().toString())+vi);
		}
		else if (!LangVars.isNumeric(sc) && !num)
		{
			vs = sc;
			value = new Value(value.getValue().toString()+vs);
		}
		else
		{
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ]:[ ADDVALUE ] Der Wert \""+sc+"\" passt nicht zum Typ der Variable!");
			System.exit(0);
		}
	    }
	    else
	    {
		Err.printErr("[ ERR ]:[ SYS ]:[ VAR ]:[ NAME:"+name+" ]:[ SETVALUE ] Diese Variable kann nicht bearbeitet werden!");
	    }
	}
	
	public void remValue(Object o)
	{
	    if (writable)
	    {
		int vi;
		
		String vs;
		String sc = o.toString();		
		
		if (LangVars.isNumeric(sc) && num)
		{
			vi = Integer.parseInt(sc);
			value = new Value(Integer.parseInt(value.getValue().toString())-vi);
		}
		else if (!LangVars.isNumeric(sc) && !num)
		{
			vs = sc;
			value = new Value(value.getValue().toString().replace(vs, ""));
		}
		else
		{
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ]:[ REMVALUE ] Der Wert \""+sc+"\" passt nicht zum Typ der Variable!");
			System.exit(0);
		}
	    }
	    else
	    {
		Err.printErr("[ ERR ]:[ SYS ]:[ VAR ]:[ NAME:"+name+" ]:[ SETVALUE ] Diese Variable kann nicht bearbeitet werden!");
	    }
	}
	
	public void mulValue(Object o)
	{
	    if (writable)
	    {
		int vi;
		String sc = o.toString();		
		
		if (LangVars.isNumeric(sc) && num)
		{
			vi = Integer.parseInt(sc);
			value = new Value(Integer.parseInt(value.getValue().toString())*vi);
		}
		else
		{
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ]:[ MULVALUE ] Der Wert \""+sc+"\" passt nicht zum Typ der Variable!");
			System.exit(0);
		}
	    }
	    else
	    {
		Err.printErr("[ ERR ]:[ SYS ]:[ VAR ]:[ NAME:"+name+" ]:[ SETVALUE ] Diese Variable kann nicht bearbeitet werden!");
	    }
	}
	
	public void modValue(Object o)
	{
	    if (writable)
	    {
		int vi;
		String sc = o.toString();		
		
		if (LangVars.isNumeric(sc) && num)
		{
			vi = Integer.parseInt(sc);
			value = new Value(Integer.parseInt(value.getValue().toString())%vi);
		}
		else
		{
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ]:[ MODVALUE ] Der Wert \""+sc+"\" passt nicht zum Typ der Variable!");
			System.exit(0);
		}
	    }
	    else
	    {
		Err.printErr("[ ERR ]:[ SYS ]:[ VAR ]:[ NAME:"+name+" ]:[ SETVALUE ] Diese Variable kann nicht bearbeitet werden!");
	    }
	}
	
	public void divValue(Object o)
	{
	    if (writable)
	    {
		int vi;
		String sc = o.toString();		
		
		if (LangVars.isNumeric(sc) && num)
		{
			vi = Integer.parseInt(sc);
			value = new Value(Integer.parseInt(value.getValue().toString())/vi);
		}
		else
		{
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ]:[ DIVVALUE ] Der Wert \""+sc+"\" passt nicht zum Typ der Variable!");
			System.exit(0);
		}
	    }
	    else
	    {
		Err.printErr("[ ERR ]:[ SYS ]:[ VAR ]:[ NAME:"+name+" ]:[ SETVALUE ] Diese Variable kann nicht bearbeitet werden!");
	    }
	}

}
