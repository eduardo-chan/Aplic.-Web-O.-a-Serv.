package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Scanner leer = new Scanner(System.in);


        System.out.println("PRÁCTICA 2");
        String producto = null;
        Double n1, n2, n3, suma2, promedio = 0.0;
        System.out.print("Ingresa el nombre del producto: ");
        producto = leer.nextLine();
        System.out.print("Ingresa el valor 1 del producto: ");
        n1 = leer.nextDouble();
        System.out.print("Ingresa el valor 2 del producto: ");
        n2 = leer.nextDouble();
        System.out.print("Ingresa el valor 3 del producto: ");
        n3 = leer.nextDouble();
        suma2 = (n1 + n2 + n3);
        promedio = (suma2 /3);

        Object[] data2 = {producto, suma2, promedio};
        String response2 = (String) client.execute("Methods.producto", data2);
        System.out.println("Result -> " + response2);



        System.out.println("PRÁCTICA 3");

        Double num1, num2, min, max, suma = 0.0;

        System.out.print("Ingrese un número: ");
        num1 = leer.nextDouble();
        System.out.print("Ingrese otro número: ");
        num2 = leer.nextDouble();

        min = Math.min(num1, num2);
        max = Math.max(num1, num2);


        for (double i = min +1; i < max; i++) {

            System.out.print( i + " |");
        }

        for (double i = min +1; i < max; i++) {
            suma+=i;
        }


        Object[] data3 = {suma};
        String response3 = (String) client.execute("Methods.suma", data3);
        System.out.println("Result -> " + response3);

        System.out.println("PRÁCTICA 4");

        int [ ] matriz = new int [5];
        String idk = "matriz llena uwu";
        for(int i=0; i< matriz.length; i++){
            System.out.print("Ingresa el número del indice "+ "[" + i + "]" + ": ");
            matriz[i]= leer.nextInt( );
        }
        for(int i = 0; i < matriz.length - 1; i++) {
            for(int j = 0; j < matriz.length - 1; j++) {
                if (matriz[j] > matriz[j + 1]) { //si num actual > num siguiente
                    int aux = matriz[j];
                    matriz[j] = matriz[j+1];
                    matriz[j+1] = aux;
                }
            }
        }
        System.out.println("Ordenando matriz...");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(  "El numero del índice " + i+1 + " = " + matriz[i]);
        }
        System.out.println();


        Object[] data4 = {idk};
        String response4 = (String) client.execute("Methods.algo", data4);
        System.out.println("Result -> " + response4);

    }
}
