import java.io.BufferedOutputStream;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.net.Socket;

public class main2 {
    public static void main(String[] args) {
        try{
            // Takes url from user.
            Scanner stringScanner = new Scanner(System.in);
            System.out.println("Please select the functionality:\n1.Open a webpage\n2.Show a list of links\n3.Download a file\n4.Open a webpage with auth.");
            int userChoice = Integer.parseInt(stringScanner.nextLine());
            switch(userChoice){
                case 1:
                System.out.println("Please enter the url.");
                String url = stringScanner.nextLine();
                BufferedInputStream bis = null;
                BufferedOutputStream bos = null;
                Socket sc = null;
                util.httpRequestFirst(sc, bis, bos, url);
                break;
                case 2:
                System.out.println("Please enter the url.");
                String listUrl = stringScanner.nextLine();
                util.ClickableLink(listUrl);
                break;
                case 3:
                System.out.println("Please enter the url.");
                String fileUrl = stringScanner.nextLine();
                System.out.println("Please enter what you want to name the file.");
                String fileName = stringScanner.nextLine();
                System.out.println("Please enter what the file type is.");
                String fileType = stringScanner.nextLine();
                util.downloadMethod(fileUrl, fileName, fileType);
                break;
                case 4:
                System.out.println("Please enter the url.");
                String authUrl = stringScanner.nextLine();
                System.out.println("Please enter the use.");
                String username = stringScanner.nextLine();
                System.out.println("Please enter the password.");
                String password = stringScanner.nextLine();
                BufferedInputStream authBis = null;
                BufferedOutputStream authBos = null;
                Socket authSc = null;
                util.httpRequestWithToken(authSc, authBis, authBos, authUrl, username, password);            
                break;
            }

            
            stringScanner.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return;
    }
}
