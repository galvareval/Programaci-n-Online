import java.util.Arrays;
/**
 * Esta clase maneja un alista de números
 * 
 * @author (Gianfranco Álvarez Valencia) 
 * @version (01_11_01_2021)
 */
public class ListaNumeros
{
    //Declaración del array
    private int[] lista;
    //Almacenar el número de elementos guardados en la lista cuando esta se declara.
    private int elementos;

    /**
     * Constructor de objetos sobrecargado de la clase ListaNumeros.
     * 
     * @param lista Array pasado como parámetro.
     */
    public ListaNumeros(int[] addLista)
    {
        // Asgignar array recibido por parámetro al atributo lista.
        lista = addLista;
        //El número de elementos pasa a ser la dimensión del array.
        elementos = addLista.length;
    }
    
     /**
     * Constructor de objetos sobrecargado de la clase ListaNumeros.
     * 
     * @param lista Array pasado como parámetro.
     */
    public ListaNumeros(int dimension)
    {
        //Asgignar un nuevo array al atributo lista con la dimensión del parámetro pasado.
        lista = new int[dimension];
        //El número de elementos sera 0 ya que los valores del Array de dimensión dimension seran 0.
        this.elementos = 0;
        
    }

    /**
     * Método que añade el valor recibido como parámetro al final de la lista.
     * Si esta no está completa.
     * 
     * @param  valor   Valor a añadir al final de la lista.
     */
    public void añadirElemento(int valor)
    {
        // Evaluar los elementos que hay en el array(valor distinto de 0)
        // con la dimensión total del array.
        // Si se añade hay que sumar un elemento al total de elementos.
        if (elementos == lista.length)
        {
            System.out.println("Lista completa");
        }
        else 
        {
            // Añadir a la posición correcta según sea el primer valor de la lista.
            // La lista no esta vacia. Añadir a la siguiente posición libre.
            if (lista[0] != 0)
                {
                    lista[elementos] = valor;
                    elementos ++;
                }
            //La lista está vacia. Añadir a la primera posición del Array.
            else
                {
                    lista[0] = valor;
                    elementos ++;
                }
        }
        
    }
    
    /**
     * Método que devuelve el número total de elementos guardados en el array.
     * 
     * @return Número total de elementos del array.
     */
    public int getTotalNumeros()
    {
        int totalElementos;
        totalElementos = 0;
        for (int i = 0; i < elementos; i++)//ver elementos que no sean 0.
        {
            if (lista[i] != 0)
                totalElementos ++;
        }
        return totalElementos;
    }
    
    /**
     * Método que suma a cada elemento del Array el valor de su posición.
     * 
     */
    public void sumarPosicion()
    {
        for (int i = 0;i < lista.length;i++)
        {
            lista[i] = lista[i] + i;
        }
    }
    
    /**
     * Método que devuelve el valor mínimo de la lista
     * 
     * @return Devuelve el valor mímo de la lista
     */
    public int obtenerMinimo()
    {
        // Almacenar el minimo.
        int minimo;
        // Inicializar el mínimo con el primer valor, si el array esta vacio será 0.
        minimo = lista[0];
        // Comparar cada elemento de la lista con el mínimo y si el valor accedido de la lista
        // es menor, este será el nuevo valor que tomará el mínimo.
        for (int i = 0;i < elementos;i++)
        {
            if (lista[i] < minimo)
                minimo = lista[i];
        }
        return minimo;
    }
    
    /**
     * Método que devuelve cuántos valores hay en lista que coincidan con el mínimo.
     * 
     * @return Devuelve el total de valores que coinciden con el mínimo.
     */
    public int cuantosMinimos()
    {
        // Para contar el numero de valores que conciden con el mínimo de la lista.
        int contadorMinimos;
        // Declarar variable para saber el valor del minimo de la lista.
        int minimo;
        // Obtener el mínimo.
        minimo = obtenerMinimo();
        // Inicializar el contador de minimos.
        contadorMinimos = 0;
        // Recorrer la lista y si algún elemento coincide con el mínimo
        // sumar 1 al contador de mínimos.
        for (int i = 0;i < elementos;i++)
        {
            if (lista[i] == minimo)
                contadorMinimos++;
        }
        return contadorMinimos;
    }
    
