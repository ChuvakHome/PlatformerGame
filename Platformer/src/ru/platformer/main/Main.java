package ru.platformer.main;

import ru.gfe.engine.GameFusionEngine;
import ru.platformer.handler.GameHandler;
import ru.platformer.level.Levels;

public class Main 
{
	public static void main(String[] args) 
	{		
		Levels.loadLevels();
		GameFusionEngine.setEngineHandler(new GameHandler());
		GameFusionEngine.setPrimaryLevel(Levels.TEST_GAME);
		GameFusionEngine.launch();
		GameFusionEngine.getDisplay().setTitle("Platformer");
		GameFusionEngine.getDisplay().setResizable(false);
		GameFusionEngine.getDisplay().switchFullScreen();
	}
}
