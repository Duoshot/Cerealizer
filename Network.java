import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.File;

public class Network
{
  private Socket socket = null;
  private int port = 4321;
  private String ip = "localhost";

  public void send(File sendFile) throws IOException
  {
    if(socket == null || socket.isClosed())
    {
        socket = new Socket(ip, port);

    }
      //connect();

    if(socket != null && socket.isConnected())
    {
        try
        {
            OutputStream outstream = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(sendFile);
            byte[] buffer = new byte[1000000];
            int bytesRead = 0;

            while((bytesRead = fileInputStream.read(buffer)) > 0)
            {
                outstream.write(buffer,0,bytesRead);
            }

            fileInputStream.close();
            socket.close();
            System.out.println("Transfer complete");

        }
    catch(IOException e)
    {
      System.out.println("Something is closed" + e.getMessage());
    }
  }
    else
      System.out.println("Socket unavailable");
  }

  public void connect()
  {

    Sender sender = new Sender();
    try
    {
      socket = new Socket(ip, port);
      socket.setSoTimeout(500);
      sender.connected = true;
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
      sender.connected = false;
    }
  }

  public void disconnect() throws IOException
  {
    socket.close();
  }

  public void setIP(String ip)
  {
    this.ip = ip;
  }
  public void setPort(int port)
  {
    this.port = port;
  }
}
