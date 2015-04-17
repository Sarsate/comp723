package a12ObserverStrategy;

public class StateObserver implements Observer
{
	Subject s;
	Strategy strat;
	int counter;
	public StateObserver(Subject s)
	{
		this.s = s;
		s.attach(this);
		strat = StrategyFactory.getStrategy();
	}
	@Override
	public void update()
	{
		counter++;
		if(counter == 3)
		{
			strat = StrategyFactory.getStrategy();
			counter = 0;
		}
	}

}
