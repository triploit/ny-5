package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.LangVars;

public class Sleep
{
    @SuppressWarnings("static-access")
    public static void func(List<String> args)
    {
	LangVars lv = Main.getLangVars();
	Variable v = lv.getLVariableByName(args.get(1));
	
	if (!v.getName().equals("[NotFound]"))
	{
		try
		{
		    Thread.sleep(Long.parseLong(v.getValue().getValue().toString()));
		} 
		catch (NumberFormatException e)
		{
		    System.out.println("[ ERR ]:[ SLEEP ]:[ VAL:"+v.getName()+" ] Konnte den Wert der Variable nicht abrufen!");
		    System.exit(0);
		} 
		catch (InterruptedException e)
		{
		    System.out.println("[ ERR ]:[ SLEEP ]:[ VAL:"+v.getName()+" ] Konnte den Wert der Variable nicht abrufen!");
		    System.exit(0);
		}
	}
	else
	{
	    if (lv.isNumeric(args.get(1)))
	    {
        	    try
        	    {
        		Thread.sleep(Long.parseLong(args.get(1)));
        	    } 
        	    catch (NumberFormatException e)
        	    {
        		System.out.println("[ ERR ]:[ SLEEP ]:[ CANNOTCONVERTTOLONG:"+args.get(1)+" ] Kann den Wert nicht konvertieren!");
        		System.exit(0);
        	    } 
        	    catch (InterruptedException e)
        	    {
        		System.out.println("[ ERR ]:[ SLEEP ]:[ VAL:"+v.getName()+" ] Konnte den Wert nicht konvertieren!");
        		System.exit(0);
        	    }
	    }
	    else
	    {
		System.out.println("[ ERR ]:[ SLEEP ]:[ VAL ] Der Wert als Argument 1 war kein Integer!");
	    }
	}
    }
}
