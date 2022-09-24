package client;

import model.BeanUser;
import model.DaoUser;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import server.Methods;

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
        leer.useDelimiter("\n");

        BeanUser b_users = new BeanUser();
        DaoUser d_user = new DaoUser();
        Methods m = new Methods();

        String nombre = "", apellido_p = "", apellido_m = "", sexo = "", estado_nac = "", fecha_nac = "", curp = "";

        int opc = 0;

        do {
            System.out.println("SISTEMA DE REGISTRO DE CURP");

            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Registrar CURP");
            System.out.println("2. Consulta de datos");
            System.out.println("3. Salir");
            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("Ingresa tu nombre: ");
                    nombre = leer.next();
                    b_users.setNombre(nombre);

                    System.out.print("Ingresa tu apellido paterno: ");
                    apellido_p = leer.next();
                    b_users.setApellido_p(apellido_p);

                    System.out.print("Ingresa tu apellido materno: ");
                    apellido_m = leer.next();
                    b_users.setApellido_m(apellido_m);

                    System.out.print("Ingresa tu sexo: ");
                    sexo = leer.next();
                    b_users.setSexo(sexo);

                    System.out.print("Ingresa tu estado de nacimiento, ");
                    System.out.print("Nota. Si eres extranjero favor de ingresar: soy extramjero: ");
                    estado_nac = leer.next();
                    switch (estado_nac){
                        case "aguascalientes":
                            estado_nac = "AS";
                            break;
                        case "baja california":
                            estado_nac = "BC";
                            break;
                        case "baja california sur":
                            estado_nac = "BS";
                            break;
                        case "campeche":
                            estado_nac = "CC";
                            break;
                        case "coahuila":
                            estado_nac = "CL";
                            break;
                        case "colima":
                            estado_nac = "CM";
                            break;
                        case "chiapas":
                            estado_nac = "CS";
                            break;
                        case "chihuahua":
                            estado_nac = "CH";
                            break;
                        case "distrito federal":
                            estado_nac = "DF";
                            break;
                        case "durango":
                            estado_nac = "DG";
                            break;
                        case "guanajuato":
                            estado_nac = "GT";
                            break;
                        case "guerrero":
                            estado_nac = "GR";
                            break;
                        case "hidalgo":
                            estado_nac = "HG";
                            break;
                        case "jalisco":
                            estado_nac = "JC";
                            break;
                        case "estado de mexico":
                            estado_nac = "MC";
                            break;
                        case "michoacan":
                            estado_nac = "MN";
                            break;
                        case "morelos":
                            estado_nac = "MS";
                            break;
                        case "nayarit":
                            estado_nac = "NT";
                            break;
                        case "nuevo leon":
                            estado_nac = "NL";
                            break;
                        case "oaxaca":
                            estado_nac = "OC";
                            break;
                        case "puebla":
                            estado_nac = "PL";
                            break;
                        case "queretaro":
                            estado_nac = "QT";
                            break;
                        case "quintana roo":
                            estado_nac = "QR";
                            break;
                        case "san luis potosi":
                            estado_nac = "SP";
                            break;
                        case "sinaloa":
                            estado_nac = "SL";
                            break;
                        case "sonora":
                            estado_nac = "SR";
                            break;
                        case "tabasco":
                            estado_nac = "TC";
                            break;
                        case "tamaulipas":
                            estado_nac = "TS";
                            break;
                        case "tlaxcala":
                            estado_nac = "TL";
                            break;
                        case "veracruz":
                            estado_nac = "VZ";
                            break;
                        case "yucatan":
                            estado_nac = "YN";
                            break;
                        case "zacatecas":
                            estado_nac = "ZS";
                            break;
                        case "soy extranjero":
                            estado_nac = "NE";
                            break;
                    }
                b_users.setEstado_nac(estado_nac);

                System.out.print("Ingresa tu fecha de nacimiento en este formato: ");
                System.out.print("año-mes-día:");
                fecha_nac = leer.next();
                b_users.setFecha_nac(fecha_nac);
                //curp = nombre + apellido_p + apellido_m + sexo + estado_nac + fecha_nac;

               // curp.toString();
                Object[] datos = {nombre, apellido_p, apellido_m, sexo, estado_nac, fecha_nac};

                String datoscurp = (String) client.execute("Methods.generarCurp", datos);
                System.out.println("Tu curp es: " + datoscurp);
                b_users.setCurp(String.valueOf(datos)); //????????????????
                d_user.saveDatos(b_users);
                break;
                case 2:
                    System.out.println("Consulta de datos");
                    System.out.println(d_user.showDatos().toString());
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("error...");
                    break;
            }
        } while (opc != 3);


    }
}
