/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lancitounsi;

import java.sql.Connection;
import models.Projet;
import models.Proposition;
import services.ServiceProjet;
import services.ServiceProposition;
import utils.MaConnexion;

/**
 *
 * @author malek
 */
public class Lancitounsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        
        
         // Projet test
        MaConnexion instance = MaConnexion.getInstance();
        Connection cnx = instance.getCnx();
        System.out.println("connextion..."+cnx);
        
        Projet p=new Projet(2,"malek","aaaaaaaaaaaaaaaa",10,102,"pending");
        ServiceProjet s =new ServiceProjet();
         s.createProjet(p);
        s.updateProjet(10, "malik", "sdsqjdksghqdsqgd", 20, 400);
       Projet paa= s.detailProjet(5);
        s.deleteProjet(33);
        System.out.println(s.readProjets());
        System.out.println("detail : "+s.detailProjet(33));
        
        //Proposition test
        
        Proposition prop=new Proposition(paa,7,100,6,"testtesttesttestaaa ","pending");
        ServiceProposition sprop=new ServiceProposition();
        sprop.createProposition(prop);
        
        
        System.out.println("listBy : "+s.MesProjetsByStatut(2,"pending"));
        
        
        System.out.println("Verif Prop : "+sprop.verifProp(8,16));
        
        
        
        System.out.println("Verif Prop : "+s.readProjetsByCritere("id", "DESC"));
        
        // end Malek
    }
    
}
