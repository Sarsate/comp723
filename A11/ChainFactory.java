package a11ProxyChainFlyweight;

public class ChainFactory
{
	private static Chain singleton = null;
	public static Chain getChain() {
		if (singleton == null)
		{
			Chain ph = new PrimeHandler();
			Chain oh = new OddHandler();
			Chain eh = new EvenHandler();

			ph.setNext(oh);
			oh.setNext(eh);
			singleton = ph;
		}
		return singleton;
	}
}
