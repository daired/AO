package hk.htw.ao.control;

import java.math.BigInteger;
import java.util.Arrays;

import hk.htw.ao.control.abs.MethodeController;

public class GCDRekursivController extends MethodeController {


	public GCDRekursivController() {
		super();
		this.title = "GDC Rekursiv";
		this.description = "Rekursive Implementierung des zur Ermittlung des größten, gemiensamen Teilers von a und b > 0.";
		this.parameterNames = new String[]{"a", "b"};
	}

	public void startRun() {
		messageRun += title + "\n\n";
		
		BigInteger a = new BigInteger(parameterValues[0]);
		BigInteger b = new BigInteger(parameterValues[1]);
		
		long timeStart = System.nanoTime();
		BigInteger res = CALCULATOR.gcdRekursiv(a,b);
		long timeEnd = System.nanoTime();	

		messageRun += "a (" + (a.bitLength() + 1) + " Bits): " 		+ a + "\n";
		messageRun += "b (" + (b.bitLength() + 1) + " Bits): " 		+ b + "\n\n";
		messageRun += "  (" + (res.bitLength() + 1) + " Bits) = " 	+ res + "\n\n";
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
