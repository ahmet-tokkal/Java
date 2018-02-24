
public class King extends Character
{
	public King()
	{
		weaponBehavior= new SwordBehavior();
	}
	public void fight()
	{
		System.out.println("I'm the king");
	}
}
