package Server;

import java.io.*;
import java.net.Socket;

public class ConexionCliente extends Thread {

    Socket socket;
    HiloHablar HH;
    BufferedReader br;
    BufferedWriter bw;


    public ConexionCliente(Socket s) throws IOException {
        socket = s;

        br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        HH = new HiloHablar(bw);

    }


    @Override
    public void run() {
        crearHH();

        try  {
            String line;
            while ( (line = br.readLine()) != null) {
                System.out.println(line);
                Servidor.broadcast(line);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void crearHH() {
        HH.start();
    }

    public void escribir(String mensaje) {
        try {

            bw.write(mensaje);
            bw.newLine();
            bw.flush();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
