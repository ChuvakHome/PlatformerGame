package ru.platformer.item;

public class ItemStack 
{
	private int itemStackQuantity;
	
	private Item item;
	
	public ItemStack(Item item, int quantity)
	{
		this.item = item;
		itemStackQuantity = quantity;
	}
	
	public void increaseQuantity(int number)
	{
		if (number > 0)
			itemStackQuantity += number;
	}
	
	public void incrementQuantity()
	{
		++itemStackQuantity;
	}
	
	public void decreaseQuantity(int number)
	{
		if (number > 0)
			itemStackQuantity -= number;
	}
	
	public void decrementQuantity()
	{
		--itemStackQuantity;
	}
	
	public int getQuantity()
	{
		return itemStackQuantity;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}
	
	public Item getItem()
	{
		return item;
	}
}
