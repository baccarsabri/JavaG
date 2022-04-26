/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Proposition;


/**
 *
 * @author malek
 */
public interface IServiceProposition {
     public void createProposition(Proposition p);
    public List<Proposition> readPropositions();
    public void updateProposition(int id,int prix,int date_max,String description);
    public void deleteProposition(int id);
    public Proposition detailProposition(int id);
    public List<Proposition> MesPropositions(int id);
    public List<Proposition> MesPropsByStatut(int id,String statut);
    public boolean verifProp(int use_id,int projet_id);
}

