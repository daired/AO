package hk.htw.ao.function.abs;

import javafx.concurrent.Task;

public abstract class AbstractFunction{

	protected final long MINUTE_MILLIS = 1000*60;
	protected String[] parameter;
	protected Calculator calculator;
	
	public AbstractFunction(String[] parameter){
		this.parameter = parameter;
	}

	protected abstract class Calculator extends Task<Object>{ }

	public Calculator getCalculator() {
		return this.calculator;
	}
	
	
	public void runThread(Calculator calculator) throws InterruptedException {
		Thread t = new Thread(calculator);
		t.setDaemon(true);
		t.start();
		t.join(MINUTE_MILLIS); 
		if(!t.isAlive()){
			//TODO ...
		}

	}
	



	
	


}
