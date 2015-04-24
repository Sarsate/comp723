package ballot;

import java.util.HashMap;

public class LocalTallier extends Tallier
{
	@Override
	protected void process(Ballot b)
	{
		b.addVotes(this.results, "local");
	}

}
