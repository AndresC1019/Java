
import javax.swing.JOptionPane;

public class ArreglosyPracticas3 {
    public static void main(String[]args){
        int cantidadDeVuelos = ingresarEnteroMayorQue("Por favor ingrese la cantidad de vuelos.",0);
        int[] codigoVuelo = ingresarNEnterosMayoresQue("Codigo del vuelo", cantidadDeVuelos,0);
        String[] ciudadDestino = ingresarNTextos("Ingrese ciudad del destino", cantidadDeVuelos);
        double[] duracionVuelo = ingresarNRealesMayoresQue("Duracion del vuelo", cantidadDeVuelos,0);
        boolean[] vueloNacional = ingresarNBooleanos("¿Su vuelo es nacional? ",cantidadDeVuelos);
        int clasificarDuracionVueloC = totalVuelosCortos(duracionVuelo);
        int clasificarDuracionVueloM = totalVuelosMedios(duracionVuelo);
        int clasificarDuracionVueloL = totalVuelosLargos(duracionVuelo);
        double duracionVuelosSumaTotal = totalDeDuracionVuelos(duracionVuelo);
        String ciudadABuscar = ingresarTexto("Por favor ingrese la ciudad que quiere bucar disponibilidad:");
        String mensaje = generarMensajeVuelosRequerimientos(ciudadABuscar, vueloNacional, ciudadDestino, cantidadDeVuelos, codigoVuelo, clasificarDuracionVueloC, clasificarDuracionVueloM, clasificarDuracionVueloL, duracionVuelosSumaTotal);
        mostrarMensaje(mensaje);
    }
//Todas las funciones reutilizadas int

public static int ingresarEntero(String mensaje) {
    int valor = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    return valor;
}
public static int ingresarEnteroMayorQue(String mensaje, int minimo) {
    int numero;
    do {
        numero = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
        if (numero <= minimo) {
            JOptionPane.showMessageDialog(null, "Error: El número debe ser mayor que " + minimo);
        }
    } while (numero <= minimo);
    return numero;    
}
public static int[] ingresarNEnterosMayoresQue(String mensaje, int cantidad, int limiteInf) {
    int[] valores = new int[cantidad];
    for (int i = 0; i < cantidad; i++) {
        valores[i] = ingresarEnteroMayorQue(mensaje + " (" + (i + 1) + " de " + cantidad + "): ", limiteInf);
    }
    return valores;
}
//Funcione reutilizadas double
public static double ingresarRealD(String mensaje) {
    double valor = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
    return valor;
}
public static double ingresarRealMayorQue(String mensaje, double minimo) {
    double numero;
    do {
        numero = Double.parseDouble(JOptionPane.showInputDialog(null, mensaje));
        if (numero <= minimo) {
            JOptionPane.showMessageDialog(null, "Error: El número debe ser mayor que " + minimo);
        }
    } while (numero <= minimo);
    return numero;
}
public static double[] ingresarNRealesMayoresQue(String mensaje, int cantidad, double limiteInferior) {
    double[] valores = new double[cantidad];
    for (int i = 0; i < cantidad; i++) {
        valores[i] = ingresarRealMayorQue(mensaje + "(" + (i + 1) + " de " + cantidad + "):", limiteInferior);
    }
    return valores;
}
//Funciones reutilizadas String
public static String ingresarTexto(String mensaje) {
   String texto = JOptionPane.showInputDialog(mensaje);
   return texto;
}
public static String[] ingresarNTextos(String mensaje, int cantidad) { 
    String[] textos = new String[cantidad];
    for (int i = 0; i < cantidad; i++) {
        textos[i] = ingresarTexto(mensaje + " (" + (i + 1) + " de " + cantidad + "): ");
    }
    return textos;
}
//Funcione reutilizadas booleanos
public static boolean ingresarBoolean(String mensaje) {
    boolean valor = Boolean.parseBoolean(JOptionPane.showInputDialog(mensaje));
    return valor;
}
public static boolean[] ingresarNBooleanos(String mensaje, int cantidad) {
    boolean[] datos = new boolean[cantidad];
    for (int i = 0; i < cantidad; i++) {
        datos[i] = ingresarBoolean(mensaje + (i + 1) + " (true/false):");
    }
    return datos;
}
//Funciones sin reutilizar
public static int totalVuelosCortos(double[] duracionVuelo){
int contadorC=0;
for(int i=0;i<duracionVuelo.length;i++){
    if(duracionVuelo[i]<2){
        contadorC++;
        }
    }
    return contadorC;        
}
public static int totalVuelosMedios(double[] duracionVuelo){
int contadorM=0;
for(int i=0;i<duracionVuelo.length;i++){
    if(duracionVuelo[i] >= 2 && duracionVuelo[i] < 5){
        contadorM++;
        }
    }
    return contadorM;   
}
public static int totalVuelosLargos(double[] duracionVuelo){
int contadorL=0;
for(int i=0;i<duracionVuelo.length;i++){
    if(duracionVuelo[i]>=5){
        contadorL++;
        }
    }   
    return contadorL;   
}
public static double totalDeDuracionVuelos(double[] duracionVuelo){
    double horaTotal = 0;
    for(int i=0;i<duracionVuelo.length;i++){
    horaTotal += duracionVuelo[i];
    }
    return horaTotal;
}
public static String generarMensajeVuelosRequerimientos(String ciudadABuscar, boolean[] vueloNacional, String[] ciudadDestino, int cantidadDeVuelos, int[] codigoVuelo, int clasificarDuracionVueloC, int clasificarDuracionVueloM, int clasificarDuracionVueloL, double duracionVuelosSumaTotal){
    String mensaje = "";
    String vueloDisponible = "No";
    int nacional = 0;
    int internacional = 0;
    for(int i=0; i<vueloNacional.length;i++){
        if(vueloNacional[i]){
            nacional++;
        }else{
            internacional++;
        }
    }
    for (int i = 0;i < ciudadDestino.length;i++){
        if(ciudadABuscar.equalsIgnoreCase(ciudadDestino[i])){
            vueloDisponible = "Si";
    }
    mensaje = "La cantidad de vuelos son " + cantidadDeVuelos + ", de esos vuelos: " + nacional + " son nacionales y " + internacional + " son internacionales. " + "\n" + "La cantidad de vuelos cortos son: " + clasificarDuracionVueloC + "\n" + " La cantidad de vuelos de duración media son: " + clasificarDuracionVueloM + "\n" + " La cantidad de vuelos largos son: " + clasificarDuracionVueloL + "\n" + "La cantidad de horas voladas en total son: " + duracionVuelosSumaTotal + "\n" + "Su ciudad destino actualmente" + "( " + ciudadABuscar + " )" + vueloDisponible + " se encuentra disponible para vuelo.";
}
return mensaje;
}
public static void mostrarMensaje(String mensaje) {
    JOptionPane.showMessageDialog(null, mensaje);
}
}