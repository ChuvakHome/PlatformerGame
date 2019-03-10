package ru.platformer.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import ru.gfe.engine.GameFusionEngine;
import ru.gfe.handler.ResourceHandler;
import ru.gfe.sequence.Sequence;
import ru.platformer.caption.Caption;

public class ResourceUtil
{
	private static Caption screenResolution;
	
	public static boolean isJar()
	{
		String ext = ResourceHandler.getExtention(ResourceUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile());
		
		return ext != null && ext.equals("jar");
	}
	
	public static URL getURL(String resource)
	{
		if (resource.contains("%r"))
		{
			if (screenResolution == null)
			{
				screenResolution = Caption.valueOf(GameFusionEngine.getDisplayHeight());
				screenResolution.append('p');
			}
				
			resource = resource.replace("%r", screenResolution);
		}
		
		if (isJar())
		{
			resource = "/" + resource;
			
			return ResourceUtil.class.getResource(resource);
		}
		else
		{
			try 
			{
				return new File(resource).toURI().toURL();
			} catch (MalformedURLException e) {e.printStackTrace();}
		}
		
		return null;
	}
	
	public static URL[] getURLArray(String... paths)
	{
		URL[] urls = null;
		
		if (paths != null)
		{
			urls = new URL[paths.length];
			
			for (int i = 0; i < urls.length; ++i)
				urls[i] = ResourceUtil.getURL(paths[i]);
		}
			
		return urls;
	}
	
	public static Sequence createSequence(final String resource, int start, int end, int fps)
	{
		if (resource != null && start >= 0 && end >= start)
		{
			URL[] urls = new URL[end - start + 1];
			
			Caption cap = Caption.valueOf(resource);
			
			if (!resource.endsWith("/"))
				cap.append("/");
			
			int i = 0;
			
			for (i = 0; start + i <= end; ++i)
			{
				cap.append(start + i).append(".png");
				
				urls[i] = getURL(cap.toString());
				
				cap = Caption.valueOf(resource);
				
				if (!resource.endsWith("/"))
					cap.append("/");
			}
			
			Sequence sequence = new Sequence(urls);
			sequence.setFPS(fps);
			
			urls = null;
			
			i = 0;
			
			cap = null;
			
			return sequence;
		}
		
		return null;
	}
}
