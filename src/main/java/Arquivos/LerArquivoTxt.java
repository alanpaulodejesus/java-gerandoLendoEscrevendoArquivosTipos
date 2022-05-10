package Arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivoTxt {

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream entradaDadoArquivo = new FileInputStream(new File("src/main/java/Arquivos/arquivo.txt"));

        Scanner lerArquivo = new Scanner(entradaDadoArquivo, "UTF-8");

        while (lerArquivo.hasNext()){
            String linha = lerArquivo.nextLine();

            if(linha!= null&& ! linha.isEmpty()){ //Ignora linha em branco
                System.out.println(linha);
            }
        }
    }
}
