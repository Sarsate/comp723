package ballot;

public class TallyChain
{
	public static Tallier createChain() {
		Tallier tallier = new LocalTallier();
		Tallier tallier2 = new NationalTallier();
		tallier.setNext(tallier2);
		return tallier;
	}
}
