package ballot;

import java.util.HashMap;

public interface Ballot {
	public HashMap<String, VoteTracker> tally();
	public void castVote();
	public void addQuestion(String question);
}
