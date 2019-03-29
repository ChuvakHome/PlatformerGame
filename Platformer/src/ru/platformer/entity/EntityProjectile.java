package ru.platformer.entity;

import java.net.URL;

import javax.swing.JLabel;

import ru.gfe.physicobject.IPhysicObject;
import ru.gfe.physicobject.Movement;
import ru.gfe.physicobject.PhysicObject;
import ru.gfe.sequence.Sequence;
import ru.platformer.item.IDamageableCreature;
import ru.platformer.item.IInventoryOwner;
import ru.platformer.util.ResourceUtil;

public class EntityProjectile extends PhysicObject
{
	private float speed;
	private double posX;
	private float damage;
	
	private Movement movement;
	
	private boolean active;
	
	private IInventoryOwner sender;
	
	public EntityProjectile(int posX, int posY, float speed, float damage, Sequence projectileSequence, Movement movement, IInventoryOwner sender) 
	{
		super(new JLabel());
		
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.damage = damage;
		this.movement = movement;
		this.sender = sender;
		
		active = this.movement != Movement.NONE && this.movement != null;
		
		setPrimarySequence(projectileSequence);
		
		super.setX(posX);
		super.setY(posY);
		
		startOrResumeCurrentSequence();
	}
	
	public EntityProjectile(int posX, int posY, float speed, float damage, URL textureResourceURL, Movement movement, IInventoryOwner sender) 
	{
		this(posX, posY, speed, damage, new Sequence(textureResourceURL), movement, sender);
	}
	
	public EntityProjectile(int posX, int posY, float speed, float damage, String textureResource, Movement movement, IInventoryOwner sender) 
	{
		this(posX, posY, speed, damage, ResourceUtil.getURL(textureResource), movement, sender);
	}
	
	public void update()
	{
		if (active)
		{	
			super.update();
			
			super.setX((int) posX);
			
			switch (movement)
			{
				case LEFT:
					moveLeft();
					break;
				case RIGHT:
					moveRight();
					break;
				default:
					break;
			}
		}
	}
	
	private void moveLeft()
	{
		posX -= speed * 0.05f;
	}
	
	private void moveRight()
	{
		posX += speed * 0.05f;
	}
	
	public void processCollision(IPhysicObject iGameObject)
	{
		if (iGameObject != null && iGameObject instanceof IDamageableCreature && sender != null && !sender.equals(iGameObject))
		{
			((IDamageableCreature) iGameObject).processDamage(damage);
			
			active = false;
			
			level.removeGameObject(id);
		}
	}
	
	public boolean isActive()
	{
		return active;
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
	
	public void setVisible(boolean visibleFlag)
	{
		if (getVisual() != null)
			getVisual().setVisible(visibleFlag);
	}
	
	public boolean isVisible()
	{
		if (getVisual() != null)
			return getVisual().isVisible();
		else
			return false;
	}
}
