package br.trabalho.util;

import java.util.Scanner;

public class Leituras {

    private static Scanner scanner = new Scanner(System.in);

    public static String leFrase(){

        while (true) {
            String nome = scanner.nextLine().trim();

            if (nome.matches("[a-zA-ZÀ-ÿ ]+"))
                return nome;

            System.out.println("Digite apenas letras.");
        }
    }

    public static int leInt(){

        boolean valido = false;

        boolean entradaValida = false;
        int numero = 0;

        while (!entradaValida) {
            try {
                numero = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } 
            catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }

        return numero;
    }
}
