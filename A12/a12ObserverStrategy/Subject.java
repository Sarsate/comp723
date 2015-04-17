package a12ObserverStrategy;

import java.util.ArrayList;

public class Subject
{
	public int state = 0;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	public void updateState(int x)
	{
		state = x;
		notifyObservers();
	}
	public void notifyObservers()
	{
		for(Observer o: observers)
			o.update();
	}
	public void attach(Observer o)
	{
		observers.add(o);
	}
	
}
