/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsidereview;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ClientSide {
    
    
        private Socket socket;
        DataInputStream din;
        DataOutputStream dout;
        
        
        
        public ClientSide() throws UnknownHostException, IOException
	{
                socket=new Socket("localhost",1400);//this is the server's port
                din=new DataInputStream(socket.getInputStream());
                dout= new DataOutputStream(socket.getOutputStream());
               
	}
        
        public String go(String ans)

        {
           while(true)
           {
            try {
                //הפעולה שולחת לשרת את מה שקבלה ושולחת לטופס את התשובה
                dout.writeUTF(ans);          
                return din.readUTF();
                
            } catch (IOException ex) {
                Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
            }
            return  " ";
           }
       }
    
}

