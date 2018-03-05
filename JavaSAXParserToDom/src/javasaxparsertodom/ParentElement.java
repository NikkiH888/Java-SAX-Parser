/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasaxparsertodom;

import java.util.ArrayList;
/**
 *
 * @author nikkihotrabhavananda
 */
public class ParentElement {
    private final ArrayList<ChildElement> elements;
    public ParentElement() {
        elements = new ArrayList<>();
    }
    public void addChildNode(ChildElement childNode) {
        elements.add(childNode);
    }
    public ArrayList<ChildElement> getChildNodes() {
        return this.elements;
    }
}
