import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.pdfcrowd.Client;
import com.pdfcrowd.PdfcrowdError;

public class PDF2HTML {
	public static void main(String[] args) {
        try 
        {
            FileOutputStream fileStream;     
 
            // create an API client instance
            Client client = new Client("sks1130", "3369455a47e27ae6f03e7fbeba0b163d");

            // convert a web page and save the PDF to a file
            fileStream = new FileOutputStream(new File("/Users/sachin/Desktop/test.pdf"));
            client.convertURI("/Users/sachin/Desktop/", fileStream);
            fileStream.close();

            // convert an HTML string and store the PDF into a byte array
            ByteArrayOutputStream memStream  = new ByteArrayOutputStream();
            String html = "<html><body>In-memory HTML.</body></html>";
            client.convertHtml(html, memStream);

            // convert an HTML file
            fileStream = new FileOutputStream("file.pdf");
            client.convertFile("/Users/sachin/Desktop/test.html", fileStream);
            fileStream.close();

            // retrieve the number of credits in your account
            Integer ncredits = client.numTokens();
        }
        catch(PdfcrowdError why) {
            System.err.println(why.getMessage());
        }
        catch(IOException exc) {
            // handle the exception
        }
    }
}
