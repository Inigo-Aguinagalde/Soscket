package Server;

import java.io.*;
import java.net.Socket;

public class ConexionCliente extends Thread {

    Socket socket;
    HiloHablar HH;


    public ConexionCliente(Socket s) {
        socket = s;
        HH = new HiloHablar(socket);
    }

    @Override
    public void run() {

        String linea=null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("hey");
            while ((linea = br.readLine()) != null) {

                Servidor.broadcast(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CrearHH();
    }


    public void CrearHH() {
        HH.start();
    }

    public void escribir(String mensaje) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            bw.write(mensaje);
            bw.newLine();
            bw.flush();


        } catch (Exception e) {

        }
    }

}
