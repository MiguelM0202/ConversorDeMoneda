package com.mm.convex.main;

import com.google.gson.JsonSyntaxException;
import com.mm.convex.modelos.manejo.ConsultarTasaCambio;
import com.mm.convex.modelos.api.ConversorAPI;
import com.mm.convex.modelos.manejo.Textos;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("#,###.##", simbolos);

        //Variables
        int seleccionMoneda = 0;
        int seleccionConversion = 0;
        int seleccionMenuSalida = 0;
        double valorConvercion = 0;
        boolean salida = false;
        boolean opcionSeleccionMonedaEntero = false;
        boolean opcionValorConversionEntero = false;
        boolean opcionSeleccionConversionEntero = false;
        boolean opcionSelecionMenuSalidaEntero = false;
        String opcion = "";
        String moneda = "";

        var textos = new Textos();

        //APP
        System.out.println(textos.getTituloApp() + "\nCargando datos del servidor...");
        Scanner lectura = new Scanner(System.in);
        ConsultarTasaCambio conversor = null;

        //com.mm.convex.modelos.api.TRM
        try {
            conversor = new ConsultarTasaCambio();
            System.out.println("Ultima actualización de la tasa de cambio: " +
                    conversor.fechaCorta());
        //CONVEX
            while (!salida) {

                //Moneda a CONVERTIR


                while (!opcionSeleccionMonedaEntero){
                    try {
                        while (seleccionMoneda != 9) {
                            System.out.println("\n" + textos.getMensajeSeleccionarMoneda() + "\n");
                            System.out.println(textos.getMenu());
                            seleccionMoneda = lectura.nextInt();
                            opcionSeleccionMonedaEntero = true;

                            if (seleccionMoneda == 1) {
                                moneda = "Pesos argentinos";
                                opcion = "ARS";
                                break;
                            }
                            if (seleccionMoneda == 2) {
                                moneda = "Bolivianos";
                                opcion = "BOB";
                                break;
                            }
                            if (seleccionMoneda == 3) {
                                moneda = "Reales";
                                opcion = "BRL";
                                break;
                            }
                            if (seleccionMoneda == 4) {
                                moneda = "Pesos chilenos";
                                opcion = "CLP";
                                break;
                            }
                            if (seleccionMoneda == 5) {
                                moneda = "Pesos colombianos";
                                opcion = "COP";
                                break;
                            }
                            if (seleccionMoneda == 6) {
                                moneda = "Dolares";
                                opcion = "USD";
                                break;
                            }
                            if (seleccionMoneda == 9) {
                                System.out.println(textos.getMensajeFinalPrograma() + " Gracias por usar\n" + textos.getTituloApp());
                                salida = true;
                                break;
                            }
                            if (seleccionMoneda != 1 / 6) {
                                System.out.println(textos.getOpcionInvalida());

                            }
                        }


                    } catch (InputMismatchException e) {
                        System.out.println("¡Error! \nIngresa un valor numerico");
                        lectura.nextLine();
                    }
                }

                opcionSeleccionMonedaEntero = false;
                System.out.println(moneda);
                ConversorAPI consulta = conversor.consultarBasePorCodigo(opcion);

                //Ingreso del VALOR


                while (!opcionValorConversionEntero) {
                    try {
                        System.out.println(textos.getMensajeIngresarValor());
                        valorConvercion = lectura.nextDouble();
                        opcionValorConversionEntero = true;
                    } catch (InputMismatchException e){
                        System.out.println("¡Error! \nIngresa un valor numerico");
                        lectura.nextLine();
                    }
                }

                opcionValorConversionEntero = false;
                String mensajeCadena = (formato.format(valorConvercion)) + textos.getEspacio() + moneda + textos.getEspacio() + textos.getComparativaValor();

                //Moneda para hacer la CONVERSIÓN


                while (!opcionSeleccionConversionEntero){
                    try {
                        while (seleccionConversion < 1) {
                            System.out.println("\nIngresaste " +
                                    (formato.format(valorConvercion)) + " " +
                                    moneda);
                            System.out.println("\n" + textos.getMensajeMonedaConversor() + "\n");
                            System.out.println(textos.getMenu());
                            seleccionConversion = lectura.nextInt();
                            opcionSeleccionConversionEntero = true;

                            switch (seleccionConversion) {
                                case 1:
                                    System.out.println(mensajeCadena +
                                            (formato.format(valorConvercion * consulta.conversion_rates().ARS())) +
                                            " pesos argentinos");
                                    break;
                                case 2:
                                    System.out.println(mensajeCadena +
                                            (formato.format(valorConvercion * consulta.conversion_rates().BOB())) +
                                            " Bolivianos");
                                    break;
                                case 3:
                                    System.out.println(mensajeCadena +
                                            (formato.format(valorConvercion * consulta.conversion_rates().BRL())) +
                                            " Reales");
                                    break;
                                case 4:
                                    System.out.println(mensajeCadena +
                                            (formato.format(valorConvercion * consulta.conversion_rates().CLP())) +
                                            " Pesos chilenos");
                                    break;
                                case 5:
                                    System.out.println(mensajeCadena +
                                            (formato.format(valorConvercion * consulta.conversion_rates().COP())) +
                                            " Pesos colombianos");
                                    break;
                                case 6:
                                    System.out.println(mensajeCadena +
                                            (formato.format(valorConvercion * consulta.conversion_rates().USD())) +
                                            " Dolares");
                                    break;
                                case 9:
                                    System.out.println("****** ¿Segurx quieres salir del programa? ******");
                                    break;

                                default:
                                    System.out.println(textos.getOpcionInvalida());
                                    seleccionConversion = 0;
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("¡Error! \nIngresa un valor numerico");
                        lectura.nextLine();
                    }
                }

                seleccionConversion = 0;
                seleccionMoneda = 0;
                moneda = "";
                opcion = "";
                lectura.nextLine();
                opcionSeleccionConversionEntero = false;

                //EXIT

                while (!opcionSelecionMenuSalidaEntero){
                    try {
                        while (seleccionMenuSalida != 7 || seleccionMenuSalida != 9) {
                            System.out.println("\n" + textos.getMenuSalida() + "\n");
                            seleccionMenuSalida = lectura.nextInt();
                            opcionSelecionMenuSalidaEntero = true;

                            if (seleccionMenuSalida == 7) {
                                lectura.nextLine();
                                break;
                            }
                            if (seleccionMenuSalida == 9) {
                                System.out.println(textos.getMensajeFinalPrograma() + " Gracias por usar\n" + textos.getTituloApp());
                                salida = true;
                                break;
                            }

                            System.out.println(textos.getOpcionInvalida());
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("¡Error! \nIngresa un valor numerico");
                        lectura.nextLine();
                    }
                }

                opcionSelecionMenuSalidaEntero = false;
            }

            lectura.close();

        } catch (IOException | InterruptedException e) {
            System.out.println("com.mm.convex.modelos.api.TRM actual no disponible");
            System.out.println(textos.getMensajeFinalPrograma());
        } catch (JsonSyntaxException ignored) {
        }
    }
}