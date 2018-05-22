package com.esucri.financa.utils;

import javax.swing.JOptionPane;

public class AlertUtils {
    
    public static void warning(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Atenção!", 0, null);
    }
}
