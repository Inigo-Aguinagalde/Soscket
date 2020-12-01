package Server;

import java.util.Scanner;

public class Menu {

    private String menu= "1. Login " +
            "2.Mensaje" +
            "3.logout" +
            "4.Salir";

    public void obciones_menu(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        Login l = null;

        System.out.println(menu);
        opcion= sc.nextInt();

        switch (opcion){

            case 1:
                l.login();
                break;
            case 2:

                break;

            case 3:

                break;
            case 4:
                System.exit(0);
                break;
        }

    }

}
