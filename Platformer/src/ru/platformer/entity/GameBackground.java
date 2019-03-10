package ru.platformer.entity;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ru.gfe.engine.GameFusionEngine;
import ru.gfe.handler.ResourceHandler;
import ru.gfe.physicobject.Movement;
import ru.platformer.event.GameBackgroundMovingEvent;
import ru.platformer.level.PlatformerLevel;
import ru.platformer.util.ResourceUtil;

public class GameBackground
{
	protected double posX;
	protected float acceleration;
	
	protected Image image;
	
	protected Movement movement;
	
	private JLabel body;
	
	private int maxX;
	
	protected PlatformerLevel platformerLevel;
	
	protected EntityPlayer entityPlayer;
	
	public GameBackground(PlatformerLevel level, String path) 
	{
		this(level, ResourceUtil.getURL(path));
	}
	
	public GameBackground(PlatformerLevel level, URL url) 
	{	
		platformerLevel = level;
		
		movement = Movement.NONE;
		
		image = ResourceHandler.getImage(url);
		
		body = new JLabel();
		body.setIcon(new ImageIcon(image));
		
		maxX = body.getIcon().getIconWidth() - GameFusionEngine.getDisplayWidth();
	}
	
	public void setMaxX(int maxX)
	{
		this.maxX = maxX;
	}
	
	public void moveLeft(float factor)
	{
		if (Math.abs((int) posX) < Math.abs(maxX))	
		{
			posX -= factor;
			GameFusionEngine.processEvent(new GameBackgroundMovingEvent(this, factor, Movement.LEFT));
		}
		else
			GameFusionEngine.processEvent(new GameBackgroundMovingEvent(this, factor, Movement.NONE));
	}
	
	public void moveRight(float factor)
	{	
		if (posX < 0)
		{
			posX += factor;
			GameFusionEngine.processEvent(new GameBackgroundMovingEvent(this, factor, Movement.RIGHT));
		}
		else
			GameFusionEngine.processEvent(new GameBackgroundMovingEvent(this, factor, Movement.NONE));
	}
	
	public void processKeyEvent(KeyEvent e)
	{
		if (e.getID() == KeyEvent.KEY_PRESSED)
		{
			switch (e.getKeyCode()) 
			{
				case KeyEvent.VK_LEFT:
				case KeyEvent.VK_A:
				case KeyEvent.VK_RIGHT:
				case KeyEvent.VK_D:
					switch (platformerLevel.getEntityPlayer().movement)
					{
						case LEFT:
							movement = Movement.RIGHT;
							break;
						case RIGHT:
							movement = Movement.LEFT;
							break;
						case NONE:
							movement = Movement.NONE;
							break;
					}
					break;
			}
		}
		else if (e.getID() == KeyEvent.KEY_RELEASED)
		{
			switch (e.getKeyCode()) 
			{
				case KeyEvent.VK_LEFT:
				case KeyEvent.VK_A:
				case KeyEvent.VK_RIGHT:
				case KeyEvent.VK_D:
					movement = Movement.NONE;
					break;
			}
		}
	}
	
	public JLabel getVisual()
	{
		return body;
	}
	
	public void setSpeed(float speed)
	{
		acceleration = speed;
	}
	
	public void update()
	{	
		body.setLocation((int) posX, 0);
		
		float factor = 0.05f * (platformerLevel.getEntityPlayer().speed + acceleration);
		
		switch (movement)
		{
			case LEFT:
				moveLeft(factor);
				break;
			case RIGHT:
				moveRight(factor);
				break;
			case NONE:
				break;
		}
		
		factor = 0;
	}
}
