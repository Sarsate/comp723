package ballot;

public class DoMain {
	public static void main(String[] args)
	{
		Election election = new Election();
		Election localElection = new Election();
		election.addBallot(localElection);
		election.addQuestion("Will you vote for national candidate George W. Bill Clinton Obama Romney?");
		localElection.addQuestion("Should we fire the dog catcher?");
		election.castVote();
		election.castVote();
		localElection.castVote();
		localElection.castVote();
		System.out.println("National Results:");
		election.displayResults(election.tally());
		System.out.println("Local Results:");
		localElection.displayResults(localElection.tally());
		
		
		
	}

}
