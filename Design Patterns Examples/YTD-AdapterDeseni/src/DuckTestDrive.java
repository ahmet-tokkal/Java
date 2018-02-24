
public class DuckTestDrive {

	public static void main(String[] args) 
	{
		MallardDuck duck = new MallardDuck();
		WildTurkey turkey = new WildTurkey();
		
		Duck adaptedTurkey = new TurkeyAdapter(turkey);
		
		duck.quack();
		duck.fly();
		
		adaptedTurkey.quack();
		adaptedTurkey.fly();
		

	}

}
