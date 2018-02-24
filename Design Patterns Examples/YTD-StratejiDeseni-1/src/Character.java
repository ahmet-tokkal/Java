
public abstract class Character 
{
	WeaponBehavior weaponBehavior;
	
	public  Character()
	{
		
	}
	public abstract void fight();
	public void setBehavior(WeaponBehavior wB)
	{
		this.weaponBehavior=wB;
	}
	public void performWeapon()
	{
		weaponBehavior.useWeapon();
	}
}
