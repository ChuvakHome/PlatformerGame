package ru.platformer.entity;

import ru.platformer.level.PlatformerLevel;

public abstract class EntityEnemy extends EntityHuman
{	
	public EntityEnemy(PlatformerLevel platformerLevel, int damageIgnoreTime, int damageIgnoreTime2)
	{
		super(platformerLevel, damageIgnoreTime, damageIgnoreTime2);
	}
}
