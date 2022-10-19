/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author copad
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
        System.out.println("bienvenido a servidor");
        Socket soket=null;
        InputStreamReader inputsreamrader=null;
        OutputStreamWriter outputstreamreader=null;
        BufferedReader bufferedreader=null;
        BufferedWriter bufferedwriter=null;
        
        ServerSocket serversoket=null;
        
        serversoket=new ServerSocket(12345);
        
        while(true){
            try{
                soket=serversoket.accept();
                
            inputsreamrader=new InputStreamReader(soket.getInputStream());
            outputstreamreader=new OutputStreamWriter(soket.getOutputStream());
            
            bufferedreader=new BufferedReader(inputsreamrader);
            bufferedwriter=new BufferedWriter(outputstreamreader);
            
            while(true){
                String msgFromClient=bufferedreader.readLine();
                System.out.println("Client:" +msgFromClient);
                bufferedwriter.newLine();
                bufferedwriter.flush();
                
                if(msgFromClient.equalsIgnoreCase("BYE"))
                    break;
            }
            soket.close();
            serversoket.close();
            inputsreamrader.close();
            outputstreamreader.close();
            bufferedreader.close();
            bufferedwriter.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
