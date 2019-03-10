package ru.platformer.event;

import ru.gfe.event.Event;
import ru.gfe.physicobject.Movement;
import ru.platformer.entity.GameBackground;

public class GameBackgroundMovingEvent extends Event
{
	private GameBackground gameBackground;
	private float factor;
	private Movement movement;
	
	public GameBackgroundMovingEvent(GameBackground gameBackground, float factor, Movement movement)
	{
		this.gameBackground = gameBackground;
		this.factor = factor;
		this.movement = movement;
	
		data = new Object[]{this.gameBackground, this.factor, this.movement};
	}
	
	public GameBackground geGameBackground()
	{
		return gameBackground;
	}
	
	public float getFactor()
	{
		return factor;
	}
	
	public Movement getMovement()
	{
		return movement;
	}
}
