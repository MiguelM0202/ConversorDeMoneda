package com.mm.convex.modelos.manejo;

public class Textos {

    //Mensajes
    private String mensajeSeleccionarMoneda = """
                ******  Selecciona la moneda A CONVERTIR ****** 
                (Selecciona una opcion del 1 al 6)""";
    private String mensajeIngresarValor = """
                ****** INGRESA EL VALOR A CONVERTIR ******
                """;
    private String mensajeMonedaConversor = """
                ****** Ahora selecciona la moneda con la que HAREMOS LA CONVERSIÓN ******
                (Selecciona una opcion del 1 al 6)""";
    private String mensajeFinalPrograma = "Finalizando programa...";
    private String opcionInvalida = """
                ** OPCIÓN NO DISPONIBLE **""";
    private String comparativaValor = " son: ";
    private String espacio = " ";

    //MENUS
    private String menuSalida = """
                
                ** Selecciona 7 ó 9 **
                7. Ingresar otro valor a convertir
                9. Para salir del programa""";
    private String menu = """
                1.ARS - Peso argentino
                2.BOB - Boliviano boliviano
                3.BRL - Real brasileño
                4.CLP - Peso chileno
                5.COP - Peso colombiano
                6.USD - Dólar estadounidense
                
                9. Para salir del programa

                """;

    private String tituloApp = """
                 ____   _____   _   _  __    __  ____   _    _\s
                | ___| |  _  | |  \\| | \\ \\  / / | ___| \\ \\  / / CONVERSOR
                | |__  | |_| | |     |  \\ \\/ /  | ___|  > >< <     DE
                \\____| |_____| |_|\\__|   \\__/   |____| /_/  \\_\\  MONEDA
                """;



    public String getMensajeSeleccionarMoneda() {
        return mensajeSeleccionarMoneda;
    }

    public String getMensajeIngresarValor() {
        return mensajeIngresarValor;
    }

    public String getMensajeMonedaConversor() {
        return mensajeMonedaConversor;
    }

    public String getMensajeFinalPrograma() {
        return mensajeFinalPrograma;
    }

    public String getOpcionInvalida() {
        return opcionInvalida;
    }

    public String getComparativaValor() {
        return comparativaValor;
    }

    public String getEspacio() {
        return espacio;
    }

    public String getMenuSalida() {
        return menuSalida;
    }

    public String getMenu() {
        return menu;
    }

    public String getTituloApp() {
        return tituloApp;
    }
}
