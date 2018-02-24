
public class CharacterCreate {

	public static void main(String[] args) {
		Character knght=new Knight();
		knght.fight();
		knght.performWeapon();
		
		Character qnn=new Queen();
		qnn.fight();
		qnn.setBehavior(new SwordBehavior());
		qnn.performWeapon();

	}

}
