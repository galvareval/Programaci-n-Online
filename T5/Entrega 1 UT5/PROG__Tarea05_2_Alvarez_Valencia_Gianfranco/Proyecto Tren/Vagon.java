
/**
 * Esta clase maneja los vagones de un tren,cada objeto sera identificado como un vagón único.
 * Los vagones tienen asientos, siendo el primero de ellos el de la posición 0.
 * 
 * @author (Gianfranco Álvarez Valencia) 
 * @version (01_18_01_2021)
 */
public class Vagon
{
    // Declaración del array para los asientos.
    private double[] asientos;
    // Identificador único del asiento.
    int identificador;
    // Siguiente aiento libre.
    int asientoSiguiente;
    //Variable para contar los vagones.
    private static int contadorVagones = 0;
    
    /**
     * Constructor de objetos para la clase Vagon.
     * 
     * @param numeroAsientos Parámetro para pasar el número de asintos del vagón.
     */
    public Vagon(int numeroAsientos)
    {
        // Asignar el identificador.
        identificador = contadorVagones;
        // Array de dimensión del parámetro pasado al constructor.
        asientos = new double [numeroAsientos];
        // inicializar a -1 los elementos del Array.
        inicializarAsientos();
        asientoSiguiente = 0;
        // Sumar 1 al contador de vagones al crear un objeto vagón.
        contadorVagones++;
    }
    
    /**
     * Método privado para inicializar los elementos del Array a -1.
     *  
     */
    private void inicializarAsientos()
    {
        for (int i = 0;i < asientos.length;i++)
        {
            asientos[i] = -1;
        }
    }
    
    /**
     * Método que devuelve el número total de asientos en el vagón.
     * 
     * @return Devuelve la dimensión del Array que será la cantidad de asientos.
     */
    public int getCapacidad()
    {
        return asientos.length;
    }
    
    /**
     * Método que escribe por pantalla la información relativa al vagón.
     */
    public void printDetallesVagon()
    {
        System.out.println(textToString());
    }
    
    /**
     * Método que devuelve la información del vagón en string.
     * 
     * @return Devuelve un string con la información del vagón.
     */
    public String textToString()
    {
        return "Vagón " + identificador + "-Capacidad " + getCapacidad();
        
    }
    
    /**
     * Método que muestra la información del vagón y el precio del asiento pasado por parámetro.
     * 
     * @param numAsiento Parámetro para pasar la posición del asiento en el Array.
     */
    public void printTicket(int numAsiento)
    {
        // comprobar que se cumple el rango de asientos válidos.
        if ((numAsiento >= 0) && (numAsiento < getCapacidad()))
            System.out.println(textToString() + "\nNº asiento-" + numAsiento + "\nPrecio: " + asientos[numAsiento]);
         else
            System.out.println("\t##El número de asiento no está en el rango de posbiles asientos"); 
    }
    
    /**
     * Método que sirve para reembolsar un asiento vendido, retea el valor de la posición del array pasada como parámetro.
     * Y devuelve el valor reseteado en caso de que el asiento haya sido vendido, sino devuelve 0.
     * 
     * @param numAsiento Parámetro para pasar la posicón del asiento en el Array.
     * @return Devuelve el precio del asiento, si no ha sido vendido devuelve 0.
     */
    public double reembolsarAsiento(int numAsiento)
    {
        // Variable para almacenar el precio del asiento.
        double resultado;
        //inicializar a 0,0.
        resultado = 0;
        // comprobar que se cumple el rango de asientos válidos.
        if ((numAsiento >= 0) && (numAsiento < getCapacidad()))
        {
            //Asiento ha sido vendido.
            if (asientos[numAsiento] >= 0)
            {
                // Almacenar resultado.
                resultado = asientos[numAsiento];
                // Resetar el precio del asiento.
                asientos[numAsiento] = -1;
                return resultado;
            }
            else
            {
                //System.out.println("El asiento no ha sido vendido o ha sido devuelto");
                return 0; 
            }
        }
        else
            {
                //System.out.println("El número de asiento no está en el rango de posbiles asientos");
                return 0;
            }
    }
    
    /**
     * Método que reserva el asiento que apunta al siguiente asiento que todavía no se ha vendido(asientoSiguiente).
     * el precio que se asigna a esa posición del Array es =(2.5 veces esa posición + 1). 
     * 
     * @return Devuelve un valor booleano del estado de la reserva, si ha sido heccha o no.
     */
    public boolean reservarSiguienteAsiento()
    {
        // Comprobar si quedan asientos.
        if (asientoSiguiente < getCapacidad())
        {
            // Asignar el precio al asiento a reservar.
            asientos[asientoSiguiente] = 2.5 * asientoSiguiente + 1;
            // Imprimir por pantalla el asiento resrvado.
            printTicket(asientoSiguiente);
            // sumar uno para saber el siguiente asiento.
            asientoSiguiente++;
            return true;
        }
        else
            {
                return false;
            }
    }
    
    /**
     * Método que devuelve el precio medio de todos los asinetos que han sido vendidos y no reembolsados.
     * 
     * @return Devuelve la media de precios de los asientos vendidos.
     */
    public double getPrecioMedio()
    {
        // Variable para almacenar la suma de los precios de los asientos.
        double sumaPrecios;
        sumaPrecios= 0;
        // Para contar los asientos vendidos.
        int asientosVendidos;
        asientosVendidos = 0;
        for (int i = 0;i < getCapacidad();i++)
        {
            //Si el asiento ha sido vendido, o ha sido devuelto.
            if (asientos[i] != -1)
            {
                // Sumar el total de precios de los asientos.
                sumaPrecios = sumaPrecios + asientos[i];
                // Contar los asientos sumados para hacer la media.
                asientosVendidos ++;
            }
        }
        // Si no hay asientos vendidos la media será 0, para no devolver NaNa.
        if (asientosVendidos == 0)
            return 0;
        else 
        return sumaPrecios / asientosVendidos;
    }
}
