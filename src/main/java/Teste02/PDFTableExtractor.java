package Teste02;

import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.*;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PDFTableExtractor {

    public static void main(String[] args) {
        String pdfPath = "c:\\resultados\\anexo1.pdf";
        String csvPath = "c:\\resultados\\result_teste2.csv";
        String zipPath = "c:\\resultados\\Teste_Dhiego.zip";

        try {
            List<String[]> tableData = extractTableFromPDF(pdfPath);
            replaceAbbreviations(tableData);
            writeCSV(csvPath, tableData);
            zipCSVFile(csvPath, zipPath);

            System.out.println("Processo concluído! Arquivo ZIP gerado: " + zipPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> extractTableFromPDF(String pdfPath) throws IOException {
        List<String[]> tableData = new ArrayList<>();


        try (PDDocument document = PDDocument.load(new File(pdfPath))) {

            SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm();


            for (int i = 0; i < document.getNumberOfPages(); i++) {
                Page page = new ObjectExtractor(document).extract(i+1);
                List<Table> tables = sea.extract(page);

                for (Table table : tables) {
                    List<List<RectangularTextContainer>> rows = table.getRows();

                    for (List<RectangularTextContainer> row : rows) {
                        List<String> rowData = new ArrayList<>();
                        for (RectangularTextContainer cell : row) {
                            rowData.add(cell.getText());
                        }
                        tableData.add(rowData.toArray(new String[0]));
                    }
                }
            }
        }

        return tableData;
    }

    private static void replaceAbbreviations(List<String[]> tableData) {
        for (String[] row : tableData) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] != null) {
                    row[i] = row[i].replace("OD", "Seg. Odontológica")
                            .replace("AMB", "Seg. Ambulatorial");
                }
            }
        }
    }

    private static void writeCSV(String csvPath, List<String[]> tableData) throws IOException {
        try (FileWriter writer = new FileWriter(csvPath)) {
            for (String[] row : tableData) {
                writer.write(String.join(",", row) + "\n");
            }
        }
    }

    private static void zipCSVFile(String csvPath, String zipPath) throws IOException {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath));
             FileInputStream fis = new FileInputStream(csvPath)) {
            ZipEntry zipEntry = new ZipEntry(new File(csvPath).getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
        }
    }
}