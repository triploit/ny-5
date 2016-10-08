package com.github.triploit.npp5.run;

import java.util.Random;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Command;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.LangVars;

public class Init
{
    private static LangVars lv;
    
    public Init()
    {
	lv = Main.getLangVars();
    }
    
    public void initializeLanguage()
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
	
	Command deff = new Command("deff", 2);
	lv.addLCommands(deff);
	Command runf = new Command("runf", 1);
	lv.addLCommands(runf);
	
	Command wt = new Command("wt", 1);
	lv.addLCommands(wt);
	
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
	
//	Command ddm = new Command("ddm", 1);
//	lv.addLCommands(ddm);
//	Command ddv = new Command("ddv", 1);
//	lv.addLCommands(ddv);
	
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
	
	Command pf = new Command("pf", 1);
	lv.addLCommands(pf);
	
//	lv.getFunctionList().add(CommandFunctionPointers._do);
//	lv.getFunctionList().add(CommandFunctionPointers.mov);
//	lv.getFunctionList().add(CommandFunctionPointers.Eq);
//	lv.getFunctionList().add(CommandFunctionPointers.defi);
//	lv.getFunctionList().add(CommandFunctionPointers.defs);
	
    }
    
    public void initialSystemVariables()
    {
	int __rnd = 0; 
	int min = 1;
	int max = 10000;
	
	Random r = new Random();
	__rnd = r.nextInt((max - min) + 1) + min;
	
	Variable rnd = new Variable("_rnd", new Value(__rnd));
	rnd.setNumeric(true);
	
	rnd.getValue().setNumeric(true);
	rnd.getValue().setString(false);
	
	lv.addLVariable(rnd);
    }
    
}
