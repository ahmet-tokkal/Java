import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement{
	private float currentPressure=29.92f;
	private float lastPressure;
	
	
	public ForecastDisplay(Observable observable)
	{
		
		observable.addObserver(this);
	};
	
	@Override
	public void display() {
		System.out.println("Forecast:More of the same");
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData)
		{
			WeatherData wD=(WeatherData) o;
			lastPressure=currentPressure;
			currentPressure=wD.getPressure();
			display();
		}
		
	}

}
