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
import java.util.List;
import models.Reclamation;
import services.ServiceReclamation;
import java.util.ArrayList;

import models.Competence;
import models.Msg;
import models.User;
import services.ServiceCompetence;
import services.ServiceMsg;
import services.ServiceTransaction;
import services.ServiceUser;





import javax.mail.MessagingException;
import models.catégorie;
import models.contrat;
import services.ServiceCatégorie;
import services.ServiceContrat;
import utils.EmailSender;

import models.Portfolio;
import services.ServicePortfolio;
import models.Review;
import services.ServiceReview;

import java.io.*;
import utils.wordDetect;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import utils.Mailer;



/**
 *
 * @author malek
 */
public class Lancitounsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        
        
        
        System.out.println("java version : " + System.getProperty("java.version"));
       System.out.println("javafx version : " + System.getProperty("javafx.version"));
        
         // Projet test
        MaConnexion instance = MaConnexion.getInstance();
        Connection cnx = instance.getCnx();
        System.out.println("connextion..."+cnx);
        System.out.println("**********MALEK***********");
        ServiceProjet s =new ServiceProjet();
        System.out.println("kkkkkkkkkkkk : "+s.readProjetsLike("a"));
        
        String testAng;
        
        testAng="shit ok alraday qdjg ";
   String tA = testAng.replace(" ", "%20");
    
      //  Mailer.send("gamesmalek2@gmail.com","Malek*123", "malekabasise@gmail.com", "Avertissement",  "Interdit de publier cette proposition");
        
        String testFile;
        
        testFile="aa aa aa aa pute ";
        
        wordDetect wd = new wordDetect();
        System.out.println("test ang detect : " + wd.testAng(tA));
        System.out.println("test file detect : " + wd.testWithFile(testFile));
        
        
        
         
      
        /*
        Projet p=new Projet(2,"malek","aaaaaaaaaaaaaaaa",10,102,"pending");
        ServiceProjet s =new ServiceProjet();
         s.createProjet(p);
        s.updateProjet(10, "malik", "sdsqjdksghqdsqgd", 20, 400);
       Projet paa= s.detailProjet(5);
        s.deleteProjet(33);
        System.out.println("kkkkkkkkkkkk : "+s.readProjets());
        System.out.println("detail : "+s.detailProjet(33));
        
        //Proposition test
        
        Proposition prop=new Proposition(paa,7,100,6,"testtesttesttestaa ","pending");
        ServiceProposition sprop=new ServiceProposition();
        sprop.createProposition(prop);
        
        
        System.out.println("listBy : "+s.MesProjetsByStatut(2,"pending"));
        
        
        System.out.println("Verif Prop : "+sprop.verifProp(8,16));
        
        
        
        System.out.println("Verif Prop : "+s.readProjetsByCritere("id", "DESC"));
        
        // end Malek
        
        System.out.println("**********OUSSAMA***********");
        
        
        ServiceReclamation Rec=new ServiceReclamation();
        java.util.Date date = new java.util.Date();
java.sql.Date myDate = new java.sql.Date(date.getTime());
    Reclamation r = new Reclamation("heeere", myDate, "pending");   
    Reclamation r2 = new Reclamation(5,6, "cristianooo", myDate, "pending");    

//Rec.createReclamation(r);
//Rec.updateReclamation(r2); 
//Rec.deleteReclamation(21);
 List<Reclamation> reclamations; 
       //tri w recherche
 reclamations=Rec.RechercheByDescription("benzemaa");
 //reclamations=Rec.TriParDescription();
       System.out.println(reclamations.toString()); 

       //FindById
 /*Reclamation rr = new Reclamation ();
 rr= Rec.findRecById(33); 
   System.out.println(rr.toString()); */
 
        //ListByCriteria

    /* reclamations = Rec.readReclamation(); 
      reclamations= Rec.ListByStatus("finished");
     System.out.println(reclamations.toString()); */
     
     
/*ServiceFichier Fich=new ServiceFichier();
         Fichier f=new Fichier(5,"a");   
         Fichier f2=new Fichier(3,5,"suiiiii");    

Fich.createFichier(f);
//Fich.updateFichier(f2);
//Fich.deleteFichier(4);
 List<Fichier> fichiers;
        fichiers = Fich.readFichier(); 
        System.out.println(fichiers.toString());      */
