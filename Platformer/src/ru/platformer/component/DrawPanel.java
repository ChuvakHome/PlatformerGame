package ru.platformer.component;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class DrawPanel extends JPanel 
{	
	private static final long serialVersionUID = 7489679261628255205L;
	
	private Image img;
	private int imageX;
	private int imageY;
	
	public DrawPanel() 
	{
		super();
	}
	
	public DrawPanel(Image img)
	{
		super();
		this.img = img;
	}
	
	public void setImagePosition(int imageX, int imageY)
	{
		this.imageX = imageX;
		this.imageY = imageY;
	}
	
	public int getImageX()
	{
		return imageX;
	}
	
	public int getImageY()
	{
		return imageY;
	}
	
	public void setImage(Image img)
	{
		this.img = img;
	}
	
	public Image getImage()
	{
		return img;
	}

	protected void paintComponent(Graphics g)
	{
		g.drawImage(img, imageX, imageY, null);
		repaint();
	}
}
