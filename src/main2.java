import java.io.BufferedOutputStream;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.net.Socket;

public class main2 {
    public static void main(String[] args) {
        try{
            // Takes url from user.
            Scanner stringScanner = new Scanner(System.in);
            System.out.println("Please select the functionality:\n1.Open a webpage\n2.Show a list of links\n3.Download a file\n4.Open a webpage with auth.\n5.Download multiple files.");
            int userChoice = Integer.parseInt(stringScanner.nextLine());
            switch(userChoice){
                case 1:
                System.out.println("Please enter the url!");
                String url = stringScanner.nextLine();
                BufferedInputStream bis = null;
                BufferedOutputStream bos = null;
                Socket sc = null;
                util.httpRequestFirst(sc, bis, bos, url);
                break;
                case 2:
                System.out.println("Please enter the url!");
                String listUrl = stringScanner.nextLine();
                util.ClickableLink(listUrl);
                break;
                case 3:
                System.out.println("Please enter the url!");
                String fileUrl = stringScanner.nextLine();
                System.out.println("Please enter what you want to name the file.");
                String fileName = stringScanner.nextLine();
                System.out.println("Please enter what the file type is.");
                String fileType = stringScanner.nextLine();
                util.downloadMethod(fileUrl, fileName, fileType);
                break;
                case 4:
                System.out.println("Please enter the url!");
                String authUrl = stringScanner.nextLine();
                System.out.println("Please enter the use!");
                String username = stringScanner.nextLine();
                System.out.println("Please enter the password!");
                String password = stringScanner.nextLine();
                BufferedInputStream authBis = null;
                BufferedOutputStream authBos = null;
                Socket authSc = null;
                util.httpRequestWithToken(authSc, authBis, authBos, authUrl, username, password);            
                break;
                case 5:
                System.out.println("Please specify the number of files you want to download! Max 5");
                int totalFilesDownload = Integer.parseInt(stringScanner.nextLine());
                if(totalFilesDownload < 1 || totalFilesDownload > 5){
                    break;
                }
                String[] downloadUrls = new String[totalFilesDownload];
                String[] fileNames = new String[totalFilesDownload];
                String[] fileTypes = new String[totalFilesDownload];
                downloadThread[] threads = new downloadThread[totalFilesDownload];

                for(int i = 0; i < totalFilesDownload; i++){
                    System.out.println("Please input the url. COUNT: " + i+1);
                    downloadUrls[i] = stringScanner.nextLine();
                    
                    System.out.println("Please input the filename!");
                    fileNames[i] = stringScanner.nextLine();

                    System.out.println("Please input the filetype!");
                    fileTypes[i] = stringScanner.nextLine();

                    threads[i] = new downloadThread(downloadUrls[0], fileNames[i], fileTypes[i]); 
                    threads[i].start();
                }
                for(downloadThread thread: threads){
                    thread.join();
                }

                System.out.println("Download finished!");
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
