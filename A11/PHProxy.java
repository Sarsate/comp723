package a11ProxyChainFlyweight;

public class PHProxy implements ServerFace
{
	private final int PORT = 9877;
	private final boolean CLIENTSIDE = false;
	NetProxy net = new NetProxy("localhost", PORT, CLIENTSIDE);
	@Override
	public String handle(String message)
	{
		//we don't actually use this
		return null;
	}

	@Override
	public long getStatus()
	{
		//or this
		return 0;
	}

	@Override
	public int mashNum(int param)
	{
		// we do care about this
		net.sendMessage(Integer.toString(param));
		int result = Integer.parseInt(net.getMessage());
		return result;
	}

}
