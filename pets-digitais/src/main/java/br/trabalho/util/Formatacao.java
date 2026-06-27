package br.trabalho.util;

public class Formatacao {

    public static void centralizar(String texto, int largura) {

        int espacos = (largura - texto.length()) / 2;

        if (espacos < 0) {
            espacos = 0;
        }

        System.out.printf("%" + (espacos + texto.length()) + "s%n", texto);
    }

}
