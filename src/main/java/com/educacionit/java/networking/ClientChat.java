
package com.educacionit.java.networking;


import java.net.*;
import java.io.*;

import org.apache.log4j.Logger;


public class ClientChat
{

    private static final Logger logger = Logger.getLogger (ClientChat.class);


    public static void main(String args[]) throws IOException
    {
        try{
            logger.info("sending request to peer....");
            Socket client=new Socket("127.0.0.1",1300);
            logger.info("successfully conneted");
            Clie c=new Clie(client);

            BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
            PrintStream ps=new PrintStream(client.getOutputStream());
            while(true)
            {
                String s=br1.readLine();
                ps.println(s);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

class Clie implements Runnable
{

    private static final Logger logger = Logger.getLogger (Clie.class);

    Thread t;
    Socket client;
    Clie(Socket client)
    {
        this.client=client;
        t=new Thread(this);
        t.start();

    }
    public void run()
    {
        try{

            BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
            while(true)
            {
                String st1=br.readLine();
                logger.info (" "+st1);
            }

        }
        catch(IOException e)
        {
            System.out.println(e);

        }
    }
}