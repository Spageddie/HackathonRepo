import java.io.*;
import java.util.Properties;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.*;
import org.apache.tika.parser.pdf.*;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.microsoft.ooxml.OOXMLParser;//for word docs
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class PdfParse {

	public void parsePDF() throws IOException,TikaException,SAXException{
		BodyContentHandler handler = new BodyContentHandler();
	      Metadata metadata = new Metadata();
	      
	      File file = new File("C:/Users/baile/Documents/2018Hackathon/ChecksheetApp/ChecksheetApp/src/coe_ae_19.pdf");
	      
	      FileInputStream inputstream = new FileInputStream(file);
	      ParseContext pcontext = new ParseContext();
	      
	      //parsing the document using PDF parser
	      PDFParser pdfparser = new PDFParser(); 
	      pdfparser.parse(inputstream, handler, metadata,pcontext);
	      
	      //getting the content of the document
	      System.out.println("Contents of the PDF :" + handler.toString());
	      
	      //getting metadata of the document
	      System.out.println("Metadata of the PDF:");
	      String[] metadataNames = metadata.names();
	      
	      for(String name : metadataNames) {
	         System.out.println(name+ " : " + metadata.get(name));
	      }
	}
	
	public void parseWord() throws IOException,TikaException,SAXException{
		BodyContentHandler handler = new BodyContentHandler();
	      Metadata metadata = new Metadata();
	      FileInputStream inputstream = new FileInputStream(new File("C:/Users/baile/Documents/2018Hackathon/ChecksheetApp/ChecksheetApp/src/coe_ae_19.docx"));
	      ParseContext pcontext = new ParseContext();
	      
	      File output = new File("C:/Users/baile/Documents/2018Hackathon/ChecksheetApp/ChecksheetApp/src/output.txt");
	      
	      //OOXml parser
	      OOXMLParser  msofficeparser = new OOXMLParser (); 
	      msofficeparser.parse(inputstream, handler, metadata,pcontext);
	      System.out.println("Contents of the document:" + handler.toString());
	      System.out.println("Metadata of the document:");
	      String[] metadataNames = metadata.names();
	      
	      PrintWriter printer = new PrintWriter(output);
	      printer.print(handler.toString());
	      //output.close();
	      
	      /*for(String name : metadataNames) {
	         System.out.println(name + ": " + metadata.get(name));
	      }*/
	}
	
	public void converter(File file) throws TikaException, SAXException{
		try {
			InputStream input = new FileInputStream(file);
			ContentHandler handler = new BodyContentHandler();
			Metadata metadata = new Metadata();  
			metadata.add(Metadata.RESOURCE_NAME_KEY, file.getName());
			AutoDetectParser parser = new AutoDetectParser();
			parser.parse(input, handler, metadata);
			input.close();
			PrintStream output = new PrintStream("C:/Users/baile/Documents/2018Hackathon/ChecksheetApp/ChecksheetApp/src/testingInExcel.xlsx");
			output.println(handler.toString());
			output.close();
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
   public static void main(final String[] args) throws IOException,TikaException,SAXException {
	   
	   File file = new File("C:/Users/baile/Documents/2018Hackathon/ChecksheetApp/ChecksheetApp/src/coe_ae_19.docx");
	   
	   PdfParse parser = new PdfParse();
	   //parser.parseWord();
	   //parser.parsePDF();
	   parser.converter(file);
      
   }
}