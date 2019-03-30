package ru.platformer.event;

import ru.gfe.event.Event;
import ru.gfe.physicobject.Direction;
import ru.platformer.entity.GameBackground;

public class GameBackgroundMovingEvent extends Event
{
	private GameBackground gameBackground;
	private float factor;
	private Direction direction;
	
	public GameBackgroundMovingEvent(GameBackground gameBackground, float factor, Direction direction)
	{
		this.gameBackground = gameBackground;
		this.factor = factor;
		this.direction = direction;
	
		data = new Object[]{this.gameBackground, this.factor, this.direction};
	}
	
	public GameBackground geGameBackground()
	{
		return gameBackground;
	}
	
	public float getFactor()
	{
		return factor;
	}
	
	public Direction getDirection()
	{
		return direction;
	}
}
