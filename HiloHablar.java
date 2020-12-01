package Server;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import org.json.simple.*;


public class HiloHablar extends Thread{

    Socket s;

    public HiloHablar(Socket s){
        this.s=s;
    }

    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);


        String mandar;
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            while(true){
                mandar=sc.nextLine();

                bw.write(mandar);
                bw.newLine();
                bw.flush();
            }

        }catch (Exception e){

        }


    }

}
