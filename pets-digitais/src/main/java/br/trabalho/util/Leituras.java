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

    public static String leNomeUnico(){
        String texto;

        while (true) {
            texto = scanner.nextLine().trim();

            if (texto.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]+$")) {
                return texto;
            }

            System.out.println("Erro! Digite uma palavra sem espaços que contenha pelo menos uma letra e um número.");
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
