package Teste02;

import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.RectangularTextContainer;
import technology.tabula.Table;
import technology.tabula.extractors.BasicExtractionAlgorithm;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PDFTableExtractor {

    public static void main(String[] args) throws IOException {
        String table = "c:\\resultados\\anexo1.pdf";
        String csvOutput = "c:\\resultados\\resultado_teste.csv";

        List<String[]> tableInStrings = extractTableFromPDF(table);
        writeCSV(csvOutput, tableInStrings);
    }

    private static List<String[]> extractTableFromPDF(String pdfPath) throws IOException {
        List<String[]> tableData = new ArrayList<>();

        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
            ObjectExtractor extractor = new ObjectExtractor(document);
            BasicExtractionAlgorithm bea = new BasicExtractionAlgorithm();

            for (int i = 0; i < document.getNumberOfPages(); i++) {
                Page page = extractor.extract(i + 1);
                List<Table> tables = bea.extract(page);

                for (Table table : tables) {
                    for (List<RectangularTextContainer> row : table.getRows()) {
                        String[] rowData = row.stream()
                                .map(cell -> cleanText(cell.getText()))  // Nova função para limpeza
                                .toArray(String[]::new);
                        tableData.add(rowData);
                    }
                }
            }
        }
        return tableData;
    }


    private static String cleanText(String text) {
        if (text == null) return "";
        return text.trim()
                .replace("\r", " ")
                .replace("\n", " ")
                .replace("\t", " ");
    }

    private static void writeCSV(String csvPath, List<String[]> tableData) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath), StandardCharsets.UTF_8)) {

            writer.write('\uFEFF');

            for (String[] row : tableData) {
                String encodedRow = String.join(",",
                        java.util.Arrays.stream(row)
                                .map(field -> escapeSpecialCharacters(field))
                                .toArray(String[]::new));
                writer.write(encodedRow);
                writer.newLine();
            }
        }
    }


    private static String escapeSpecialCharacters(String field) {
        if (field == null) return "";
        if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        return field;
    }
}