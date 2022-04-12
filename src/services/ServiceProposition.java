/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.IServiceProposition;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Proposition;
import utils.MaConnexion;
import utils.Mailer;

/**
 *
 * @author malek
 */
public class ServiceProposition implements IServiceProposition {
    MaConnexion instance = MaConnexion.getInstance();
   Connection cnx = instance.getCnx(); 
   ServiceProjet s =new ServiceProjet();

    @Override
    public void createProposition(Proposition p) {
        
        
     String[] refuse = {"koura", "dabouza", "karahba"}; 
     String txt = p.getDescription().toLowerCase();
     boolean ban = false ;
     for (int i=0;i<refuse.length;i++){
         if(txt.contains(refuse[i])){
             
             ban = true;
         }
     }
     if(ban==false){
       String req = "INSERT INTO proposition(projet_id,user_id,prix, date_max, description, created_at, statut)"+" VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, p.getProjet().getId());
            st.setInt(2, p.getUser_id());
            st.setInt(3, p.getPrix());
            st.setInt(4, p.getDate_max());
            st.setString(5, p.getDescription());
            st.setDate(6, p.getCreated_at());
            st.setString(7, p.getStatut());
            
            st.executeUpdate();
            System.out.println("Proposition ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
     } else {
         System.out.println("Interdit");
         Mailer.send("gamesmalek2@gmail.com","Malek*123", "malekabasise@gmail.com", "Avertissement",  "Interdit de publier cette proposition");
     }
           //request
      
        
        
        
    }

    @Override
    public List<Proposition> readPropositions() {
           ArrayList<Proposition> props = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM proposition";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                props.add(new Proposition(rs.getInt(1),s.detailProjet(rs.getInt(2)), rs.getInt(3),rs.getInt(4),rs.getInt(5), rs.getString("description"), rs.getDate(7), rs.getString("statut")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return props;
    }

    @Override
    public void updateProposition(int id, int prix, int date_max, String description) {
          String req = "UPDATE  proposition SET prix = ?, date_max = ?, description = ? where id = ?  ";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, prix);
            st.setInt(1, date_max);
            st.setString(3,description );
            st.setInt(4, id);
            
            
            st.executeUpdate();
            System.out.println("Proposition modifié avec succes.");
            
        } catch (SQLException ex) {
            
           ex.printStackTrace();
       
    }
    }

    @Override
    public void deleteProposition(int id) {
             String req = "DELETE FROM proposition WHERE id = ?";
           try {
            PreparedStatement st = cnx.prepareStatement(req);
            
            st.setInt(1, id);
            
            
            st.executeUpdate();
            System.out.println("Proposition supprimé avec succes.");
            
        } catch (SQLException ex) {
            
           ex.printStackTrace();
       
    }
    }

    @Override
    public Proposition detailProposition(int id) {
         String req = "SELECT * FROM proposition WHERE id ="+id;
          Proposition pa =  new Proposition();
        try {
            Statement st = cnx.createStatement();
            
            
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
					{
                          
                
              pa =  new Proposition(rs.getInt(1),s.detailProjet(rs.getInt(2)),rs.getInt(3),rs.getInt(4),rs.getInt(5), rs.getString("description"), rs.getDate(7), rs.getString("statut"));
                }
            
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return pa;
    }

    @Override
    public List<Proposition> MesPropositions(int id) {
         ArrayList<Proposition> mesProps = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM proposition WHERE user_id="+id;
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                mesProps.add(new Proposition(rs.getInt(1),s.detailProjet(rs.getInt(2)), rs.getInt(3),rs.getInt(4),rs.getInt(5), rs.getString("description"), rs.getDate(7), rs.getString("statut")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return mesProps;
    }

    @Override
    public List<Proposition> MesPropsByStatut(int id, String statut) {
          ArrayList<Proposition> mesProps = new ArrayList();
        
        try {
            
            String req = "SELECT * FROM projet WHERE user_id = ? AND statut = ?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1,id);
            st.setString(2, statut);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {                
                
                mesProps.add(new Proposition(rs.getInt(1),s.detailProjet(rs.getInt(2)), rs.getInt(3),rs.getInt(4),rs.getInt(5), rs.getString("description"), rs.getDate(7), rs.getString("statut")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return mesProps;
    }

    @Override
    public boolean verifProp(int user_id, int projet_id) {
        
        
            String req = "SELECT * FROM proposition WHERE user_id ="+user_id+" AND projet_id ="+projet_id;
          Proposition pa =  new Proposition();
          boolean res =true ;
        try {
            
            Statement st = cnx.createStatement();
            
            
            ResultSet rs = st.executeQuery(req);
            if(rs.next())
		{
              res= false;
                }
            
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return res;
    }
    
}
