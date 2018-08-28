
package com.educacionit.java.networking;


import org.apache.log4j.Logger;

import java.net.InetAddress;


public class DomainNameIP {


    private static final Logger logger = Logger.getLogger (DomainNameIP.class);


    public static void main (String[] args) {


        /*
         * DNS LookUp.
         * */

        String name = "www.yahoo.com";


        try {

            InetAddress[] addresses = InetAddress.getAllByName (name);

            for (InetAddress item: addresses) {

                logger.info (item.getHostAddress ());
            }

        } catch (Exception e) {

            logger.error (e.getMessage ());
        }
    }
}