/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsi;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import models.catégorie;
import models.contrat;
import services.ServiceCatégorie;
import services.ServiceContrat;
import utils.EmailSender;
/**
 *
 * @author 21655
 */
public class Lancitounsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessagingException {
        // TODO code application logic here
       
         ServiceCatégorie cat= new ServiceCatégorie();
         ServiceContrat ca= new ServiceContrat();
          
       // AJOUT CATÉGORIE 
         /*
         catégorie res=new catégorie("yassIIII");

        
         java.util.Date date = new java.util.Date();
         java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
         
         contrat aj=new contrat(1,1,5555,sqlDate,"KJJJJJJ");
         contrat up=new contrat(4445,1,1,77,sqlDate,"pending");
   
       //  AJOUT CONTRAT
           ca.createContrat(aj);
       // UPDATE CONTRAT
            ca.updatecontrat(up);
       // DELETE CONTRAAT
          ca.Deletecontrat(4473);

        
        
           catégorie upp=new catégorie(4457,"sam");
        // UPDATE CATÉGORIE

            cat.updateCatégorie(upp);
        // DELETE CATÉGORIE 

             cat.DeleteCatégorie(4462);

      
      //affiche catégorie  
        cat.createCatégorie(res);
        List<catégorie> catégories = new ArrayList();
        catégories = cat.readCatégories(); 
        System.out.println(catégories.toString());
       
        //affiche contrat 
       ca.createContrat(aj);
        List<contrat> contrats = new ArrayList();
        contrats = ca.readcontrats(); 
        System.out.println(contrats.toString()); 
       
       */
          
         
        /*
      //  EMAIL
        EmailSender.sendEmailWithAttachments("samaali.mohamedyassine@esprit.tn", "test CONTRAT ", "message");
        */
        
        /*
       // affiche par statut
           List<contrat> contrats = new ArrayList();
           contrats=ca.RechercherparStatut("a");
           System.out.println(contrats.toString()); 
        */     

       /* 
      //  prix total de contrat
                float total=0;
                 total=ca.Sommetotale();
                 System.out.println(total);
    */
       
       
        /*         
       // TRI PRIX  
                 List<contrat> yassine = new ArrayList();
                 yassine=ca.TriPrix();
                 System.out.println(yassine);
        */
        
       
              

      // Tri par nom 
      /*
        List<catégorie> catégories = new ArrayList();
        catégories=cat.TriNom();
        System.out.println(catégories);
*/
      
      

     // Recherche
       /*  List<catégorie> recherche = new ArrayList();
        recherche=cat.RechercherparNom("a");
        System.out.println(recherche);
     */  
       //getbyid
       
       catégorie catt=new catégorie();
       catt=cat.GetbyID(4473);
        System.out.println(catt);
      
        contrat ct= new contrat();
        ct=ca.GetbyID(4450);
        System.out.println(ct);
              
        
       
    }
    
}

