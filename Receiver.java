//import org.jdom2.Document;
//
///**
// * Created by Gorman on 2015-11-05.
// */
//public class Receiver
//{
//
//    public static Deserializer deserializer = null;
//    private static Visualizer visualizer = null;
//    private static SocketAcceptor socketAcceptor = null;
//
//    public static boolean connected;
//
//    public static void main(String[] args)
//    {
//        initialize(args);
//
//        while(connected) {
//            String message = socketAcceptor.getMessage();
//
//            if (!connected)
//                continue;
//
//            Document doc = deserializer.stringToDoc(message);
//            Object obj = deserializer.deserialize(doc);
//
//            visualizer.visualize(obj, true);
//
//        }
//
//        exit();
//    }
//
//    public static void initialize(String[] args)
//    {
//        conn
//    }
//}
