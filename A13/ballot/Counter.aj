package ballot;

import java.util.HashMap;

public aspect Counter {
	private int numYes;
	private int numNo;
	private int numBallots;
	
	pointcut printResults() : execution(public void resetCount());
	
	void around(HashMap<String, VoteTracker> map): call(private void printResults(HashMap<String, VoteTracker>)) && args(map) 
	{
		//System.out.println("Aspect Code: counting numYes/NO");
		for(String q: map.keySet())
		{
			numYes += map.get(q).getYes();
			numNo += map.get(q).getNo();
		}
		proceed(map);
		
	}
	void around(): call(protected void process(Ballot))
	{
		numBallots++;
		proceed();
	}
	after() : printResults() {
		System.out.println("Aspect Code: Total Results:");
		System.out.println("Number of Yes Votes: " + numYes);
		System.out.println("Number of No Votes: " + numNo);
		System.out.println("Number of Ballots processed: " + numBallots);
		numYes = 0;
		numNo = 0;
		numBallots = 0;
	}

}
