package ru.platformer.entity;

import java.net.URL;

import javax.swing.JLabel;

import ru.gfe.handler.SoundHandler;
import ru.gfe.physicobject.IPhysicObject;
import ru.gfe.physicobject.PhysicObject;
import ru.platformer.item.IDamageableCreature;
import ru.platformer.util.ResourceUtil;

public class GameObjectExplosion extends PhysicObject
{
	private String explosionResource = "resources/level/testGame/textures/robot/death";
	
	private String explosionSoundResource = "resources/level/testGame/sounds/explosion.wav";
	
	private URL explosionSoundResourceURL = ResourceUtil.getURL(explosionSoundResource);
	
	public GameObjectExplosion() 
	{
		super(new JLabel());
		
		setPrimarySequence(ResourceUtil.createSequence(explosionResource, 0, 16, 15));
		
		startOrResumeCurrentSequence();
		SoundHandler.play(explosionSoundResourceURL);
	}

	public void processCollision(IPhysicObject iGameObject)
	{
		if (iGameObject != null && iGameObject instanceof IDamageableCreature)
			((IDamageableCreature) iGameObject).processDamage(50);	
	}
	
	public void update()
	{
		super.update();
		
		if (currentSequenceStarted() && currentSequenceEnded())
		{	
			level.removeGameObject(id);
			destroyGameObject();
		}
	}
	
	protected void destroyGameObject()
	{
		super.destroyGameObject();
		
		explosionResource = null;
		
		explosionSoundResource = null;
		
		explosionSoundResourceURL = null;
	}
}
