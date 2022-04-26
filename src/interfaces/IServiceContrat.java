/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import models.catégorie;
import models.contrat;
/**
 *
 * @author 21655
 */
public interface IServiceContrat {
     //CRUD
    public void createContrat(contrat  c);
    public List<contrat> readcontrats();
     public void Deletecontrat(int id);
    public void updatecontrat(contrat c);
     public float Sommetotale();
      public List<contrat> RechercherparStatut(String statut);
        public List<contrat> TriPrix();
}
