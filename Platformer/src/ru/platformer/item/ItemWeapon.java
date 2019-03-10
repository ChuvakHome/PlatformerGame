package ru.platformer.item;

import java.awt.Image;
import java.net.URL;

import ru.gfe.handler.SoundHandler;
import ru.gfe.sequence.Sequence;

public class ItemWeapon extends Item implements IItemUpdateable
{	
	public static int ID = 10;
	
	private Item bulletItem;

	private URL strikeSoundResourceURL;
	private URL emptySoundResourceURL;
	private URL reloadSoundResourceURL;
	
	private Sequence sequence;
	
	public ItemWeapon(String name, Item bulletItem, IInventoryOwner iItemOwner, URL strikeSoundURL, URL reloadSoundURL, URL emptySoundURL)
	{
		super(name, iItemOwner);
		
		if (bulletItem == null)
			throw new NullPointerException("Bullet item cannot be null");
		
		this.bulletItem = bulletItem;
		
		setStrikeSoundURL(strikeSoundURL);
		setReloadSoundURL(reloadSoundURL);
		setEmptySoundURL(emptySoundURL);
	}
	
	public boolean onItemInUse()
	{
		if (canShoot())
		{
			if (strikeSoundResourceURL != null && noSoundPlaying())
			{
				SoundHandler.play(strikeSoundResourceURL);
				
				return true;
			}
		}
		
		return false;
	}
	
	public boolean canShoot()
	{
		return bulletItem != null && noSoundPlaying();
	}
	
	private boolean noSoundPlaying()
	{
		return !SoundHandler.isPlaying(strikeSoundResourceURL) && !SoundHandler.isPlaying(reloadSoundResourceURL) && !SoundHandler.isPlaying(emptySoundResourceURL);
	}
	
	public Item getBulletItem()
	{
		return bulletItem;
	}
	
	public void setStrikeSoundURL(URL strikeSoundURL)
	{
		if (strikeSoundURL != null)
			strikeSoundResourceURL = strikeSoundURL;
		else
			throw new NullPointerException("URL of sound file cannot be null");
	}
	
	public void setEmptySoundURL(URL emptySoundURL)
	{
		if (emptySoundURL != null)
			emptySoundResourceURL = emptySoundURL;
		else
			throw new NullPointerException("URL of sound file cannot be null");
	}
	
	public void setReloadSoundURL(URL reloadSoundURL)
	{
		if (reloadSoundURL != null)
			reloadSoundResourceURL = reloadSoundURL;
		else
			throw new NullPointerException("URL of sound file cannot be null");
	}
	
	public void setVisual(Sequence sequence)
	{
		if (sequence != null)
			this.sequence = sequence;
		else
			throw new NullPointerException("Sequence cannot be null");
	}
	
	public void setVisual(Image image)
	{
		if (image != null)
			sequence = new Sequence(image);
		else
			throw new NullPointerException("Image cannot be null");
	}
	
	public Sequence getVisual()
	{
		return sequence;
	}
	
	public void update() {}
	
	public int getItemId()
	{
		return ID;
	}
}
