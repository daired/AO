package hk.htw.ao.control;

import java.math.BigInteger;
import java.util.Arrays;

import hk.htw.ao.control.abs.FunctionController;
import hk.htw.ao.function.GCDExtended;

public class GCDExtendedController extends FunctionController {

	public GCDExtendedController() {
		super();
		this.title = "Extended GDC";
		this.description = "Description Text is here for the extended gdc( a,b ) algorithm.";
		this.parameterNames = new String[]{"a", "b"};
	}

public void startRun() {

	
		messageRun += title + "\n\n";
	
		GCDExtended function = new GCDExtended(parameterValues);
		
		long timeStart = System.nanoTime();
		
		//Start function call in new Thread
		try { function.runThread(function.getCalculator());
		} catch (InterruptedException e) {}
		
		long timeEnd = System.nanoTime();	

		messageRun +=  parameterNames[0] + ": "+ parameterValues[0] + "\n\n";
		messageRun +=  parameterNames[1] + ": "+ parameterValues[1] + "\n\n";
		//messageRun +=  parameterNames[2] + ": "+ parameterValues[2] + "\n\n";
		//messageRun +=  parameterNames[3] + ": "+ parameterValues[3] + "\n\n";
		messageRun += "\n = "+ Arrays.toString(function.getRes()) + "\n\n";
		messageRun += printTime(timeEnd - timeStart);
		
	}

	public void startTest() {
		messageRun += title + "\n\n";

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
//			messageTest += "a (" + (a.bitLength() + 1) + "Bits): "+ a + "\n";
//			messageTest += "b (" + (b.bitLength() + 1) + "Bits): "+ b + "\n";
//			messageTest += "\n = "+ Arrays.toString(res) + "\n\n";
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
