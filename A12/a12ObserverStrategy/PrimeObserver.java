package a12ObserverStrategy;

public class PrimeObserver 
{
	private final int PORT = 9877;
	private final boolean SERVERSIDE = true;
	public void start(ServerFace srv)
	{
		NetProxy net = new NetProxy("localhost", PORT, SERVERSIDE);
		String param;
		while(true) {
			param = net.getMessage();
			srv.mashNum(Integer.parseInt(param));
		}
	}
	
	public static void main(String[] args)
	{
		PrimeObserverServer srv = new PrimeObserverServer();
		PrimeObserver demo = new PrimeObserver();
		demo.start(srv);
	}
}

class PrimeObserverServer implements ServerFace
{
	Strategy strat = StrategyFactory.getStrategy();
	int counter = 0;
	@Override
	public String handle(String message)
	{
		return null;
	}

	@Override
	public long getStatus()
	{
		return 0;
	}

	@Override
	public int mashNum(int param)
	{
		if(isPrime(param))
		{
			counter++;
			System.out.println("Received prime number update: ");
			strat.render(param);
		}
		if(counter == 3)
		{
			strat = StrategyFactory.getStrategy();
		}
		return 0;
	}
	private boolean isPrime(int num){
		for(int i = 2; i <((int)Math.sqrt(num)+1); i++)
		{
			if( num % i == 0)
					return false;
		}
		return true;
	}
}
