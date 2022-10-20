package lab3;

public class TestClass {
    private long timer = 0;

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    private static int counter = 0;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        TestClass.counter = counter;
    }

    private int own = 0;

    public int getOwn() {
        return own;
    }

    public void setOwn(int own) {
        this.own = own;
    }

    public void printData(){
        System.out.println(this.getOwn()+". ["+this.getTimer()+"]");
    }

    public TestClass() {
        this.setTimer(System.currentTimeMillis());
        TestClass.setCounter(TestClass.getCounter()+1);
        this.setOwn(TestClass.getCounter());
    }

    public static void main(String[] args) {
        //TODO: refer to the exercise sheet. Add int args support
    }
}
