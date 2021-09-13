/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversidereview;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ServerSideReview {

        
    ServerSocket mainsocket;
    Socket socket;
    int port;
   public static Console c1;
    
    public static int moneReview = 0;
    public static int [] Visit = new int[3];
    public static int [] Product = new int[3];
    public static int [] Sheroot = new int[3];
    public static int [] Mivchar = new int[3];
    public static int Moadon = 0;
    public ServerSideReview(Console c)
    {
        c1=c;
        try {
            mainsocket=new ServerSocket(1400);
        } catch (IOException ex) {
            Logger.getLogger(ServerSideReview.class.getName()).log(Level.SEVERE, null, ex);
        }
        go();
    }
    
    
    public void go()
    {           
        while(true)
        {
            try 
            {
                
                socket=mainsocket.accept();
                ThreadServer reservedSeat= new ThreadServer(socket);   
                moneReview++;
                
            } 
            catch (IOException ex) 
            {
              
            }            
         
        }
    }
  
    
}

