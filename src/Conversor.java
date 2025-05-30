import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarTasaCambio conversor = new ConsultarTasaCambio();
        System.out.println("""
                 ____   _____   _   _  __    __ __    __
                | ___| | | | | |  \\| | \\ \\  / / \\ \\  / / CONVERSOR
                | |__  | |_| | |     |  \\ \\/ /   > >< <     DE
                \\____| |_____| |_|\\__|   \\__/   /_/  \\_\\  MONEDA
                """);
        System.out.println("Ingresa la moneda");
        var moneda = lectura.nextLine();
        ConversorAPI consulta = conversor.codigoBase(String.valueOf(moneda));
        System.out.println(consulta);
    }
}
