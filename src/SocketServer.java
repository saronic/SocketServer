import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;


public class SocketServer {
	private static int count = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8889);
			while (true) {
				count++;
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
				System.out.println("===");
				Socket client = server.accept();
				System.out.println(count + " : " + sdf.format(System.currentTimeMillis()));
				if (client != null) {
					OutputStream out = client.getOutputStream();
					String msg = "Hello, Androi";
					out.write(msg.getBytes());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
