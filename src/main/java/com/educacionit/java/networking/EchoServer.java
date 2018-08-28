
package com.educacionit.java.networking;


import java.net.*;
import java.io.*;

import org.apache.log4j.Logger;


public class EchoServer {


    private static final Logger logger = Logger.getLogger (EchoServer.class);


    public static void main(String args[]) throws IOException {

        ServerSocket server=new ServerSocket(1235);

        logger.info ("waiting for request from client");
        Socket client=server.accept();
        logger.info ("request accepted");

        BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
        while (true) {

            String st=br.readLine ();
            logger.info ("Data received : " + st);
            if(st.equals("exit")) {

                logger.info ("connection with client is lost....");
                System.exit(1);
            }
            PrintStream ps=new PrintStream(client.getOutputStream());
            ps.println(st);
        }
    }
}