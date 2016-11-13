package hk.htw.ao.function.abs;

import javafx.concurrent.Task;

public abstract class FunctionThread{

	protected final long TIMEOUT_MILLIS = 1000*30; // 30 sec
	
	protected String[] parameter;
	protected Calculation calculation;
	
	public FunctionThread(String[] parameter){
		this.parameter = parameter;
	}

	protected abstract class Calculation extends Task<Object>{ }

	public Calculation getCalculator() {
		return this.calculation;
	}
	
	
	public void runThread(Calculation calculator) throws InterruptedException {
		Thread t = new Thread(calculator);
		t.setDaemon(true);
		t.start();
		t.join(TIMEOUT_MILLIS); 
		if(!t.isAlive()){
			//TODO ... Success
		}

	}
	



	
	


}
