
package com.educacionit.java.networking;


import java.net.*;

import org.apache.log4j.Logger;


public class TestUrl {


    private static final Logger logger = Logger.getLogger (TestUrl.class);


    public static void main (String a[]) {

        try {

            String myUrl = "http://www.educacionit.com";
            URL url = new URL(myUrl);
            logger.info (url.toString());

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }
}