/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasaxparsertodom;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author nikkihotrabhavananda
 */
public class JavaSaxParserUIController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    private TextArea textArea;
    @FXML
    private void handleClear(ActionEvent event) {
        textArea.setText(""); // empty textArea
    }
    @FXML
    private void handleOpen(ActionEvent event) 
            throws SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        DefaultHandler defaultHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)throws SAXException {
                textArea.appendText("<" + qName + ">");
            }
            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                textArea.appendText("</" + qName + ">");
            }
            @Override
            public void characters(char[] ch, int start, int length) {
                textArea.appendText("" + new String(ch, start, length));
            }
        };
        try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(textArea.getScene().getWindow());
            FileInputStream inputStream = new FileInputStream(file); 
            SAXParser parser = factory.newSAXParser();
            parser.parse(inputStream, defaultHandler);
        } 
        catch (Exception ex) {
            displayAlert("Exception parsing XML file.", ex);
        }
    }
    private void displayAlert(String message, Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Exception!");
        alert.setContentText(message);
        PrintWriter pw = new PrintWriter(new StringWriter());
        ex.printStackTrace(pw);
    }
}
