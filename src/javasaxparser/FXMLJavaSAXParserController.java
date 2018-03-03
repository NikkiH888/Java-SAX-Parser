/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasaxparser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

/**
 *
 * @author nikkihotrabhavananda
 */
public class FXMLJavaSAXParserController implements Initializable {
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private void handleClear(ActionEvent event) {
        textArea.setText("");
    }
    
    @FXML
    private void handleOpen(ActionEvent event) throws Exception {
        
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(textArea.getScene().getWindow());
        
        if (file != null) {
            ParseXMLLoader loader = new ParseXMLLoader();
            ParseXMLLoader.load(file);
            
            if (!loader.getTextBody().isEmpty()) {
                /* Generate text in the textArea and clear after finishing */
                textArea.setText("");
                textArea.setText(loader.getTextBody());
                loader.setTextBody();
            }
        }
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
