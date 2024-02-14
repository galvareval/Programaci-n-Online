/**
 * Esta clase maneja los vagones de un tren,cada objeto sera identificado como un vagón único.
 * Los vagones tienen asientos, siendo el primero de ellos el de la posición 0.
 * 
 * @author (Gianfranco Álvarez Valencia) 
 * @version (01_18_01_2021)
 */
 public class Tren
{
    // Máxima dimensión del tren.
    private final int MAX_VAGONES = 10;
    // Declaración del array para almacenar los vagones que tendrá el tren.
    private Vagon [] vagones;
    // Almacenar el último vagón.
    private int ultimoVagon;
    
    /**
     *  Constructor de objetos para la clase Tren.
     * 	
     * 
     */
    public Tren ()
    {
        // Crear un array de objetos Vagon de dimension MAX_VAGONES.
    	vagones = new Vagon [MAX_VAGONES];
    	ultimoVagon = -1;
    }
     
    /**
    * Método que devuelve el número actual de vagones.
    * 
    * @return Devuelve el número de vagones que tiene el tren.
    */
    public int getNumeroVagon()
    {
        // Si el vagon ha sido ordenado ressetear.
        if (ultimoVagon == -2)
            ultimoVagon = -1;
    	return ultimoVagon;
    }

    /**
     * Método que recibe como parámetro un objeto Vagon y lo añade al tren.
     * 
     * @param Parámetro para pasar un objeto Vagon al tren.
     */
    public void añadirVagon(Vagon addVagon)
    {
        // Comprobar que existe el vagon a ñadir y que hay sitio en el tren para añadirlo.
        if ((addVagon != null) && (getNumeroVagon()+1 <10 ))
    	{
            //Añadir a la última posición.
            vagones[ultimoVagon + 1] = addVagon;
            // Sumar 1 para el siguiente vagon a añadir.
            ultimoVagon++;
    	}
    	else
        	{
                	if (addVagon == null)
                        System.out.println("No añadido, es un vagon nulo.");
                        else
                        {
                            addVagon.printDetallesVagon();
                            System.out.println("No añadido, fuera de rango");
                        }
                }
    }
	
    /**
     * Método que borra el vagón de una posición del tren pasada como parámetro y devuelve el vagón borrado.
     * 
     * @param Parámetro para pasar la posición del vagón en el tren.
     * @return Devuvle el objeto vagon borrado.
     * 
     */
    public Vagon borrarVagon(int posVagon)
    {
        // objeto vagon auxiliar para guardar el vagon borrado.
    	Vagon vagonAborrar;
    	// Inicializar a vacio.
    	vagonAborrar = null;
        // Comprobar que la posición pasada está dentro del rango permitido.
    	if ((posVagon >= 0) && (posVagon < MAX_VAGONES))
    	{
    	   vagonAborrar = vagones[posVagon];
    	   vagones[posVagon] = null;
    	   ultimoVagon--;
        }
        else
            System.out.println("Posición del vagón fuera del rango, no se puede borrar");
        // Devovler el vagonBorrado.
        return vagonAborrar;
    }	
    
    /**
     * Método que escribe por pantalla la información del tren. 
     */
    public void printListaVagones()
    {
        if (ultimoVagon == -1)
            System.out.println("El tren no tiene vagones");
        else
            for (int i = 0;i < vagones.length;i++)
            {
                // Saltar los nulos.
                if (vagones[i] != null)
                    vagones[i].printDetallesVagon();
                    
            }
    }
    
    /**
     * Método que devuelve un valor booleano en caso de poder reservar un asiento en un vagon del tren.
     * 
     * @return Devuelve un booleano en funcion de si se ha podido reservar asiento o no.
     */
    public boolean emitirTicket()
    {
        // Almacenar el estado de la compra.
        boolean ticketvendido;
        // Inicializar en false, para el primer intento de compra.
        ticketvendido = false;
        // Para recorrer los vagones del tren.
        for (int i = 0;i <= getNumeroVagon();i++)
        {
            // Si no se ha vendido ticket en el vaogn en el que se intenta comprar.
            if (ticketvendido == false)
            {
                // Si se vende se asigna true, de lo contrario false.
                ticketvendido = vagones[i].reservarSiguienteAsiento();
            }
        }
        return ticketvendido;
    }
    
    /**
     * Método que ordena los vagones del tren en base a su capacidad de mayor a menor capacidad.
     */
    public void ordenarVagones() 
    {
        // Almacenar el mayort idice.
        int indiceMayorVagon;
        // inicializar a 0.
        indiceMayorVagon = 0;
        // Objeto Vagon para poder borrar un vagón.
        Vagon vagonBorrado;
        // Nuevo Array de objetos Vagon.
        Vagon [] temporal;
        // Establecer dimesión.
        temporal = new Vagon [MAX_VAGONES];
        for (int i = 0;i < vagones.length ;i++)
        {
            // Buscar el de indice mayor.
            indiceMayorVagon = buscarIndiceDelMayor();
            //Asignar al temporal el valor del mayor.
            temporal [i] = vagones [indiceMayorVagon];
            // Borrar del tren
            vagonBorrado = borrarVagon(indiceMayorVagon);
        }
        // Asignar al atributo vagones el temporal ordenado.
        vagones = temporal;
        // como se han borrado todos al ordenar los vagones el tren estará vacio, el último elemtno será -1.
        // -2 para diferenciarlo de un tren en estado vacío.
        ultimoVagon = -2;
    }
    
    /**
     * Método que detecta el vagón de mayor capacidad y devuelve su posición.
     * 
     * @return Devuelve la posición del vagón de mayor capacidad.
     */
    private int buscarIndiceDelMayor()
    {
        // Para almacenar el indice de mayor capacidad y para almacenar y comparar la capacida.
        // inicializar a 0.
        int indiceMayorCapacidad, vagonMasCapacidad;
        indiceMayorCapacidad = 0;
        vagonMasCapacidad = vagones[0].getCapacidad();
        for (int i = 0;i < vagones.length ;i++)
        {
            // No tener encuenta los vagones borrados.
            if (vagones[i] != null)
            // Buscar el de más capacidad y asignar a la variable que lo almacena.
            // Almacenar el ínidice del que tiene más capacidad.
                if (vagones[i].getCapacidad() >= vagonMasCapacidad)
                    {
                        vagonMasCapacidad = vagones[i].getCapacidad();
                        indiceMayorCapacidad = i;
                    }
        }
        return indiceMayorCapacidad;
    }
    
    /**
     * Método que rdena todos los vagones del tren en base a su capacidad, 
     * de mayor a menor capacidad, utilizando el método de ordenación por selección directa.
     */
    public void ordenarVagonesPorSeleccionDirecta()
    {
        int posMin;
        Vagon aux_vagon;
        for (int i = 0;i < vagones.length;i++)
        {
            posMin = i;
            for (int j = i + 1;j <vagones.length;j++)
            {
                //Comparar para establecer el orden de mayor a menor.
                if (vagones[j].getCapacidad() > vagones[posMin].getCapacidad())
                    posMin = j;
            }
            aux_vagon = vagones[posMin];
            vagones[posMin] = vagones[i];
            vagones[i]=aux_vagon;
        }
    }
}