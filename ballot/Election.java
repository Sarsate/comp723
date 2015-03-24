package ballot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Election implements Ballot {

	protected ArrayList<Ballot> children;
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
		//need to inherit questions.
	}
	@Override
	public void tally() {
		for(Ballot child : children)
		{
			child.tally();
		}
		for(String localQuestion : this.questions.keySet())
			{
				if(questions.containsKey(localQuestion))
				{
					VoteTracker localVotes = this.questions.get(localQuestion);
					VoteTracker totalVotes = questions.get(localQuestion);
					totalVotes.addYes(localVotes.getYes());
					totalVotes.addNo(localVotes.getNo());
				}
			}
		}
		
		
		
	}
	public void displayResults()
	{
		for(String question : questions.keySet())
		{
			System.out.println(question);
			System.out.println(questions.get(question).getYes());
			System.out.println(questions.get(question).getNo());
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
		questions.put(question, new VoteTracker());
		for(Ballot child : children)
			child.addQuestion(question);
	}
}
