package ru.platformer.level;

import ru.gfe.engine.Level;
import ru.platformer.entity.EntityPlayer;

public class PlatformerLevel extends Level
{
	private EntityPlayer entityPlayer;
	
	public void setEntityPlayer(EntityPlayer entityPlayer)
	{
		if (this.entityPlayer == null)
			this.entityPlayer = entityPlayer;
	}
	
	public EntityPlayer getEntityPlayer()
	{
		return entityPlayer;
	}
}
