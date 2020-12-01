package Server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HiloEscucha extends Thread {

    Socket s;

    public HiloEscucha(Socket s) {
        this.s = s;

    }

    @Override
    public void run() {
        BufferedReader br = null;
        String mensaje = null;
        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while ((mensaje = br.readLine()) != null) {
                System.out.println(mensaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
