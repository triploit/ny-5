package com.github.triploit.npp5.run;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.other.Err;
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
	
	@SuppressWarnings("static-access")
	public void doTokenize()
	{
		//System.out.println("[ NYPP ] Tokenize...");
		this.code = this.p.getRawCode().toCharArray();
		String tmpstr = "";
		
		boolean isStr = false;
		boolean func = false;
		boolean kmt = false;
		
		for (int i = 0; i < this.code.length; i++)
		{
			
			if (tmpstr.startsWith("{") && tmpstr.endsWith("}"))
			{
			    if (!Main.isCpp())
			    {
				LangVars lv = Main.getLangVars();
				tmpstr = tmpstr.replace("{", "").replace("}", "")+"~"+cmds.size();
				
				if (lv.findGotoByName(tmpstr))
				{
					Err.printErr("[ ERR ]:[ GOTO ]:[ EXISTS:"+tmpstr+" ] Sprungmarke existiert bereits!");
					System.exit(0);
				}
				
				String name = tmpstr;				
				if (Main.getLangVars().isNumeric(name) || name.contains("[") || name.contains(" ") || name.contains("+") || name.contains("*") || name.contains("/") || name.contains("#") || name.contains("'") || name.contains("\"") || name.contains("<") || name.contains(">") || name.contains("|") || name.contains("]") || name.contains("(") || name.contains(")") || name.contains("{") || name.contains("}") || name.contains(" ") || name.contains("\"") || name.contains(",") || name.contains(";") || name.contains(":") || name.contains(".") || name.contains("!") || name.contains("§") || name.contains("$"))
				{
				    Err.printErr("[ ERR ]:[ GOTO ]:[ DEFG ]:[ ILLEGALCHARACTERIN:"+name+" ] Eine Variable darf nur aus Buchstaben und Zahlen bestehen!");
				}
				
				lv.addGotoValue(tmpstr);
				tmpstr = "";
			    }
			    else
			    {
				this.cmds.add(tmpstr);
				tmpstr = "";
			    }
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
					if (!func)
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
							else if (code[i] == '\n')
							{
							    	if (tmpstr.startsWith("\"") && tmpstr.endsWith("\""))
        								tmpstr = tmpstr.substring(1, tmpstr.length()-1);
        							
        							try	{ if (tmpstr != null) this.cmds.add(tmpstr); }
        							catch (NullPointerException ex) {}
        						
        							//System.out.println("[ CMD ] "+tmpstr+ "\t[ SIZE ]  [  "+cmds.size()+"\t ]");
        							tmpstr = "";
        							
        							tmpstr = "+[DN3:F0:1NE7";
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
							if (code[i] != ']' && code[i+1] != ']')
							tmpstr += code[i];
						}
					}
					else
					{

						if (code[i] == ']' && func)
						{
//							System.out.println("[ DEFF ] Zu!");
							func = false;
							i++;
						}
						else
						{
							tmpstr += code[i];
						}
					}
				}
			}
			else
			{
				if (code[i] == '[' && code[i+1] == '[' && !func)
				{
					i++;
					i++;
					//System.out.println("[ DEFF ] Offen!");
					func = true;
				}
				
				if (code[i] == ']' && code[i+1] == ']' && func)
				{
//					System.out.println("[ DEFF ] Zu!");
					func = false;
				}
				else if (code[i] == ']' && code[i+1] == ']' && !func)
				{
					Err.printErr("[ ERR ]:[ FUNC ]:[ NOTOPENED ] Es wurde keine Funktion göffnet, die geschlossen werden muss!");
				}
				
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
					{
					    isStr = false;

					    tmpstr = tmpstr.replace("%aX", "\"");
					    tmpstr = tmpstr.replace("%eX", "\'");
					    tmpstr = tmpstr.replace("%nX", "\n");
					    tmpstr = tmpstr.replace("%tX", "\t");
					    

//					    tmpstr = tmpstr.replace("%aX", ((char) 132)+"");
//					    tmpstr = tmpstr.replace("%uX", ((char) 129)+"");
//					    tmpstr = tmpstr.replace("%oX", ((char) 148)+"");
					}
					else
					{
					    isStr = true;
					}
				}
				
//				if (code[i] == '(')
//				{
//					func = true;
//				}
//				
//				if (code[i] == ')')
//				{
//					func = false;
//				}
//				
				tmpstr = tmpstr + (""+code[i]);
			}
		}
	}
	
	public void executeCode() throws IOException
	{
		LangVars lv = Main.getLangVars();
		CommandGetter getter = new CommandGetter(this.cmds, lv.getLCommands(), Main.isCpp());
		
		getter.execute();
	}
}
