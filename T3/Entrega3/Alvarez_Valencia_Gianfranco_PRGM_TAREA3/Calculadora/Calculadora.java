
/**
 * Este proyecto modela el comportamiento de una calculadora muy sencilla capaz de realizar las operaciones básicas sobre dos operandos.
 * Registra además el número de operaciones que realiza.
 * 
 * @author (Gianfranco Álvarez) 
 * @version (01_15_10_2021)
 */
public class Calculadora
{
    // Almacena el primer número decimal con el que operará la calculadora.
    private double operando1;
    // Almacena el segundo número decimal con el que operará la calculadora.
    private double operando2;
    // Almacena numero de operaciones(entero).
    private int total;
    
    /**
     * Constructor de objetos para la clase Calculadora.
     * Iniciliza el valor de los atributos a 0.
     */
    
    public Calculadora()
    {
        // Inicializar operando1 a 0.
        operando1 = 0;
        // Inicializar operando2 a 0.
        operando2 = 0;
        // Inicializar total a 0.
        total = 0;
    }

    /**
     * Método para obtener el valor del primer operando(operando1).
     * 
     * @param  valOperando1 Parámetro para obetener el valor de operando1 (número Real).
     */
    
    public void setOperando1(double valOperando1)
    {
        operando1 = valOperando1;
    }
    
    /**
     * Método para obtener el valor del segundo operando (operando2).
     * 
     * @param  valOperando2 Parámetro para obetener el valor de operando2 (número Real).
     */
    
    public void setOperando2(double valOperando2)
    {
        operando2 = valOperando2;
    }
    
    /**
     * Método para obtener el total de operaciones.
     * 
     * @return Devuelve el total de operaciones hechas por la calculadora.
     */
    
    public int getTotalOperaciones()
    {
        return total;
    }
    
    /**
     * Método para obtener la suma de los operandos.
     * 
     * @return Devuelve la suma de los dos operandos.
     */
    
    public double sumar()
    {
        //Al total de operaciones se le suma una operacion(la de sumar). 
        total += 1;
        //Calcula la suma de los operandos
        return operando1 + operando2;
    }

    /**
     * Método para obtener la resta de los operandos.
     * 
     * @return Devuelve la resta del primer operando con el segundo.
     */
    
    public double restar()
    {
        //Al total de operaciones se le suma una operacion(la de restar). 
        total += 1;
        //Calcula la resta de los operandos
        return operando1 - operando2;
    }
    
    /**
     * Método para obtener el producto de los dos operandos.
     * 
     * @return Devuelve el producto de los operandos.
     */
    
    public double multiplicar()
    {
        //Al total de operaciones se le suma una operacion(la de multiplicar). 
        total += 1;
        //Calcula producto de los operandos.
        return operando1 * operando2;
    }
    
    /**
     * Método para obtener la división entera del primer operando entre el segundo.
     * Para ello convierte los operandos a números enteros.
     * 
     * @return Devuelve la división entera del primer operando entre el segundo.
     */
    
    public int dividir()
    {
        //Declarar variables locales operando1Entero y operando2Entero para convertir(cast) los operandos 1 y 2(reales) a enteros.
        //Sin modificar el valor original.
        //Inicializarlas con los valores de los atributos operandos1 y operando2.
        int operando1Entero = (int) operando1;
        int operando2Entero = (int) operando2;
        //Al total de operaciones se le suma una operacion(la de división entera). 
        total += 1;
        //Calcula la division entera del primer operando entre el segundo.
        return operando1Entero / operando2Entero;
    }
    
    /**
     * Método para obtener la división real del primer operando entre el segundo.
     * 
     * @return Devuelve la división real del primer operando entre el segundo.
     */
    
    public double dividirReal()
    {
        //Al total de operaciones se le suma una operacion(la de división real). 
        total += 1;
        //Calcula la division real(exacta) del primer operando entre el segundo.
        return operando1 / operando2;
    }
    
    /**
     * Método para obtener el resultado del primer operando elevado al segundo.
     * 
     * @return Devuelve el primer operando elevado al segundo.
     */
    
    public double calcularPotencia()
    {
        //Al total de operaciones se le suma una operacion(la de calcular la pontencia). 
        total += 1;
        //Calcula mediante el metodo pow el resultado del primer operando elevado al segundo.
        return Math.pow(operando1, operando2);
    }
    
    /**
     * Método para restablecer los atributos a su valor incial(0).
     * 
     * 
     */
    
    public void clear()
    {
        //El valor inicial de operando1 en el contructor es 0.
        operando1 = 0;
        //El valor inicial de operando2 en el contructor es 0.
        operando2 = 0;
        //El valor inicial de total en el contructor es 0.
        total = 0;
    }
}
