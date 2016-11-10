package hk.htw.ao.util;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class CanvasDrawingTool {

	private GraphicsContext gc;
	public CanvasDrawingTool(GraphicsContext gc){
		this.gc=gc;
	}
	public GraphicsContext getGraphicsContext() {
		return gc;
	}
	public void setGraphicsContext(GraphicsContext gc) {
		this.gc = gc;
	}
	
	
	public void drawPytagorasTree(int angle, int height){
			
		this.gc.setStroke(Color.RED);
		this.gc.setFill(Color.TRANSPARENT);

		//move to A
		this.gc.moveTo(100, 100);
		//line to B
		this.gc.lineTo(100, 80);
		//line to B
		this.gc.lineTo(120, 80);
		//line to B
		this.gc.lineTo(120, 100);
		//line to B
		this.gc.lineTo(120, 100);

		this.gc.stroke();
		
		
		

	}
	
	
}
