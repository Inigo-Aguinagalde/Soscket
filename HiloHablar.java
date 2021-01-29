package Server;

import java.io.BufferedWriter;
import java.util.Scanner;
import org.json.simple.*;


public class HiloHablar extends Thread{

    BufferedWriter bw;

    public HiloHablar(BufferedWriter bw){
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
            bw.flush();
        }catch (Exception e){

        }


    }

}
