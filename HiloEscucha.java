package Server;


import java.io.*;
import java.net.Socket;

public class HiloEscucha extends Thread {

    Socket s;
    BufferedReader br;
    BufferedWriter bw;
    HiloMandarMensaje hm;

    public HiloEscucha(Socket s) throws IOException {
        this.s=s;
        br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        bw= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        hm = new HiloMandarMensaje(bw);

    }

    @Override
    public void run() {

        crearHM();

        try  {
            String line;
            while ( (line = br.readLine()) != null) {
                System.out.println(line);

            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void crearHM() {
        hm.start();
    }

}
