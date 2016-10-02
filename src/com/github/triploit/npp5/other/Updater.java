package com.github.triploit.npp5.other;

import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Updater 
{
	
	private File f;
	private boolean ex;
	private boolean err;

	public void findFile(String string) 
	{
		if (!err)
		{
			f = new File(string);
			
			if (f.exists())
				ex = true;
		}
	}

	@SuppressWarnings("resource")
	public void getLocalServerFile() 
	{
		if (ex && !err)
		{
			try 
			{
				URL website = new URL("http://www.website.com/information.asp");
				ReadableByteChannel rbc = Channels.newChannel(website.openStream());
				FileOutputStream fos = new FileOutputStream("verd.txt");
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("[ WARN ]:[ UPDATER ]:[ NOTFOUND:"+f.getName()+"] Konnte die Datei nicht finden! Update fehlgeschlagen!");
			err = true;
		}
	}

	public void equalsVersion() 
	{
		if (!err)
		{
			
		}
	}

}
