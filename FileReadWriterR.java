import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

public class FileReadWriterR {

	public static void main(String[] args) {
		try {
			/******
			 * InputStream
			 *******/
            FileInputStream fis = new FileInputStream("G:\\works\\wk_java\\MyTest.gwt.xml");
            InputStreamReader isr = new InputStreamReader(fis, "Shift-JIS");

            /******
             * OutputStream
             *******/
            FileOutputStream fos = new FileOutputStream("G:\\works\\wk_java\\output1.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);

            /******
             * InputXML
             *******/
            XMLInputFactory ixml = XMLInputFactory.newInstance();
            ixml.createXMLEventReader(isr);

            /*****
             * BufferedRead
             ******/
            BufferedReader br = new BufferedReader(isr);

            /*****
             * read & write
             ******/
            PrintWriter pw = new PrintWriter(osw);
            String ch;
            while ((ch = br.readLine()) != null) {
            	pw.println(ch);
            	//System.out.println(ch);
            	ch = br.readLine();
            }
            isr.close();
            osw.close();
		} catch (IOException | XMLStreamException e) {
            System.out.println(e);
        }
	}
}
