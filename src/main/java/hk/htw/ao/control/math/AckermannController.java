package hk.htw.ao.control.math;

import java.math.BigInteger;

import hk.htw.ao.control.FunctionController;
import hk.htw.ao.function.math.Ackermann;

public class AckermannController extends FunctionController {


	public AckermannController() {
		super();
		this.title = "Ackermann Funktion";
		this.description = "Rekursiv\n Exponentielles Wachstum";
		this.parameterNames = new String[]{"m", "n"};
	}

	public void startRun() {
		messageRun += title + "\n\n";
		
		//FUNCTION CLASS
		Ackermann function = new Ackermann(parameterValues);
		
		long timeStart = System.nanoTime();
		
		//Start function call in new Thread
		try { function.runThread(function.getFunctionTask());
		} catch (InterruptedException e) {}
		
		long timeEnd = System.nanoTime();	

		if(function.getRes() != null){
			messageRun +=  parameterNames[0] + ": "+ parameterValues[0] + "\n\n";
			messageRun +=  parameterNames[1] + ": "+ parameterValues[1] + "\n\n";
			//messageRun +=  parameterNames[2] + ": "+ parameterValues[2] + "\n\n";
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

		final long warmuploops = 0;
		final long testloops = 1;
		final int bitlength = 1000;
		long timetotal = 0;
				
		//Warmup Phase
		for(int i=0;i<warmuploops;i++){
			BigInteger a = RANDOM.generatePositiveRandomByBitLength(bitlength);
			BigInteger b = RANDOM.generatePositiveRandomByBitLength(bitlength);
			// TODO call function
		}
		
		//Test Phase
		for(int i=0;i<testloops;i++){
			BigInteger a = RANDOM.generatePositiveRandomByBitLength(bitlength);
			BigInteger b = RANDOM.generatePositiveRandomByBitLength(bitlength);

			long timeStart = System.nanoTime();
			// TODO call function
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);
//			messageTest += "Test Iteration " + i + "\n\n";
//			messageTest += "a (" + (a.bitLength() + 1) + " Bits): " 		+ a + "\n";
//			messageTest += "b (" + (b.bitLength() + 1) + " Bits): " 		+ b + "\n\n";
//			messageTest += "  (" + (res.bitLength() + 1) + " Bits) = " 		+ res + "\n\n";
		}
		timetotal = (timetotal / testloops);

		//TODO Remove line when after implement test
		messageTest += "Test not implemented Yet! Remove this line when implemented\n\n";
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
