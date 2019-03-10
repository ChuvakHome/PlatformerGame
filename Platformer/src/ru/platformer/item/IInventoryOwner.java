package ru.platformer.item;

public interface IInventoryOwner extends IDamageableCreature
{
	public int getItemQuantity(Item item);
}
