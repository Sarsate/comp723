package ballot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Election implements Ballot {

	ArrayList<Ballot> children;
	HashMap<String, VoteTracker> questions;
	Scanner scanner;
	public Election()
	{
		children = new ArrayList<Ballot>();
		questions = new HashMap<String, VoteTracker>();
		scanner = new Scanner(System.in);
	}
	public void addBallot(Ballot ballot)
	{
		children.add(ballot);
		for(String q : questions.keySet())
		{
			ballot.addQuestion(q);
		}
	}
	public HashMap<String, VoteTracker> tally()
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
		
	}
	public void displayResults(HashMap<String, VoteTracker> map)
	{
		for(String question : map.keySet())
		{
			System.out.println(question);
			System.out.println(map.get(question).getYes());
			System.out.println(map.get(question).getNo());
		}
	}
	@Override
	public void castVote() {
		for(String q: questions.keySet())
		{
			String output = "";
			while(!(output.equals("no") || output.equals("yes")))
			{
				System.out.println("Question:" + q);
				System.out.println("(Answer \"yes\" or \"no\"");
				output = scanner.next();
				output = output.toLowerCase();
			}
			if(output.equals("no"))
				questions.get(q).voteNo();
			else if(output.equals("yes"))
				questions.get(q).voteYes();
			else
				System.out.println("we done goofed");
			
		}
	}
	@Override
	public void addQuestion(String question) {
		if(questions.containsKey(question))
			return;
		questions.put(question, new VoteTracker());
		for(Ballot child : children)
			child.addQuestion(question);
	}
}
