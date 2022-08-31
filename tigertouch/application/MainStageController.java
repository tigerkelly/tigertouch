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

public class MainStageController implements Initializable, RefreshScene {
	
	private Robot robot = null;
	private List<Button> sceneBtns = null;
	private TtGlobal tt = TtGlobal.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button btnStage1;

    @FXML
    private Button btnStage2;

    @FXML
    private Button btnStage3;
    
    @FXML
    private Button btnQuit;
    
    @FXML
    private Label lblTitle;

    @FXML
    void doStage1(ActionEvent event) {
    	robot.mouseMove(0, 0);
    	tt.loadSceneNav(SceneNav.STAGE1);
		robot.mouseMove(0, 0);
    }

    @FXML
    void doStage3(ActionEvent event) {
    	robot.mouseMove(0, 0);
    	tt.loadSceneNav(SceneNav.STAGE3);
		robot.mouseMove(0, 0);
    }

    @FXML
    void doStage2(ActionEvent event) {
    	robot.mouseMove(0, 0);
    	tt.loadSceneNav(SceneNav.STAGE2);
		robot.mouseMove(0, 0);
    }
    
    @FXML
    void doQuit(ActionEvent event) {
    	System.exit(0);
    }
    
    private void btnStage1Clicked() {
		doStage1(null);
	}
    
    private void btnStage2Clicked() {
		doStage2(null);
	}
    
    private void btnStage3Clicked() {
		doStage3(null);
	}
    
    private void btnQuitClicked() {
		doQuit(null);
	}
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	mainPane.setCursor(Cursor.NONE);
		robot = new Robot();
		robot.mouseMove(0, 0);
		
		sceneBtns = new ArrayList<Button>();
		
		sceneBtns.add(btnStage1);
		sceneBtns.add(btnStage2);
		sceneBtns.add(btnStage3);
		sceneBtns.add(btnQuit);
		
		assert mainPane != null : "fx:id=\"aPane\" was not injected: check your FXML file 'MainScrn.fxml'.";
        assert btnStage1 != null : "fx:id=\"btnStage1\" was not injected: check your FXML file 'MainScrn.fxml'.";
        assert btnStage2 != null : "fx:id=\"btnStage2\" was not injected: check your FXML file 'MainScrn.fxml'.";
        assert btnStage3 != null : "fx:id=\"btnStage3\" was not injected: check your FXML file 'MainScrn.fxml'.";
	}

	@Override
	public void refreshScene() {
		System.out.println("Refreshing MainStage");
	}

	@Override
	public void leaveScene() {
		System.out.println("Leaving MainStage");
	}

	@Override
	public void clickIt(String text, WidgetType widgetType) {
		if (widgetType == WidgetType.BUTTON) {
			for (Button b : sceneBtns) {
//				ag.logIt("1 Button: '" + b.getText() + "'");
				if (b.getText().equals(text)) {
					switch(text) {
					case "Stage 1":
						btnStage1Clicked();
						break;
					case "Stage 2":
						btnStage2Clicked();
						break;
					case "Stage 3":
						btnStage3Clicked();
						break;
					case "Quit":
						btnQuitClicked();
						break;
					}
					break;
				}
			}
		}
	}
}

