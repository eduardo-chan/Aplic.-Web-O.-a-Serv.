package server;

public class Methods {
    public double suma(String n1, String n2){

        double suma = Double.parseDouble(n1) + Double.parseDouble(n2);
        return suma;
    }

    public double resta(String n1, String n2){

        double resta = Double.parseDouble(n1) - Double.parseDouble(n2);
        return resta;
    }

    public double multi(String n1, String n2){

        double multi = Double.parseDouble(n1) * Double.parseDouble(n2);
        return multi;
    }

    public double div(String n1, String n2){
        double div = Double.parseDouble(n1) / Double.parseDouble(n2);
        return div;
    }

    public double exp(String n1, String n2){
        double base = Double.parseDouble(n1);
        double exp = Double.parseDouble(n2);
        double resultado = Math.pow(base, exp);
        return resultado;
    }

    public double raiz(String n1){
        double num = Double.parseDouble(n1);
        double resultado = Math.sqrt(num);
        return resultado;
    }
}
