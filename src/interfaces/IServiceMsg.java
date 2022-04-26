/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Msg;

/**
 *
 * @author admin
 */
public interface IServiceMsg {
    
    //CRUD
    public void createMsg(Msg m);
    public List<Msg> readMsg();
    public void deleteMsg(int id);
    public void updateMsg(Msg m);
    
}