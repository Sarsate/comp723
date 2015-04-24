package ballot;

import java.util.HashMap;

public aspect Logger {
	pointcut castVote() : execution(public void castVote());
	pointcut addVotes() : execution(public void addVotes(HashMap<String, VoteTracker>, String));
	pointcut process() : execution(protected void process(Ballot));
	
	before(): castVote() {
		System.out.println("Aspect Code: Casting Vote!");
	}
	
	before(): process() {
		System.out.println("Aspect Code: Counting Vote!");
	}

}
