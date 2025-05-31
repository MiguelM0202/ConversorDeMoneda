import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarTasaCambio conversor = new ConsultarTasaCambio();
        System.out.println("""
                 ____   _____   _   _  __    __  ____  __    __
                | ___| |  _  | |  \\| | \\ \\  / / | ___| \\ \\  / / CONVERSOR
                | |__  | |_| | |     |  \\ \\/ /  | ___|  > >< <     DE
                \\____| |_____| |_|\\__|   \\__/   |____| /_/  \\_\\  MONEDA
                """);
        System.out.println("Ingresa la moneda");
        var moneda = lectura.nextLine();
        ConversorAPI consulta = conversor.codigoBase(String.valueOf(moneda));
        System.out.println("El valor del "
                + moneda +
                " en pesos colombianos es: "
                +consulta.conversion_rates().COP());
    }
}
