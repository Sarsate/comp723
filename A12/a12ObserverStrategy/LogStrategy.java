package a12ObserverStrategy;

public class LogStrategy implements Strategy
{

	@Override
	public void render(int x)
	{
		StringBuffer buf = new StringBuffer();
		int y = 1;
		for(int i = 0; i < x; i += y)
		{
			buf.append(i + ", ");
			if(i >= 10)
				y = 10;
			if(i >= 100)
				y = 100;
		}
		buf.delete(buf.length()-2,buf.length());
		buf.append(": " + x);
		System.out.println(buf.toString());
	}

}
