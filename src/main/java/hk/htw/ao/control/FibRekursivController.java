package hk.htw.ao.control;

import java.math.BigInteger;
import java.util.Arrays;

import hk.htw.ao.control.abs.MethodeController;

public class FibRekursivController extends MethodeController {


	public FibRekursivController() {
		super();
		this.title = "Fibbonacci Folge - Rekursiv";
		this.description = "rekrusive Implementierung zur berechnung der n-ten Fibbonaccizahl.";
		this.parameterNames = new String[]{"n"};
	}

	public void startRun() {
		messageRun += title + "\n\n";
		
		BigInteger n = new BigInteger(parameterValues[0]);
		
		long timeStart = System.nanoTime();
		BigInteger res = CALCULATOR.fibRekursiv(n);
		long timeEnd = System.nanoTime();	

		messageRun += "n (" + (n.bitLength() + 1) + " Bits): " 		+ n + "\n\n";
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
			BigInteger n = RANDOM.generatePositiveRandomByBitLength(bitlength);
			// TODO call function
		}
		
		//Test Phase
		for(int i=0;i<testloops;i++){
			BigInteger n = RANDOM.generatePositiveRandomByBitLength(bitlength);

			long timeStart = System.nanoTime();
			// TODO call function
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);
//			messageTest += "Test Iteration " + i + "\n\n";
//			messageTest += "n (" + (n.bitLength() + 1) + " Bits): " 		+ n + "\n";
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
