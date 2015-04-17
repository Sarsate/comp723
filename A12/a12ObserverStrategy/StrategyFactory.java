package a12ObserverStrategy;

public class StrategyFactory
{
	static boolean alternate = false;
	public static Strategy getStrategy()
	{
		
		if(!alternate)
		{
			alternate = true;
			return new LogStrategy();
		}
		else
		{
			alternate = false;
			return new BarStrategy();
		}
	}
}
