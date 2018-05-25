package com.esucri.financa.utils;

import javax.swing.JTextField;

public class FormUtils {
    
    public static void cleanTextFields(JTextField[] fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
}
