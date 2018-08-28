
package com.educacionit.java.networking;


import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;


public class TestUrl2 {


    private static final Logger logger = Logger.getLogger (TestUrl2.class);


    public static void main (String a[]) {

        try {

            String protocol = "http";
            String host = "www.educacionit.com";
            int port = 80;
            String path = "/paquetes-java";
            URL url = new URL(protocol, host, port, path);

            logger.info (url.toString());

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }
}