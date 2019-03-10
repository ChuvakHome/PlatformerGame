package ru.platformer.item;

import ru.gfe.sequence.Sequence;

public abstract class Item 
{	
	public static final int SEQUENCE_ARRAY_SIZE = 127;
	
	protected String itemName;
	private Sequence[] sequences;
	protected IInventoryOwner owner;
	
	public Item(String name, IInventoryOwner iItemOwner)
	{
		if (name != null && iItemOwner != null)
		{
			itemName = name;
			owner = iItemOwner;
			sequences = new Sequence[SEQUENCE_ARRAY_SIZE];
		}
		else if (name == null)
			throw new NullPointerException("Name of item cannot be null");
		else
			throw new NullPointerException("Item consumer cannot be null");
	}
	
	public abstract int getItemId();
	
	public void addSequence(Sequence sequence, int index, boolean replace)
	{
		checkIndex(index);
		
		if (sequence != null)
		{
			if ((sequences[index] != null && replace) || sequences[index] == null)
				sequences[index] = sequence;
		}
	}
	
	public void addSequence(Sequence sequence, int index)
	{
		addSequence(sequence, index, true);
	}
	
	public boolean onItemInUse() 
	{
		return true;
	}
	
	public void removeSequence(Sequence sequence)
	{
		if (sequence != null)
		{
			int i = 0;
			int j = -1;
			int k = 0;
			
			for (i = 0; i < SEQUENCE_ARRAY_SIZE && j < 0; ++i)
			{
				if (sequences[i].equals(sequence))
					j = i;
			}
			
			if (j >= 0)
			{
				sequences[j].stop();
				
				sequences[j] = null; 
				
				Sequence[] temp = new Sequence[SEQUENCE_ARRAY_SIZE];
				
				for (i = 0; i < SEQUENCE_ARRAY_SIZE; ++i)
				{
					if (i != j)
						temp[k++] = sequences[i];
				}
				
				sequences = temp;
				
				temp = null;
			}
			
			i = 0;
			j = 0;
			k = 0;
		}
	}
	
	private static void checkIndex(int index)
	{
		if (index < 0)
			throw new IndexOutOfBoundsException("Index cannot be negative");
		else if (index < SEQUENCE_ARRAY_SIZE)
			throw new IndexOutOfBoundsException("Index cannot be greater than SequenceArraySize");
	}
	
	public String getName()
	{
		return itemName;
	}
}
