package ru.platformer.level;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ru.gfe.engine.GameFusionEngine;
import ru.gfe.engine.Level;
import ru.gfe.handler.ResourceHandler;
import ru.platformer.component.DrawPanel;
import ru.platformer.util.ResourceUtil;

public class LevelMainMenu extends Level 
{
	private String backgroundResource = "resources/level/mainMenu/textures/background.png";
	private String buttonNewGameResource = "resources/level/mainMenu/textures/newGameButton.png";
	private String buttonContinueResource = "resources/level/mainMenu/textures/continueButton.png";
	private String buttonExitGameResource = "resources/level/mainMenu/textures/exitGameButton.png";
	
	private URL backgroundResourceURL = ResourceUtil.getURL(backgroundResource);
	private URL buttonNewGameResourceURL = ResourceUtil.getURL(buttonNewGameResource);
	private URL buttonContinueResourceURL = ResourceUtil.getURL(buttonContinueResource);
	private URL buttonExitGameResourceURL = ResourceUtil.getURL(buttonExitGameResource);
	
	private Image background = ResourceHandler.getImage(backgroundResourceURL);
	private Image newGame = ResourceHandler.getImage(buttonNewGameResourceURL);
	private Image continueGame = ResourceHandler.getImage(buttonContinueResourceURL);
	private Image exitGame = ResourceHandler.getImage(buttonExitGameResourceURL);
	
	private ImageIcon newGameImageIcon = ResourceHandler.getImageIcon(newGame);
	private ImageIcon continueGameImageIcon = ResourceHandler.getImageIcon(continueGame);
	private ImageIcon exitGameImageIcon = ResourceHandler.getImageIcon(exitGame);
	
	private JLabel newGameButton;
	private JLabel continueButton;
	private JLabel exitGameButton;
	
	private int mode = -1;
	
	private ActionHandler actionHandler;
	
	private DrawPanel drawPanel;
	
	private class ActionHandler implements MouseListener
	{
		public void mouseClicked(MouseEvent e) {}

		public void mousePressed(MouseEvent e) 
		{
//			actionPerformed();
		}

		public void mouseReleased(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) 
		{	
			Object source = e.getSource();
			
			if (source == newGameButton)
				mode = 0;
			else if (source == continueButton)
				mode = 1;
			else if (source == exitGameButton)
				mode = 2;
			
			source = null;
			
			selectButton();
		}

		public void mouseExited(MouseEvent e) {}
	}
	
	public void init()
	{
		levelContainer.setLayout(new GridLayout());
		
		actionHandler = new ActionHandler();
		
		drawPanel = new DrawPanel();
		
		newGameButton = new JLabel();
		newGameButton.setIcon(newGameImageIcon);
		
		continueButton = new JLabel();
		continueButton.setIcon(continueGameImageIcon);
		
		exitGameButton = new JLabel();
		exitGameButton.setIcon(exitGameImageIcon);
		
		newGameButton.addMouseListener(actionHandler);
		continueButton.addMouseListener(actionHandler);
		exitGameButton.addMouseListener(actionHandler);
		
		drawPanel.setImage(background);
	
		drawPanel.setLayout(new GridBagLayout());
		drawPanel.add(newGameButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.5, GridBagConstraints.NORTH, 
				GridBagConstraints.RELATIVE, new Insets(630, -1300, 0, 0), 0, 0));
		drawPanel.add(continueButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.5, GridBagConstraints.NORTH, 
				GridBagConstraints.RELATIVE, new Insets(730, -1300, 0, 0), 0, 0));
		drawPanel.add(exitGameButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.5, GridBagConstraints.NORTH, 
				GridBagConstraints.RELATIVE, new Insets(850, -1300, 0, 0), 0, 0));
		
		levelContainer.add(drawPanel);
	}
	
	public void postInit()
	{
		newGameButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		continueButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitGameButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	protected void destroy()
	{
		super.destroy();
		
		mode = 0;
		
		newGameButton.setIcon(null);
		continueButton.setIcon(null);
		exitGameButton.setIcon(null);
		
		newGameButton.removeMouseListener(actionHandler);
		continueButton.removeMouseListener(actionHandler);
		exitGameButton.removeMouseListener(actionHandler);
		
		actionHandler = null;
		
		backgroundResource = null;
		buttonNewGameResource = null;
		buttonContinueResource = null;
		buttonExitGameResource = null;
		
		backgroundResourceURL = null;
		buttonNewGameResourceURL = null;
		buttonContinueResourceURL = null;
		buttonExitGameResourceURL = null;
		
		background = null;
		newGame = null;
		continueGame = null;
		exitGame = null;
		
		newGameImageIcon = null;
		continueGameImageIcon = null;
		exitGameImageIcon = null;
		
		newGameButton = null;
		continueButton = null;
		exitGameButton = null;
	}
	
	private void selectButton()
	{
		resetAllButtons();
		
		switch (mode)
		{
			case 0:
//				newGameButton.setIcon(newGameSelectedImageIcon);
				break;
			case 1:
//				continueButton.setIcon(chooseNightSelectedImageIcon);
				break;
			case 2:
//				exitGameButton.setIcon(settingsSelectedImageIcon);
				break;
		}
		
//		SoundHandler.play(blipResourceURL);
	}
	
	private void resetAllButtons()
	{
		newGameButton.setIcon(newGameImageIcon);
		continueButton.setIcon(continueGameImageIcon);
		exitGameButton.setIcon(exitGameImageIcon);
	}
	
	private void rollUp()
	{
		mode += 5;
		mode %= 3;
		
		selectButton();
	}
	
	private void rollDown()
	{
		mode = ++mode % 3;
		
		selectButton();
	}
	
	public void processKeyEvent(KeyEvent e)
	{
		if (e.getID() == KeyEvent.KEY_PRESSED)
		{	
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_UP:
					rollUp();
					break;
				case KeyEvent.VK_DOWN:
					rollDown();
					break;
				case KeyEvent.VK_ENTER:
//					actionPerformed();
					break;
				case KeyEvent.VK_ESCAPE:
					GameFusionEngine.exit();
			}
		}
	}
}
