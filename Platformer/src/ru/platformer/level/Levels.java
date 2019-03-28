package ru.platformer.level;

import ru.gfe.engine.GameFusionEngine;

public class Levels 
{
	public static final String TEST_GAME = "TestGame";
	
	public static void loadLevels()
	{
		GameFusionEngine.addLevel(TEST_GAME, LevelTestGame.class);
	}
}
