
package com.educacionit.java.networking;


import java.net.*;

import org.apache.log4j.Logger;


public class ConnectToWebServer {


    private static final Logger logger = Logger.getLogger (ConnectToWebServer.class);


    public static void main(String[] args) {

        try {

            InetAddress addr;
            Socket sock = new Socket ("www.educacionit.com", 80);
            addr = sock.getInetAddress();

            logger.info("Connected to " + addr);
            sock.close();

        } catch (java.io.IOException e) {

            logger.error (e.getMessage ());
        }
    }
}