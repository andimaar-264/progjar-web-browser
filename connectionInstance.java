import java.io.BufferedInputStream;
import java.net.Socket;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class connectionInstance {
    connectionInstance(Socket socket, BufferedInputStream bis, BufferedOutputStream bos, String message) throws IOException{
        // socket uses the input from the textfield
            socket = new Socket("" + textfield.getText(), 80);

            bis = new BufferedInputStream(socket.getInputStream());
            bos = new BufferedOutputStream(socket.getOutputStream());
            
            sendResponse(socket, bis, bos, message);


            socket.close(); 
    }

    // Method
	// Will send a message to the socket.
    public void sendResponse(Socket socket, BufferedInputStream bis, BufferedOutputStream bos, String message) throws IOException{

        // exchange msg here
        bos.write(message.getBytes(), 0, message.length());
        bos.flush();

        String responses = new String(bis.readAllBytes());
        // System.out.println(responses);
        // set the label into the server's response
        label.setText(responses);

        String copystr = String.valueOf(responses);

} 
    
}
