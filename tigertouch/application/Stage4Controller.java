package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.robot.Robot;

public class Stage4Controller implements Initializable, RefreshScene {
	
	private Robot robot = null;
	private List<Button> sceneBtns = null;
	private TtGlobal tt = TtGlobal.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane stage4Pane;
    
    @FXML
    private Button btnRetStage1;
    
    @FXML
    private Label lblTitle;

    @FXML
    void doRetStage1(ActionEvent event) {
    	tt.sceneNav.scenePop();
    }
    
    private void btnRetStage1Clicked() {
		doRetStage1(null);
	}

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	stage4Pane.setCursor(Cursor.NONE);
		robot = new Robot();
		robot.mouseMove(0, 0);
		
		sceneBtns = new ArrayList<Button>();
		
		sceneBtns.add(btnRetStage1);

        assert stage4Pane != null : "fx:id=\"stage4Pane\" was not injected: check your FXML file 'Stage4.fxml'.";
        assert btnRetStage1 != null : "fx:id=\"btnRetStage1\" was not injected: check your FXML file 'Stage4.fxml'.";

    }

	@Override
	public void refreshScene() {
		System.out.println("Refreshing Stage 4");
	}

	@Override
	public void leaveScene() {
		System.out.println("Leaving Stage 4");
	}

	@Override
	public void clickIt(String text, WidgetType widgetType) {
		if (widgetType == WidgetType.BUTTON) {
			for (Button b : sceneBtns) {
//				ag.logIt("1 Button: '" + b.getText() + "'");
				if (b.getText().equals(text)) {
					switch(text) {
					case "Return to Stage 1":
						btnRetStage1Clicked();
						break;
					}
					break;
				}
			}
		}
	}

}
