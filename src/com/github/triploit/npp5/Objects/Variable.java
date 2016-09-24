package com.github.triploit.npp5.Objects;

import com.github.triploit.npp5.other.LangVars;

public class Variable 
{
	
	private String name;
	private Value value;	
	private boolean num;
	
	public Variable(String name, Value v)
	{
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
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ]:[ ADDVALUE ] Der Wert \""+sc+"\" passt nicht zum Typ der Variable!");
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
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ]:[ ADDVALUE ] Der Wert \""+sc+"\" passt nicht zum Typ der Variable!");
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
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ]:[ ADDVALUE ] Der Wert \""+sc+"\" passt nicht zum Typ der Variable!");
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
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ]:[ ADDVALUE ] Der Wert \""+sc+"\" passt nicht zum Typ der Variable!");
		}
	}

}
