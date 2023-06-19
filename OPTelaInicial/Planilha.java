package OPTelaInicial;
import Model.Empresa;
import Model.Funcionario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Planilha {
    public Planilha(){};

    public void gerarPlanilha(Empresa empresa){

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        Font columnNameFont = workbook.createFont();
        columnNameFont.setBold(true);
        columnNameFont.setFontHeightInPoints((short) 12);


        CellStyle columnNameStyle = workbook.createCellStyle();
        columnNameStyle.setFont(columnNameFont);

        ArrayList<String> cols = new ArrayList<>();
        cols.add("Nome");
        cols.add("Idade");
        cols.add("CPF");
        cols.add("Cargo");
        cols.add("Salario");
        cols.add("Bonus");
        cols.add("Total");
        cols.add("Tipo");
        //Criação das colunas
        Row row = sheet.createRow(0);
        for (int i = 0; i < cols.size(); i ++){
            Cell columnNameCell = row.createCell(i);
            columnNameCell.setCellValue(cols.get(i));
            columnNameCell.setCellStyle(columnNameStyle);
        }

        //escrever dados dos funcionários
        for (int i = 1; i <= empresa.getFuncionarios().size(); i++) {
            Row newRow = sheet.createRow(i);
            Funcionario funcionario = empresa.getFuncionarios().get(i - 1);

            Cell nome = newRow.createCell(0);
            nome.setCellValue(funcionario.getNome());

            Cell idade = newRow.createCell(1);
            idade.setCellValue(funcionario.getIdade());

            Cell cpf = newRow.createCell(2);
            cpf.setCellValue(funcionario.getCpf());

            Cell cargo = newRow.createCell(3);
            cargo.setCellValue(funcionario.getCargo());

            Cell salario = newRow.createCell(4);
            salario.setCellValue(funcionario.getSalario());

            Cell bonus = newRow.createCell(5);
            bonus.setCellValue(funcionario.getBonus());

            Cell total = newRow.createCell(6);
            total.setCellValue(funcionario.calcSalario());

            Cell tipo = newRow.createCell(7);
            tipo.setCellValue(funcionario.getTipo());


        }


        // gerar documento
        try (FileOutputStream fileOut = new FileOutputStream("planilha.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Planilha gerada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
