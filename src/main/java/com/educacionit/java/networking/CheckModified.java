
package com.educacionit.java.networking;


import java.net.*;

import org.apache.log4j.Logger;


public class CheckModified {


    private static final Logger logger = Logger.getLogger (CheckModified.class);


    public static void main (String[] argv)throws Exception {

        URL u = new URL ("https://www.sport.es/es/noticias/opinion/psg-manda-barca-segundo-aviso-7004306");
        URLConnection uc = u.openConnection ();
        uc.setUseCaches (false);

        long timestamp = uc.getLastModified ();
        logger.info (String.format ("The last modification time of %s :", timestamp));
    }
}