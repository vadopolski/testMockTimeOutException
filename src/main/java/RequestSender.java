public class RequestSender {
//    @Autowired
    private Connection connection;

    public RequestSender(Connection connection) {
        this.connection = connection;
    }

    public void sendRequestOuter() {
        try {
            connection.sendRequest("Test Request");
            System.out.println("Test Test");
        } catch (Exception e) {
            System.out.print("Exception Point");
        }
    }

}