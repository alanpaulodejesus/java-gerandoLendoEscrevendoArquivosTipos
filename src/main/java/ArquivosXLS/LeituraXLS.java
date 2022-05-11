package ArquivosXLS;

import ArquivosCsv.Pessoa;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeituraXLS {

    public static void main(String[] args) throws IOException {

        FileInputStream entrada = new FileInputStream(new File("src/main/java/ArquivosXLS/arquivoExcel.xls"));

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);//Prepara entrada de arquivo para ler

        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);//Pegando primeira planilha

        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa>pessoas=new ArrayList<Pessoa>();

        while (linhaIterator.hasNext()){//enquanto houver linha em excel
            Row linha = linhaIterator.next();
            Iterator<Cell> celula = linha.iterator();

            Pessoa pessoa = new Pessoa();

            while (celula.hasNext()){//enquanto houver celula
                Cell cell = celula.next();

                switch (cell.getColumnIndex()){
                    case 0: pessoa.setNome(cell.getStringCellValue());
                    break;
                    case 1: pessoa.setEmail(cell.getStringCellValue());
                    break;
                    case 2: pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
                    break;
                }
            }//fim celula da linha

            pessoas.add(pessoa);
        }

        entrada.close();//terminou de ler o arquivo

        for (Pessoa pessoa:pessoas){
          System.out.println(pessoa);
        }
    }
}
