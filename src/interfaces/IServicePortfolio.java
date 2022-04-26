/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Portfolio;

/**
 *
 * @author YOGA
 */
public interface IServicePortfolio {
    
    //CRUD
    public void createPortfolio(Portfolio p);
    public List<Portfolio> readPortfolio();
    
}
