package Application;

import Model.Entity.CarRental;
import Model.Entity.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String CarModel = sc.nextLine();
        System.out.println("Retirada (dd/mm/aaaa hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(),formatter);
        System.out.println("Retorno (dd/mm/aaaa hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),formatter);

        CarRental cr = new CarRental(start, finish, new Vehicle(CarModel));

        sc.close();
    }
}
