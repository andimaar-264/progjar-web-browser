import java.io.BufferedInputStream;
import java.net.Socket;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class util {
    public static boolean checkUrl(){

        return true;
    }

    public static String httpRequestFirst(Socket sc, BufferedInputStream bis, BufferedOutputStream bos, String url) throws IOException{
        sc = new Socket("" + url, 80);
        bis = new BufferedInputStream(sc.getInputStream());
        bos = new BufferedOutputStream(sc.getOutputStream());

        // exchange msg here
        String messageHeader = "GET / HTTP/1.1\n";
        String host = "Host: " + url;
        bos.write(messageHeader.getBytes());
        bos.write(host.getBytes());
        bos.write("\r\n\r\n".getBytes());
        bos.flush();

        String responses = new String(bis.readAllBytes());

        sc.close();

        return responses;
        // System.out.println(responses);

    } 
}
