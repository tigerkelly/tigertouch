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

public class Stage1Controller implements Initializable, RefreshScene {
	
	private Robot robot = null;
	private List<Button> sceneBtns = null;
	private TtGlobal tt = TtGlobal.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane stage1Pane;
    
    @FXML
    private Button btnRetMain;
    
    @FXML
    private Button btnStage4;
    
    @FXML
    private Label lblTitle;

    @FXML
    void doRetMain(ActionEvent event) {
    	tt.sceneNav.scenePop();
    }
    
    private void btnRetMainClicked() {
		doRetMain(null);
	}
    
    @FXML
    void doStage4(ActionEvent event) {
    	robot.mouseMove(0, 0);
    	tt.loadSceneNav(SceneNav.STAGE4);
		robot.mouseMove(0, 0);
    }
    
    private void btnStage4Clicked() {
		doStage4(null);
	}

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	stage1Pane.setCursor(Cursor.NONE);
		robot = new Robot();
		robot.mouseMove(0, 0);
		
		sceneBtns = new ArrayList<Button>();
		
		sceneBtns.add(btnRetMain);
		sceneBtns.add(btnStage4);

        assert stage1Pane != null : "fx:id=\"stage1Pane\" was not injected: check your FXML file 'Stage1.fxml'.";

    }

	@Override
	public void refreshScene() {
		System.out.println("Refreshing Stage1");
	}

	@Override
	public void leaveScene() {
		System.out.println("Leaving Stage1");
	}

	@Override
	public void clickIt(String text, WidgetType widgetType) {
		if (widgetType == WidgetType.BUTTON) {
			for (Button b : sceneBtns) {
//				ag.logIt("1 Button: '" + b.getText() + "'");
				if (b.getText().equals(text)) {
					switch(text) {
					case "Return to Main Stage":
						btnRetMainClicked();
						break;
					case "Stage 4":
						btnStage4Clicked();
						break;
					}
					break;
				}
			}
		}
	}

}
