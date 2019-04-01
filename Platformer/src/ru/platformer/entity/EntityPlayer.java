package ru.platformer.entity;

import java.awt.event.KeyEvent;
import java.net.URL;

import ru.gfe.physicobject.Direction;
import ru.gfe.sequence.Sequence;
import ru.platformer.level.PlatformerLevel;
import ru.platformer.util.ResourceUtil;

public class EntityPlayer extends EntityHuman
{	
	public static final int DAMAGE_IGNORE_TIME = 1500;
	public static final int DAMAGE_IGNORE_TIME2 = 1200;
	
	private static String marcusStandingFrame0Resource = "resources/level/testGame/textures/marcus/standing/0.png";
	
	private static String marcusRunningLeftResource = "resources/level/testGame/textures/marcus/running/left";
	
	private static String marcusRunningRightResource = "resources/level/testGame/textures/marcus/running/right";
	
	private static String marcusJumpingLeftFrame0Resource = "resources/level/testGame/textures/marcus/jumping/left/0.png";
	
	private static String marcusJumpingRightFrame0Resource = "resources/level/testGame/textures/marcus/jumping/right/0.png";
	
	private static String marcusJumpingFrame0Resource = "resources/level/testGame/textures/marcus/jumping/0.png";
	
	private static String marcusFallingLeftFrame0Resource = "resources/level/testGame/textures/marcus/falling/left/0.png";
	
	private static String marcusFallingRightFrame0Resource = "resources/level/testGame/textures/marcus/falling/right/0.png";
	
	private static String marcusFallingFrame0Resource = "resources/level/testGame/textures/marcus/falling/0.png";
	
	private static String marcusDamagingStandingFrame0Resource = "resources/level/testGame/textures/marcus/damaging/standing/0.png";
	
	private static String marcusDamagingRunningLeftResource = "resources/level/testGame/textures/marcus/damaging/running/left";
	
	private static String marcusDamagingRunningRightResource = "resources/level/testGame/textures/marcus/damaging/running/right";
	
	private static String marcusDamagingJumpingLeftFrame0Resource = "resources/level/testGame/textures/marcus/damaging/jumping/left/0.png";
	
	private static String marcusDamagingJumpingRightFrame0Resource = "resources/level/testGame/textures/marcus/damaging/jumping/right/0.png";
	
	private static String marcusDamagingJumpingFrame0Resource = "resources/level/testGame/textures/marcus/damaging/jumping/0.png";
	
	private static String marcusDamagingFallingLeftFrame0Resource = "resources/level/testGame/textures/marcus/damaging/falling/left/0.png";
	
	private static String marcusDamagingFallingRightFrame0Resource = "resources/level/testGame/textures/marcus/damaging/falling/right/0.png";
	
	private static String marcusDamagingFallingFrame0Resource = "resources/level/testGame/textures/marcus/damaging/falling/0.png";
	
	private static URL marcusStandingFrame0ResourceURL = ResourceUtil.getURL(marcusStandingFrame0Resource);
	
	private static URL marcusJumpingLeftFrame0ResourceURL = ResourceUtil.getURL(marcusJumpingLeftFrame0Resource);
	
	private static URL marcusJumpingRightFrame0ResourceURL = ResourceUtil.getURL(marcusJumpingRightFrame0Resource);
	
	private static URL marcusJumpingFrame0ResourceURL = ResourceUtil.getURL(marcusJumpingFrame0Resource);
	
	private static URL marcusFallingLeftFrame0ResourceURL = ResourceUtil.getURL(marcusFallingLeftFrame0Resource);
	
	private static URL marcusFallingRightFrame0ResourceURL = ResourceUtil.getURL(marcusFallingRightFrame0Resource);
	
	private static URL marcusFallingFrame0ResourceURL = ResourceUtil.getURL(marcusFallingFrame0Resource);
	
	private static URL marcusDamagingStandingFrame0ResourceURL = ResourceUtil.getURL(marcusDamagingStandingFrame0Resource);
	
	private static URL marcusDamagingJumpingLeftFrame0ResourceURL = ResourceUtil.getURL(marcusDamagingJumpingLeftFrame0Resource);
	
	private static URL marcusDamagingJumpingRightFrame0ResourceURL = ResourceUtil.getURL(marcusDamagingJumpingRightFrame0Resource);
	
	private static URL marcusDamagingJumpingFrame0ResourceURL = ResourceUtil.getURL(marcusDamagingJumpingFrame0Resource);
	
