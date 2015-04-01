package ballot;

public class DoMain {
	public static void main(String[] args)
	{
		BasicBallot national = new BasicBallot("national");
		BasicBallot local = new BasicBallot("local");
		national.addBallot(local);
		national.addQuestion("Will you vote for national candidate George W. Bill Clinton Obama Romney?");
		local.addQuestion("Should we fire the dog catcher?");
		national.castVote();
		BasicBallot national2 = new BasicBallot("national");
		BasicBallot local2 = new BasicBallot("local");
		national2.addBallot(local2);
		national2.addQuestion("Will you vote for national candidate George W. Bill Clinton Obama Romney?");
		local2.addQuestion("Should we fire the dog catcher?");
		national2.castVote();
		Tallier results = new NationalTallier();
		System.out.println("National Results:");
		results.tally(national);
		results.tally(national2);
		results.print();
		results.resetCount();
		Tallier localResults = new LocalTallier();
		results.setNext(localResults);
		System.out.println("Local Results:");
		results.tally(national);
		results.tally(national2);
		results.print();
		//dumbTallier.showMeTheMoney();
	}

}