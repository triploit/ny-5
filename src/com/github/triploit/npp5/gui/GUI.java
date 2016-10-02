package com.github.triploit.npp5.gui;

import java.io.*;

public class GUI 
{
	File f;
	
	public GUI(String fname)
	{
		f = new File(fname);
	}
	
	public File getFile()
	{
		return this.f;
	}
	
	public void setFile(File f)
	{
		this.f = f;
	}

	@SuppressWarnings("deprecation")
	public void startGUI() 
	{
		Window w = new Window();
		w.show();
	}
}
