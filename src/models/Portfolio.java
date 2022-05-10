

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


/**
 *
 * @author YOGA
 */
public class Portfolio {

    //var
    private int id;
    private String image;
    private String title;
    private int user_id;
    private String img;
    ImageView photo;
   Button review=new Button("review");

    public Button getReview() {
        return review;
    }

    public void setReview(Button review) {
        this.review = review;
    }
    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Portfolio( String title, String image , String img, Button review) {
       
         this.title = title;
         this.image = image;
       
        
        this.img = img;
        this.review=review;
    }

    public Portfolio(int id, String image, String title, int user_id) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.user_id = user_id;
    }

    public Portfolio(String image, String title) {
        this.image = image;
        this.title = title;
        this.review=new Button("review");
    }

    @Override
    public String toString() {
        return "Portfolio{" + "id=" + id + ", image=" + image + ", title=" + title + ", user_id=" + user_id + '}';
    }

    public Portfolio() {
     
    }
    
   public Portfolio(Button review) {
     this.review=review;
    }
    

   
    

    

   
}