package Aplicacao;

import Entidades.ContratoPorHora;
import Entidades.Departamento;
import Entidades.Trabalhador;
import Entidades.enums.NivelDoTrabalho;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o nome do departamento: ");
        String nomeDerpatamento = sc.nextLine();
        System.out.println("Entre com os dados do trabalhador");
        System.out.print("Nome: ");
        String nomeTrabalhador = sc.nextLine();
        System.out.print("Nivel: ");
        String nivelTrabalhador = sc.nextLine();
        System.out.print("Salario base: ");
        double salarioBaseTrabalhador = sc.nextDouble();

        // Criando um objeto que é o trabalhador  
        Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelDoTrabalho.valueOf(nivelTrabalhador), salarioBaseTrabalhador, new Departamento(nomeDerpatamento));

        System.out.print("Quantos contratos esse trabalhador vai ter? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do contrato #" + i);
            System.out.print("Data (DD/MM/AAAA): ");
            sc.nextLine();  // Consumir a linha pendente
            Date dataContrato = sdf.parse(sc.nextLine());
            System.out.print("Valor por hora: ");
            double valorHora = sc.nextDouble();
            System.out.print("Duração do contrato (horas): ");
            int horas = sc.nextInt();

            ContratoPorHora contrato = new ContratoPorHora(dataContrato, valorHora, horas);
            trabalhador.adicionarContrato(contrato);
        }

        System.out.println();
        sc.nextLine();  // Consumir a linha pendente após o último nextInt()
        System.out.print("Para calcular a renda entre com o mes e o ano (MM/AAAA): ");
        String mesAno = sc.nextLine();

        if (mesAno.length() != 7 || mesAno.charAt(2) != '/') {
            System.out.println("Formato inválido. Use MM/AAAA.");
            return;
        }

        int mes = Integer.parseInt(mesAno.substring(0, 2));
        int ano = Integer.parseInt(mesAno.substring(3, 7));

        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        System.out.println("Nivel: " + trabalhador.getNivel());
        System.out.println("A renda de " + mesAno + " rendeu: " + String.format("%.2f", trabalhador.renda(ano, mes)));

        sc.close();
    }
}
