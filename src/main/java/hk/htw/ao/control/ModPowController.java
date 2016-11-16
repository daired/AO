package hk.htw.ao.control;

import hk.htw.ao.control.abs.FunctionController;
import hk.htw.ao.function.ModPow;

public class ModPowController extends FunctionController {

	public ModPowController() {
		super();
		this.title = "ModPow";
		this.description = "a^n mod m\n BigInteger Implementierung ";
		this.parameterNames = new String[]{"Basis", "Exponent", "Modulo"};
	}

public void startRun() {
	messageRun += title + "\n\n";
	
	// init function class 
	ModPow function = new ModPow(parameterValues);
	
	long timeStart = System.nanoTime();
	
	//Start function call in new Thread
	try { function.runThread(function.getFunctionTask());
	} catch (InterruptedException e) {	}
	
	long timeEnd = System.nanoTime();	

	if(function.getRes() != null){
		messageRun +=  parameterNames[0] + ": "+ parameterValues[0] + "\n\n";
		messageRun +=  parameterNames[1] + ": "+ parameterValues[1] + "\n\n";
		messageRun +=  parameterNames[2] + ": "+ parameterValues[2] + "\n\n";
		//messageRun +=  parameterNames[3] + ": "+ parameterValues[3] + "\n\n";
		messageRun += "\n = "+ function.getRes() + "\n\n";
	}
	else{
		messageRun += "Stopped thread...";
	}
	messageRun += printTime(timeEnd - timeStart);
	
	}

	public void startTest() {
		messageTest+= title + "\n\n";

		final long warmuploops = 1;
		final long testloops = 2;
		final int bitlength = 1000;
		long timetotal = 0;
				
		//Warmup Phase
		for(int i=0;i<warmuploops;i++){
			parameterValues[0] = RANDOM.generatePositiveRandomByBitLength(bitlength).toString();
			parameterValues[1] = RANDOM.generatePositiveRandomByBitLength(bitlength).toString();
			parameterValues[2] = RANDOM.generatePositiveRandomByBitLength(bitlength).toString();

			// init function class 
			ModPow function = new ModPow(parameterValues);
						
			//Start function call in new Thread
			try { function.runThread(function.getFunctionTask());
			} catch (InterruptedException e) {	}
			

		}
		
		//Test Phase
		for(int i=0;i<testloops;i++){
			parameterValues[0] = RANDOM.generatePositiveRandomByBitLength(bitlength).toString();
			parameterValues[1] = RANDOM.generatePositiveRandomByBitLength(bitlength).toString();
			parameterValues[2] = RANDOM.generatePositiveRandomByBitLength(bitlength).toString();
			// init function class 
			ModPow function = new ModPow(parameterValues);
			
			long timeStart = System.nanoTime();
			
			//Start function call in new Thread
			try { function.runThread(function.getFunctionTask());
			} catch (InterruptedException e) {	}
			
			long timeEnd = System.nanoTime();	
			timetotal += (timeEnd - timeStart);

			messageTest +=  parameterNames[0] + ": "+ parameterValues[0] + "\n\n";
			messageTest +=  parameterNames[1] + ": "+ parameterValues[1] + "\n\n";
			messageTest +=  parameterNames[2] + ": "+ parameterValues[2] + "\n\n";
			//messageTest +=  parameterNames[3] + ": "+ parameterValues[3] + "\n\n";
			messageTest += "\n = "+ function.getRes() + "\n\n";
			messageTest += MESSAGEBREAK;
				
		}
		timetotal = (timetotal / testloops);

		messageTest += title + " in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
				+ printTime(timetotal);
		
	}

	public void drawRun() {
		// TODO Auto-generated method stub
		
	}

	public void drawTest() {
		// TODO Auto-generated method stub
		
	}



}
