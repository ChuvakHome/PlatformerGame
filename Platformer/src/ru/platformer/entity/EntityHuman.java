package ru.platformer.entity;

import java.net.URL;

import javax.swing.JLabel;

import ru.gfe.handler.SoundHandler;
import ru.gfe.physicobject.Movement;
import ru.gfe.sequence.Sequence;
import ru.platformer.item.IInventoryOwner;
import ru.platformer.item.Item;
import ru.platformer.item.ItemStack;
import ru.platformer.level.PlatformerLevel;

public class EntityHuman extends Entity implements IInventoryOwner
{
	public static final int RUNNING_LEFT_SEQUENCE = 0;
	public static final int RUNNING_RIGHT_SEQUENCE = 1;
	
	public static final int JUMPING_LEFT_SEQUENCE = 3;
	public static final int JUMPING_RIGHT_SEQUENCE = 4;
	public static final int JUMPING_SEQUENCE = 5;
	
	public static final int FALLING_LEFT_SEQUENCE = 6;
	public static final int FALLING_RIGHT_SEQUENCE = 7;
	public static final int FALLING_SEQUENCE = 8;
	
	public static final int DAMAGING_STANDING_SEQUENCE = 9;
	
	public static final int DAMAGING_RUNNING_LEFT_SEQUENCE = 10;
	public static final int DAMAGING_RUNNING_RIGHT_SEQUENCE = 11;
	
	public static final int DAMAGING_JUMPING_LEFT_SEQUENCE = 12;
	public static final int DAMAGING_JUMPING_RIGHT_SEQUENCE = 13;
	public static final int DAMAGING_JUMPING_SEQUENCE = 14;
	
	public static final int DAMAGING_FALLING_LEFT_SEQUENCE = 15;
	public static final int DAMAGING_FALLING_RIGHT_SEQUENCE = 16;
	public static final int DAMAGING_FALLING_SEQUENCE = 17;
	
	public static final int DEATH_SEQUENCE = 18;
	
	public static final String STANDING_SEQUENCE_NAME = "standing";
	
	public static final String RUNNING_LEFT_SEQUENCE_NAME = "running_left";
	public static final String RUNNING_RIGHT_SEQUENCE_NAME = "running_right";
	
	public static final String JUMPING_LEFT_SEQUENCE_NAME = "jumping_left";
	public static final String JUMPING_RIGHT_SEQUENCE_NAME = "jumping_right";
	public static final String JUMPING_SEQUENCE_NAME = "jumping";
	
	public static final String FALLING_LEFT_SEQUENCE_NAME = "falling_left";
	public static final String FALLING_RIGHT_SEQUENCE_NAME = "falling_right";
	public static final String FALLING_SEQUENCE_NAME = "falling";
	
	public static final String DAMAGING_STANDING_SEQUENCE_NAME = "damaging_standing";
	
	public static final String DAMAGING_RUNNING_LEFT_SEQUENCE_NAME = "damaging_running_left";
	public static final String DAMAGING_RUNNING_RIGHT_SEQUENCE_NAME = "damaging_running_right";
	
	public static final String DAMAGING_JUMPING_LEFT_SEQUENCE_NAME = "damaging_jumping_left";
	public static final String DAMAGING_JUMPING_RIGHT_SEQUENCE_NAME = "damaging_jumping_right";
	public static final String DAMAGING_JUMPING_SEQUENCE_NAME = "damaging_jumping";
	
	public static final String DAMAGING_FALLING_LEFT_SEQUENCE_NAME = "damaging_falling_left";
	public static final String DAMAGING_FALLING_RIGHT_SEQUENCE_NAME = "damaging_falling_right";
	public static final String DAMAGING_FALLING_SEQUENCE_NAME = "damaging_falling";
	
	public static final String DEATH_SEQUENCE_NAME = "death";
	
	public static final int DEFAULT_FPS = 4;
	
	public static final int JUMP_DURATION = 1;
	
	public static final int JUMP_DELTA_Y = 125;
	
	public static final long DELAY = 9;
	
	protected Movement movement;
	protected State state;
	
	private int counter;
	private long delayCounter;
	
	private double posX;
	
	protected float speed;
	
	protected boolean jumpingOrFalling;
	
	protected boolean damaging;
	
	private boolean damage0;
	
	private int ignoreTime = 0;
	
	private int ignoreTime2 = 0;
	
	private final int damageIgnoreTime;
	private final int damageIgnoreTime2;
	
	private boolean deathSequenceSetted;
	
	private URL damageResourceURL;
	
	private ItemStack[] inventory;
	
	public EntityHuman(PlatformerLevel platformerLevel, int damageIgnoringTime, int damageIgnoringTime2) 
	{
		super(platformerLevel, new JLabel());
		
		state = State.STANDING;
		movement = Movement.NONE;
		
		health = 100f;
		
		damageIgnoreTime = damageIgnoringTime;
		damageIgnoreTime2 = damageIgnoringTime2;
		
		inventory = new ItemStack[50];
	}
	
	public void setStandingSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(STANDING_SEQUENCE_NAME);
			
