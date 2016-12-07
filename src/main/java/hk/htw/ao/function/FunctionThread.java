package hk.htw.ao.function;

import java.math.BigInteger;

import javafx.concurrent.Task;

public abstract class FunctionThread{

	protected final static long TIMEOUT_MILLIS = 1000*30; // 30 sec
	protected final static BigInteger TWO = new BigInteger("2");
	protected final static BigInteger ONE = new BigInteger("1");
	protected final static BigInteger ZERO = new BigInteger("0");
	
	protected String[] parameter;
	protected FunctionTask functiontask;
	protected Thread thread;
	
	public FunctionThread(String[] parameter){
		this.parameter = parameter;
	}

	protected abstract class FunctionTask extends Task<Object>{ }

	public FunctionTask getFunctionTask() {
		return this.functiontask;
	}
	
	
	public void runThread(FunctionTask functiontask) throws InterruptedException {
		thread = new Thread(functiontask);
		thread.setDaemon(true);
		thread.start();
		thread.join(TIMEOUT_MILLIS); 
		if(!thread.isAlive()){
			//TODO ... Success
		}
	}
	



	
	


}