	private static URL marcusDamagingFallingLeftFrame0ResourceURL = ResourceUtil.getURL(marcusDamagingFallingLeftFrame0Resource);
	
	private static URL marcusDamagingFallingRightFrame0ResourceURL = ResourceUtil.getURL(marcusDamagingFallingRightFrame0Resource);
	
	private static URL marcusDamagingFallingFrame0ResourceURL = ResourceUtil.getURL(marcusDamagingFallingFrame0Resource);
	
	private static String damageSoundResource = "resources/level/testGame/sounds/damage.wav";
	
	private static URL damageSoundResourceURL = ResourceUtil.getURL(damageSoundResource);
	
//	private static String soundResource = "resources/level/testGame/sounds/weapons/gauss/gauss_shoot.wav";
	
//	private static URL soundResourceURL = ResourceUtil.getURL(soundResource);
	
	private boolean active;
	
	public EntityPlayer(PlatformerLevel platformerLevel) 
	{
		super(platformerLevel, DAMAGE_IGNORE_TIME, DAMAGE_IGNORE_TIME2);
		
		setSpeed(3.05F);
		
		this.platformerLevel = platformerLevel;
		
		Sequence seq = new Sequence("");
		
		seq.loadFrames(marcusStandingFrame0ResourceURL);
		setStandingSequence(seq.clone());
		
		setRunningLeftSequence(ResourceUtil.createSequence(marcusRunningLeftResource, 0, 3, EntityHuman.DEFAULT_FPS));
		
		setRunningRightSequence(ResourceUtil.createSequence(marcusRunningRightResource, 0, 3, EntityHuman.DEFAULT_FPS));
		
		seq.loadFrames(marcusJumpingLeftFrame0ResourceURL);
		setJumpingLeftSequence(seq.clone());
		
		seq.loadFrames(marcusJumpingRightFrame0ResourceURL);
		setJumpingRightSequence(seq.clone());
		
		seq.loadFrames(marcusJumpingFrame0ResourceURL);
		setJumpingSequence(seq.clone());
		
		seq.loadFrames(marcusFallingLeftFrame0ResourceURL);
		setFallingLeftSequence(seq.clone());
		
		seq.loadFrames(marcusFallingRightFrame0ResourceURL);
		setFallingRightSequence(seq.clone());
		
		seq.loadFrames(marcusFallingFrame0ResourceURL);
		setFallingSequence(seq.clone());
		
		seq.loadFrames(marcusDamagingStandingFrame0ResourceURL);
		setDamagingStandingSequence(seq.clone());
		
		setDamagingRunningLeftSequence(ResourceUtil.createSequence(marcusDamagingRunningLeftResource, 0, 2, DEFAULT_FPS));
		
		setDamagingRunningRightSequence(ResourceUtil.createSequence(marcusDamagingRunningRightResource, 0, 2, DEFAULT_FPS));
		
		seq.loadFrames(marcusDamagingJumpingLeftFrame0ResourceURL);
		setDamagingJumpingLeftSequence(seq.clone());
		
		seq.loadFrames(marcusDamagingJumpingRightFrame0ResourceURL);
		setDamagingJumpingRightSequence(seq.clone());
		
		seq.loadFrames(marcusDamagingJumpingFrame0ResourceURL);
		setDamagingJumpingSequence(seq.clone());
		
		seq.loadFrames(marcusDamagingFallingLeftFrame0ResourceURL);
		setDamagingFallingLeftSequence(seq.clone());
		
		seq.loadFrames(marcusDamagingFallingRightFrame0ResourceURL);
		setDamagingFallingRightSequence(seq.clone());
		
		seq.loadFrames(marcusDamagingFallingFrame0ResourceURL);
		setDamagingFallingSequence(seq.clone());
		
		setDamageSound(damageSoundResourceURL);
		
		seq = null;
		
		active = true;
		
		startOrResumeCurrentSequence();
	}
	
	public void setSpeed(float speed)
	{
		this.speed = speed > 0 ? speed : 0;
	}
	
	public float getSpeed()
	{
		return speed;
	}
	
