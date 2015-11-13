import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Gorman on 2015-11-08.
 */
public class SocketAcceptor
{

    private static ServerSocket serverSocket = null;
    private int port = 4321;

    public static boolean connected;

    public SocketAcceptor() throws IOException
    {
        serverSocket = new ServerSocket(port);
        connected = true;
        //default constructor


    }

    public File getFile() throws IOException
    {
        //serverSocket = new ServerSocket(port);
        while(true)
        {
            System.out.println("Waiting for client request");
            File rFile = new File("ReceivedData.xml");
            Socket rSocket = null;

            rSocket = serverSocket.accept();
            System.out.println("Receiver connected");

            receiveFile(rFile, rSocket);

            return rFile;
        }
    }

    public static void receiveFile(File aFile, Socket s) throws IOException, FileNotFoundException
    {
        InputStream inputStream = s.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(aFile);

        byte[] buffer = new byte[1000000];

        int bytesReceived = 0;

        System.out.println("Receiving file");

        while((bytesReceived = inputStream.read(buffer)) > 0)
        {
            outputStream.write(buffer, 0 ,bytesReceived);
        }

    }

    public static void disconnect() throws IOException
    {
        serverSocket.close();
    }
}
