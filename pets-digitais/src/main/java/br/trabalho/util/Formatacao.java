package br.trabalho.util;

public class Formatacao {

    public static void imprimirCentralizado(String texto, int largura) {
        int esquerda = (largura - texto.length()) / 2;
        int direita = largura - texto.length() - esquerda;

        System.out.printf("║%" + esquerda + "s%s%" + direita + "s║%n",
                "", texto, "");
    }

    private static final int LARGURA = 31;

    public static void imprimirLinha(String titulo, Object valor) {
        String texto = titulo + valor;
        System.out.printf("║%-" + LARGURA + "s║%n", texto);
    }

}


