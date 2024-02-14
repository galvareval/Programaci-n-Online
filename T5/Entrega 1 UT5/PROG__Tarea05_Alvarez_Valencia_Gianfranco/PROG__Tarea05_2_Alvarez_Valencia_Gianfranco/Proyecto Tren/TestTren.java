
/**
 * Esta clase para probar el proyecto tren
 * 
 * @author (Gianfranco Álvarez Valencia) 
 * @version (01_18_01_2021)
 */
public class TestTren
{
    /**
     *  Método main, contiene las sentencias necesarias para testear la aplicación.
     */
    public static void main(String[] args)
    {
        // Objetos de la clase vagon.
        Vagon v0;
        Vagon v1;
        Vagon v2;
        Vagon v3;
        Vagon v4Borrar;
        Vagon v5;
        Vagon v6;
        Vagon v7;
        Vagon v8;
        Vagon v9;
        Vagon v10;
        Vagon v11;
        Vagon v12;
        // Objeto de la clase Tren.
        Tren ave;
        ave = new Tren();
        // Crear los objetos vagon.
        v0 = new Vagon(1);
        v1 = new Vagon(1);
        v2 = new Vagon(1);
        // Imprimir los asientos del vagon 1.
        System.out.println("\t*Imprimir los asientos del vagon 0 ");
        v0.printDetallesVagon();
        // Imprimir precio ticket del asiento 0 del vagon 1.
        System.out.println("\t*Imprimir precio ticket del asiento 0, no comprado, del vagon 0.");
        v0.printTicket(0);
        // Imprimir precio del asiento 2 del vagon 1, no existe el asiento.
        System.out.println("\t*Imprimir precio del asiento 2 del vagon 0, fuera de rango.");
        v0.printTicket(2);
        // Imprimir precio del asiento -2 del vagon 1, no existe el asiento.
        System.out.println("\t*Imprimir precio del asiento -2 del vagon 0, fuera de rango.");
        v0.printTicket(-2);
        // Prueba métodos Tren
        System.out.println("\t*Añadir v0,v1. v2 al Tren: ");
        // Añadir los vagones al tren.
        ave.añadirVagon(v0);
        ave.añadirVagon(v1);
        ave.añadirVagon(v2);
        // Imprimir los vagones del tren.
        System.out.println("\t*Imprimir los vagones del tren");
        ave.printListaVagones();
        // Reservar asiento en primero vagon disponible.
        System.out.println("\t*Emitir un ticket en el primer vagon: 1ºvez");
        ave.emitirTicket();
        System.out.println("\t*Emitir un ticket en el primer vagon: 2ºvez");
        ave.emitirTicket();
        System.out.println("\t*Emitir un ticket en el primer vagon: 3ºvez");
        ave.emitirTicket();
        System.out.println("\t*Emitir un ticket en el primer vagon: 4ºvez");
        // Imprimir el 4 intento de comprar tiicket, no se puede = false.
        System.out.println("\t*Como no se puede comprar ticket devuelve: " + ave.emitirTicket());
        // Precio medio de los asientos vendidos del primer vagón.
        System.out.println("\t*Precio medio de los asientos del vagón 0: " + v0.getPrecioMedio());
        // Nuevo vagón para ver precio medio sin asientos vendidos.
        System.out.println("\t*Nuevo vagón con asientos sin vender, v3");
        System.out.println("\t*Crear el vagón v3 .");
        v3 = new Vagon(5);
        v3.printDetallesVagon();
        System.out.println("\t*Precio medio sin asientos vendidos del vagon 3: " + v3.getPrecioMedio());
        // Reservar un asiento del vagón 3 para  luego devolverlo.
        System.out.println("\t*Reservar un asiento del vagón 3 para  luego devolverlo: ");
        v3.reservarSiguienteAsiento();
        // Devolver asiento vendido.
        System.out.println("\t*Devolver el asiento 0 de v3, resultado: " + v3.reembolsarAsiento(0));
        // Devolver asiento no vendido
        System.out.println("\t*Devolver el asiento 1 de v3, no vendido,  resultado: " + v3.reembolsarAsiento(0));
        System.out.println("\t*Devolver asiento (10) de v3 fuera del rango, resultado: "+ v3.reembolsarAsiento(10));
        System.out.println("\t*Devolver asiento (-10) de v3 fuera del rango, resultado: "+ v3.reembolsarAsiento(-10));
        // Borrar un vagon
        // Nuevo vagon alamacenar vagon borrado.
        v4Borrar = new Vagon(3);
        // Añadir el vagón v3 al tren.
        System.out.println("\t*Añadir v3 al tren: ");
        ave.añadirVagon(v3);
        System.out.println("\t*Estado del tren antes de borrar: ");
        ave.printListaVagones();
        v4Borrar = ave.borrarVagon(3);
        System.out.println("\t*Borrar el vagón v3");
        System.out.println("\t*Estado del tren después de borrar v3: ");
        ave.printListaVagones();
        System.out.println("\t*El vagón borrado: ");// Se alamcena en un objeto vagon.
        v4Borrar.printDetallesVagon();
        //Añadir 6 vagones al tren
        System.out.println("\t*Añadir vagones al tren para comprobar límite: ");
        v5 = new Vagon(2);
        v6 = new Vagon(4);
        v7 = new Vagon(6);
        v8 = new Vagon(28);
        v9 = new Vagon(10);
        v10 = new Vagon(12);
        v11 = new Vagon(19);
        v12 = new Vagon(16);
        ave.añadirVagon(v5);
        ave.añadirVagon(v6);
        ave.añadirVagon(v7);
        ave.añadirVagon(v8);
        ave.añadirVagon(v9);
        ave.añadirVagon(v10);
        ave.añadirVagon(v11);
        ave.añadirVagon(v12);
        System.out.println("\t*Estado del tren después de añadir los vagones: ");
        ave.printListaVagones();
        System.out.println("\t*Intentado borrar fuera del rago: ");// ya que cuenta la psición 0.
        v4Borrar = ave.borrarVagon(10);
        System.out.println("\t*Estado del tren después de borrar v10: ");
        ave.printListaVagones();
        System.out.println("\t*Ordenar Vagones metodo borrar: ");
        ave.ordenarVagones();
        System.out.println("\t*Estado del tren después de ordenar: ");
        ave.printListaVagones();
        System.out.println("\t*Ordenar Vagones metodo isercción directa: ");
        // Crear un nuevo tren av2 y añadir los vagones: 
        System.out.println("\t*Crear un nuevo tren av2 y añadir los vagones: ");
        // Declarar nuevos objetos tren y vagones.
        Tren ave2;
        ave2 = new Tren();
        Vagon v2_0;
        Vagon v2_1;
        Vagon v2_2;
        Vagon v2_3;
        Vagon v2_4;
        Vagon v2_5;
        Vagon v2_6;
        Vagon v2_7;
        Vagon v2_8;
        Vagon v2_9;
        Vagon v2_10;
        Vagon vNulo;
        v2_0 = new Vagon(52);
        v2_1 = new Vagon(32);
        v2_2 = new Vagon(14);
        v2_3 = new Vagon(23);
        v2_4 = new Vagon(11);
        v2_5 = new Vagon(18);
        v2_6 = new Vagon(16);
        v2_7 = new Vagon(30);
        v2_8 = new Vagon(1);
        v2_9 = new Vagon(8);
        v2_10 = new Vagon(19);
        vNulo = null;
        // Añadir los vagones al tren
        ave2.añadirVagon(v2_0);
	ave2.añadirVagon(v2_1);
	ave2.añadirVagon(v2_2);
	ave2.añadirVagon(v2_3);
	ave2.añadirVagon(v2_4);
	ave2.añadirVagon(v2_5);
	ave2.añadirVagon(v2_6);
	ave2.añadirVagon(v2_7);
	ave2.añadirVagon(v2_8);
	ave2.añadirVagon(v2_9);
	ave2.añadirVagon(v2_10);
        System.out.println("\t*Estado del tren : ");
        ave2.printListaVagones();
        System.out.println("\t*Estado del tren después de ordenar por selección directa: ");
        ave2.ordenarVagonesPorSeleccionDirecta();
        ave2.printListaVagones();
        System.out.println("\t*Comprar varios ticket en un vagon: ");
        v2_0.reservarSiguienteAsiento();
        v2_0.reservarSiguienteAsiento();
        v2_0.reservarSiguienteAsiento();
        v2_0.reservarSiguienteAsiento();
        v2_0.reservarSiguienteAsiento();
        v2_0.reservarSiguienteAsiento();
        ave2.añadirVagon(vNulo);
    }
}
