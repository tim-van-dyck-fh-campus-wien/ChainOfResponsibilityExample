public class ChainHandler {
        private Processor chainStart;
        public ChainHandler(){
            buildChain();
        }
        private void buildChain(){
            chainStart = new AddNumbersProcessor(new MultiplyNumbersProcesser(null));
        }
        public void handleRequest(Numbers request){
            chainStart.process(request);
        }
}
abstract class Processor{
    private Processor nextProcessor;//Reference to next processor in chain
    public Processor(Processor nextProcessor){
        this.nextProcessor=nextProcessor;//Set the suceeding processor in chain via construktor
    }
    public void process(Numbers request){ // if the process could not be handled, call next concrete processor in chain, if it exists
        if(this.nextProcessor!=null){
            nextProcessor.process(request);
        }else{
            System.out.println("REQUEST COULD NOT BE HANDLED");
        }
    }
}

class AddNumbersProcessor extends Processor{
    public AddNumbersProcessor(Processor nextProcessor){
        super(nextProcessor);
    }
    @Override public void process(Numbers request){
        if(request.getOperation()=="plus"){
            int result = request.getNumber1()+request.getNumber2();
            System.out.println("AddNumbers:"+(request.getNumber1())+"+"+request.getNumber2()+"="+result);
        }else{
            super.process(request);
        }
    }
}
class MultiplyNumbersProcesser extends Processor{
    public MultiplyNumbersProcesser(Processor nextProcessor){
        super(nextProcessor);
    }
    @Override public void process(Numbers request){
        if(request.getOperation()=="multiply"){
            int result = request.getNumber1()*request.getNumber2();
            System.out.println("MultiplyNumbers:"+(request.getNumber1())+"*"+request.getNumber2()+"="+result);
        }else{
            super.process(request);
        }
    }
}

