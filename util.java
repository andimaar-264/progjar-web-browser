import java.io.BufferedInputStream;
import java.net.Socket;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class util {

    private static int bufferSize = 8192;

    public static boolean checkUrl(){

        return true;
    }

    public static void httpRequestFirst(Socket sc, BufferedInputStream bis, BufferedOutputStream bos, String url) throws Exception{
        sc = new Socket("" + url, 80);
        bis = new BufferedInputStream(sc.getInputStream());
        bos = new BufferedOutputStream(sc.getOutputStream());

        // exchange msg here
        String messageHeader = "GET / HTTP/1.1\n";
        String host = "Host: " + url;
        bos.write(messageHeader.getBytes(), 0, messageHeader.length());
        bos.write(host.getBytes(), 0, host.length());
        bos.write("\r\n\r\n".getBytes(), 0, "\r\n\r\n".length());
        bos.flush();

        int counter = 0;
        String tempResponse = null;
        do{
            tempResponse = new String(bis.readNBytes(bufferSize));
            if(tempResponse.isEmpty()){
                break;
            }
            if(counter == 0){
                statusCodeHandler(getStatusCode(tempResponse));
                counter++;
            }
            String[] responseArr = tempResponse.split("\r\n");
            for (String string : responseArr) {
                System.out.println(string);
            }

        }while(tempResponse.length() < bufferSize);
        // String[] response = ;
        // String tempResponse = null;
        // do{
        //     tempResponse =  new String(bis.readNBytes(4096));
        //     // response[counter] = tempResponse;

        //     System.out.println(tempResponse);
        // }
        // while(!tempResponse.isEmpty() || tempResponse.length() < bufferSize);
        // String responses = new String(bis.readNBytes(bufferSize));


        sc.close();

        // System.out.println(responses);

    } 

    public static int getStatusCode(String response) throws NumberFormatException{
        String[] responses = response.split("\r\n");

        String[] firstLine = responses[0].split(" ");
        
        int statusCode = Integer.parseInt(firstLine[1]);
        return statusCode;
    }

    public static void statusCodeHandler(int statusCode) throws Exception{
        if(statusCode >= 100 && statusCode < 200){
            throw new Exception("Error: Status code " + statusCode);
        }
        if(statusCode >= 200 && statusCode < 300){
            return;
        }

        if(statusCode >=300 && statusCode < 400){
            // throw new Exception("Error: Status code " + statusCode);
            return;
            // TEMPORARY TODO
        }
        if(statusCode >= 400 && statusCode < 600){
            throw new Exception("Error: Status code " + statusCode);
        }
    }
}

