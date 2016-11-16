package hk.htw.ao.control;

import hk.htw.ao.function.FunctionThread;
import hk.htw.ao.util.OptimizedRandom;
import javafx.event.ActionEvent;

public abstract class FunctionController implements FunctionEventHandler {

	protected final static String MESSAGEBREAK = "___________________________________\n\n";
	
	protected final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	
	protected String title;
	protected String description;
	protected FunctionThread currentFunctionThread;

	protected String[] parameterNames;

	protected boolean testMode;
	protected String[] parameterValues;

	protected String messageRun, messageTest;

	public FunctionController() {
		this.parameterValues = new String[4];
		this.testMode = false;
		this.messageRun = MESSAGEBREAK;
		this.messageTest = MESSAGEBREAK;

	}

	public void handle(ActionEvent event) {
		if (!testMode) {
			startRun();
			drawRun();
			consoleOutRun();

		} else {
			startTest();
			drawTest();
			consoleOutTest();
		}

	}

	public static String printTime(long nanoTime) {
		return "\nCPU time:\n\n" + nanoTime + " nanoseconds \n" + nanoTime / 1000.f + " microseconds \n"
				+ nanoTime / 1000000.f + " milliseconds \n" + nanoTime / 1000000000.f + " seconds \n";
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String[] getParameterNames() {
		return parameterNames;
	}
	
	public void consoleOutRun() {
		System.out.println(messageRun);
		messageRun = MESSAGEBREAK;
	}

	public void consoleOutTest() {
		System.out.println(messageTest);
		messageTest = MESSAGEBREAK;
	}

	public void setParamterValues(int index, String parameterValue) {
		this.parameterValues[index] = parameterValue;
	}

	public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}
	
	public FunctionThread getCurrentFunctionThread(){
		return this.currentFunctionThread;
	}
	

}
