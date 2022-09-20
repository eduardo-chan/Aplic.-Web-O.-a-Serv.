package server;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class RPCServer {
    public static void main(String[] args) throws XmlRpcException, IOException {
        System.out.printf("Initializing server...");
        PropertyHandlerMapping mapping = new PropertyHandlerMapping(); //le decimos al server que por medio de una palabra clave apunta  a nuestra clase de methods, funciona como request
        mapping.addHandler("Methods", Methods.class); //por medio de la palabra methods hace referencia a nuestra clase methods

        WebServer server = new WebServer(1200); //apuntamos al puerto, en que puerto correrá el server
        server.getXmlRpcServer().setHandlerMapping(mapping); //añadimos el mapeo que hicimos, mapping da acceso a los que está adentro de nuestra clase por medio de una palabra referencia
        server.start();
        System.out.println("Server running in http://localhost:1200");
        System.out.printf("Waiting requests...");




    }
}



/*mapping
*
* */