package ru.platformer.level;

import java.awt.event.KeyEvent;
import java.net.URL;

import ru.gfe.engine.GameFusionEngine;
import ru.gfe.event.Event;
import ru.gfe.handler.SoundHandler;
import ru.gfe.physicobject.IPhysicObject;
import ru.platformer.entity.Entity;
import ru.platformer.entity.EntityPlayer;
import ru.platformer.entity.EntityRobot;
import ru.platformer.entity.GameBackground;
import ru.platformer.event.GameBackgroundMovingEvent;
import ru.platformer.util.ResourceUtil;

public class LevelTestGame extends PlatformerLevel
{	
	private EntityPlayer player;
	private EntityRobot robot;
	private GameBackground gameBackground;
	
	private String titleResource = "resources/level/testGame/sounds/title.wav";
	
	private URL titleResourceURL = ResourceUtil.getURL(titleResource);
	
	public void init()
	{			
		levelContainer.setLayout(null);
		
		player = new EntityPlayer(this);
		setEntityPlayer(player);
		addGameObject(player, false);
		
		setIGameObjectZOrder(1);
		
		robot = new EntityRobot(this);
		addGameObject(robot, false);
		
		gameBackground = new GameBackground(this, "resources/level/testGame/textures/background.png");
		gameBackground.setSpeed(1.5f);
		levelContainer.add(gameBackground.getVisual());
		
		gameBackground.getVisual().setBounds(0, 0, gameBackground.getVisual().getIcon().getIconWidth(), gameBackground.getVisual().getIcon().getIconHeight());
		
		player.getVisual().setBounds(0, 0, 100, 100);
		player.setX(750);
		player.setY(715);
		
		robot.getVisual().setBounds(0, 0, 100, 110);
		robot.setX(0);
		robot.setY(705);
	}
	
	public void postInit()
	{
		super.postInit();
		
		SoundHandler.playAndLoop(titleResourceURL, 0.45);
	}
	
	public void update()
	{	
		gameBackground.update();
		
		super.update();
	}
	
	public void processKeyEvent(KeyEvent e)
	{
		if (e.getID() == KeyEvent.KEY_PRESSED)
		{
			switch (e.getKeyCode()) 
			{
				case KeyEvent.VK_ESCAPE:
					GameFusionEngine.exit();
					break;
				case KeyEvent.VK_R:
					GameFusionEngine.changeLevel(GameFusionEngine.getLevelName());
					break;
			}
		}
		
		player.processKeyEvent(e);
		gameBackground.processKeyEvent(e);
	}
	
	public void processEvent(Event e)
	{
		if (e instanceof GameBackgroundMovingEvent)
		{
			GameBackgroundMovingEvent event = (GameBackgroundMovingEvent) e;
			
			for (IPhysicObject iPhysicObject: iPhysicObjects)
			{
				if (iPhysicObject instanceof Entity)
					((Entity) iPhysicObject).processGameBackgroundMovingEvent(event);
			}
		}
	}
}
