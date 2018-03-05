/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasaxparsertodom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author nikkihotrabhavananda
 */
public class XMLLoader {
    // Static Java SAX parser
    public static ParentElement load(File xmlNodeFile) throws Exception {
        ParentElement parentElement = new ParentElement();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(xmlNodeFile);
            document.getDocumentElement().normalize();
            NodeList childElements = document.getElementsByTagName("node");
        } catch (Exception e) {
            throw e;
        }
        return parentElement;
    }
}