	public void processKeyEvent(KeyEvent e)
	{
		if (e.getID() == KeyEvent.KEY_PRESSED)
		{
			switch (e.getKeyCode()) 
			{
				case KeyEvent.VK_A:
				case KeyEvent.VK_LEFT:
					if (!jumpingOrFalling)
					{
						direction = Direction.LEFT;
						state = State.RUNNING;
					}
					else
						direction = Direction.NONE;
					break;
				case KeyEvent.VK_D:
				case KeyEvent.VK_RIGHT:
					if (!jumpingOrFalling)
					{
						direction = Direction.RIGHT;
						state = State.RUNNING;
					}
					else
						direction = Direction.NONE;
					break;
				case KeyEvent.VK_B:
					processDamage(0.55f);
					break;
				case KeyEvent.VK_SPACE:
					jump();
					break;
				case KeyEvent.VK_F:
					spawnProjectile();
//					SoundHandler.play(soundResourceURL, 0.25);
					break;
			}
		}
		else if (e.getID() == KeyEvent.KEY_RELEASED && !jumpingOrFalling)
		{	
			switch (e.getKeyCode()) 
			{
				case KeyEvent.VK_A:
				case KeyEvent.VK_LEFT:
					if (direction == Direction.LEFT)
					{	
						direction = Direction.NONE;
						state = State.STANDING;
					}
					break;
				case KeyEvent.VK_D:
				case KeyEvent.VK_RIGHT:
					if (direction == Direction.RIGHT)
					{	
						direction = Direction.NONE;
						state = State.STANDING;
					}
					break;
			}
		}
	}
	
	public void update()
	{
		super.update();
		
		String name = getCurrentSequenceName();
		
		if (name != null)
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
		
		if (health <= 0)
			System.out.println("Ouch! " + health);
		
		name = null;
	}
	
	private void spawnProjectile()
	{
		EntityProjectile entityProjectile = new EntityProjectile(getX() + 100, getY() + 50, 40f, 75f, "resources/level/testGame/textures/gun/projectile/projectile.png", direction, this);
		level.addGameObject(entityProjectile);
		
		entityProjectile.getVisual().setBounds(getX() + 100, getY() + 50, 18, 18);
		entityProjectile.setX(getX() + 100);
		entityProjectile.setY(getY() + 50);
	}
	
	protected void onDeath()
	{
		active = false;
	}
	
	public boolean isActive()
	{
		return active;
	}
	
	protected void destroyGameObject()
	{
		super.destroyGameObject();
		
		marcusStandingFrame0Resource = null;
		
		marcusRunningLeftResource = null;
		
		marcusRunningRightResource = null;
		
		marcusJumpingLeftFrame0Resource = null;
		
		marcusJumpingRightFrame0Resource = null;
		
		marcusJumpingFrame0Resource = null;
		
		marcusFallingLeftFrame0Resource = null;
		
		marcusFallingRightFrame0Resource = null;
		
		marcusFallingFrame0Resource = null;
		
		marcusDamagingStandingFrame0Resource = null;
		
		marcusDamagingRunningLeftResource = null;
		
		marcusDamagingRunningRightResource = null;
		
		marcusDamagingJumpingLeftFrame0Resource = null;
		
		marcusDamagingJumpingRightFrame0Resource = null;
		
		marcusDamagingJumpingFrame0Resource = null;
		
		marcusDamagingFallingLeftFrame0Resource = null;
		
		marcusDamagingFallingRightFrame0Resource = null;
		
		marcusDamagingFallingFrame0Resource = null;
		
		marcusStandingFrame0ResourceURL = null;
		
		marcusJumpingLeftFrame0ResourceURL = null;
		
		marcusJumpingRightFrame0ResourceURL = null;
		
		marcusJumpingFrame0ResourceURL = null;
		
		marcusFallingLeftFrame0ResourceURL = null;
		
		marcusFallingRightFrame0ResourceURL = null;
		
		marcusFallingFrame0ResourceURL = null;
		
		marcusDamagingStandingFrame0ResourceURL = null;
		
		marcusDamagingJumpingLeftFrame0ResourceURL = null;
		
		marcusDamagingJumpingRightFrame0ResourceURL = null;
		
		marcusDamagingJumpingFrame0ResourceURL = null;
		
		marcusDamagingFallingLeftFrame0ResourceURL = null;
		
		marcusDamagingFallingRightFrame0ResourceURL = null;
		
		marcusDamagingFallingFrame0ResourceURL = null;
		
		damageSoundResource = null;
		
		damageSoundResourceURL = null;
		
//		soundResource = null;
		
//		soundResourceURL = null;
	}
}
