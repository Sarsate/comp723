package a12ObserverStrategy;

public class ChainFactory
{
	private static Chain singleton = null;
	public static Chain getChain() {
		if (singleton == null)
		{
			Chain ph = new StateHandler(new Subject());
			singleton = ph;
		}
		return singleton;
	}
}
