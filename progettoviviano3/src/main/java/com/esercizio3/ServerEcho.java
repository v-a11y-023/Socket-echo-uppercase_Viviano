package com.esercizio3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEcho {
    public static void main(String[] args) {
       int porta = 5000;

       BufferedReader in = null;
       PrintWriter out = null;

        try(ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Il server è in ascolto sulla porta " + porta);

            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket + " connesso");

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            String messaggioRic = in.readLine();
            System.out.println("Messaggio ricevuto dal client: " + messaggioRic);


        } catch (Exception e) {
            System.err.println("Impossibile ascoltare sulla porta " + porta + ": " + e.getMessage());
        }
    }
    
}
