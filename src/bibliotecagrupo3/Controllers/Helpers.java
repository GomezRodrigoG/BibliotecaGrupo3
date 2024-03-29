/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Controllers;

import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Helpers {
    /**
     * 
     * @param text El String que queremos verificar
     * @param nullMessage El mensaje a mostrar en caso que el string este vacio
     * @param onlyNumbersMessage Mensaje a mostrar en caso que no sea un numero
     * @return 
     */
    public static int parseStringToInt(String text,String nullMessage, String onlyNumbersMessage){
        int toRet = 0;
        
        if(text.equals("")){
            JOptionPane.showMessageDialog(null,nullMessage);
            return 0;
        }
        
        try{
            toRet = Integer.parseInt(text);
        } catch ( NumberFormatException nf ){
            JOptionPane.showMessageDialog(null, onlyNumbersMessage);
            return 0;
        }
        
        return toRet;
}
}


