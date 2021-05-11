public class Numbers {//Request data type
    private int number1;
    private int number2;
    private String operation;//"plus","minus","multiply"...

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getOperation() {
        return operation;
    }



    public Numbers(int number1, int number2, String operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }
}