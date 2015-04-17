package a12ObserverStrategy;

public class LocalObserver extends StateObserver
{

	public LocalObserver(Subject s)
	{
		super(s);
	}
	public void update()
	{
		super.update();
		strat.render(this.s.state);
	}
}
