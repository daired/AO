package hk.htw.ao.gui;


import hk.htw.ao.util.OptimizedRandom;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class ParameterPaneItem extends HBox {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();

	Button btnRandom;
	TextField tfValue, tfBits;
	Text label, labelBits;
	
	public ParameterPaneItem(){
		
		this.visibleProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
			}
	    });
		this.setVisible(false);
		
		this.tfValue = new TextField();
		ParameterPaneItem.setMargin(tfValue, new Insets(0,10,0,10));
		this.tfValue.setMinWidth(200);
		
		this.tfBits = new TextField("8");
		this.tfBits.setMaxWidth(50);
		ParameterPaneItem.setMargin(tfValue, new Insets(0,10,0,10));


		this.label = new Text();

		ParameterPaneItem.setMargin(label, new Insets(0,10,0,10));

		this.labelBits = new Text("Bits");
		ParameterPaneItem.setMargin(labelBits, new Insets(0,10,0,10));

		this.btnRandom = new Button("Random");
		this.btnRandom.setMinWidth(60);
		ParameterPaneItem.setMargin(btnRandom, new Insets(0,10,0,10));
		this.btnRandom.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				tfValue.setText("" + RANDOM.generatePositiveRandomByBitLength(new Integer(tfBits.getText())) + "");
			}
		});

		this.getChildren().addAll(label, tfValue, btnRandom ,tfBits, labelBits);
		this.setAlignment(Pos.CENTER_RIGHT);
	}
	
	public void setLabel(String name){
		label.setText(name);
	}
	
	public TextField getValueTextField(){
		return this.tfValue;
	}
	public String getValue(){
		return tfValue.getText();
	}
	
}
