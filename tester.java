/**
 * tester
 */
public class tester {

    public static void main(String[] args) {
        testParseCode();
    }

    public static void testParseCode(){
        String testHeaderFirst = new String("HTTP/1.1 200 OK\r\nDate: Tue, 21 Mar 2023 13:28:33 GMT\r\nExpires: -1\r\n\r\n");
        int statusCodeFirst = util.getStatusCode(testHeaderFirst);
        System.out.println(statusCodeFirst);

        // String testHeaderSecond = new String();
        // statusCodeSecond = util.getStatusCode(testHeaderSecond);
        // System.out.println(statusCodeSecond);

    }
}