import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;
import org.jdom2.output.Format;


import java.io.IOException;

import org.jdom2.*;

public class Sender
{
  private static Network network = null;
  private static Serializer serializer = null;
  private static ObjectCreator objCreator = null;

  public static boolean connected;

  public static void main(String[] args) throws IOException
  {
      initialize(args);

      while(connected)
      {
        Object obj = objCreator.createObject();

        if(!connected)
          continue;
        Document doc = serializer.serialize(obj);
        String XMLString = XMLtoString(doc);



        //network.send(XMLString);
      }
      exit();
  }

  public static void initialize(String[] args)
  {
    connected = true;
    network = new Network();
    serializer = new Serializer();
    objCreator = new ObjectCreator();

    if(args.length == 2)
    {
      network.setIP(args[0]);
      network.setPort(Integer.valueOf(args[1]));
    }
  }

  public static String XMLtoString(Document doc) throws IOException {
    XMLOutputter xmlOutput = new XMLOutputter();
    //return xmlOutput.outputString();

    xmlOutput.setFormat(Format.getPrettyFormat());
    xmlOutput.output(doc, System.out);

    return xmlOutput.toString();
  }

  public static void exit() throws IOException
  {
    network.disconnect();
    connected = false;
  }
}
