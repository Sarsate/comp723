package a11ProxyChainFlyweight;

public class PHServer 
{
	private final int PORT = 9877;
	private final boolean SERVERSIDE = true;
	public void start(ServerFace srv)
	{
		NetProxy net = new NetProxy("localhost", PORT, SERVERSIDE);
		String param;
		while(true) {
			param = net.getMessage();
			net.sendMessage(Integer.toString(srv.mashNum(Integer.parseInt(param))));
		}
	}
	
	public static void main(String[] args)
	{
		PrimeServer srv = new PrimeServer();
		PHServer demo = new PHServer();
		demo.start(srv);
	}
}

class PrimeServer implements ServerFace
{

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
		return param + 10;
	}
	
}
