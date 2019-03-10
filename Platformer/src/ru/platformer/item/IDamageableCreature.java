package ru.platformer.item;

import ru.gfe.physicobject.IPhysicObject;

public interface IDamageableCreature extends IPhysicObject
{
	public void processDamage(float damage);
}
