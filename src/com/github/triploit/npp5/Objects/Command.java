package com.github.triploit.npp5.Objects;

public class Command 
{
	private String name;
	private int argc;
	
	public Command(String name, int argc)
	{
		this.name = name;
		this.argc = argc;
	}
	
	public int getArgCount()
	{
		return this.argc;
	}
	
	public void setArgCount(int i)
	{
		this.argc = i;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String s)
	{
		this.name = s;
	}

}
