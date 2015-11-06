/**
 * Created by Gorman on 2015-11-04.
 */
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteXMLFile {

    public static void main(String[] args){

        try{

            // Out root element in file.xml is `company`
            Element company = new Element("company");
            Document doc = new Document();

            // Set the root element of the document to `company`
            doc.setRootElement(company);

            // Wanna see this root element ?
            System.out.println("Root element: " + doc.getRootElement());

            // Next Element is `staff`
            Element staff = new Element("staff");

            // BUT this element has an attribute. This is how you set it:
            staff.setAttribute(new Attribute("id", "1"));

            // Add content to the staff element
            staff.addContent(new Element("firstname").setText("ryan"));
            staff.addContent(new Element("lastname").setText("eggold"));
            staff.addContent(new Element("salary").setText("1999999"));

            // Now you're adding all of this content to the root element
            doc.getRootElement().addContent(staff);

            // Next staff
            Element staff2 = new Element("staff");

            staff2.setAttribute(new Attribute("id", "2"));

            staff2.addContent(new Element("firstname").setText("megan"));
            staff2.addContent(new Element("lastname").setText("boone"));
            staff2.addContent(new Element("salary").setText("1888888"));

            doc.getRootElement().addContent(staff2);

            XMLOutputter xmlOutput = new XMLOutputter();

            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, System.out);

            // Use this if you want to save output it in a file
            //xmlOutput.output(doc, new FileWriter("newfile.xml"));
            System.out.println("File Saved");


        }catch(Exception e){

        }

    }

}
