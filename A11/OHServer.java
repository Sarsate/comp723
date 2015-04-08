package a11ProxyChainFlyweight;

public class OHServer
{
	private final int PORT = 9876;
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
		OddServer srv = new OddServer();
		OHServer demo = new OHServer();
		demo.start(srv);
	}
}

class OddServer implements ServerFace
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
		return (int)(Math.random() * param);
	}
	
}
