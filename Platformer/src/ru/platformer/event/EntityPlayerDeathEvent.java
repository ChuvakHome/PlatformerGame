package ru.platformer.event;

import ru.gfe.event.Event;
import ru.platformer.entity.EntityPlayer;

public class EntityPlayerDeathEvent extends Event
{
	private EntityPlayer entityPlayer;
	
	public EntityPlayerDeathEvent(EntityPlayer entityPlayer)
	{
		this.entityPlayer = entityPlayer;
		
		data = new Object[]{this.entityPlayer};
	}
	
	public EntityPlayer getEntityPlayer()
	{
		return entityPlayer;
	}
}
