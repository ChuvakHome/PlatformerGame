package ru.platformer.entity;

import javax.swing.JLabel;

import ru.gfe.physicobject.PhysicObject;
import ru.platformer.event.GameBackgroundMovingEvent;
import ru.platformer.level.PlatformerLevel;

public abstract class MovingPhysicObject extends PhysicObject
{
	protected PlatformerLevel platformerLevel;
	
	public MovingPhysicObject(PlatformerLevel platformerLevel, JLabel body) 
	{
		super(body);
		
		this.platformerLevel = platformerLevel;
	}
	
	public void processGameBackgroundMovingEvent(GameBackgroundMovingEvent event)
	{
		if (!(this instanceof EntityPlayer))
		{	
			float factor = event.getFactor();
			
			switch (event.getDirection())
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
	
	public abstract void moveLeft(float factor);
	
	public abstract void moveRight(float factor);
}
