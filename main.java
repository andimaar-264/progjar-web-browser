
import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.file.*;

public class main {
    public static void ClickableLink(String url) {
        try {
            if (url.contains("https://")) {
                String[] arrOfStr = url.split("https://", 2);
                url = arrOfStr[1];
            }

            Socket socket = new Socket("" + url, 80);

            // Instantiates a new PrintWriter passing in the sockets output stream
            PrintWriter wtr = new PrintWriter(socket.getOutputStream());

            // Prints the request string to the output stream
            wtr.println("GET / HTTP/1.1");
            wtr.println("Host: " + url);
            wtr.println("");
            wtr.flush();

            BufferedReader bufRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String outStr;

            boolean foundLinks = false;
            int count = 1;
            // Prints each line of the response
            while ((outStr = bufRead.readLine()) != null) {
                if (outStr.contains("<a href=")) {
                    // Extract the hyperlink from the HTML string
                    int startIndex = outStr.indexOf("href=\"") + 6;
                    int endIndex = outStr.indexOf("\"", startIndex);
                    String link = outStr.substring(startIndex, endIndex);

                    // Print the hyperlink
                    System.out.println(count++ + "." + link);

                    foundLinks = true;
                }
            }

            if (!foundLinks) {
                System.out.println("No hyperlinks found in response.");
            }

            bufRead.close();
            wtr.close();
            socket.close();

        } catch (IOException e) {
            // confused
            e.printStackTrace();
        }
    }
    public static void SocketConnect(String url) {
        try {
            if (url.contains("https://")) {
                String[] arrOfStr = url.split("https://", 2);
                url = arrOfStr[1];
            }

            Socket socket = new Socket("" + url, 80);

            // Instantiates a new PrintWriter passing in the sockets output stream
            PrintWriter wtr = new PrintWriter(socket.getOutputStream());

            // Prints the request string to the output stream
            wtr.println("GET / HTTP/1.1");
            wtr.println("Host: " + url);
            wtr.println("");
            wtr.flush();

            BufferedReader bufRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String outStr;

            int i = 0;

            // Prints each line of the response
            while (i <= 10) {
                outStr = bufRead.readLine();
                System.out.println(outStr);
                i++;
            }

            bufRead.close();
            wtr.close();
            socket.close();
        } catch (IOException e) {
            // confused
            e.printStackTrace();
        }
    }

    public static void downloadMethod(String FILE_URL, String FILE_NAME) throws IOException {
        try {
            URL url = new URL(FILE_URL);

            BufferedInputStream bis = new BufferedInputStream(url.openStream());
            FileOutputStream fis = new FileOutputStream("D:/ITS/6th sem/ProgJar/dummyfolder/" + FILE_NAME + ".pdf");

            byte[] buffer = new byte[1024];
            int count = 0;

            while ((count = bis.read(buffer, 0, 1024)) != -1) {
                fis.write(buffer, 0, count);
            }

            fis.close();
            bis.close();

        } catch (IOException e) {
            // confused fr fr
            e.printStackTrace();
        }

    }

    public static void responseCode(String url) {
        try {
            if (url.contains("https://")) {
                String[] arrOfStr = url.split("https://", 2);
                url = arrOfStr[1];
            }

            Socket socket = new Socket("" + url, 80);

            // Instantiates a new PrintWriter passing in the sockets output stream
            PrintWriter wtr = new PrintWriter(socket.getOutputStream());

            // Prints the request string to the output stream
            wtr.println("GET / HTTP/1.1");
            wtr.println("Host: " + url);
            wtr.println("");
            wtr.flush();

            BufferedReader bufRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String outStr;

            int i = 0;

            // Prints each line of the response
            while (i == 0) {
                outStr = bufRead.readLine();
                System.out.println(outStr);
                i++;
            }

            bufRead.close();
            wtr.close();
            socket.close();
        } catch (IOException e) {
            // confused
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String key = "";
        String url = "";

        String urn = "";
        // String urx = "";

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("==========!!!==========");
            System.out.println("1. Open a Web");
            System.out.println("2. Show list of clickable link");
            System.out.println("3. Download File");
            System.out.println("4. Show respective HTTP error messages");
            System.out.println("12. Exit");
            System.out.println("==========!!!==========");
            System.out.println("1-12?");
            key = sc.nextLine();

            switch (key) {
                // shows text from entering link
                case "1":
                    System.out.println("URI?");
                    url = sc.nextLine();
                    SocketConnect(url);
                    break;

                // show clickable links
                case "2":
                    System.out.println("URI?");
                    url = sc.nextLine();
                    ClickableLink(url);
                    break;

                // downloading files
                case "3":
                    System.out.println("URL for downloading?");
                    url = sc.nextLine();

                    System.out.println("File name? Only accepts .pdf");
                    urn = sc.nextLine();
                    // String[] arrOfStr = url.split("/", 2);
                    // urn = "/" + arrOfStr[1];

                    // urx = "https://" + arrOfStr[0];

                    // for (String a : arrOfStr)
                    // {
                    // System.out.println(a);
                    // }

                    // System.out.println("URX: " + urx);

                    // System.out.println("URN: " + urn);

                    downloadMethod(url, urn);
                    break;

                case "4":
                    System.out.println("URI?");
                    url = sc.nextLine();
                    responseCode(url);
                    break;
                case "12":
                    System.exit(0);
                default:
                    break;
            }
        }

    }
