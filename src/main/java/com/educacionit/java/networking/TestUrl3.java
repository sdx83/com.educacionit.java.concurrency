
package com.educacionit.java.networking;


import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;


public class TestUrl3 {


    private static final Logger logger = Logger.getLogger (TestUrl3.class);


    public static void main (String a[]) {

        try {

            String protocol = "http";
            String host = "www.educacionit.com";
            int port = 80;
            String path = "/paquetes-java";
            URL url = new URL(protocol, host, port, path);

            logger.info ("Protocol: " + url.getProtocol ());
            logger.info ("Host: " + url.getHost ());
            logger.info ("Port: " + url.getPort ());
            logger.info ("Athority of the URL: " + url.getAuthority ());
            logger.info ("Query: " + url.getQuery ());
            logger.info ("Reference: " + url.getRef ());

            logger.info (url.toString());

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }
}