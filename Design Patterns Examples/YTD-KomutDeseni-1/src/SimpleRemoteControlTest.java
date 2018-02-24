
public class SimpleRemoteControlTest {

	public static void main(String[] args) 
	{
		SimpleRemoteControl simpleRemoteControl=new SimpleRemoteControl();
		Light light = new Light();
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		LightOffCommand lightOffCommand= new LightOffCommand(light);
		
		GarageDoor door = new GarageDoor();
		GarageDoorOpenCommand garageDoorOpenCommand=new GarageDoorOpenCommand(door);
		GarageDoorCloseCommand closeCommand=new GarageDoorCloseCommand(door);
		
		simpleRemoteControl.setCommand(lightOnCommand);
		simpleRemoteControl.buttonWasPushed();
		
		simpleRemoteControl.setCommand(garageDoorOpenCommand);
		simpleRemoteControl.buttonWasPushed();
		
		simpleRemoteControl.setCommand(lightOffCommand);
		simpleRemoteControl.buttonWasPushed();
		
		simpleRemoteControl.setCommand(closeCommand);
		simpleRemoteControl.buttonWasPushed();
	}

}
