package com.esucri.financa.utils;

import javax.swing.JOptionPane;

public class AlertUtils {
    
    public static void information(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Informação!", JOptionPane.INFORMATION_MESSAGE, null);
    }
    
    public static void warning(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Atenção!", JOptionPane.WARNING_MESSAGE, null);
    }
    
    public static void error(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Ops, aconteceu um problema...", JOptionPane.ERROR_MESSAGE, null);
    }
}
