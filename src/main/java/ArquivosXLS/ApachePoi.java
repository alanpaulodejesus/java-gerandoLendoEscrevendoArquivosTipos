package ArquivosXLS;

import ArquivosCsv.Pessoa;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePoi {

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/java/ArquivosXLS/arquivoExcel.xls");

        if(!file.exists()){
            file.createNewFile();
        }

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

        List<Pessoa> pessoas=new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        HSSFWorkbook hssworkbook = new HSSFWorkbook();//Escreve a planilha
        HSSFSheet linhaPessoa = hssworkbook.createSheet("Planilha de pessoa excel");//Criar a planilha

        int numeroLinha =0;

        for (Pessoa p: pessoas) {
            Row linha = linhaPessoa.createRow(numeroLinha++);//cria linha na planilha

            int celula=0;

            Cell celNome = linha.createCell(celula++);
            celNome.setCellValue(p.getNome());

            Cell celEmail = linha.createCell(celula++);
            celEmail.setCellValue(p.getEmail());

            Cell celIdade = linha.createCell(celula++);
            celIdade.setCellValue(p.getIdade());
        }

        FileOutputStream saida = new FileOutputStream(file);
        hssworkbook.write(saida);//Escreve a planilha em arquivo

        saida.flush();
        saida.close();

        System.out.println("Planilha criada");
    }
}
