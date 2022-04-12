/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Projet;

/**
 *
 * @author malek
 */
public interface IServiceProjet {
    public void createProjet(Projet p);
    public List<Projet> readProjets();
    public List<Projet> readProjetsByCritere(String critere,String param);
    public void updateProjet(int id,String nom,String description,double min_salaire,double max_salaire);
    public void deleteProjet(int id);
    public Projet detailProjet(int id);
    public List<Projet> MesProjets(int id);
    public List<Projet> MesProjetsByStatut(int id,String statut);
}