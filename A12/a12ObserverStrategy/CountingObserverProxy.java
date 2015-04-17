package a12ObserverStrategy;

public class CountingObserverProxy implements ServerFace, Observer
{
	private final int PORT = 9878;
	private final boolean CLIENTSIDE = false;
	private Subject s;
	NetProxy net = new NetProxy("localhost", PORT, CLIENTSIDE);
	public CountingObserverProxy(Subject s)
	{
		this.s = s;
		s.attach(this);
	}
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
		net.sendMessage(Integer.toString(param));
		return 0;
	}

	@Override
	public void update()
	{
		this.mashNum(s.state);
	}

}
