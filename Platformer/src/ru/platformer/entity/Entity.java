package ru.platformer.entity;

import javax.swing.JLabel;

import ru.platformer.item.IDamageableCreature;
import ru.platformer.level.PlatformerLevel;

public abstract class Entity extends MovingPhysicObject implements IDamageableCreature 
{
	protected float health;
	protected float resistance;
	
	public Entity(PlatformerLevel platformerLevel, JLabel body) 
	{
		super(platformerLevel, body);
		
		this.platformerLevel = platformerLevel;
	}
	
	public void processDamage(float damage)
	{
		health -= damage * (1f - resistance);
		
		if (health < 0)
		{
			health = 0;
			
			onDeath();
		}
	}
//	
//	public boolean isActive()
//	{
//		return health > 0;
//	}
	
	protected abstract void onDeath();
}
