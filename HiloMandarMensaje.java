package Server;

import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.util.Scanner;

public class HiloMandarMensaje extends Thread{
    BufferedWriter bw;
    public HiloMandarMensaje(BufferedWriter bw) {
        this.bw=bw;
    }

    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);
        String mandar;
        mandar=sc.nextLine();
        JSONObject mensaje = new JSONObject();
        mensaje.put("mensaje:",mandar);

        try {
            bw.write(mensaje.toString());
            bw.newLine();
            bw.flush();
        }catch (Exception e){

        }
    }
}
