package br.com.alura.threads;

public class Principal {

    public static void main(String[] args) throws Exception{

        System.out.println("Isso é uma thread main");

        Thread.sleep(30000);

        System.out.println("Finalizando thread");

    }

}
