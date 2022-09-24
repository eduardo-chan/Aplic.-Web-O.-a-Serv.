package server;

import java.util.Random;

public class Methods {

    public String generarCurp(String nombre, String apellido_p, String apellido_m, String sexo, String estado_nac, String fecha_nac, String curp){

        String apellidopc1 = String.valueOf(apellido_p.charAt(0));


        String apellidopc2 = String.valueOf(apellido_p.charAt(1)); //no jala ptm

        String apellidoo = apellido_p.substring(0,1);

        char apellidomc = apellido_m.charAt(0);
        String nombrec = String.valueOf(nombre.charAt(0));



        String fechac = fecha_nac.substring(2,9);
        String sexoc = String.valueOf(sexo.charAt(0));

        //String estado = estado_nac; //jala pero no el estado que deberia



        String apellidopc21 = String.valueOf(apellido_p.charAt(2));
        String apellidopm2 = String.valueOf(apellido_m.charAt(2));

        char nombrec2 = nombre.charAt(3);

        Random random = new Random();
        String aleatorio = "";
        String alfa = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String alfa2 = "0123456789";
        aleatorio = alfa.charAt(random.nextInt(alfa.length())) + "" + alfa2.charAt(random.nextInt(alfa2.length()));

        String resultadin = apellidoo.toUpperCase() + Character.toUpperCase(apellidomc) +
                nombrec.toUpperCase() + fechac.toUpperCase() + sexoc.toUpperCase() + estado_nac +
                apellidopc21.toUpperCase() + apellidopm2.toUpperCase() + Character.toUpperCase(nombrec2);
        resultadin = curp;
        return  resultadin;







    }

}
