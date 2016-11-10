package hk.htw.ao;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Arrays;

import hk.htw.ao.gui.Console;
import hk.htw.ao.util.CanvasDrawingTool;
import hk.htw.ao.util.OptimizedCalculator;
import hk.htw.ao.util.OptimizedRandom;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	private final OptimizedCalculator CALCULATOR = OptimizedCalculator.getInstance();
	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();

	private CanvasDrawingTool cdt;

	public static void main(String[] args) throws Exception {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("M10 Algorithms & Optimization - OptimizedCalculator");

		// Create Grig Layout
		BorderPane border = new BorderPane();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		border.setCenter(grid);

		Canvas canvas = new Canvas(300, 300);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		cdt = new CanvasDrawingTool(gc);

		cdt.getGraphicsContext().setFill(Color.BLUE);
		cdt.getGraphicsContext().fillRect(280, 0, 20, 20);
		cdt.getGraphicsContext().setFill(Color.GREEN);
		cdt.getGraphicsContext().fillRect(0, 280, 20, 20);
		cdt.getGraphicsContext().setFill(Color.YELLOW);
		cdt.getGraphicsContext().fillRect(0, 0, 20, 20);
		cdt.getGraphicsContext().setFill(Color.RED);
		cdt.getGraphicsContext().fillRect(280, 280, 20, 20);

		border.setRight(canvas);

		Scene scene = new Scene(border, 900, 500);
		primaryStage.setScene(scene);

		// Input Elements
		Text scenetitle = new Text("Welcome. Please type in parameters and choose a methode.");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		grid.add(scenetitle, 0, 0, 2, 1);

		final TextField tfParameter1 = new TextField();
		grid.add(tfParameter1, 0, 2);

		Button random1 = new Button("Random 1000Bit");
		HBox hbRandom1 = new HBox(10);
		hbRandom1.setAlignment(Pos.BOTTOM_RIGHT);
		hbRandom1.getChildren().add(random1);
		grid.add(hbRandom1,0, 1);
		random1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				tfParameter1.setText("" + RANDOM.generatePositiveRandomByBitLength(1000) + "");
			}
		});

		
		final TextField tfParameter2 = new TextField();
		grid.add(tfParameter2, 1, 2);
		
		Button random2 = new Button("Random 1000Bit");
		HBox hbRandom2 = new HBox(10);
		hbRandom2.setAlignment(Pos.BOTTOM_RIGHT);
		hbRandom2.getChildren().add(random2);
		grid.add(hbRandom2,1, 1);
		random2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				tfParameter2.setText("" + RANDOM.generatePositiveRandomByBitLength(1000) + "");
			}
		});

		final TextField tfParameter3 = new TextField();
		grid.add(tfParameter3, 2, 2);

		Button random3 = new Button("Random 1000Bit");
		HBox hbRandom3 = new HBox(10);
		hbRandom3.setAlignment(Pos.BOTTOM_RIGHT);
		hbRandom3.getChildren().add(random3);
		grid.add(hbRandom3, 2, 1);
		random3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				tfParameter3.setText("" + RANDOM.generatePositiveRandomByBitLength(1000) + "");
			}
		});
		
		// Console
		TextArea ta = new TextArea();
		Console console = new Console(ta);
		PrintStream ps = new PrintStream(console, true);
		System.setOut(ps);
		System.setErr(ps);
		border.setBottom(ta);

		// Button btnExtendedGCD
		Button btnExtendedGCD = new Button("Extended GCD");
		HBox hbBtn3 = new HBox(10);
		hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn3.getChildren().add(btnExtendedGCD);
		grid.add(hbBtn3, 0, 7);

		// Button GCD Mod rekursiv
		Button btnGCDModRecursiv = new Button("GCD Mod rekursiv");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btnGCDModRecursiv);
		grid.add(hbBtn, 1, 7);

		// Button GCD Mod iterativ
		Button btnGCDModIterativ = new Button("GCD Mod iterativ");
		HBox hbBtn2 = new HBox(10);
		hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn2.getChildren().add(btnGCDModIterativ);
		grid.add(hbBtn2, 2, 7);

		// Button fibbonacci rekursiv
		Button btnFibRec = new Button("fibbonacci rekursiv");
		HBox hbBtn4 = new HBox(10);
		hbBtn4.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn4.getChildren().add(btnFibRec);
		grid.add(hbBtn4, 3, 7);

		// Button fibbonacci iterativ
		Button btnFibIterativ = new Button("fibbonacci iterativ");
		HBox hbBtn5 = new HBox(10);
		hbBtn5.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn5.getChildren().add(btnFibIterativ);
		grid.add(hbBtn5, 0, 8);

		// Button Pytagoras Tree
		Button btnPytagorasTree = new Button("Pytagoras Tree");
		HBox hbBtn6 = new HBox(10);
		hbBtn6.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn6.getChildren().add(btnPytagorasTree);
		grid.add(hbBtn6, 1, 8);

		// Button Ackermann
		Button btnAckermann = new Button("Ackermann Funktion");
		HBox hbBtn7 = new HBox(10);
		hbBtn7.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn7.getChildren().add(btnAckermann);
		grid.add(hbBtn7, 2, 8);

		Button btnPotenz = new Button("bigPow(a,n)");
		HBox hbBtn10 = new HBox(10);
		hbBtn10.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn10.getChildren().add(btnPotenz);
		grid.add(hbBtn10, 3, 8);
		
		Button btnPotenzModulo = new Button("PowMod(a,n,m)");
		HBox hbBtn8 = new HBox(10);
		hbBtn8.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn8.getChildren().add(btnPotenzModulo);
		grid.add(hbBtn8, 4, 8);
		
		Button btnPotenzModuloTest = new Button("Test PowMod");
		HBox hbBtn9 = new HBox(10);
		hbBtn9.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn9.getChildren().add(btnPotenzModuloTest);
		grid.add(hbBtn9, 4, 7);

		
		Button btnRabinMiller = new Button("RabinMiller");
		HBox hbBtn11 = new HBox(10);
		hbBtn11.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn11.getChildren().add(btnRabinMiller);
		grid.add(hbBtn11, 4, 9);
		
		
		// Text
		final Text outputText = new Text();
		grid.add(outputText, 1, 6);

		// Handle
		btnGCDModRecursiv.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// outputText.setFill(Color.SEAGREEN);
				// outputText.setText("Sign in button pressed");
				if (!tfParameter1.getText().trim().isEmpty() && !tfParameter2.getText().trim().isEmpty()) {
					BigInteger a = new BigInteger(tfParameter1.getText());
					BigInteger b = new BigInteger(tfParameter2.getText());
					long startTime = System.nanoTime();
					BigInteger res = CALCULATOR.gcdMod2(a, b);
					long endTime = System.nanoTime();

					System.out.println(" ");
					System.out.println("_________________________________________________");
					System.out.println(" ");
					System.out.println("GCD_Mod_recursiv(" + a + ", " + b + ") = " + res);
					System.out.println(" ");
					System.out.println(
							"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
									+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
					System.out.println(" ");
					System.out.println("_________________________________________________");
				} else {
					System.out.println("Please insert Parameter 1 and 2");
				}
			}
		});

		btnGCDModIterativ.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (!tfParameter1.getText().trim().isEmpty() && !tfParameter2.getText().trim().isEmpty()) {
					BigInteger a = new BigInteger(tfParameter1.getText());
					BigInteger b = new BigInteger(tfParameter2.getText());

					long startTime = System.nanoTime();
					BigInteger res = CALCULATOR.gcdMod2(a, b);
					long endTime = System.nanoTime();
					System.out.println(" ");
					System.out.println("_________________________________________________");
					System.out.println(" ");
					System.out.println("GCD_Mod_iterativ(" + a + ", " + b + ") = " + res);
					System.out.println(" ");
					System.out.println(
							"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
									+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
					System.out.println(" ");
					System.out.println("_________________________________________________");
				} else {
					System.out.println("Please insert Parameter 1 and 2");
				}
			}
		});

		btnExtendedGCD.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (!tfParameter1.getText().trim().isEmpty() && !tfParameter2.getText().trim().isEmpty()) {
					BigInteger a = new BigInteger(tfParameter1.getText());
					BigInteger b = new BigInteger(tfParameter2.getText());
					long startTime = System.nanoTime();
					String res = Arrays.toString(CALCULATOR.extendedGCD(a, b));
					long endTime = System.nanoTime();

					System.out.println(" ");
					System.out.println("_________________________________________________");
					System.out.println(" ");
					System.out.println("extendedGCD(" + a + ", " + b + ") = " + res);
					System.out.println(" ");
					System.out.println(
							"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
									+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
					System.out.println(" ");
					System.out.println("_________________________________________________");
				} else {
					System.out.println("Please insert Parameter 1 and 2");
				}
			}
		});

		btnFibRec.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (!tfParameter1.getText().trim().isEmpty()) {
					BigInteger n = new BigInteger(tfParameter1.getText());
					long startTime = System.nanoTime();
					BigInteger res = CALCULATOR.fibonacci(n);
					long endTime = System.nanoTime();
					long duration = endTime - startTime;

					System.out.println(" ");
					System.out.println("_________________________________________________");
					System.out.println(" ");
					System.out.println("fibbonacci(" + n + ") = " + res);
					System.out.println(" ");
					System.out.println(
							"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
									+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
					System.out.println(" ");
					System.out.println("_________________________________________________");
				} else {
					System.out.println("Please insert Parameter 1");
				}
			}
		});

		btnFibIterativ.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (!tfParameter1.getText().trim().isEmpty()) {
					BigInteger n = new BigInteger(tfParameter1.getText());
					long startTime = System.nanoTime();
					BigInteger res = CALCULATOR.fibonacci2(n);
					long endTime = System.nanoTime();
					long duration = endTime - startTime;

					System.out.println(" ");
					System.out.println("_________________________________________________");
					System.out.println(" ");
					System.out.println("fibbonacci2(" + n + ") = " + res);
					System.out.println(" ");
					System.out.println(
							"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
									+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
					System.out.println(" ");
					System.out.println("_________________________________________________");
				} else {
					System.out.println("Please insert Parameter 1");
				}
			}
		});
		
		btnRabinMiller.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (!tfParameter1.getText().trim().isEmpty()) {
					BigInteger n = new BigInteger(tfParameter1.getText());
					long startTime = System.nanoTime();
					boolean res = CALCULATOR.rabinMiller(n);
					long endTime = System.nanoTime();
					long duration = endTime - startTime;

					System.out.println(" ");
					System.out.println("_________________________________________________");
					System.out.println(" ");
					System.out.println("rabinMiller(" + n + ") \n = " + res);
					System.out.println(" ");
					System.out.println(
							"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
									+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
					System.out.println(" ");
					System.out.println("_________________________________________________");
				} else {
					System.out.println("Please insert Parameter 1");
				}
			}
		});

		btnPotenzModuloTest.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				final long warmuploops = 0;
				final long testloops = 1;
				final int bitlength = 1000;
				long timetotal = 0;
				
				//Warmup Phase
				for(int i=0;i<warmuploops;i++){
					BigInteger a = RANDOM.generatePositiveRandomByBitLength(bitlength);
					BigInteger n = RANDOM.generatePositiveRandomByBitLength(bitlength);
					BigInteger m = RANDOM.generatePositiveRandomByBitLength(bitlength);
					CALCULATOR.potenzModuloBig(a, n, m);
				}
				
				//Test Phase
				for(int j=0;j<testloops;j++){
					BigInteger a = RANDOM.generatePositiveRandomByBitLength(bitlength);
					BigInteger n = RANDOM.generatePositiveRandomByBitLength(bitlength);
					BigInteger m = RANDOM.generatePositiveRandomByBitLength(bitlength);

					long timeStart = System.nanoTime();
					BigInteger res = CALCULATOR.potenzModuloBig(a, n, m);
					long timeEnd = System.nanoTime();
					timetotal += (timeEnd - timeStart);
					System.out.println("Test Iteration " + j + ": a^n mod m \n a (" + (a.bitLength() + 1) + "Bits): " + a + ", \n n (" + (n.bitLength() + 1) + "Bits): " + n + ", \n m (" + (m.bitLength() + 1) + "Bits): " + m + "\n \n= " + res + "\n \n");
					
				}
				timetotal = (timetotal / testloops);
				
				System.out.println("Calculated potenzModuloBig(a,n,m) "
						+ "with bitlength = " + bitlength + "\n\n"
						+ "in " + testloops + " test loops and with " + warmuploops + " warmup loops \n\n"
						+ "approximated CPU time:\n" 
						+ timetotal + " nanoseconds \n"
						+ timetotal/1000.f + " microseconds \n"
						+ timetotal/1000000.f + " milliseconds \n"
						+ timetotal/1000000000.f + " seconds \n");
			}
		});

		btnPotenzModulo.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (!tfParameter1.getText().trim().isEmpty() 
						&& !tfParameter2.getText().trim().isEmpty()
						&& !tfParameter3.getText().trim().isEmpty()) {

					BigInteger a = new BigInteger(tfParameter1.getText());
					BigInteger n = new BigInteger(tfParameter2.getText());
					BigInteger m = new BigInteger(tfParameter3.getText());

					long startTime = System.nanoTime();
					BigInteger res = CALCULATOR.potenzModuloBig(a, n, m);
					long endTime = System.nanoTime();
					long duration = endTime - startTime;

					System.out.println(" ");
					System.out.println("_________________________________________________");
					System.out.println(" ");
					System.out.println("a^n mod m \n a (" + (a.bitLength()) + "Bits): " + a + ", \n n (" + (n.bitLength()) + "Bits): " + n + ", \n m (" + (m.bitLength()) + "Bits): " + m + "\n \n (" + (res.bitLength()) + "Bits) = "+ res);
					System.out.println(" ");
					System.out.println(
							"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
									+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
					System.out.println(" ");
					System.out.println("_________________________________________________");
				} else {
					System.out.println("Please insert Parameter 1 : Basis");
					System.out.println("Please insert Parameter 2 : Modulo");
					System.out.println("Please insert Parameter 3 : Exponent");

				}

			}
		});

		
		btnPotenz.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (!tfParameter1.getText().trim().isEmpty() 
						&& !tfParameter2.getText().trim().isEmpty()) {

					BigInteger a = new BigInteger(tfParameter1.getText());
					BigInteger n = new BigInteger(tfParameter2.getText());

					long startTime = System.nanoTime();
					BigInteger res = CALCULATOR.powBig(a, n);
					long endTime = System.nanoTime();
					long duration = endTime - startTime;

					System.out.println(" ");
					System.out.println("_________________________________________________");
					System.out.println(" ");
					System.out.println("a^n \n a (" + (a.bitLength() + 1) + "Bits): " + a + "\n n (" + (n.bitLength() + 1) + "Bits): " + n + " \n= " + res);
					System.out.println(" ");
					System.out.println(
							"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
									+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
					System.out.println(" ");
					System.out.println("_________________________________________________");
				} else {
					System.out.println("Please insert Parameter 1 : Basis");
					System.out.println("Please insert Parameter 2 : Exponent");

				}

			}
		});
		
		
		btnAckermann.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (!tfParameter1.getText().trim().isEmpty() && !tfParameter2.getText().trim().isEmpty()) {
					BigInteger m = new BigInteger(tfParameter1.getText());
					BigInteger n = new BigInteger(tfParameter2.getText());
					long startTime = System.nanoTime();
					BigInteger res = CALCULATOR.ackermannFunc(m, n);
					long endTime = System.nanoTime();

					System.out.println(" ");
					System.out.println("_________________________________________________");
					System.out.println(" ");
					System.out.println("ackermann(" + m + ", " + n + ") = " + res);
					System.out.println(" ");
					System.out.println(
							"CPU time: \t" + (endTime - startTime) + " nanoseconds, " + ((endTime - startTime) / 1000)
									+ " mircoseconds, " + ((endTime - startTime) / 1000000) + " milliseconds");
					System.out.println(" ");
					System.out.println("_________________________________________________");
				} else {
					System.out.println("Please insert Parameter 1 and 2");
				}
			}
		});

		btnPytagorasTree.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				cdt.drawPytagorasTree(40, 20);

			}

		});

		primaryStage.show();
	}

}