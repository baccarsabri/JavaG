/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

/**
 *
 * @author malek
 */
public class wordDetect {
    public boolean testAng (String word) throws IOException, InterruptedException{
        String tA = word.replace(" ", "%20");
    HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://community-purgomalum.p.rapidapi.com/containsprofanity?text="+tA))
		.header("X-RapidAPI-Host", "community-purgomalum.p.rapidapi.com")
		.header("X-RapidAPI-Key", "316ec6f82cmshc96a5db1353ccb5p1a7f0bjsn6c88b8a6add1")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());
       if(response.body().equals("true")){
           return true;
       }else {return false;}
    }
    
    
    public boolean testWithFile(String word) throws FileNotFoundException{
          boolean flag = false;
      int count = 0;
      
      String[] words = word.split("\\W+");
     
      
      
       
        Scanner sc2 = new Scanner(new FileInputStream("C:\\Users\\malek\\Downloads\\list-of-french-swear-words_text-file\\text.txt"));
       
          
            
              while(sc2.hasNextLine()) {
                 String line = sc2.nextLine(); 
                for(int i =0;i<words.length;i++){   
                  
                    
         
         if(line.indexOf(words[i])!=-1) {
            flag = true;
            count = count+1;
         }
         
         
         }
         
      }
            
        
     
      //Reading the contents of the file
      
     
      if(flag) {
         return true;
      } else {
         return false ;
      }
    }
}
