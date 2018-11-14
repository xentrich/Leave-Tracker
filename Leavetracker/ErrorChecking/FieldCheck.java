/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrorChecking;

/**
 *
 * @author Shiro
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FieldCheck {
    
     private boolean stringContains(String str){
        boolean flag = false;
        
        String[] tokens = str.split("");
        for (String token : tokens) {
            if (token.equals(";")) {
                flag = true;
                break;
            }
        }
        
        return flag;
    }
    
    public boolean checkFields(ArrayList fieldList){ //NEED TO IMPLEMENT
        boolean flag = false;
        
        for (Object fieldListObject : fieldList) {
            JTextField tempField = (JTextField) fieldListObject;
            
            if (tempField.getText().equals("")||stringContains(tempField.getText())) {
                flag = true;
                JOptionPane.showMessageDialog(null, "Please fill out the form completely.");
                break;
            }
        }
        
        return flag;
    }
    
    public boolean checkAreas(ArrayList areaList){ //NEED TO IMPLEMENT
        boolean flag = false;
        
        for (Object areaListObject : areaList) {
            JTextArea tempField = (JTextArea) areaListObject;
            
            if (tempField.getText().equals("")||stringContains(tempField.getText())) {
                flag = true;
                JOptionPane.showMessageDialog(null, "Please fill out the form completely.");
                break;
            }
        }
        
        return flag;
    }
    
}
