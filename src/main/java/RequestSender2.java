public class RequestSender2 {
    //    @Autowired
    private Connection connection1;

    //    @Autowired
    private Connection connection2;

    public RequestSender2(Connection connection1, Connection connection2) {
        this.connection1 = connection1;
        this.connection2 = connection2;
    }

    public void sendRequestOuter() {
        try {
            connection1.sendRequest("Test Request");
        } catch (Exception e) {
            connection2.sendRequest("Test Test");
        }
    }

}