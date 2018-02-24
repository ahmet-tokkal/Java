
public class Knight extends Character {
	public Knight()
	{
		weaponBehavior = new BowAndArrowBehavior();
	}
	@Override
	public void fight() 
	{
		System.out.println("I'm the Knight");

	}

}
