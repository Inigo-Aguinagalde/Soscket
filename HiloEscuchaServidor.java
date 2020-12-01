package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HiloEscuchaServidor extends Thread {
    Socket s;
    public HiloEscuchaServidor(Socket socket){
        s=socket;
    }

    @Override
    public void run(){

        BufferedReader br = null;
        String mensaje = null;
        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while((mensaje=br.readLine())!=null) {
                Servidor.broadcast(mensaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
