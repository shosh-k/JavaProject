/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversidereview;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ThreadServer extends Thread
{
    
    Socket socket;
    DataInputStream din;
    java.io.DataOutputStream dout;
    String id;
    int numOfSeat;
    
    public ThreadServer(Socket socket)
    {
        this.socket=socket;
        try {
            din= new DataInputStream(socket.getInputStream());
            dout=new java.io.DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        start();
    }
    
    @Override
    public void run()
    {
        try {
            
            String s=din.readUTF();
            ReserveReview(s);
            ServerSideReview.c1.Add();
            dout.writeUTF("תודה שפינית מזמנך ");
        } catch (IOException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public synchronized void ReserveReview(String s)
      {
          String [] t=s.split(",");
          ServerSideReview.Visit[Integer.valueOf(t[0])]++;
          ServerSideReview.Product[Integer.valueOf(t[1])]++;
          ServerSideReview.Sheroot[Integer.valueOf(t[2])]++;
          ServerSideReview.Mivchar[Integer.valueOf(t[3])]++;
          ServerSideReview.Moadon+=Integer.valueOf(t[3]);  
      }
    
}












