
/**
 * Este proyecto modela el comportamiento de una carta de la baraja española, cada carta tiene un palo y un valor.
 * 
 * @author (Gianfranco Álvarez) 
 * @version (01_19_10_2021)
 */
public class CartaBaraja
{
    //Declaración del atributo para el valor de la carta;
    private int valor;
    //Declaración del atributo para el palo de la carta;
    private int palo;
    // Declaración de la constante para la carta del palo oro e inicialización con valor 1.
    private final int OROS = 1;
    // Declaración de la constante para la carta del palo copas e inicialización con valor 2.
    private final int COPAS = 2;
    // Declaración de la constante para la carta del palo espadas e inicialización con valor 3.
    private final int ESPADAS = 3;
    // Declaración de la constante para la carta del palo bastos e inicialización con valor 4.
    private final int BASTOS = 4;
    
    /**
     * Constructor de objetos para la clase CartaBaraja.
     * Se obtiene mediante parámetros el valor y el palo de la carta.
     * 
     * @param queValor Parámetro para obtener el valor de la carta(número entero 1-12).
     * @param quePalo Parámetro para obtener el palo de la carta(1=OROS, 2=COPAS, 3=ESPADAS, 4=BASTOS).
     */
    
    public void CartaBaraja(int queValor, int quePalo)
    {
        // Asignar el valor de la carta.
        valor = queValor;
        // AsignaR al palo de la carta.
        palo = quePalo;
    }

    /**
     * Método para mostrar el valor del palo usando swicth.
     * 
     * @return  Muestra el valor del palo.
     */
    
    public String getPalo()
    {
        switch (palo)
        {
            //Si el valor de palo es 1 = OROS;devolver string OROS.    
            case OROS: return "OROS";
            //Si el valor de palo es 2 = COPAS;devolver string COPAS.   
            case COPAS: return "COPAS"; 
            //Si el valor del palo es 3 = ESPADAS;devolver string ESPADAS.   
            case ESPADAS: return "ESPADAS";
            //Si el valor del palo es 4 = BASTOS;devolver string BASTOS.   
            case BASTOS: return "BASTOS";
            //Si el valor de palo no es 1,2,3 o 4; devolver que no existe ese palo.
            default: return "No existe ese palo";
        }
    }
    
    /**
     * Método para mostrar el valor de la carta usando sentencia if.
     * 
     * @return  Muestra el valor de la carta.
     */
    
    public String getValor()
    {
        //Comparar el valor de la carta y dependiendo del que tenga devuelve el valor(numero) en string si es del 1 al 9.
        //String con la figura en caso 10, 11, 12.
        if (valor == 1)
            return "UNO";
        else if (valor == 2)
            return "DOS";
        else if (valor == 3)
            return "TRES";
        else if (valor == 4)
            return "CUATRO";
        else if (valor == 5)
            return "CINCO";
        else if (valor == 6)
            return "SEIS";
        else if (valor == 7)
            return "SIETE"; 
        else if (valor == 8)
            return "OCHO";
        else if (valor == 9)
            return "NUEVE";
        //Caso figura.     
        else if(valor == 10) 
            return "SOTA";
        //Caso figura.    
        else if(valor == 11)
            return "CABALLO";
        //Caso figura.    
        else if(valor == 12)
            return "REY";
        //En caso de no ser una carta del 1 al 12.    
        else
            return "La carta tiene que tener un valor del 1 al 12";
    }
    
    /**
     * Método que devuelve una cadena representado la carta.
     * 
     * @return  Muestra una representación de la carta.
     */
    
    public String toString()
    {
        //pasar a minúsculas y devolver el valor de la carta y el palo
        return getValor().toLowerCase()+ " de " + getPalo().toLowerCase();
    }
    
}    