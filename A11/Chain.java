package a11ProxyChainFlyweight;

import java.math.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class Chain {
	Chain nextLink;

	public void setNext(Chain link) {
		nextLink = link;
	}
	
	abstract protected void handleNum(int num);
}

class PrimeHandler extends Chain {
	ServerFace proxy = new PHProxy();
	protected void handleNum(int num){
		if (isPrime(num)){
			System.out.println("num: " + num + " handled in PrimeHandler");
			int result = proxy.mashNum(num);
			// TODO always send across the network to PP
			// PP returns some function of the number
			// PH reports the result in a pop-up window, saying it was obtained remotely
			//System.out.println(result);
			JOptionPane.showMessageDialog(null, "PrimeProxy returned: " + result + " \nServer queried: true");
		}
		else nextLink.handleNum(num);
	}
	
	private boolean isPrime(int num){
		for(int i = 2; i <((int)Math.sqrt(num)+1); i++)
		{
			if( num % i == 0)
					return false;
		}
		return true;
	}
}

class OddHandler extends Chain {
	OHProxy proxy = new OHProxy();
	protected void handleNum(int num){
		if(num % 2 != 0){
			System.out.println("num: " + num + " handled in OddHandler");
			// TODO "sometimes" send the number across the network to OP
			if(Math.random() < 0.3)
			{
				JOptionPane.showMessageDialog(null, "Sucks to suck. (Message not sent.)");
				return;
			}
			int result = proxy.mashNum(num);
			// OP performs a non-deterministic function
			// OP sends the result back to OH
			// OH reports result in pop-up window with a note saying it was obtained from cache or remotely
			JOptionPane.showMessageDialog(null, "OddProxy returned: " + result + "\nServer queried: " + proxy.queriedServer);
		}
		else nextLink.handleNum(num);
	}
}

class EvenHandler extends Chain {
	protected void handleNum(int num){
		System.out.println("num: " + num + " handled in EvenHandler");
		EHServer srvr = new EHServer();
		int result = srvr.mashNum(num);
		// TODO EH puts the result in a pop-up window, and that it was computed locally
		JOptionPane.showMessageDialog(null, "EvenHandler returned: " + result);
	}
}