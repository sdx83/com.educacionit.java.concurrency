
package com.educacionit.java.networking;

import java.net.*;
import java.io.*;

import org.apache.log4j.Logger;


public class ServerChat {

    private static final Logger logger = Logger.getLogger (ServerChat.class);

    public static void main(String args[]) throws IOException
    {

        ServerSocket server=new ServerSocket(1300);
        System.out.println("waiting for request from peer.....");
        Socket client=server.accept();
        Serv s=new Serv(client);
        System.out.println("request accepted");
        BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
        PrintStream ps2=new PrintStream(client.getOutputStream());
        while(true)
        {
            String st=br2.readLine();
            ps2.println(st);
        }
    }
}

class Serv implements Runnable
{
    private static final Logger logger = Logger.getLogger (Serv.class);

    Thread t;
    Socket client;
    Serv(Socket client)
    {
        this.client=client;
        t=new Thread(this);
        t.start();
    }
    public void run()
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
            while(true)
            {
                String st1=br.readLine();
                logger.info("client: "+st1);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();

        }
    }
}