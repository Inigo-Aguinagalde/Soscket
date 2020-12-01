package Server;

import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

    static ConexionCliente[] CC = new ConexionCliente[2];

    public static void main(String[] args) {


        try {
            ServerSocket ss = new ServerSocket(1234);


            for(int i=0;i<2;i++){


                Socket socket = ss.accept();

                CC[i] = new ConexionCliente(socket);
                CC[i].start();

                }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void broadcast(String mensaje) {

        for (int i = 0; i < 2; i++) {

            CC[i].escribir(mensaje);
        }

    }


}