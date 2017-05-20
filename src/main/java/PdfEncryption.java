import java.io.FileOutputStream;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class PdfEncryption {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String outputPdfFile = "/Users/sachin/Desktop/testing.pdf";
			String userPassword = "testing_user";
			String ownerPassword ="testing_owner"; 
			String pdfContent = "This is the demonstration of the pdf password protection";
			Document document = new Document(PageSize.A4);
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPdfFile));
			writer.setEncryption(userPassword.getBytes(), ownerPassword.getBytes(),
					PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
			document.open();
			document.addAuthor("Sachin Srivastava");
			document.addCreator("Sachin Srivastava");
			document.addSubject("Thanks for your support");
			document.addTitle("Please read this");
			HTMLWorker htmlWorker = new HTMLWorker(document);
			htmlWorker.parse(new StringReader(pdfContent));
			document.close();
			writer.close();
			System.out.println("pdf created from content");
		} catch (Exception e) {
			System.out.println("error occured in creating pdf from content");
		}
	}

}
