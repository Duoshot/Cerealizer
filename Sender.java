import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;
import org.jdom2.output.Format;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.*;

public class Sender
{
  private static Network network = null;
  private static Serializer serializer = null;
  private static ObjectCreator objCreator = null;

  private static int fileCount = 0;

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
        File sendFile = XMLtoFile(doc);
        network.send(sendFile);
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

  public static File XMLtoFile(Document doc) throws IOException {
    XMLOutputter xmlOutput = new XMLOutputter();

    xmlOutput.setFormat(Format.getPrettyFormat());
    File sendFile = new File("sentFile.xml");
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(sendFile));

    xmlOutput.output(doc, bufferedWriter);
    bufferedWriter.close();

    return sendFile;
  }


  public static void exit() throws IOException
  {
    network.disconnect();
    connected = false;
  }
}
