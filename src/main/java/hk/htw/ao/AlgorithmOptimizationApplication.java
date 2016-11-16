package hk.htw.ao;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import hk.htw.ao.control.FunctionController;
import hk.htw.ao.control.math.AckermannController;
import hk.htw.ao.control.math.FibIterativController;
import hk.htw.ao.control.math.FibRekursivController;
import hk.htw.ao.control.math.GCDExtendedController;
import hk.htw.ao.control.math.GCDIterativController;
import hk.htw.ao.control.math.GCDRekursivController;
import hk.htw.ao.control.math.ModPowController;
import hk.htw.ao.control.math.PowController;
import hk.htw.ao.control.sort.InsertionSortController;
import hk.htw.ao.control.sort.MergeSortController;
import hk.htw.ao.control.sort.QuickSortController;
import hk.htw.ao.gui.Console;
import hk.htw.ao.gui.ParameterPaneItem;
import hk.htw.ao.util.CanvasDrawingTool;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlgorithmOptimizationApplication extends Application implements ChangeListener<String> {

	private final String VERSION =  "0.8";
	private final String STAGETITLE = "Algorithm Optimization App " + VERSION;
	
	private List<FunctionController> controls = new ArrayList<FunctionController>();
	private List<ParameterPaneItem> ppis = new ArrayList<ParameterPaneItem>();

	private FunctionController currentController;
	private CanvasDrawingTool cdt;
	
	private Text titlePaneTitle;
	private TextArea descriptionArea;
	private Button btnRun;
	private CheckBox checkboxTest;
	private ParameterPaneItem ppi00 = new ParameterPaneItem();
	private ParameterPaneItem ppi01 = new ParameterPaneItem();
	private ParameterPaneItem ppi02 = new ParameterPaneItem();
	private ParameterPaneItem ppi03 = new ParameterPaneItem();

	public static void main(String[] args) throws Exception  {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage){
		
		//INIT CONTROLLER
		controls.add(new InsertionSortController());	
		controls.add(new MergeSortController());	
		controls.add(new QuickSortController());	
		controls.add(new ModPowController());
		controls.add(new PowController());
		controls.add(new GCDExtendedController());
		controls.add(new GCDIterativController());
		controls.add(new GCDRekursivController());
		controls.add(new AckermannController());	
		controls.add(new FibRekursivController());	
		controls.add(new FibIterativController());	

		
		
		primaryStage.setTitle(STAGETITLE);
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(10, 10, 10, 10));
		
		/**
		 * MethodePane
		 */
		VBox methodePane = new VBox(10);
		methodePane.setAlignment(Pos.TOP_LEFT);
		methodePane.setPadding(new Insets(10, 10, 10, 0));
		

		ComboBox<String> methodeComboBox = new ComboBox<String>();
		methodeComboBox.setMinWidth(250);
		methodeComboBox.setMaxWidth(250);
		for(FunctionController control : controls)
			methodeComboBox.getItems().add(control.getTitle());
		// Add this as changeListener --> methode changed(...)
		methodeComboBox.valueProperty().addListener(this);
		methodeComboBox.setPromptText("Please choose a methode");
		
		descriptionArea = new TextArea();
		descriptionArea.setMinWidth(250);
		descriptionArea.setMaxWidth(250);
		descriptionArea.setMinHeight(100);
		descriptionArea.setMaxHeight(100);
		descriptionArea.setBackground(Background.EMPTY);
		descriptionArea.setStyle("-fx-control-inner-background: #F4F4F4;");
		descriptionArea.setEditable(false);
		descriptionArea.setFocusTraversable(false);
		descriptionArea.setWrapText(true);
		
		methodePane.getChildren().addAll(methodeComboBox,descriptionArea);
		

		
		/**
		 * InputPane
		 */
		VBox inputPane = new VBox(10);
		inputPane.setAlignment(Pos.TOP_CENTER);
		inputPane.setPadding(new Insets(10, 10, 10, 10));

		ppi00.getValueTextField().textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				currentController.setParamterValues(0,newValue);
			}
		});
		ppi01.getValueTextField().textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				currentController.setParamterValues(1,newValue);
			}
		});
		ppi02.getValueTextField().textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				currentController.setParamterValues(2,newValue);
			}
		});
		ppi03.getValueTextField().textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				currentController.setParamterValues(3,newValue);
			}
		});
		
		ppis.add(ppi00);
		ppis.add(ppi01);
		ppis.add(ppi02);
		ppis.add(ppi03);
		inputPane.getChildren().addAll(ppi00, ppi01, ppi02, ppi03);
	


		
		
		/**
		 * TitlePane
		 */
		HBox titlePane = new HBox();
		titlePane.setAlignment(Pos.TOP_LEFT);
		titlePane.setPadding(new Insets(10, 0, 10, 0));
		
		titlePaneTitle = new Text("Welcome. Please choose a methode.");
		titlePaneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		//titlePaneTitle.setTextAlignment(TextAlignment.LEFT);
		
		titlePane.getChildren().addAll(titlePaneTitle);
	

		
		
		/**
		 * ViewPane
		 */
		HBox viewPane = new HBox();
		viewPane.setAlignment(Pos.BOTTOM_RIGHT);
		// Console
		TextArea ta = new TextArea();
		ta.setMinWidth(600);
		ta.setEditable(false);
		ta.setWrapText(true);
		Console console = new Console(ta);
		PrintStream ps = new PrintStream(console, true);
		System.setOut(ps);
		System.setErr(ps);
	
		//Canvas
		Canvas canvas = new Canvas(300, 300);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		cdt = new CanvasDrawingTool(gc);
		cdt.getGraphicsContext().setFill(Color.BLACK);
		cdt.getGraphicsContext().fillRect(295, 0, 5, 5);
		cdt.getGraphicsContext().setFill(Color.BLACK);
		cdt.getGraphicsContext().fillRect(0, 295, 5, 5);
		cdt.getGraphicsContext().setFill(Color.BLACK);
		cdt.getGraphicsContext().fillRect(0, 0, 5, 5);
		cdt.getGraphicsContext().setFill(Color.BLACK);
		cdt.getGraphicsContext().fillRect(295, 295, 5, 5);

		viewPane.getChildren().addAll(ta,canvas);
		
		
		/**
		 * ButtonPane
		 */
		VBox buttonPane = new VBox(10);
		buttonPane.setAlignment(Pos.TOP_LEFT);
		buttonPane.setPadding(new Insets(10, 0, 10, 10));

		btnRun = new Button("Run");
		btnRun.setMinWidth(100);
		checkboxTest = new CheckBox("Test");
		checkboxTest.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				currentController.setTestMode(newValue);
			}
		});
		
		buttonPane.getChildren().addAll(btnRun, checkboxTest);

		

		
		
		
		/**
		 * add Panes to BorderPanes and set Scene
		 */
		borderPane.setTop(titlePane);
		borderPane.setLeft(methodePane);
		borderPane.setCenter(inputPane);
		borderPane.setRight(buttonPane);
		borderPane.setBottom(viewPane);
		
		// borderPane.setMinSize(880, 500);
		// borderPane.setMaxSize(880, 500);
		
		Scene scene = new Scene(borderPane);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(AlgorithmOptimizationApplication.class.getResource("gui/css/main.css").toExternalForm());
	    primaryStage.setResizable(false);
		primaryStage.show();
	}

	
	
	//Change ComboBox
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		String[] pnames = {};
		for (FunctionController control : controls) {
			if(control.getTitle() == newValue){
				currentController = control;
				pnames = control.getParameterNames();
				break;
			}
		}
		//Set up to 4 ParamterPaneItems visible and set labels
		for (int i = 0; i < pnames.length; i++) {
			ppis.get(i).setVisible(true);
			ppis.get(i).setLabel(pnames[i]);
		}
		for (int i = pnames.length; i < 4; i++) {
			ppis.get(i).setVisible(false);
			ppis.get(i).setLabel("");
		}
		
		titlePaneTitle.setText(currentController.getTitle());
		descriptionArea.setText(currentController.getDescription());
		btnRun.setOnAction(currentController);
		currentController.setParamterValues(0,ppi00.getValue());
		currentController.setParamterValues(1,ppi01.getValue());
		currentController.setParamterValues(2,ppi02.getValue());
		currentController.setParamterValues(3,ppi03.getValue());
		currentController.setTestMode(checkboxTest.isSelected());

		
	}
	
}