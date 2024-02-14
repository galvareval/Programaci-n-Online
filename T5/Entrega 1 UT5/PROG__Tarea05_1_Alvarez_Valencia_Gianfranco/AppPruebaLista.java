 
/**
 * Esta clase va a actuar es este caso como clase de prueba de los métodos
 * de ListaNumeros
 */
import javax.swing.JOptionPane;

public  class AppPruebaLista
{
     
    /**
     * 
     */
    public static void main(String[] args)
    {
         ListaNumeros lista = new ListaNumeros(20);
           
         int[] valores = { 2, 4, 6, 8, 12, 13,2, 2, 9};
         for (int i = 0; i < valores.length; i++)
            lista.añadirElemento(valores[i]);
            
         int totalElementos = lista.getTotalNumeros();
         
         String salida = "Lista después de crear y añadir { 2, 4, 6, 8, 12, 13, 2, 2, 9 } \n" +
                        lista.toString() + "\nTotal elementos en la lista " + totalElementos;
                        
         salida += "\nEl mínimo es " + lista.obtenerMinimo();
         int minimos = lista.cuantosMinimos();
         
         salida += "\nTotal mínimos " +  minimos;
         
         lista.borrarMultiplosDe(2);
         salida += "\nDespués de borrar los múltiplos de 2 " + lista.toString();
         
         int[] copia = lista.copiar();
         String str = "{ ";
         for (int i = 0; i < copia.length; i++)
            str += copia[i] + "  ";
         str += " }";
         salida += "\nLa copia ahora de la lista es " +  str;   
         //Crear nuevo objeto de ListaNumeros, copiaLista, para la copia y pasar mediante el constructor el array copiado antes.
         ListaNumeros copiaLista = new ListaNumeros(copia);
         copiaLista.sumarPosicion();
         salida += "\nDespués de sumar posición la lista queda " +  copiaLista.toString(); //imprimir la copia.
         
         lista = new ListaNumeros(20);
         for (int i = 0; i < valores.length; i++)
            lista.añadirElemento(valores[i]);
         salida += "\nLista después de crear y añadir ahora { 2, 4, 6, 8, 12, 13, 2, 2, 9 } \n" +
                        lista.toString() + "\nTotal elementos en la lista " + lista.getTotalNumeros();
         salida += "\nHacemos lista.copiarRango(0, 5) \n";               
         str = lista.copiarRango(0, 5);
         salida += str;
         
         
         salida += "\nHacemos lista.copiarRango(3, 8) \n";
         str = lista.copiarRango(3, 8);
         salida += str;
         
         salida += "\nHacemos lista.copiarRango(-10, 5) \n";
         str = lista.copiarRango(-10, 5);
         salida += str;
         
         salida += "\nHacemos lista.copiarRango(8, 25) \n";
         str = lista.copiarRango(8, 25);
         salida += str;
        
         salida += "\nHacemos lista.copiarRango(8, 8) \n";
         str = lista.copiarRango(8, 8);
         salida += str;
         JOptionPane.showMessageDialog(null, salida,
                                "Prueba de todos los métodos de la clase ListaNumeros",
                                JOptionPane.INFORMATION_MESSAGE);
    }
}
