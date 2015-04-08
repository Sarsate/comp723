package a11ProxyChainFlyweight;

import java.util.HashMap;

public class OHProxy implements ServerFace
{
	private final int PORT = 9876;
	private final boolean CLIENTSIDE = false;
	public boolean queriedServer = false;
	HashMap<Integer, ServerResult> cache = new HashMap<Integer, ServerResult>();
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
		if(cache.containsKey(param))
		{
			long currenttime = System.currentTimeMillis()/1000;
			long pasttime = cache.get(param).timestamp;
			if(currenttime - pasttime >= 30)
			{
				net.sendMessage(Integer.toString(param));
				queriedServer = true;
				int result = Integer.parseInt(net.getMessage());
				ServerResult tuple = new ServerResult(result, System.currentTimeMillis() /1000);
				cache.put(param, tuple);
				return result;
			}
			else
			{
				queriedServer = false;
				return cache.get(param).result;
			}
		}
		else
		{
			net.sendMessage(Integer.toString(param));
			queriedServer = true;
			int result = Integer.parseInt(net.getMessage());
			ServerResult tuple = new ServerResult(result, System.currentTimeMillis() /1000);
			cache.put(param, tuple);
			return result;
		}
	}
}
