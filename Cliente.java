package Server;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Cliente {

    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",1234);

            HiloEscucha he = new HiloEscucha(s);
            he.start();

            HiloHablar HH = new HiloHablar(s);
            HH.start();

        }catch(Exception e){System.out.println(e);}
    }
}