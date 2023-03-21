import java.io.BufferedOutputStream;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;

public class main2 {
    public static void main(String[] args) {
        try{
            // Takes url from user.
            Scanner stringScanner = new Scanner(System.in);
            System.out.println("Please enter the url.");
            String url = stringScanner.nextLine();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            Socket sc = null;
    
            String response = util.httpRequestFirst(sc, bis, bos, url);
            
            System.out.println(response);
            stringScanner.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
