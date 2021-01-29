package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Servidor {

    static ArrayList<ConexionCliente> listaConexion = new ArrayList<>();

    public static void main(String[] args) {



        try {
            ServerSocket ss = new ServerSocket(1234);


            while(true) {


                Socket socket = ss.accept();
                ConexionCliente cc=new ConexionCliente(socket);

                listaConexion.add(cc);
                cc.start();

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void broadcast(String mensaje) {

        for (ConexionCliente cc : listaConexion) {

            cc.escribir(mensaje);
        }

    }


}