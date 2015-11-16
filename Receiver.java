import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Gorman on 2015-11-05.
 * From Lee Ringham's code
 */
public class Receiver
{

    public static Deserializer deserializer = null;
    private static Visualizer visualizer = null;
    private static SocketAcceptor socketAcceptor = null;

    public static boolean connected;

    public static void main(String[] args) throws Exception {
        System.out.println("Initializing Receiver");
        connected = true;
        initialize(args);


        while(connected) {

            System.out.println("Connecting to Sender");
            File receiveFile = socketAcceptor.getFile();

            SAXBuilder saxBuilder = new SAXBuilder();
            Document doc = (Document) saxBuilder.build(receiveFile);



            if (!connected)
                continue;

            System.out.println("Visualizing");

            List objList = doc.getRootElement().getChildren();

            for(int i = 0; i < objList.size(); i++) {
                visualizer = new Visualizer();
                Object obj = Deserializer.deserialize(doc, Integer.toString(i));
                visualizer.inspect(obj, true);
            }
        }

        //exit();
    }

    public static void initialize(String[] args) throws IOException
    {
        deserializer = new Deserializer();
        visualizer = new Visualizer();
        socketAcceptor = new SocketAcceptor();
    }

    public static void exit() throws IOException
    {
        SocketAcceptor.disconnect();
        connected = false;
    }
}