/*

System.out.println("**********CHEHINE***********");

//COMPETENCE 
    ServiceCompetence comp = new ServiceCompetence() ;
    Competence c = new Competence("test");
   //Competence c2 = new Competence( 3, "chehine");

    
comp.createCompetence(c);
//comp.updateCompetence(c2);
//comp.deleteCompetence(3);
 /*List<Competence> competences = new ArrayList();
        competences = comp.readCompetence(); 
        System.out.println(competences.toString());
        */
/*
        List<Competence> competences ;
        //competences = comp.SearchByName("javascript");
        competences = comp.TriParName();
        System.out.println(competences.toString());
        
        
        
        
        
        //MESSAGE
        /* ServiceMsg m = new ServiceMsg() ;
         Msg m1        = new Msg("chehine zouari 3A49");
         
         
         m.createMsg(m1);
//m.updateMsg(m1);
//m.deleteCompetence(3);
 List<Msg> msgs = new ArrayList();
        msgs = m.readMsg(); 
        System.out.println(msgs.toString());
         */


        
         System.out.println("**********SABRI***********");
         // TODO code application logic he
        long millis=System.currentTimeMillis();  
        java.sql.Date now=new java.sql.Date(millis);  
        
    
      
        
        ServiceUser su=new ServiceUser();
        ServiceTransaction t= new ServiceTransaction();
        User user= su.UserDetails(1);
        User u;
       u = new User( "sabri@gmail.com" , "password" , "malek" , "abassisse" , now , "ok" , "ok" , true , "1234", now , false , 100, "tunis", 2015, "sabri");
       su.addUser(u);
        
        User a=su.login("baccar_sabri@hotmail.co", "12345678");
        
        t.transaction(user, "BASIC_PLANS");
       
       boolean test=su.updateUser(2 ,"sabribaccar6@gmail.com", "12345678", "ghofrahn", "sabri", now, "okey", "developper", "la goulette", 2015, "photo2");
       System.out.println(test);
       List<User> l=su.Users();
       System.out.println(l);  
       
       
       System.out.println("**********YASSINE***********");
       ServiceCatégorie cat= new ServiceCatégorie();
         ServiceContrat ca= new ServiceContrat();
         /*
       // AJOUT CATÉGORIE 
         
         catégorie res=new catégorie("yassIIII");

        
         
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
        
         
       // affiche par statut
           List<contrat> contrats = new ArrayList();
           contrats=ca.RechercherparStatut("pending");
           System.out.println(contrats.toString()); 
          

       
      //  prix total de contrat
                float total=0;
                 total=ca.Sommetotale();
                 System.out.println(total);
    
       
       
        /*         
       // TRI PRIX  
                 List<contrat> yassine = new ArrayList();
                 yassine=ca.TriPrix();
                 System.out.println(yassine);
        */
        
       
              
/*
      // Tri par nom 
      
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
       /*
       catégorie catt=new catégorie();
       catt=cat.GetbyID(4473);
        System.out.println(catt);
      
        contrat ct= new contrat();
        ct=ca.GetbyID(4450);
        System.out.println(ct);
              
        */
       
       
       System.out.println("**********SYRINE***********");
       
       
       ServicePortfolio portSer=new ServicePortfolio();
    
       Portfolio p0= new Portfolio("java", "syrineee");
       Portfolio p1= new Portfolio("web","syrine");
       Portfolio p2= new Portfolio("weeeb", "good");
       
       
       
          
    
    //portSer.createPortfolio(p0);
          //portSer.modifier_portfolio(p2,"weeeb");
          portSer.supprimer_portfolio(p2);
          List<Portfolio> portfolios = new ArrayList();
        portfolios = portSer.readPortfolio(); 
        System.out.println(portfolios.toString());
   

        

  // ServiceReview revSer=new ServiceReview();
     //   Review r= new Review(20,"syrine");
      // Review r2= new Review(4, "good");
        
            

    
        
  // revSer.createReview(r2);
   // portSer.modifier_review(r2,4);
    //portSer.supprimer_review(r2,30);
     //List<Review> reviews = new ArrayList();
      //  reviews = revSer.readReviews(); 
       // System.out.println(reviews.toString());
           }
    
}
