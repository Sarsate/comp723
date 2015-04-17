package a12ObserverStrategy;

public class BarStrategy implements Strategy
{

	public void render(int x)
	{
		int numAsterisks = x/10;
		for(int i = 0; i < numAsterisks; i++)
		{
			System.out.print("*");
		}
		System.out.println(x);

	}

}
