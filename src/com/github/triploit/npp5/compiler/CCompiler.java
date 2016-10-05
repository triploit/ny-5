package com.github.triploit.npp5.compiler;

import java.io.IOException;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.other.LangVars;

public class CCompiler
{
    private LangVars lv = new LangVars();
    
    public CCompiler() {}
    
    public void writeCCode()
    {
	lv.writeCCode();
    }
    
    public void writeToFile(String txt) throws IOException
    {
	lv.writeFile(Main.getFileName(), txt);
    }
    
}
