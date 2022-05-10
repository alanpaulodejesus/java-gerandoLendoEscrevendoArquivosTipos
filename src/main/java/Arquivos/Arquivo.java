package Arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

    public static void main(String[] args) throws IOException {
        File arquivo = new File("src/main/java/Arquivos/arquivo.txt");

        if (arquivo.exists()){
            arquivo.createNewFile();
        }
        FileWriter escreverNoArquivo = new FileWriter(arquivo);
        escreverNoArquivo.write("Texto no Arquivo");
        escreverNoArquivo.write("\n");
        escreverNoArquivo.write("Minha segunda linha");
        escreverNoArquivo.write("\n");

        for(int i=1; i<10; i++){
            escreverNoArquivo.write("Texto no Arquivo: "+i+"\n");
        }

        escreverNoArquivo.flush();
        escreverNoArquivo.close();
    }
}
