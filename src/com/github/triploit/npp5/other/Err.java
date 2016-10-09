package com.github.triploit.npp5.other;

import com.github.triploit.npp5.run.CommandGetter;

public class Err
{
    public static void printErr(String j)
    {
	System.out.println("["+CommandGetter.getLine()+":"+CommandGetter.getJ()+"] "+j);
	System.exit(0);
    }
}
