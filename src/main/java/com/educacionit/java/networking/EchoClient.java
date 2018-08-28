
package com.educacionit.java.networking;


import java.io.IOException;
import java.net.*;
import java.io.*;

import org.apache.log4j.Logger;


public class EchoClient {


    private static final Logger logger = Logger.getLogger (EchoClient.class);


    public static void main(String args[]) throws IOException {


        logger.info ("Sending request to server....");
        Socket client = new Socket("127.0.0.1",1235);
        logger.info ("Successfully connected");

        BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
        PrintStream ps=new PrintStream(client.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));

        while (true) {

            logger.info ("Input the data you want to send to echo server: ");
            String s=br1.readLine();
            ps.println(s);

            if(s.equals("exit")) {

                System.exit(1);
            }

            String st=br.readLine();
            logger.info ("data returned by the server:   ");
            logger.info (st);
        }
    }
}