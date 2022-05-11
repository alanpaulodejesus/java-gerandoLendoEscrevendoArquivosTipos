package ArquivosCsv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivoCsv {

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream entradaDadoArquivo = new FileInputStream(new File("ArquivosCsv/arquivo.csv"));

        Scanner lerArquivo = new Scanner(entradaDadoArquivo, "UTF-8");

        while (lerArquivo.hasNext()){
            String linha = lerArquivo.nextLine();

            if(linha!= null&& ! linha.isEmpty()){ //Ignora linha em branco
                System.out.println(linha);
            }
        }
    }
}
