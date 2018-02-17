import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;  

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlForm; 
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLDocument;


public class Scient {

	public static void main(String[] args) throws Exception{
		
		String Abb = "";
		
		Abb= JOptionPane.showInputDialog("Enter the abbreviation of the major: ");
		
		final WebClient webClient = new WebClient();
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(false);
		
	    final HtmlPage page = webClient.getPage("https://registrar.vt.edu/graduation-multi-brief/checksheets/college/index.html");
	   
	    List<HtmlAnchor> anchors = new ArrayList<HtmlAnchor>();
	    anchors = page.getAnchors();
	    List<String> anchzz = new ArrayList<String>();
		for(int i=0; i<anchors.size(); i++)
		{
			anchzz.add(anchors.get(i).getHrefAttribute());
		}
		String findThis = "_" + Abb + "_";
		String Href = "";
		for(int i=0; i<anchzz.size(); i++)
		{
			if(anchzz.get(i).contains(findThis + "1") || anchzz.get(i).contains(findThis + "2"))
				Href = anchzz.get(i);
		}
		
		System.out.println(Href);
		
		final HtmlAnchor linkeroo = page.getAnchorByHref(Href);
	    
	    System.out.println(linkeroo.click().getWebResponse().getContentAsStream());		
	    
		webClient.close();

		//----------------------------------- Downloading File -------------------------------------------
		
		String filePart1 = "/Users/dtorn/Documents/Scient/Test_";
		String filePart2 = "_Checksheet.pdf";
		String fileName = filePart1 + Abb + filePart2;
		
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			// read this file into InputStream
			inputStream = linkeroo.click().getWebResponse().getContentAsStream();

			// write the inputStream to a FileOutputStream
			outputStream =
	                    new FileOutputStream(new File(fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			System.out.println("Done!");

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		

	} //end of main

}
