package com.github.triploit.npp5.run;

import java.util.ArrayList;
import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.other.LangVars;

public class Tokenizer 
{
	private Parser p;
	private List<String> cmds = new ArrayList<String>();
	private char[] code;
	
	public Tokenizer(Parser p)
	{
		this.p = p;
	}
	
	public Parser getParser()
	{
		return this.p;
	}
	
	public void doTokenize()
	{
		System.out.println("[ NYPP ] Tokenize...");
		this.code = this.p.getRawCode().toCharArray();
		String tmpstr = "";
		
		boolean isStr = false;
		boolean kmt = false;
		
		for (int i = 0; i < this.code.length; i++)
		{
			
			if (tmpstr.startsWith("{") && tmpstr.endsWith("}"))
			{
				LangVars lv = Main.getLangVars();
				lv.addGotoValue(tmpstr.replace("{", "").replace("}", "")+"~"+cmds.size());
				tmpstr = "";
			}
			
			/*
			if (code[i] == ' ' || code[i] == ',' || code[i] == '\t' || code[i] == ';')
			{
				
			}
			*/
			if (code[i] == ' ' || code[i] == ',' || code[i] == '\t' || code[i] == ';' || code[i] == '\n' || code[i] == '@')
			{				
				if (!kmt)
				{
					if (!isStr)
					{
						if (code[i] == ';' && code[i] != ',')
						{
							if (tmpstr.startsWith("\"") && tmpstr.endsWith("\""))
								tmpstr = tmpstr.substring(1, tmpstr.length()-1);
							
							try	{ if (tmpstr != null) this.cmds.add(tmpstr); }
							catch (NullPointerException ex) {}
						
							//System.out.println("[ CMD ] "+tmpstr+ "\t[ SIZE ]  [  "+cmds.size()+"\t ]");
							tmpstr = "";
							
							tmpstr += code[i];
							this.cmds.add(tmpstr);
							tmpstr = "";
						}
						else if (code[i] == '@')
						{
							
							if (tmpstr.startsWith("\"") && tmpstr.endsWith("\""))
								tmpstr = tmpstr.substring(1, tmpstr.length()-1);
							
							try	{ if (tmpstr != null) this.cmds.add(tmpstr); }
							catch (NullPointerException ex) {}
						
							//System.out.println("[ CMD ] "+tmpstr+ "\t[ SIZE ]  [  "+cmds.size()+"\t ]");
							tmpstr = "";
							
							tmpstr += code[i];
							this.cmds.add(tmpstr);
							tmpstr = "";
						}
						else
						{
						
							if ((i+1) < code.length)
							{
								for (int c = (i+1); c < this.code.length && (code[c] == ' ' || code[c] == ',' || code[c] == '\t' || code[c] == ';' || code[c] == '\n') && code[c] != '@'; c++)
								{
									if (c >= this.code.length)
										continue;
									else
										i = c;
								}
							}
														
							if (tmpstr.startsWith("\"") && tmpstr.endsWith("\""))
								tmpstr = tmpstr.substring(1, tmpstr.length()-1);
							
							try	{ if (tmpstr != null) this.cmds.add(tmpstr); }
							catch (NullPointerException ex) {}
						
							//System.out.println("[ CMD ] "+tmpstr+ "\t[ SIZE ]  [  "+cmds.size()+"\t ]");
							tmpstr = "";
						}
						
					}
					else
					{
						tmpstr += code[i];
					}
				}
			}
			else
			{
				if (code[i] == '?' && !isStr)
				{
					if (kmt)
						kmt = false;
					else
						kmt = true;
				}
				
				if (code[i] == '\"')
				{
					if (isStr)
						isStr = false;
					else
						isStr = true;
				}
				
				tmpstr = tmpstr + (""+code[i]);
			}
		}
	}
	
	public void executeCode()
	{
		LangVars lv = Main.getLangVars();
		CommandGetter getter = new CommandGetter(this.cmds, lv.getLCommands());
		
		getter.execute();
	}
}
