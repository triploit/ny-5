package com.github.triploit.npp5.Objects;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.other.LangVars;

public class Variable 
{
	
	private String name;
	private Value value;	
	private boolean num;
	
	@SuppressWarnings("static-access")
	public Variable(String name, Value v)
	{
		String names = name.substring(0,1);
		if (Main.getLangVars().isNumeric(names) || name.contains("[") || name.contains("]") || name.contains("(") || name.contains(")") || name.contains("{") || name.contains("}") || name.contains(" ") || name.contains("\"") || name.contains(",") || name.contains(";") || name.contains(":") || name.contains(".") || name.contains("!") || name.contains("§") || name.contains("$"))
		{
			System.out.println("[ ERR ]:[ VAR ]:[ DEFN ]:[ ILLEGALCHARACTERIN:"+name+" ] Eine Variable darf nur aus Buchstaben bestehen!");
			System.exit(0);
		}
			
		this.name = name;
		this.value = v;
	}
	
	public Value getValue() {
		return value;
	}

	public void setValue(Value value) 
	{
		if (value.isNumeric() && this.value.isNumeric())
			this.value = value;
		else if (!value.isNumeric() && !this.value.isNumeric())
			this.value = value;
		else
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ]:[ SETVALUE ] Der Wert passt nicht zum Typ!");
		System.exit(0);
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
		num = b;
		value.setNumeric(b);
	}
	
	public void addValue(Object o)
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
	
	public void remValue(Object o)
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
	
	public void mulValue(Object o)
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
	
	public void modValue(Object o)
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
	
	public void divValue(Object o)
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

}
