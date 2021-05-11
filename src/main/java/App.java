public class App {
    public static void main(String args[]){
        ChainHandler processingChain = new ChainHandler();
        Numbers request = new Numbers(100,7,"multiply");
        processingChain.handleRequest(request);
    }
}
