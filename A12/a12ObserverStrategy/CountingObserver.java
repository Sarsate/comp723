package a12ObserverStrategy;

public class CountingObserver 
{
	private final int PORT = 9878;
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
		CountingObserverServer srv = new CountingObserverServer();
		CountingObserver demo = new CountingObserver();
		demo.start(srv);
	}
}

class CountingObserverServer implements ServerFace
{
	private int counter = 0;
	private int counter2 = 0;
	private Strategy strat = StrategyFactory.getStrategy();
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
		counter++;
		if(counter2 == 3)
		{
			strat = StrategyFactory.getStrategy();
			counter2 = 0;
		}
		if(counter == 4)
		{
			System.out.println("Received 4nth number update: ");
			strat.render(param);
			counter2++;
			counter = 0;
		}
		return 0;
	}
}
