package lab3;

public class TestClass {

    private static TestClass[] obj_array; // Array of all objects of the class

    private static TestClass[] getObj_array() {
        return obj_array;
    }

    private static void addObj_array(TestClass obj) {
        TestClass.obj_array[TestClass.getObj_array().length]=obj;
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

    public TestClass() {
        this.setCreation_time(System.currentTimeMillis());
        TestClass.advanceCounter();
        this.setNumber(TestClass.getCounter());
        TestClass.addObj_array(this);
    }
    
    public static void main(String[] args) {
        // TODO: refer to the exercise sheet. Add int args support
    }
}
