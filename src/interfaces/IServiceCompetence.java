/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Competence;

/**
 *
 * @author admin
 */
public interface IServiceCompetence {
    
    //CRUD
    public void createCompetence(Competence c);
    public List<Competence> readCompetence();
    public void deleteCompetence(int id);
    public void updateCompetence(Competence c);
    
    
}