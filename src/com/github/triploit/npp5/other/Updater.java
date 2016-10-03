package com.github.triploit.npp5.other;

import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import com.github.triploit.npp5.Main;

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
				URL website = new URL("https://github.com/Triploit-org/ny-5/blob/master/Interpreter/ver.txt");
				ReadableByteChannel rbc = Channels.newChannel(website.openStream());
				FileOutputStream fos = new FileOutputStream("verd.txt");
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			} 
			catch (IOException e) 
			{
				System.err.println("[ WARN ]:[ UPDATER ]:[ CANTWRITE ] Konnte keine Schreibrechte für Updates erlangen!");
				err = true;
			}
		}
		else
		{
			System.out.println("[ WARN ]:[ UPDATER ]:[ NOTFOUND:"+f.getName()+"] Konnte die Datei nicht finden! Update fehlgeschlagen!");
			err = true;
		}
	}

	@SuppressWarnings("resource")
	public void equalsVersion() 
	{
		if (!err)
		{
			try
			{
			    if (f.getName().equalsIgnoreCase("ver.txt"))
			    {
				f.delete();
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write((Main.getVersion()));
				bw.close();
			    }
				
			    BufferedReader bw = new BufferedReader((new FileReader(f)));
			    BufferedReader bw2 = new BufferedReader((new FileReader(new File("verd.txt"))));
			    
			    String l = bw.readLine();
			    String line = "";
			    String l2 = "";
			    
			    while ((line = bw2.readLine()) != null)
			    {
				l2 += line;
			    }
			    
			    if (!l2.contains(l))
			    {
				System.out.println(
					"[ INF ]:[ UPDATER ]:[ UPDATEFOUND ] Es wurde ein neues Update gefunden!"//+
					//"\n[ INF ]:[ VERSION ] Ihre Version: "+l
					);
			    }	
			    else
			    {
//				System.out.println("[ INF ]:[ VERSION ] Ihre Version: "+l);
//				System.out.println("[ INF ]:[ SERVER ]:[ VERSION ] Server-Version: "+l2);
			    }
			    
			    File f = new File("verd.txt");
			    
			    if (f.exists())
				f.delete();
			    
			} catch (IOException e)
			{
			    System.err.println("[ WARN ]:[ UPDATER ]:[ CANTWRITE ] Konnte keine Schreibrechte für Updates erlangen!");
			    err = true;
			}
		}
	}

}
