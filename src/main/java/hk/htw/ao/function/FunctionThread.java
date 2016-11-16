package hk.htw.ao.function;

import javafx.concurrent.Task;

public abstract class FunctionThread{

	protected final long TIMEOUT_MILLIS = 1000*30; // 30 sec
	
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
