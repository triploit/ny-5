package com.github.triploit.npp5.compiler;

import java.util.ArrayList;
import java.util.List;

public class LCompiler 
{
	private List<String> normstr = new ArrayList<String>();
	private List<String> compstr = new ArrayList<String>();
	private String code;
	
	public LCompiler(String code)
	{
		this.code = code;
	}
	
	public void setCode(String c)
	{
		this.code = c;
	}
	
	public void addString(String norm, String comp)
	{
		normstr.add(norm);
		compstr.add(comp);
	}
	
	public String doEncrypt()
	{
		String enc = this.code;
		
		for (int i = 0; i < normstr.size() && i < compstr.size(); i++)
		{
			enc = enc.replace(normstr.get(i), compstr.get(i));
		}
		
		return enc;
	}
	
	public String doDecrypt()
	{
		String dec = this.code;
		
		for (int i = 0; i < normstr.size() && i < compstr.size(); i++)
		{
			dec = dec.replace(compstr.get(i), normstr.get(i));
		}
		
		return dec;
	}
}
