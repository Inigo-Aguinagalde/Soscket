package Server;


import java.net.Socket;
import java.util.Scanner;

public class Multicliente {


    public static void main(String[] args) {

        try {
            Socket s = new Socket("localhost", 1234);
            Scanner sc = new Scanner(System.in);


            HiloEscucha he = new HiloEscucha(s);
            he.start();

            HiloHablar HH = new HiloHablar(s);
            HH.start();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
