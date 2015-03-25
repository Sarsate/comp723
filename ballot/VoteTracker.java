package ballot;

public class VoteTracker {
	int yes = 0;
	int no = 0;
	public void voteYes(){
		yes++;
	}
	public void voteNo(){
		no++;
	}
	public void addYes(int x)
	{
		yes += x;
	}
	public void addNo(int x)
	{
		no += x;
	}
	public int getYes(){
		return yes;
	}
	public int getNo(){
		return no;
	}
	public void reset(){
		no = 0;
		yes = 0;
		
	}
}
