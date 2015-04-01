package ballot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class BasicBallot implements Ballot {

	ArrayList<Ballot> children;
	HashMap<String, Boolean> questions;
	Scanner scanner;
	String level = "local";
	public BasicBallot(String level)
	{
		children = new ArrayList<Ballot>();
		questions = new HashMap<String, Boolean>();
		scanner = new Scanner(System.in);
		this.level = level;
	}
	public void addBallot(Ballot ballot)
	{
		children.add(ballot);
		/*for(String q : questions.keySet())
		{
			ballot.addQuestion(q);
		}*/
	}
	/*public HashMap<String, VoteTracker> tally()
	{
		HashMap<String, VoteTracker> results = new HashMap<String, VoteTracker>(questions); 
		for(Ballot child : children)
		{
			HashMap<String, VoteTracker> localResults = child.tally();
			for(String q : localResults.keySet())
			{
				if(results.containsKey(q))
				{
					VoteTracker localVotes = localResults.get(q);
					VoteTracker totalVotes = results.get(q);
					totalVotes.addYes(localVotes.getYes());
					totalVotes.addNo(localVotes.getYes());
				}
			}
		}
		return results;
		
	}*/
	public HashMap<String, Boolean> getResults()
	{
		HashMap<String, Boolean> daResults = new HashMap<String, Boolean>(questions);
		for(Ballot b: children)
		{
			daResults.putAll(b.getResults());
		}
		return daResults;
	}
	@Override
	public void castVote() {
		for(String q: questions.keySet())
		{
			String output = "";
			while(!(output.equals("no") || output.equals("yes")))
			{
				System.out.println("Question:" + q);
				System.out.println("(Answer \"yes\" or \"no\")");
				output = scanner.next();
				output = output.toLowerCase();
			}
			if(output.equals("no"))
				questions.put(q,false);
			else if(output.equals("yes"))
				questions.put(q,true);
			else
				System.out.println("we done goofed");
			
		}
		for(Ballot b: children)
			b.castVote();
	}
	@Override
	public void addQuestion(String question) {
		if(questions.containsKey(question))
			return;
		questions.put(question, false);
		/*for(Ballot child : children)
			child.addQuestion(question);*/
	}
	@Override
	public String getLevel()
	{
		return level;
	}
	public void addVotes(HashMap<String, VoteTracker> results, String level)
	{
		if(level.equals(this.level))
		{
			for(String q: questions.keySet())
			{
				if(!(results.containsKey(q)))
				{
					results.put(q, new VoteTracker());
				}
				if(questions.get(q))
					results.get(q).addYes(1);
				else
					results.get(q).addNo(1);
			}
		}
		for(Ballot b : children)
			b.addVotes(results, level);
	}
}