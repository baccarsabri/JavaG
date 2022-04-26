/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Reclamation;

/**
 *
 * @author Oussama Fdhila
 */
public interface IServiceReclamation {
    
    //CRUD
    public void createReclamation(Reclamation r);
    public List<Reclamation> readReclamation();
    public void deleteReclamation(int id);
    public void updateReclamation(Reclamation r);
    public List<Reclamation> RechercheByDescription(String desc);
    public List<Reclamation> TriParDescription();
}