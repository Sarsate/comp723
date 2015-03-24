package ballot;

import java.util.HashMap;

public interface Ballot {
	public void tally();
	public void castVote();
	public void addQuestion(String question);
}
