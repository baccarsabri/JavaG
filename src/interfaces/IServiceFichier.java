/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import models.Fichier;

/**
 *
 * @author Oussama Fdhila
 */
public interface IServiceFichier {
    
    public void createFichier(Fichier f);
    public List<Fichier> readFichier();
    public void deleteFichier(int id);
    public void updateFichier(Fichier f);
    public Fichier findFichById(int id)throws SQLException;
    public List<Fichier> RechercheByLink(String lnk);
    
}