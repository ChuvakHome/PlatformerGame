package ru.platformer.entity;

import java.awt.event.KeyEvent;
import java.net.URL;

import ru.gfe.handler.SoundHandler;
import ru.gfe.physicobject.Movement;
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
	
//	private static String damageResource = "resources/level/testGame/sounds/damage.wav";
	
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
//	
//	private int relaxationTime = 0;
//	
//	private int relaxationTime2 = 0;
	
	private static String soundResource = "resources/level/testGame/sounds/weapons/gauss/gauss_shoot.wav";
	
	private static URL soundResourceURL = ResourceUtil.getURL(soundResource);
	
//	private Item currentItem;
	
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
						movement = Movement.LEFT;
					else
						movement = Movement.NONE;
					setMovementSequence();
					break;
				case KeyEvent.VK_D:
				case KeyEvent.VK_RIGHT:
					if (!jumpingOrFalling)
						movement = Movement.RIGHT;
					else
						movement = Movement.NONE;
					setMovementSequence();
					break;
				case KeyEvent.VK_SPACE:
					jump();
					break;
				case KeyEvent.VK_F:
					spawnProjectile();
					SoundHandler.play(soundResourceURL, 0.25);
					break;
			}
		}
		else if (e.getID() == KeyEvent.KEY_RELEASED)
		{	
			switch (e.getKeyCode()) 
			{
				case KeyEvent.VK_A:
				case KeyEvent.VK_LEFT:
					if (movement == Movement.LEFT)
					{
						movement = Movement.NONE;
						resetAllSequences();
						setMovementSequence();
					}
					break;
				case KeyEvent.VK_D:
				case KeyEvent.VK_RIGHT:
					if (movement == Movement.RIGHT)
					{
						movement = Movement.NONE;
						resetAllSequences();
						setMovementSequence();
					}
					break;
			}
		}
	}
	
	public void update()
	{
		super.update();
	
//		if (collision(EntityEnemy.class) && relaxationTime == 0)
//		{	
//			SoundHandler.play(damageResourceURL);
//			
//			damaging = !damaging ? true : damaging;
//			
//			relaxationTime = DAMAGE_IGNORE_TIME;
//			relaxationTime2 = DAMAGE_IGNORE_TIME2;
//		}
//		else if (relaxationTime > 0)
//			--relaxationTime;
//		
//		if (relaxationTime2 > 0)
//			--relaxationTime2;
//		else if (relaxationTime == 0)
//			damaging = false;
		
		String name = getCurrentSequenceName();
		
		if (name != null && !jumpingOrFalling)
		{	
			switch (movement)
			{
				case LEFT:
					moveLeft(0.05f * speed);	
					if (!name.equals(RUNNING_LEFT_SEQUENCE_NAME) && !name.equals(DAMAGING_RUNNING_LEFT_SEQUENCE_NAME))
						startSequence(damaging ? DAMAGING_RUNNING_LEFT_SEQUENCE : RUNNING_LEFT_SEQUENCE);
					else if (name.equals(RUNNING_LEFT_SEQUENCE_NAME) && damaging)
						startSequence(DAMAGING_RUNNING_LEFT_SEQUENCE);
					break;
				case RIGHT:
					moveRight(0.05f * speed);				
					if (!name.equals(RUNNING_RIGHT_SEQUENCE_NAME) && !name.equals(DAMAGING_RUNNING_RIGHT_SEQUENCE_NAME))
						startSequence(damaging ? DAMAGING_RUNNING_RIGHT_SEQUENCE : RUNNING_RIGHT_SEQUENCE);
					else if (name.equals(RUNNING_RIGHT_SEQUENCE_NAME) && damaging)
						startSequence(DAMAGING_RUNNING_RIGHT_SEQUENCE);
					break;
				case NONE:
					if (!name.equals(STANDING_SEQUENCE_NAME) && !name.equals(DAMAGING_STANDING_SEQUENCE_NAME))
					{
						if (damaging)
							startSequence(DAMAGING_STANDING_SEQUENCE);
						else
							resetToPrimarySequence();
					}
					else if (name.equals(STANDING_SEQUENCE_NAME) && damaging)
						startSequence(DAMAGING_STANDING_SEQUENCE);
					break;
			}
		}
		
		name = null;
	}
	
	private void spawnProjectile()
	{
		EntityProjectile entityProjectile = new EntityProjectile(getX() + 100, getY() + 50, 40f, 100f, "resources/level/testGame/textures/gun/projectile/projectile.png", movement, this);
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
}
