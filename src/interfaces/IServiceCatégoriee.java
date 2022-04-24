/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import models.catégorie;
/**
 *
 * @author 21655
 */
public interface IServiceCatégoriee {
     //CRUD
    public void createCatégorie(catégorie  c);
    public List<catégorie> readCatégories();
    public void DeleteCatégorie(int id);
    public void updateCatégorie(catégorie c);
      public List<catégorie> TriNom();
    public List<catégorie> RechercherparNom (String nom);
    public catégorie GetbyID (int id);
 
}
