package client;

import model.DaoCalculadora;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCClient {

    static Scanner leer = new Scanner(System.in); //no pierde su valor dutrante todo el programa

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl(); //le decimos que utilize nuestro server
        config.setServerURL(new URL("http://localhost:1200")); // con esta url

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);// le pasamos la config de arriba al cliente


        String option = "", n1 = "", n2 = "";
        Object data[] = null;
        double response = 0.0;
        do {
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Exponente");
            System.out.println("6. Raiz");
            System.out.println("7. Consultar historial");
            System.out.println("8. Salir");
            option = leer.next();
            if (isNumber(option)) {
                switch (Integer.parseInt(option)) {
                    case 1:
                        do {
                            System.out.println("SUMA");
                            System.out.print("Ingresa el 1er número: ");
                            n1 = leer.next();
                            if (!isDouble(n1)) {
                                System.out.println("Ingrese un número válido");
                            }
                        } while (!isDouble(n1));

                        do {
                            System.out.print("Ingresa el 2do número: ");
                            n2 = leer.next();
                            if (!isDouble(n2)) {
                                System.out.println("Ingrese un número válido");
                            }
                        } while (!isDouble(n2));
                        data = new Object[]{n1, n2};
                        response = (Double) client.execute("Methods.suma", data);
                        System.out.printf("Result --> " + response);
                        System.out.println();

                        //ejecución del método en el ervidor
                        break;
                    case 2:
                        do {
                            System.out.println("Resta");
                            System.out.print("Ingresa el 1er número: ");
                            n1 = leer.next();
                            if (!isDouble(n1)) {
                                System.out.println("Ingrese un número válido");
                            }
                        } while (!isDouble(n1));

                        do {
                            System.out.print("Ingresa el 2do número: ");
                            n2 = leer.next();
                            if (!isDouble(n2)) {
                                System.out.println("Ingrese un número válido");
                            }
                        } while (!isDouble(n2));
                        data = new Object[]{n1, n2};
                        response = (Double) client.execute("Methods.resta", data);
                        System.out.printf("Result --> " + response);
                        System.out.println();

                        //ejecución del método en el servidor
                        break;
                    case 3:
                        do {
                            System.out.println("Multiplicación");
                            System.out.print("Ingresa el 1er número: ");
                            n1 = leer.next();
                            if (!isDouble(n1)) {
                                System.out.println("Ingrese un número válido");
                            }
                        } while (!isDouble(n1));

                        do {
                            System.out.print("Ingresa el 2do número: ");
                            n2 = leer.next();
                            if (!isDouble(n2)) {
                                System.out.println("Ingrese un número válido");
                            }
                        } while (!isDouble(n2));
                        data = new Object[]{n1, n2};
                        response = (Double) client.execute("Methods.multi", data);
                        System.out.printf("Result --> " + response);
                        System.out.println();

                        //ejecución del método en el servidor
                        break;
                    case 4:
                        //no se peude dividir entre cero, falta eso
                        do {
                            System.out.println("Division");
                            System.out.print("Ingresa el 1er número: ");
                            n1 = leer.next();
                            if (!isDouble(n1)) {
                                System.out.println("Ingrese un número válido");
                            }
                        } while (!isDouble(n1));

                        do {
                            System.out.print("Ingresa el 2do número: ");
                            n2 = leer.next();
                            if (!isDouble(n2)) {
                                System.out.println("Ingrese un número válido");
                            }
                        } while (!isDouble(n2));
                        data = new Object[]{n1, n2};
                        response = (Double) client.execute("Methods.div", data);
                        System.out.printf("Result --> " + response);
                        System.out.println();

                        //ejecución del método en el servidor
                        break;
                    case 5:
                        do {
                            System.out.println("Exponente");
                            System.out.print("Ingresa la base: ");
                            n1 = leer.next();
                            if (!isDouble(n1)) {
                                System.out.println("Ingrese un número válido");
                            }
                        } while (!isDouble(n1));
                        do {
                            System.out.print("Ingresa el exponente: ");
                            n2 = leer.next();
                            if (!isDouble(n2)) {
                                System.out.println("Ingrese un número válido");
                            }
                        } while (!isDouble(n2));

                        data = new Object[]{n1, n2};


                        response = (Double) client.execute("Methods.exp", data);
                        System.out.printf("Result --> " + response);
                        System.out.println();

                        //ejecución del método en el servidor
                        break;
                    case 6:
                        do {
                            System.out.println("Raiz");
                            System.out.print("Ingresa un numero: ");
                            n1 = leer.next();
                            if (!isDouble(n1)) {
                                System.out.println("Ingrese un número válido");
                            }
                        } while (!isDouble(n1));

                        data = new Object[]{n1};
                        response = (Double) client.execute("Methods.raiz", data);
                        System.out.printf("Result --> " + response);
                        System.out.println();

                        //ejecución del método en el servidor
                        break;
                    case 7:

                        break;
                    case 8:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Esta opción no existe");
                }

            } else {
                System.out.println("ERROR...opción incorrecta");
            }
        } while (!option.equals("8"));


    }

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
