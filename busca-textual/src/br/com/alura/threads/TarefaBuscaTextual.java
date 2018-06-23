package br.com.alura.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

    private String arquivo;
    private String nomeBusca;

    public TarefaBuscaTextual(String arquivo, String nomeBusca) {
        this.arquivo = arquivo;
        this.nomeBusca = nomeBusca;
    }

    @Override
    public void run() {

        try{

            Scanner scanner = new Scanner(new File(this.arquivo));

            int i = 1;
            while (scanner.hasNextLine()){
                String linha = scanner.nextLine();
                if(linha.toLowerCase().contains(this.nomeBusca.toLowerCase())){
                    System.out.println(this.arquivo + " - " + i + " - "+ linha);
                }
                i++;
            }

        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }

    }
}
