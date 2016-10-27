package com.github.triploit.npp5.Objects;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

import com.github.triploit.npp5.run.Parser;
import com.github.triploit.npp5.run.Tokenizer;

public class Function 
{
	private Parser p;
	private Tokenizer t;
	private String name;
	private String commands;
	//private List<String> cmds = new ArrayList<String>();
	
	public Function(String name, String commands) throws IOException
	{
		this.commands = commands;
		this.name = name;

		p = new Parser("", false, "", false);
		p.setRawCode(commands);
		
		t = new Tokenizer(p);
		//System.out.println("NEW COMMAND: "+name+"\n>>> "+commands +"\n<<<");
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void runFunction()
	{
		try
		{
		    this.t.doTokenize();
		    this.t.executeCode();
		} 
		catch (IOException e)
		{
		    System.out.println("[ ERR ]:[ FATAL ]:[ FUNCTION ]:[ IOException ] Bitte diesesn Error Melden!");
		    System.exit(0);
		}
	}
	
	public String getCommands()
	{
		return this.commands;
	}
}
