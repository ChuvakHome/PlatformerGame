package ru.platformer.entity;

import java.net.URL;

import ru.gfe.handler.SoundHandler;
import ru.gfe.physicobject.Direction;
import ru.gfe.physicobject.IPhysicObject;
import ru.platformer.item.IDamageableCreature;
import ru.platformer.level.PlatformerLevel;
import ru.platformer.util.ResourceUtil;

public class EntityRobot extends EntityEnemy
{
	private static String robotStandingResource = "resources/level/testGame/textures/robot/standing";
	
	private static String robotRunningLeftResource = "resources/level/testGame/textures/robot/running/left";
	
	private static String robotRunningRightResource = "resources/level/testGame/textures/robot/running/right";
	
	private static String robotJumpingLeftResource = "resources/level/testGame/textures/robot/jumping/left";
	
	private static String robotJumpingRightResource = "resources/level/testGame/textures/robot/jumping/right";
	
	private static String robotJumpingResource = "resources/level/testGame/textures/robot/jumping";
	
	private static String robotFallingLeftResource = "resources/level/testGame/textures/robot/falling/left";
	
	private static String robotFallingRightResource = "resources/level/testGame/textures/robot/falling/right";
	
	private static String robotFallingResource = "resources/level/testGame/textures/robot/falling";
	
	private static String robotDamagingStandingResource = "resources/level/testGame/textures/robot/damaging/standing";
	
	private static String robotDamagingRunningLeftResource = "resources/level/testGame/textures/robot/damaging/running/left";
	
	private static String robotDamagingRunningRightResource = "resources/level/testGame/textures/robot/damaging/running/right";
	
	private static String robotDamagingJumpingLeftResource = "resources/level/testGame/textures/robot/damaging/jumping/left";
	
	private static String robotDamagingJumpingRightResource = "resources/level/testGame/textures/robot/damaging/jumping/right";
	
	private static String robotDamagingJumpingResource = "resources/level/testGame/textures/robot/damaging/jumping";
	
	private static String robotDamagingFallingLeftResource = "resources/level/testGame/textures/robot/damaging/falling/left";
	
	private static String robotDamagingFallingRightResource = "resources/level/testGame/textures/robot/damaging/falling/right";
	
	private static String robotDamagingFallingResource = "resources/level/testGame/textures/robot/damaging/falling";
	
	private static String robotDeathResource = "resources/level/testGame/textures/explosion";
	
	private static String explosionSoundResource = "resources/level/testGame/sounds/explosion.wav";
	
	private static URL explosionSoundResourceURL = ResourceUtil.getURL(explosionSoundResource);
	
	private boolean explosion;
	
