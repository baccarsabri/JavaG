/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Review;

/**
 *
 * @author YOGA
 */
public interface IServiceReview {
    
    //CRUD
    public void createReview(Review r);
    public List<Review> readReviews();
    public void  supprimer_review(Review a,int id);
    public void modifier_review(Review a, int note);
    
}
