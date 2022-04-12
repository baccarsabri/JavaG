/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.time.LocalDate;



/**
 *
 * @author bacca
 */
public class User {
    private int id;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private String description;
    private String profession;
    private boolean verified;
    private String code ;
    private Date created_at;
    private boolean banned;
    private int bids;
    private String address;
    private int code_postal;
    private String  photo;

    public User(int id, String email, String password, String nom, String prenom, Date date_naissance, String description, String profession, boolean verified, String code, Date created_at, boolean banned, int bids, String address, int code_postal, String photo) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.description = description;
        this.profession = profession;
        this.verified = verified;
        this.code = code;
        this.created_at = created_at;
        this.banned = banned;
        this.bids = bids;
        this.address = address;
        this.code_postal = code_postal;
        this.photo = photo;
    }

    public User(int id, String email, String password, String nom, String prenom, Date date_naissance, String description, String profession, String address, int code_postal, String photo) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.description = description;
        this.profession = profession;
        this.address = address;
        this.code_postal = code_postal;
        this.photo = photo;
    }

    public User(String email, String password, String nom, String prenom, Date date_naissance, String description, String profession, boolean verified, String code, Date created_at, boolean banned, int bids, String address, int code_postal, String photo) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.description = description;
        this.profession = profession;
        this.verified = verified;
        this.code = code;
        this.created_at = created_at;
        this.banned = banned;
        this.bids = bids;
        this.address = address;
        this.code_postal = code_postal;
        this.photo = photo;
    }

    public User() {
    }

  
    
    
    

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public String getDescription() {
        return description;
    }

    public String getProfession() {
        return profession;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getCode() {
        return code;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public boolean isBanned() {
        return banned;
    }

    public int getBids() {
        return bids;
    }

    public String getAddress() {
        return address;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public String getPhoto() {
        return photo;
    }

  

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public void setBids(int bids) {
        this.bids = bids;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", description=" + description + ", profession=" + profession + ", verified=" + verified + ", code=" + code + ", created_at=" + created_at + ", banned=" + banned + ", bids=" + bids + ", address=" + address + ", code_postal=" + code_postal + ", photo=" + photo + '}';
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
