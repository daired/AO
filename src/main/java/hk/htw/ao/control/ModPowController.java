package hk.htw.ao.control;

import java.math.BigInteger;
import java.util.Arrays;

import hk.htw.ao.control.abs.MethodeController;

public class ModPowController extends MethodeController {

	public ModPowController() {
		super();
		this.title = "modulares Potenzieren (a^n mod m)";
		this.description = "Iterative BigInteger Implementation modulares Potenzieren (a^n mod m)\n";
		this.parameterNames = new String[]{"a", "n", "m"};
	}

public void startRun() {
		messageRun += title + "\n\n";
	
		BigInteger a = new BigInteger(parameterValues[0]);
		BigInteger n = new BigInteger(parameterValues[1]);
		BigInteger m = new BigInteger(parameterValues[2]);
		
		long timeStart = System.nanoTime();
		BigInteger res = CALCULATOR.potenzModuloBig(a,n,m);
		long timeEnd = System.nanoTime();	

		messageRun += "a (" + (a.bitLength() + 1) + " Bits): " 		+ a + "\n\n";
		messageRun += "n (" + (n.bitLength() + 1) + " Bits): " 		+ n + "\n\n";
		messageRun += "m (" + (m.bitLength() + 1) + " Bits): " 		+ m + "\n\n";
		messageRun += "  (" + (res.bitLength() + 1) + " Bits) = " 	+ res + "\n\n";
		messageRun += printTime(timeEnd - timeStart);
		
	}

	public void startTest() {
		messageRun += title + "\n\n";

		final long warmuploops = 1;
		final long testloops = 2;
		final int bitlength = 1000;
		long timetotal = 0;
				
		//Warmup Phase
		for(int i=0;i<warmuploops;i++){
			BigInteger a = RANDOM.generatePositiveRandomByBitLength(bitlength);
			BigInteger n = RANDOM.generatePositiveRandomByBitLength(bitlength);
			BigInteger m = RANDOM.generatePositiveRandomByBitLength(bitlength);
			BigInteger res = CALCULATOR.potenzModuloBig(a, n, m);

		}
		
		//Test Phase
		for(int i=0;i<testloops;i++){
			BigInteger a = RANDOM.generatePositiveRandomByBitLength(bitlength);
			BigInteger n = RANDOM.generatePositiveRandomByBitLength(bitlength);
			BigInteger m = RANDOM.generatePositiveRandomByBitLength(bitlength);

			long timeStart = System.nanoTime();
			BigInteger res = CALCULATOR.potenzModuloBig(a, n, m);
			long timeEnd = System.nanoTime();
			timetotal += (timeEnd - timeStart);

			messageTest += "Test Iteration " + i + "\n\n";
			messageTest += "a (" + (a.bitLength() + 1) + " Bits): " 		+ a + "\n\n";
			messageTest += "n (" + (n.bitLength() + 1) + " Bits): " 		+ n + "\n\n";
			messageTest += "m (" + (m.bitLength() + 1) + " Bits): " 		+ m + "\n\n";
			messageTest += "  (" + (res.bitLength() + 1) + " Bits) = " 	+ res + "\n\n";
			
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
