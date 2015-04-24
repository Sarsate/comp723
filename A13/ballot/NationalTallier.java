package ballot;

import java.util.HashMap;

public class NationalTallier extends Tallier
{

	@Override
	protected void process(Ballot b)
	{
		b.addVotes(this.results, "national");
	}

}
