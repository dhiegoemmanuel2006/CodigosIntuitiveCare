package Teste01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DownloadPDF {
     public static void main(String[] args) throws IOException {
         String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";

         Document doc = Jsoup.connect(url).get();
         Elements PDFs = doc.select("a:contains(Anexo I.), a:contains(Anexo II.)");

         int count = 0;
         for(Element PDF : PDFs) {
             String urlArquivo = PDF.attr("href");
             byte[] dataAsByte;
             try(InputStream inputStream = new URL(urlArquivo).openStream(); OutputStream outputStream = new FileOutputStream("c:\\resultados\\anexo"+ ++count + ".pdf")){
                 dataAsByte = inputStream.readAllBytes();
                 outputStream.write(dataAsByte);
             }
             catch(IOException e){
                 System.out.println("Erro durante leitura e escrita do arquivo");
             }

             if(count == 2) break;
         }

         try(
                 ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("c:\\resultados\\anexos.zip"))){
             int countZip = 0;
             for(Element PDF : PDFs) {
                 String urlArquivo = PDF.attr("href");
                 byte[] dataAsByte;
                 try(InputStream inputStream = new URL(urlArquivo).openStream()){
                     dataAsByte = inputStream.readAllBytes();
                     zipOutputStream.putNextEntry(new ZipEntry("anexo"+ ++countZip + ".pdf"));
                     zipOutputStream.write(dataAsByte);
                 }
             }
         }
     }

}
