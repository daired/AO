package hk.htw.ao.control.abs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface FunctionEventHandler extends EventHandler<ActionEvent> {

	
	public void startRun();
	public void startTest();
	
	public void drawRun();
	public void drawTest();
	
	public void consoleOutRun();
	public void consoleOutTest();

}


