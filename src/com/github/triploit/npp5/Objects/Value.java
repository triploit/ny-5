package com.github.triploit.npp5.Objects;

import com.github.triploit.npp5.other.LangVars;

public class Value 
{
	private int ival;
	private String sval;
	
	private boolean isstr;
	private boolean isint;
	
	public Value(Object value, boolean isi)
	{
		isint = isi;
		String s = value.toString();
		
		if (LangVars.isNumeric(s))
		{
			ival = Integer.parseInt(s);
			isint = true;
		}
		else if (!LangVars.isNumeric(s))
		{
			sval = value.toString();
			isstr = true;
		}
		else
		{
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ]:[ INITVARIABLE ] Der Wert '"+s+"' passt nicht zum Typ der Zelle!");
//			System.out.println("LV.ISINT: "+LangVars.isNumeric(s));
//			System.out.println("ISSTR: "+isstr+"\nISINT: "+isint);
		}
	}
	
	public Value(Object value)
	{
		String s = value.toString();
		
		if (LangVars.isNumeric(s))
		{
			ival = Integer.parseInt(s);
			isint = true;
		}
		else if (!LangVars.isNumeric(s))
		{
			sval = value.toString();
			isstr = true;
		}
		else
		{
			System.out.println("[ ERR ]:[ SYS ]:[ VAR ] Der Wert '"+s+"' passt nicht zum Typ der Zelle!");
//			System.out.println("LV.ISINT: "+LangVars.isNumeric(s));
//			System.out.println("ISSTR: "+isstr+"\nISINT: "+isint);
		}
	}
	
	public Object getValue()
	{
		if (isstr)
		{
			return sval;
		}
		else if (isint)
		{
			return ival;
		}
		else
		{
			System.out.println("[ ERR ]:[ VAL ]:[ VALUE ]:[ GETVALUE ] Konnte den angegebenen Wert der Variable nicht zurückgeben!");
			return null;
		}
	}
	
	public boolean isNumeric()
	{
		return isint;
	}
	
	public boolean isString()
	{
		return isstr;
	}

	public void setNumeric(boolean b)
	{
		isint = b;
	}
	

	public void setString(boolean b)
	{
		isstr = b;
		
		if (sval == null)
		    sval = ival+"";
	}
}
