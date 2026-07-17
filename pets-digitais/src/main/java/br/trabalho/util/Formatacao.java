package br.trabalho.util;

public class Formatacao {

    private static final int LARGURA = 37;

    public static void imprimirCentralizado(String texto) {
        if (texto == null)
            texto = "";

        int larguraInterna = LARGURA - 2;

        if (texto.length() > larguraInterna)
            texto = texto.substring(0, larguraInterna);

        int esquerda = (larguraInterna - texto.length()) / 2;
        int direita = larguraInterna - texto.length() - esquerda;

        System.out.printf("║%" + esquerda + "s%s%" + direita + "s║%n", "", texto, "");
    }

    public static void imprimirLinha(String titulo, Object valor) {
        String texto = titulo + ": " + valor;
        int larguraInterna = LARGURA - 2;

        if (texto.length() > larguraInterna)
            texto = texto.substring(0, larguraInterna);

        System.out.printf("║%-" + larguraInterna + "s║%n", texto);
    }

    public static void imprimirLinha(String titulo, String barra, String estado) {

        String texto = String.format("%-11s %s %-12s", titulo + ":", barra, estado);
        int larguraInterna = LARGURA - 2;

        if (texto.length() > larguraInterna)
            texto = texto.substring(0, larguraInterna);

        System.out.printf("║%-" + larguraInterna + "s║%n", texto);
    }

    public static String barra(int valor) {
        int total = 10;                 
        int preenchidos = valor / 10; 

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < preenchidos; i++) {
            sb.append("▓");
        }

        for (int i = preenchidos; i < total; i++) {
            sb.append("▒");
        }

        return sb.toString();
    }

    public static void imprimirLinhaVazia() {
        System.out.printf("║%-35s║%n", "");
    }

}


