/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

import java.text.*;
import javafx.scene.control.TableView;
import javax.swing.*;

/**
 *
 * @author Oussama Fdhila
 */
public class Divers {
    public static void imprimerJTable(JTable jt, String titre){
        MessageFormat entete = new MessageFormat(titre);
        MessageFormat pied =new MessageFormat("Page{0, number, integer}");
        try{
            jt.print(JTable.PrintMode.FIT_WIDTH, entete, pied);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erreur :\n"+e,"Impression", JOptionPane.ERROR_MESSAGE);
        }
    }
            
    
}
