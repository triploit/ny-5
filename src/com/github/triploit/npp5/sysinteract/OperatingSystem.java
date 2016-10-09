package com.github.triploit.npp5.sysinteract;

public class OperatingSystem
{
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static int getOperatingSystem() 
    {
        if (isWindows()) 
        {
            return 1;
            
        } 
        else if (isMac()) 
        {
            return 2;

        } 
        else if (isUnix()) 
        {
            return 3;

        } 
        else 
        {
            return 4;

        }
    }

    private static boolean isWindows() 
    {
        return (OS.indexOf("win") >= 0);
    }

    private static boolean isMac() 
    {
        return (OS.indexOf("mac") >= 0);
    }

    private static boolean isUnix() 
    {
        return (OS.indexOf("nux") >= 0);
    }
}
