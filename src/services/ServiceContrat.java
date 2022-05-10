/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import interfaces.IServiceContrat ;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Projet;
import models.User;

import models.contrat;
import utils.MaConnexion;

/**
 *
 * @author 21655
 */
public class ServiceContrat implements IServiceContrat{
    
    
    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    
    public void createContrat(contrat  p) {
        
        //request
        String req = "INSERT INTO `contrat`( `user_client_id`, `user_freelancer_id`, `prix`, `created_at`, `statut`,`projet_id`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, p.getUser_client_id());
            st.setInt(2, p.getUser_freelancer_id());
            st.setFloat(3, p.getPrix());
            st.setDate(4, p.getCreated_at());
            st.setString(5, p.getStatut());
             st.setInt(6, p.getProjet_id());
            
            
         
          ;
            st.executeUpdate();
            System.out.println("Contrat ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }

    public List<contrat> readcontrats() {
        ArrayList<contrat> cr = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM contrat ";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                cr.add(new contrat (rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4), rs.getFloat(5), rs.getDate(6), rs.getString(7)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return cr;
    }

   
    
    
    
    @Override
     public void updatecontrat(contrat c) {
        try {

            if (c.getId() != 0) {
                String sql = "UPDATE contrat  SET statut=?,created_at=? WHERE id=?";

                PreparedStatement st = cnx.prepareStatement(sql);
                   
            
            st.setString(1, c.getStatut());
                        st.setDate(2, c.getCreated_at());

                System.out.println(c.getStatut());
                               System.out.println(c.getId());

                st.setInt(3, c.getId());
                st.executeUpdate();
                System.out.println("updated !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override
     public List<contrat> RechercherparStatut(String statut)  {
        ArrayList<contrat> contrat = new ArrayList();

        String req1 = "SELECT * FROM `contrat` where statut=?";
        try{
        PreparedStatement preparedStatement = cnx.prepareStatement(req1);
        preparedStatement.setString(1, statut);

        ResultSet rs = preparedStatement.executeQuery();
         
            while (rs.next()) {                
                
                contrat.add(new contrat (rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getDate(5), rs.getString(6)));
                
            }

          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return contrat;

    }
    @Override
     public float Sommetotale() {
        float somme = 0;
        String req = "SELECT sum(prix) as somme FROM contrat ";
        try {
            PreparedStatement prepared = cnx.prepareStatement(req);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {
                somme = rs.getFloat("somme");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return somme;

    }
    
    @Override
      public List<contrat> TriPrix() {
        ArrayList<contrat> contrat = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM contrat order by prix ASC ";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                contrat.add(new contrat (rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getDate(5), rs.getString(6)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return contrat;
    }
    
      public contrat GetbyID (int id)  {
contrat cat= new contrat();

        String req1 = "SELECT * FROM `contrat` where id=?";
        try{
        PreparedStatement preparedStatement = cnx.prepareStatement(req1);
        preparedStatement.setInt(1, id);

        ResultSet rs = preparedStatement.executeQuery();
         
            while (rs.next()) {                
                
               cat=new contrat(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getDate(5), rs.getString(6));
                
            }

          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cat;

    }
      
        public List<contrat> contratsfinis() {
        ArrayList<contrat> cr = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM contrat where statut='Finished'";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                cr.add(new contrat (rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getDate(5), rs.getString(6)));
                
            }
            System.out.println(cr);
                    
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return cr;
    }
      public List<contrat> contratsencours() {
        ArrayList<contrat> cr = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM contrat where statut='Pending'";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                cr.add(new contrat (rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getDate(5), rs.getString(6)));
                
            }
            System.out.println(cr);
                    
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return cr;
    }
      public float Sommetotalefini() {
        float somme = 0;
        String req = "SELECT sum(prix) as somme FROM contrat where statut='Finished' ";
        try {
            PreparedStatement prepared = cnx.prepareStatement(req);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {
                somme = rs.getFloat("somme");
            }
            System.out.println(somme);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return somme;

    }
      
      public float Sommetotaleencours() {
        float somme = 0;
        String req = "SELECT sum(prix) as somme FROM contrat where statut='Pending' ";
        try {
            PreparedStatement prepared = cnx.prepareStatement(req);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {
                somme = rs.getFloat("somme");
            }
            System.out.println(somme);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return somme;

    }
      
      
       public List<contrat> pagination(int size, int row) {
        List<contrat> cr = new ArrayList<contrat>();

        try {
            String req = "select * from `contrat` LIMIT ? OFFSET ? ";

            PreparedStatement s = cnx.prepareStatement(req);
            s.setInt(1, size);
            s.setInt(2, row);

            ResultSet rs = s.executeQuery();
            while (rs.next()) {

              cr.add(new contrat (rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getDate(5), rs.getString(6)));
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cr;

    }
          public int getRowCount() {
        int count = 0;
        try {
            String req = "SELECT COUNT(*) FROM `contrat`";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return count;
    }

    @Override
    public void Deletecontrat(int id) {
        try {
            if (id != 0) {
                String sql = "delete from contrat WHERE id=?";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, id);
                st.executeUpdate();
                System.out.println("contrat supprimé !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 public Date afficher_date(){

    java.sql.Date dt = new java.sql.Date(0,0,0);   
        String req="SELECT DATE(created_at) AS date, COUNT(*) AS count FROM contrat GROUP BY date ORDER BY count DESC LIMIT 1";
        
        try {
            PreparedStatement ste = cnx.prepareStatement(req);
            

            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                dt = rs.getDate("date");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dt;
    }
    
        public List<Projet> MesProjets(int id) {
         ArrayList<Projet> mesProjets = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM projet WHERE user_id="+id;
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                mesProjets.add(new Projet(rs.getInt(1),rs.getInt(2), rs.getString("nom"), rs.getString("description"), rs.getDouble(5), rs.getDouble(6), rs.getString("statut")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return mesProjets;
    }

      
      
      
      public List<User> Mesuser() {
         ArrayList<User> Mesuser = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM user ";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                Mesuser.add(new User(rs.getInt(1), rs.getString("email"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("date_naissance"),rs.getString("description"),rs.getString("profession") , rs.getString("address") ,rs.getInt("code_postal"), rs.getString("photo")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return Mesuser;
    }
      
      
      

    
    
    
}
