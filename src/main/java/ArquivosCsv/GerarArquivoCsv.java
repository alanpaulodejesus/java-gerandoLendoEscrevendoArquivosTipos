package ArquivosCsv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerarArquivoCsv {

    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setEmail("pessoa1@gmail.com");
        pessoa1.setIdade(51);
        pessoa1.setNome("José");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setEmail("pessoa2@gmail.com");
        pessoa2.setIdade(52);
        pessoa2.setNome("José 2");

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setEmail("pessoa3@gmail.com");
        pessoa3.setIdade(53);
        pessoa3.setNome("José 3");

        List<Pessoa>pessoas=new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        File arquivo = new File("ArquivosCsv/arquivo.csv");

        if (arquivo.exists()){
            arquivo.createNewFile();
        }

        FileWriter escreverNoArquivo = new FileWriter(arquivo);

        for (Pessoa p:pessoas){
            escreverNoArquivo.write(p.getNome()+";"+p.getEmail()+";"+p.getIdade()+"\n");
        }

        /*
        for(int i=1; i<10; i++){
            escreverNoArquivo.write("Texto no Arquivo: "+i+"\n");
        }
         */

        escreverNoArquivo.flush();
        escreverNoArquivo.close();
    }
}
