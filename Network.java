import java.io.OutputStream;
import java.net.Socket;
import java.io.IOException;

public class Network
{
  private Socket socket = null;
  private int port = 4321;
  private String ip = "localhost";

  public void send(String message)
  {
    if(socket == null)
      connect();

    if(socket != null && socket.isConnected())
    {
        try
        {
         OutputStream outstream = socket.getOutputStream();
          outstream.write(message.getBytes());
          outstream.flush();
        }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
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
    //socket.close() or something like that
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
