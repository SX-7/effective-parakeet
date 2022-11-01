package lab3;

import java.util.Vector;

public class TestClass {

    private static Vector<TestClass> obj_vec = new Vector<TestClass>(); // Array of all objects of the class

    private static Vector<TestClass> getObj_vec() {
        return obj_vec;
    }

    private static void addObj_array(TestClass obj) {
        TestClass.getObj_vec().add(obj);
    }

    private int number; // The number assigned to the object

    private int getNumber() {
        return number;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private static int counter = 0; // The global counter

    private static int getCounter() {
        return counter;
    }

    private static void advanceCounter() {
        TestClass.counter = TestClass.counter + 1;
    }

    private long creation_time; // When was this object created

    private long getCreation_time() {
        return creation_time;
    }

    private void setCreation_time(long creation_time) {
        this.creation_time = creation_time;
    }

    public static void printClassData() {
        String out_str ="";
        for (TestClass testClass : getObj_vec()) {
            out_str = out_str.concat(Integer.toString(testClass.getNumber())+". ["+Long.toString(testClass.getCreation_time())+"]\n");
        }
        System.out.println(out_str);
        System.out.println("Liczba obiektów: "+getObj_vec().size());
    }

    public TestClass() {
        this.setCreation_time(System.currentTimeMillis());
        TestClass.advanceCounter();
        this.setNumber(TestClass.getCounter());
        TestClass.addObj_array(this);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            System.exit(0);
        }
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            new TestClass();
        }
        TestClass.printClassData();
    }
}