			setPrimarySequence(sequence);
		}
		else
			throw new NullPointerException();
	}
	
	public void setRunningLeftSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(RUNNING_LEFT_SEQUENCE_NAME);
			
			addSequence(sequence, RUNNING_LEFT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setRunningRightSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(RUNNING_RIGHT_SEQUENCE_NAME);
			
			addSequence(sequence, RUNNING_RIGHT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setJumpingLeftSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(JUMPING_LEFT_SEQUENCE_NAME);
			
			addSequence(sequence, JUMPING_LEFT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setJumpingRightSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(JUMPING_RIGHT_SEQUENCE_NAME);
			
			addSequence(sequence, JUMPING_RIGHT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setJumpingSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(JUMPING_SEQUENCE_NAME);
			
			addSequence(sequence, JUMPING_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setFallingLeftSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(FALLING_LEFT_SEQUENCE_NAME);
			
			addSequence(sequence, FALLING_LEFT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setFallingRightSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(FALLING_RIGHT_SEQUENCE_NAME);
			
			addSequence(sequence, FALLING_RIGHT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setFallingSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(FALLING_SEQUENCE_NAME);
			
			addSequence(sequence, FALLING_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setDamagingStandingSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(DAMAGING_STANDING_SEQUENCE_NAME);
			
			addSequence(sequence, DAMAGING_STANDING_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setDamagingRunningLeftSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(DAMAGING_RUNNING_LEFT_SEQUENCE_NAME);
			
			addSequence(sequence, DAMAGING_RUNNING_LEFT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setDamagingRunningRightSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(DAMAGING_RUNNING_RIGHT_SEQUENCE_NAME);
			
			addSequence(sequence, DAMAGING_RUNNING_RIGHT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setDamagingJumpingLeftSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(DAMAGING_JUMPING_LEFT_SEQUENCE_NAME);
			
			addSequence(sequence, DAMAGING_JUMPING_LEFT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setDamagingJumpingRightSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(DAMAGING_JUMPING_RIGHT_SEQUENCE_NAME);
			
			addSequence(sequence, DAMAGING_JUMPING_RIGHT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setDamagingJumpingSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(DAMAGING_JUMPING_SEQUENCE_NAME);
			
			addSequence(sequence, DAMAGING_JUMPING_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setDamagingFallingLeftSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(DAMAGING_FALLING_LEFT_SEQUENCE_NAME);
			
			addSequence(sequence, DAMAGING_FALLING_LEFT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setDamagingFallingRightSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(DAMAGING_FALLING_RIGHT_SEQUENCE_NAME);
			
			addSequence(sequence, DAMAGING_FALLING_RIGHT_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setDamagingFallingSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(Sequence.LOOP_CONTINUOUSLY);
			sequence.setSequenceName(DAMAGING_FALLING_SEQUENCE_NAME);
			
			addSequence(sequence, DAMAGING_FALLING_SEQUENCE);
		}
		else
			throw new NullPointerException();
	}
	
	public void setDeathSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			sequence.loop(1);
			sequence.setSequenceName(DEATH_SEQUENCE_NAME);
			
			addSequence(sequence, DEATH_SEQUENCE);
			
			deathSequenceSetted = true;
		}
	}
	
	public void setSpeed(float speed)
	{
		this.speed = speed > 0 ? speed : 0;
	}
	
	public float getSpeed()
	{
		return speed;
	}
	
	public void update()
	{
		super.update();
		super.setX((int) posX);
			
		switch (state)
		{
			case JUMPING:				
				if (!jumpingOrFalling)
					jumpingOrFalling = true;
					
				if (counter > 0)
				{	
					++delayCounter;
					
					if (delayCounter == DELAY)
					{
						delayCounter = 0;
						posY = (int) (posY - 1d / JUMP_DURATION);
						--counter;
					}
				}
				else
				{
					state = State.FALLING;
					delayCounter = 0;
					counter = JUMP_DELTA_Y;
						
					switch (movement)
					{
						case LEFT:
							startSequence(damaging ? DAMAGING_FALLING_LEFT_SEQUENCE : FALLING_LEFT_SEQUENCE);
							break;
						case RIGHT:
							startSequence(damaging ? DAMAGING_FALLING_RIGHT_SEQUENCE : FALLING_RIGHT_SEQUENCE);
							break;
						case NONE:
							startSequence(damaging ? DAMAGING_FALLING_SEQUENCE : FALLING_SEQUENCE);
							break;
					}
				}
					
				break;
			case FALLING:
				if (counter > 0)
				{
					++delayCounter;
						
					if (delayCounter == DELAY)
					{
						delayCounter = 0;
						posY = (int) (posY + 1d / JUMP_DURATION);
						--counter;
					}
				}
				else
				{
					switch (movement)
					{
						case LEFT:
							state = State.RUNNING;
							startSequence(damaging ? DAMAGING_RUNNING_LEFT_SEQUENCE : RUNNING_LEFT_SEQUENCE);
							break;
						case RIGHT:
							state = State.RUNNING;
							startSequence(damaging ? DAMAGING_RUNNING_RIGHT_SEQUENCE : RUNNING_RIGHT_SEQUENCE);
							break;
						case NONE:
							state = State.STANDING;
							if (damaging)
								startSequence(DAMAGING_STANDING_SEQUENCE);
							else
								resetToPrimarySequence();
							break;
					}
						
					jumpingOrFalling = false;
						
					delayCounter = 0;
				}
				break;
			default:
				
				break;
		}
			
		if (health > 0)
		{
			if (ignoreTime > 0)
				--ignoreTime;
				
			if (ignoreTime2 > 0)
				--ignoreTime2;
			else if (ignoreTime == 0)
				damaging = false;
				
			if (damage0 != damaging)
			{
				if (jumpingOrFalling)
				{
					switch (movement)
					{
						case LEFT:
							startSequence(damaging ? DAMAGING_JUMPING_LEFT_SEQUENCE : JUMPING_LEFT_SEQUENCE);
							break;
						case RIGHT:
							startSequence(damaging ? DAMAGING_JUMPING_RIGHT_SEQUENCE : JUMPING_RIGHT_SEQUENCE);
							break;
						case NONE:
							startSequence(damaging ? DAMAGING_JUMPING_SEQUENCE : JUMPING_SEQUENCE);
							break;
					}
				}
				else
				{
					switch (movement)
					{
						case LEFT:
							startSequence(damaging ? DAMAGING_RUNNING_LEFT_SEQUENCE : RUNNING_LEFT_SEQUENCE);
							break;
						case RIGHT:
							startSequence(damaging ? DAMAGING_RUNNING_RIGHT_SEQUENCE : RUNNING_RIGHT_SEQUENCE);
							break;
						case NONE:
							if (damaging)
								startSequence(DAMAGING_STANDING_SEQUENCE);
							else
								resetToPrimarySequence();
							break;
					}
				}
					
				damage0 = damaging;
			}
		}
		else if (getCurrentSequenceName() != null && getCurrentSequenceName().equals(DEATH_SEQUENCE_NAME) && currentSequenceStarted() && currentSequenceEnded())
			level.removeGameObject(id);
	}

	protected void setMovementSequence()
	{	
		if (!jumpingOrFalling)
		{			
			switch (movement)
			{
				case LEFT:
					startSequence(damaging ? DAMAGING_RUNNING_LEFT_SEQUENCE : RUNNING_LEFT_SEQUENCE);
					break;
				case RIGHT:
					startSequence(damaging ? DAMAGING_RUNNING_RIGHT_SEQUENCE : RUNNING_RIGHT_SEQUENCE);
					break;
				case NONE:
					if (damaging)
						startSequence(DAMAGING_STANDING_SEQUENCE);
					else
						resetToPrimarySequence();
					break;
			}
		}
	}
	
	public void jump()
	{
		if (!jumpingOrFalling)
		{
			switch (movement)
			{
				case LEFT:
					startSequence(damaging ? DAMAGING_JUMPING_LEFT_SEQUENCE : JUMPING_LEFT_SEQUENCE);
					break;
				case RIGHT:
					startSequence(damaging ? DAMAGING_JUMPING_RIGHT_SEQUENCE : JUMPING_RIGHT_SEQUENCE);
					break;
				case NONE:
					startSequence(damaging ? DAMAGING_JUMPING_SEQUENCE : JUMPING_SEQUENCE);
					break;
			}
			
			counter = JUMP_DELTA_Y;
			
			state = State.JUMPING;
		}
	}
	
	public void moveLeft(float factor)
	{
		posX -= factor;
	}
	
	public void moveRight(float factor)
	{
		posX += factor;
	}
	
	public void setDamageSound(URL damageSoundURL)
	{
		damageResourceURL = damageSoundURL;
	}
	
	public URL getDamageSound()
	{
		return damageResourceURL;
	}
	
	protected void onDeath()
	{
		movement = Movement.NONE;
		
		if (deathSequenceSetted)
			startSequence(DEATH_SEQUENCE);
	}
	
	protected void destroyGameObject()
	{
		super.destroyGameObject();
		
		health = 0;
		posX = 0;
			
		speed = 0f;
			
		counter = 0;
		delayCounter = 0;
			
		movement = null;
			
		state = null;
	}
	
	public void setX(int posX)
	{
		this.posX = posX;
		
		super.setX(posX);
	}
	
	public int getX()
	{
		return (int) posX;
	}
	
	public void processDamage(float damage)
	{
		if (isActive() && ignoreTime == 0 && damage > 0)
		{
			super.processDamage(damage);
			
			if (damageResourceURL != null)
				SoundHandler.play(damageResourceURL);
			
			damaging = !damaging ? true : damaging;
			
			ignoreTime = damageIgnoreTime;
			ignoreTime2 = damageIgnoreTime2;
		}
	}
	
	public int getItemQuantity(Item item0)
	{
		if (item0 != null)
		{
			Item item;
			
			int quantity = 0;
			
			for (ItemStack itemStack: inventory)
			{
				if (itemStack != null && itemStack.getItem() != null)
				{
					item = itemStack.getItem();
					
					if (item.equals(item0))
						quantity += itemStack.getQuantity();
				}
			}
			
			item = null;
			
			return quantity;
		}
		else
			return 0;
	}
}
