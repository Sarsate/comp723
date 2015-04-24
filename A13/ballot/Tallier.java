package ballot;

import java.util.HashMap;
import java.util.List;

public abstract class Tallier
{
	static final int LOCAL = 1;
	static final int NATIONAL = 0;
	protected HashMap<String, VoteTracker> results;
	private Tallier next;
	public Tallier(){
		results = new HashMap<String, VoteTracker>();
	}
	public void setNext(Tallier t)
	{
		next = t;
	}
	public void tally(Ballot b)
	{
		process(b);
		if(next != null)
			next.tally(b);
		//printResults(results);
	}
	public void resetCount()
	{
		results = new HashMap<String, VoteTracker>();
	}
	private void printResults(HashMap<String, VoteTracker> results)
	{
		for(String q : results.keySet())
		{
			System.out.println(q);
			System.out.println(results.get(q).getYes());
			System.out.println(results.get(q).getNo());
		}
	}
	public void print()
	{
		printResults(results);
		if(next != null)
			next.print();
	}
	abstract protected void process(Ballot b);
}