	public EntityRobot(PlatformerLevel platformerLevel) 
	{
		super(platformerLevel, 1500, 1200);
		
		setSpeed(2.95F + 3.05F);
		
		setStandingSequence(ResourceUtil.createSequence(robotStandingResource, 0, 0, DEFAULT_FPS));
		
		setRunningLeftSequence(ResourceUtil.createSequence(robotRunningLeftResource, 0, 5, DEFAULT_FPS));
		
		setRunningRightSequence(ResourceUtil.createSequence(robotRunningRightResource, 0, 5, DEFAULT_FPS));
		
		setJumpingLeftSequence(ResourceUtil.createSequence(robotJumpingLeftResource, 0, 0, DEFAULT_FPS));
		
		setJumpingRightSequence(ResourceUtil.createSequence(robotJumpingRightResource, 0, 0, DEFAULT_FPS));
		
		setJumpingSequence(ResourceUtil.createSequence(robotJumpingResource, 0, 0, DEFAULT_FPS));
		
		setFallingLeftSequence(ResourceUtil.createSequence(robotFallingLeftResource, 0, 0, DEFAULT_FPS));
		
		setFallingRightSequence(ResourceUtil.createSequence(robotFallingRightResource, 0, 0, DEFAULT_FPS));
		
		setFallingSequence(ResourceUtil.createSequence(robotFallingResource, 0, 0, DEFAULT_FPS));
		
		setDamagingStandingSequence(ResourceUtil.createSequence(robotDamagingStandingResource, 0, 0, DEFAULT_FPS));
		
		setDamagingRunningLeftSequence(ResourceUtil.createSequence(robotDamagingRunningLeftResource, 0, 5, DEFAULT_FPS));
		
		setDamagingRunningRightSequence(ResourceUtil.createSequence(robotDamagingRunningRightResource, 0, 5, DEFAULT_FPS));
		
		setDamagingJumpingLeftSequence(ResourceUtil.createSequence(robotDamagingJumpingLeftResource, 0, 0, DEFAULT_FPS));
		
		setDamagingJumpingRightSequence(ResourceUtil.createSequence(robotDamagingJumpingRightResource, 0, 0, DEFAULT_FPS));
		
		setDamagingJumpingSequence(ResourceUtil.createSequence(robotDamagingJumpingResource, 0, 0, DEFAULT_FPS));
		
		setDamagingFallingLeftSequence(ResourceUtil.createSequence(robotDamagingFallingLeftResource, 0, 0, DEFAULT_FPS));
		
		setDamagingFallingRightSequence(ResourceUtil.createSequence(robotDamagingFallingRightResource, 0, 0, DEFAULT_FPS));
		
		setDamagingFallingSequence(ResourceUtil.createSequence(robotDamagingFallingResource, 0, 0, DEFAULT_FPS));
		
		setDeathSequence(ResourceUtil.createSequence(robotDeathResource, 0, 16, 15));
		
		resistance = 0.75f;
		
		startOrResumeCurrentSequence();
	}
	
	public void update()
	{
		super.update();
		
		if (getLevel() != null && getLevel() instanceof PlatformerLevel)
		{
			if (((PlatformerLevel) getLevel()).getEntityPlayer() != null)
			{
				EntityPlayer entityPlayer = ((PlatformerLevel) getLevel()).getEntityPlayer();
				
				int playerX = entityPlayer.getX();
				int robotX = getX();
				
				if (Math.abs(playerX - robotX) <= 550)
				{
					if (playerX < robotX)
					{
						direction = Direction.LEFT;
						state = State.RUNNING;
					}
					else if (playerX > robotX)
					{
						direction = Direction.RIGHT;
						state = State.RUNNING;
					}
					else
					{
						direction = Direction.NONE;
						state = State.STANDING;
					}
				}
			
				playerX = 0;
				robotX = 0;
			}
		}
		
		if (isActive() && health > 0)
		{
			switch (direction)
			{
				case LEFT:
					moveLeft(0.05f * speed);
					break;
				case RIGHT:
					moveRight(0.05f * speed);
					break;
				case NONE:
					break;
			}
		}
	}
	
	public void processCollision(IPhysicObject iGameObject)
	{
		if (iGameObject != null && iGameObject instanceof IDamageableCreature && explosion)
			((IDamageableCreature) iGameObject).processDamage(50);
	}
	
	protected void onDeath()
	{
		super.onDeath();
		
		explosion = true;
		
		SoundHandler.play(explosionSoundResourceURL);
	}
	
	protected void destroyGameObject()
	{
		super.destroyGameObject();
		
		robotStandingResource = null;
		
		robotRunningLeftResource = null;
		
		robotRunningRightResource = null;
		
		robotJumpingLeftResource = null;
		
		robotJumpingRightResource = null;
		
		robotJumpingResource = null;
		
		robotFallingLeftResource = null;
		
		robotFallingRightResource = null;
		
		robotFallingResource = null;
		
		robotDamagingStandingResource = null;
		
		robotDamagingRunningLeftResource = null;
		
		robotDamagingRunningRightResource = null;
		
		robotDamagingJumpingLeftResource = null;
		
		robotDamagingJumpingRightResource = null;
		
		robotDamagingJumpingResource = null;
		
		robotDamagingFallingLeftResource = null;
		
		robotDamagingFallingRightResource = null;
		
		robotDamagingFallingResource = null;
		
		robotDeathResource = null;
		
		explosionSoundResource = null;
		
		explosionSoundResourceURL = null;
		
		explosion = false;
	}
}