    /**
     * Método que devuelve un array con los valores mínimos de la lista
     * 
     * @return Devuelve un array con los valores minimos de la lista.
     */
    public int[] generarArrayMinimos()
    {
        // Para almacenar cuántos mínimos hay.
        int contadorMinimos;
        // Obtener el número de mínimos.
        contadorMinimos = cuantosMinimos();
        // Crear nuevo Array para el resultado con la dimension del número de mínimos.
        int[ ] resultado = new int[contadorMinimos];
        // Llenar el Array resultado con el valor del mínimo en cada posición.
        for (int i = 0;i < resultado.length;i++)
        {
            resultado[i] = obtenerMinimo();
        }
        return resultado;
    }
    
    /**
     * Método que borra del array lista los valores que sean múltiplos del parámetro.
     * 
     * @param valorMultiplo Se eliminarán del array los multiplos de este número.
     */
    public void borrarMultiplosDe(int valorMultiplo)
    {
        // Recorrer la lista y si el resto de la división entre el elemento de la 
        // lista y el parámetro pasado es 0 eliminar el elemento de la lista.
        for (int i = 0;i < lista.length;i++)
        {
            if (lista[i] % valorMultiplo == 0)
                borrarUno(i);
        }
    }
    
    /**
     * Método que borra el valor de un aray en la posición pasada como parámetro.
     * 
     * @param posicionAborrar Posición del valor que se quiere borrar.
     */
    private void borrarUno(int posicionAborrar)
    {
        // Para borrar el elemento de la posición pasada como parámetro.
        // Asignar 0 a la posición pasada de la lista.
        lista[posicionAborrar] = 0;
        //elementos--;
    }
    
    /**
     * Método que devuelve una cadena con la representación de la lista.
     * 
     * @return Devuelve la representación de la lista.
     */
    public String toString()
    {
        String Rlista = "";
        for (int i = 0; i < elementos; i++)//Cargar el string a devolver
        {
            if (lista[i] != 0)
            {
                Rlista = Rlista + lista[i];//Carga en cada interacción el valor de la posicion.
                if(i != getTotalNumeros() - 1)
                    Rlista = Rlista +  ",";
            }
        }
        return "{" + Rlista + "}";
    }
    
    /**
     * Método que muestra en pantalla la lista.
     * 
     */
    public void escribirLista()
    {
        System.out.println(toString());
    }
    
    /**
     * Método que devuelve una copia de la lista(posiciones ocupadas)
     */
    public int [] copiar()
    {
        //int[] resultado = new int[elementos];
        int nuevaDimension;
        int j ;//para recorrer el Array resultado;
        j = 0;
        nuevaDimension = getTotalNumeros();
        int [] resultadoAux = Arrays.copyOf(lista, elementos);
        int [] resultado = new int [nuevaDimension];
        for (int i = 0; i < resultadoAux.length; i++)
        {
            if (resultadoAux[i] != 0 )
                {
                    resultado[j] = resultadoAux[i];
                    j++;
                }
        }
        return resultado;
    }
    
    /**
     * Método que devuelve una cadena con los valores comprendidos en el rango 
     * pasado por parámetro(inicio, fin) sin incluir el final.
     * 
     * @param from Parámetro que indica desde que posición se empieza a copiar la lista.
     * @param to Parámetro que indica hasta donde hay que copiar la lista.
     */
    public String copiarRango(int from, int to)
    {
        String resultado;
        if (indiceCorrecto(from))
            {
                resultado = "{";
                if (to > lista.length)
                    resultado = resultado + lista[getTotalNumeros()-1] + "}";
                else
                    {
                        for (int i = from; i < to; i++)//Cargar el string a devolver
                        {
                            if (i == from )
                                resultado = resultado + lista[i];
                            else
                                resultado = resultado + "," + lista[i];
                        }
                        return resultado + "}";
                    }
            }
        else
            resultado = "Indice incorrecto. No se ha podido copiar";
            return resultado ;
    }
    
    /**
     * Método que comprueba si un valor pasado es mayor que 0.
     * 
     * @param pos Parámetro para pasar el valor a evaluar.
     * @return Devuelve booleano con el resultado de la evaluación.
     */
    public boolean indiceCorrecto(int pos)
    {
        return pos>=0;
    }
}
