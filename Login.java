package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Login {

    private String[]usuarios ={"usuario1","usuario2","usuario3","usuario4"};

    private String[]contraseñas = {"usuario1","usuario2","usuario3","usuario4"};

    public void login(){
        String usuario;
        boolean salir=false;
        boolean error=true;
        Scanner sc = new Scanner(System.in);
       do{
           System.out.println("Introduzca el usuario");
           usuario=sc.nextLine();
           if(usuario.equalsIgnoreCase("exit")){
               salir();
           }
       }while(error);
        for(int i=0;i<usuarios.length||salir;i++){
            if(usuarios[i].equals(usuario)){
                System.out.println("login correcto");
                error=false;

            }
        }

    }

    public void salir(){
        System.exit(0);
    }

    public Socket devovler() throws IOException {
        Socket s =new Socket("localhost",1234);

        return s;

    }
}
