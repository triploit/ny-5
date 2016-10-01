package com.github.triploit.npp5.Objects;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

import com.github.triploit.npp5.run.Parser;
import com.github.triploit.npp5.run.Tokenizer;

public class Function 
{
	private Parser p;
	private Tokenizer t = new Tokenizer(p);
	private String name;
	private String commands;
	//private List<String> cmds = new ArrayList<String>();
	
	public Function(String name, String commands) throws IOException
	{
		p = new Parser("", false, "");
		this.commands = commands;
		p.setRawCode(commands);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void runFunction() throws IOException
	{
		this.t.doTokenize();
		this.t.executeCode();
	}
	
	public String getCommands()
	{
		return this.commands;
	}
}
