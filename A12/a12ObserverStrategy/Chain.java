package a12ObserverStrategy;

import java.math.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class Chain {
	Chain nextLink;
	public Subject s;

	public void setNext(Chain link) {
		nextLink = link;
	}
	
	abstract protected void handleNum(int num);
}

class StateHandler extends Chain {
	
	public StateHandler(Subject s)
	{
		super();
		this.s = s;
	}
	protected void handleNum(int num){
		//System.out.println("Updating subject");
		s.updateState(num);
	}
}