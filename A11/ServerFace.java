package a11ProxyChainFlyweight;

interface ServerFace {                  // 5. To support plug-compatibility 
	String handle(String message);       //
	long getStatus();                    //    between the wrapper and the
	int mashNum(int param);        //    target, create an interface 
}
