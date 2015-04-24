package ballot;

import java.util.ArrayList;
import java.util.HashMap;

public interface Ballot {
	
	public void castVote();
	public void addQuestion(String question);
	public HashMap<String, Boolean> getResults();
	public String getLevel();
	public void addVotes(HashMap<String, VoteTracker> results, String level);
}