package com.esucri.financa.utils;

public class StringUtils {
    
    public static Boolean stringListIsValid(String[] stringList) {
        for (String str : stringList) {
            if (str.isEmpty()) {                
                return false;
            }
        }        
        return true;
    }
}
