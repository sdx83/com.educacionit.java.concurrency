
package com.educacionit.java.networking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;


public class MultiThreadServer implements Runnable {


    private static final Logger logger = Logger.getLogger (MultiThreadServer.class);


    Socket csocket;
    MultiThreadServer(Socket csocket) {
        this.csocket = csocket;
    }
    public static void main(String args[]) throws Exception {
        ServerSocket ssock = new ServerSocket(1235);
        logger.info("Listening");

        while (true) {
            Socket sock = ssock.accept();
            logger.debug ("Connected");
            new Thread(new MultiThreadServer(sock)).start();
        }
    }
    public void run() {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(csocket.getInputStream()));
            String st=br.readLine ();
            logger.info ("Data received : " + st);

            PrintStream ps=new PrintStream(csocket.getOutputStream());
            ps.println(st);

            csocket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}