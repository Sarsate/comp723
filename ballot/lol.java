package ballot;

public class lol {
	public static void main(String[] args)
	{
		Election election = new Election();
		Election localElection = new Election();
		election.addBallot(localElection);
		election.addQuestion("Is Obama the anti-christ?");
		election.addQuestion("Has Anyone Really Been Far Even as Decided to Use Even Go Want to do Look More Like?");
		election.addQuestion("Whatever?");
		localElection.addQuestion("Should we fire the dog catcher?");
		election.castVote();
		election.castVote();
		localElection.castVote();
		localElection.castVote();
		election.displayResults();
		localElection.displayResults();
		
		
		
	}

}
