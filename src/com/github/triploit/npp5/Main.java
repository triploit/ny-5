package com.github.triploit.npp5;

import java.io.IOException;

import com.github.triploit.npp5.Objects.Command;
//import com.github.triploit.npp5.other.CommandFunctionPointers;
import com.github.triploit.npp5.other.LangVars;
import com.github.triploit.npp5.run.Parser;
import com.github.triploit.npp5.run.Tokenizer;

public class Main 
{
	private static LangVars lv = new LangVars();
	
	//@SuppressWarnings("static-access")
	public static void main(String[] args)
	{		
		Command mov = new Command("mov", 2);
		lv.addLCommands(mov);
		
		Command eq = new Command("eq", 3);
		lv.addLCommands(eq);
		Command leq = new Command("leq", 3);
		lv.addLCommands(leq);
		Command neq = new Command("neq", 3);
		lv.addLCommands(neq);
		Command geq = new Command("geq", 3);
		
		lv.addLCommands(geq);
		Command defi = new Command("defi", 2);
		lv.addLCommands(defi);
		Command defs = new Command("defs", 2);
		
		lv.addLCommands(defs);
		Command prv = new Command("prv", 1);
		lv.addLCommands(prv);
		Command inp = new Command("inp", 1);
		lv.addLCommands(inp);
		Command gt = new Command("gt", 2);
		lv.addLCommands(gt);
		Command say = new Command("say", 1);
		lv.addLCommands(say);
		
		Command end = new Command("end", 0);
		lv.addLCommands(end);
		Command rtrn = new Command("return", 0);
		lv.addLCommands(rtrn);
		
		Command ddm = new Command("ddm", 1);
		lv.addLCommands(ddm);
		Command ddv = new Command("ddv", 1);
		lv.addLCommands(ddv);
		
		Command div = new Command("div", 2);
		lv.addLCommands(div);
		Command mul = new Command("mul", 2);
		lv.addLCommands(mul);
		Command add = new Command("add", 2);
		lv.addLCommands(add);
		Command rem = new Command("rem", 2);
		lv.addLCommands(rem);
		Command mod = new Command("mod", 2);
		lv.addLCommands(mod);
		
		
//		lv.getFunctionList().add(CommandFunctionPointers._do);
//		lv.getFunctionList().add(CommandFunctionPointers.mov);
//		lv.getFunctionList().add(CommandFunctionPointers.Eq);
//		lv.getFunctionList().add(CommandFunctionPointers.defi);
//		lv.getFunctionList().add(CommandFunctionPointers.defs);
		
		try 
		{
			Parser p = new Parser(args[0]);
			Tokenizer tok = new Tokenizer(p);
			
			tok.doTokenize();
			tok.executeCode();
		} 
		catch (IOException e) 
		{
			System.out.println("[ ERR ] Konnte Datei nicht finden! Wurde eine Datei angegeben?\n\n ->->-> Java-Error:");
			e.printStackTrace();
		}
	}
	
	public static LangVars getLangVars()
	{
		return lv;		
	}
}
