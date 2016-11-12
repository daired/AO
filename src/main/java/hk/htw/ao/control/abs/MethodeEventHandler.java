package hk.htw.ao.control.abs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface MethodeEventHandler extends EventHandler<ActionEvent> {

	
	public void startRun();
	public void startTest();
	
	public void drawRun();
	public void drawTest();
	
	public void consoleOutRun();
	public void consoleOutTest();

}
	
	
	
//	// Handle
//	btnGCDModRecursiv.setOnAction(new EventHandler<ActionEvent>() {
//		public void handle(ActionEvent e) {
//			// outputText.setFill(Color.SEAGREEN);
//			// outputText.setText("Sign in button pressed");
//			if (!tfParameter1.getText().trim().isEmpty() && !tfParameter2.getText().trim().isEmpty()) {
//				BigInteger a = new BigInteger(tfParameter1.getText());
//				BigInteger b = new BigInteger(tfParameter2.getText());
//				long startTime = System.nanoTime();
//				BigInteger res = CALCULATOR.gcdMod2(a, b);
//				long endTime = System.nanoTime();
//
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//				System.out.println(" ");
//				System.out.println("GCD_Mod_recursiv(" + a + ", " + b + ") = " + res);
//				System.out.println(" ");
//				System.out.println(
//						"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
//								+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//			} else {
//				System.out.println("Please insert Parameter 1 and 2");
//			}
//		}
//	});
//
//	btnGCDModIterativ.setOnAction(new EventHandler<ActionEvent>() {
//		public void handle(ActionEvent e) {
//			if (!tfParameter1.getText().trim().isEmpty() && !tfParameter2.getText().trim().isEmpty()) {
//				BigInteger a = new BigInteger(tfParameter1.getText());
//				BigInteger b = new BigInteger(tfParameter2.getText());
//
//				long startTime = System.nanoTime();
//				BigInteger res = CALCULATOR.gcdMod2(a, b);
//				long endTime = System.nanoTime();
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//				System.out.println(" ");
//				System.out.println("GCD_Mod_iterativ(" + a + ", " + b + ") = " + res);
//				System.out.println(" ");
//				System.out.println(
//						"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
//								+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//			} else {
//				System.out.println("Please insert Parameter 1 and 2");
//			}
//		}
//	});
//
//	btnExtendedGCD.setOnAction(new EventHandler<ActionEvent>() {
//		public void handle(ActionEvent e) {
//			if (!tfParameter1.getText().trim().isEmpty() && !tfParameter2.getText().trim().isEmpty()) {
//				BigInteger a = new BigInteger(tfParameter1.getText());
//				BigInteger b = new BigInteger(tfParameter2.getText());
//				long startTime = System.nanoTime();
//				String res = Arrays.toString(CALCULATOR.extendedGCD(a, b));
//				long endTime = System.nanoTime();
//
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//				System.out.println(" ");
//				System.out.println("extendedGCD(" + a + ", " + b + ") = " + res);
//				System.out.println(" ");
//				System.out.println(
//						"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
//								+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//			} else {
//				System.out.println("Please insert Parameter 1 and 2");
//			}
//		}
//	});
//
//	btnFibRec.setOnAction(new EventHandler<ActionEvent>() {
//		public void handle(ActionEvent e) {
//			if (!tfParameter1.getText().trim().isEmpty()) {
//				BigInteger n = new BigInteger(tfParameter1.getText());
//				long startTime = System.nanoTime();
//				BigInteger res = CALCULATOR.fibonacci(n);
//				long endTime = System.nanoTime();
//				long duration = endTime - startTime;
//
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//				System.out.println(" ");
//				System.out.println("fibbonacci(" + n + ") = " + res);
//				System.out.println(" ");
//				System.out.println(
//						"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
//								+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//			} else {
//				System.out.println("Please insert Parameter 1");
//			}
//		}
//	});
//
//	btnFibIterativ.setOnAction(new EventHandler<ActionEvent>() {
//		public void handle(ActionEvent e) {
//			if (!tfParameter1.getText().trim().isEmpty()) {
//				BigInteger n = new BigInteger(tfParameter1.getText());
//				long startTime = System.nanoTime();
//				BigInteger res = CALCULATOR.fibonacci2(n);
//				long endTime = System.nanoTime();
//				long duration = endTime - startTime;
//
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//				System.out.println(" ");
//				System.out.println("fibbonacci2(" + n + ") = " + res);
//				System.out.println(" ");
//				System.out.println(
//						"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
//								+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//			} else {
//				System.out.println("Please insert Parameter 1");
//			}
//		}
//	});
//	
//	btnRabinMiller.setOnAction(new EventHandler<ActionEvent>() {
//		public void handle(ActionEvent e) {
//			if (!tfParameter1.getText().trim().isEmpty()) {
//				BigInteger n = new BigInteger(tfParameter1.getText());
//				long startTime = System.nanoTime();
//				boolean res = CALCULATOR.rabinMiller(n);
//				long endTime = System.nanoTime();
//				long duration = endTime - startTime;
//
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//				System.out.println(" ");
//				System.out.println("rabinMiller(" + n + ") \n = " + res);
//				System.out.println(" ");
//				System.out.println(
//						"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
//								+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//			} else {
//				System.out.println("Please insert Parameter 1");
//			}
//		}
//	});
//
//	btnPotenzModuloTest.setOnAction(new EventHandler<ActionEvent>() {
//		public void handle(ActionEvent e) {
//
//			final long warmuploops = 0;
//			final long testloops = 1;
//			final int bitlength = 1000;
//			long timetotal = 0;
//			
//			//Warmup Phase
//			for(int i=0;i<warmuploops;i++){
//				BigInteger a = RANDOM.generatePositiveRandomByBitLength(bitlength);
//				BigInteger n = RANDOM.generatePositiveRandomByBitLength(bitlength);
//				BigInteger m = RANDOM.generatePositiveRandomByBitLength(bitlength);
//				CALCULATOR.potenzModuloBig(a, n, m);
//			}
//			
//			//Test Phase
//			for(int j=0;j<testloops;j++){
//				BigInteger a = RANDOM.generatePositiveRandomByBitLength(bitlength);
//				BigInteger n = RANDOM.generatePositiveRandomByBitLength(bitlength);
//				BigInteger m = RANDOM.generatePositiveRandomByBitLength(bitlength);
//
//				long timeStart = System.nanoTime();
//				BigInteger res = CALCULATOR.potenzModuloBig(a, n, m);
//				long timeEnd = System.nanoTime();
//				timetotal += (timeEnd - timeStart);
//				System.out.println("Test Iteration " + j + ": a^n mod m \n a (" + (a.bitLength() + 1) + "Bits): " + a + ", \n n (" + (n.bitLength() + 1) + "Bits): " + n + ", \n m (" + (m.bitLength() + 1) + "Bits): " + m + "\n \n= " + res + "\n \n");
//				
//			}
//			timetotal = (timetotal / testloops);
//			
//			System.out.println("Calculated potenzModuloBig(a,n,m) "
//					+ "with bitlength = " + bitlength + "\n\n"
//					+ "in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
//					+ "approximated CPU time:\n" 
//					+ timetotal + " nanoseconds \n"
//					+ timetotal/1000.f + " microseconds \n"
//					+ timetotal/1000000.f + " milliseconds \n"
//					+ timetotal/1000000000.f + " seconds \n");
//		}
//	});
//
//	btnPotenzModulo.setOnAction(new EventHandler<ActionEvent>() {
//		public void handle(ActionEvent e) {
//			if (!tfParameter1.getText().trim().isEmpty() 
//					&& !tfParameter2.getText().trim().isEmpty()
//					&& !tfParameter3.getText().trim().isEmpty()) {
//
//				BigInteger a = new BigInteger(tfParameter1.getText());
//				BigInteger n = new BigInteger(tfParameter2.getText());
//				BigInteger m = new BigInteger(tfParameter3.getText());
//
//				long startTime = System.nanoTime();
//				BigInteger res = CALCULATOR.potenzModuloBig(a, n, m);
//				long endTime = System.nanoTime();
//				long duration = endTime - startTime;
//
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//				System.out.println(" ");
//				System.out.println("a^n mod m \n a (" + (a.bitLength()) + "Bits): " + a + ", \n n (" + (n.bitLength()) + "Bits): " + n + ", \n m (" + (m.bitLength()) + "Bits): " + m + "\n \n (" + (res.bitLength()) + "Bits) = "+ res);
//				System.out.println(" ");
//				System.out.println(
//						"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
//								+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//			} else {
//				System.out.println("Please insert Parameter 1 : Basis");
//				System.out.println("Please insert Parameter 2 : Modulo");
//				System.out.println("Please insert Parameter 3 : Exponent");
//
//			}
//
//		}
//	});
//
//	
//	btnPotenz.setOnAction(new EventHandler<ActionEvent>() {
//		public void handle(ActionEvent e) {
//			if (!tfParameter1.getText().trim().isEmpty() 
//					&& !tfParameter2.getText().trim().isEmpty()) {
//
//				BigInteger a = new BigInteger(tfParameter1.getText());
//				BigInteger n = new BigInteger(tfParameter2.getText());
//
//				long startTime = System.nanoTime();
//				BigInteger res = CALCULATOR.powBig(a, n);
//				long endTime = System.nanoTime();
//				long duration = endTime - startTime;
//
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//				System.out.println(" ");
//				System.out.println("a^n \n a (" + (a.bitLength() + 1) + "Bits): " + a + "\n n (" + (n.bitLength() + 1) + "Bits): " + n + " \n= " + res);
//				System.out.println(" ");
//				System.out.println(
//						"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
//								+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//			} else {
//				System.out.println("Please insert Parameter 1 : Basis");
//				System.out.println("Please insert Parameter 2 : Exponent");
//
//			}
//
//		}
//	});
//	
//	
//	btnAckermann.setOnAction(new EventHandler<ActionEvent>() {
//		public void handle(ActionEvent e) {
//			if (!tfParameter1.getText().trim().isEmpty() && !tfParameter2.getText().trim().isEmpty()) {
//				BigInteger m = new BigInteger(tfParameter1.getText());
//				BigInteger n = new BigInteger(tfParameter2.getText());
//				long startTime = System.nanoTime();
//				BigInteger res = CALCULATOR.ackermannFunc(m, n);
//				long endTime = System.nanoTime();
//
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//				System.out.println(" ");
//				System.out.println("ackermann(" + m + ", " + n + ") = " + res);
//				System.out.println(" ");
//				System.out.println(
//						"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
//								+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
//				System.out.println(" ");
//				System.out.println("_________________________________________________");
//			} else {
//				System.out.println("Please insert Parameter 1 and 2");
//			}
//		}
//	});
//
//	btnPytagorasTree.setOnAction(new EventHandler<ActionEvent>() {
//		public void handle(ActionEvent e) {
//
//			cdt.drawPytagorasTree(40, 20);
//
//		}
//
//	});
//	

