import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntStackImplTest {


    IntStackImpl testStack;

    @BeforeEach
    public void init() {
        testStack = new IntStackImpl();
    }

    @Test
    public void pushZeroTest() {
        testStack.push(0);
        Assertions.assertEquals(1, testStack.size());
        Assertions.assertEquals(0, testStack.getByIndex(0));
    }

    @Test
    public void pushArrayResizeTest() {
        Assertions.assertEquals(10, testStack.capacity());
        for (int i = 0; i < 6; i++) {
            testStack.push(Integer.MAX_VALUE);
        }
        Assertions.assertEquals(20, testStack.capacity());
    }

    @Test
    public void popEmptyTest() {
        Assertions.assertEquals(Integer.MIN_VALUE, testStack.pop());
    }

    @Test
    public void popTest() {
        testStack.push(0);
        Assertions.assertEquals(0, testStack.pop());
        Assertions.assertEquals(0, testStack.size());
    }

    @Test
    public void peekTest() {
        testStack.push(0);
        Assertions.assertEquals(0, testStack.peek());
        Assertions.assertEquals(1, testStack.size());
    }

    @Test
    public void addTest() {
        testStack.add(0);
        Assertions.assertEquals(1, testStack.size());
        Assertions.assertEquals(0, testStack.getByIndex(0));
    }

    @Test
    public void insertTest() {
        testStack.insert(0, 0);
        Assertions.assertEquals(0, testStack.getByIndex(0));
        Assertions.assertEquals(1, testStack.size());
        int[] expectedArray = {0, 1, 100, 2, 3, 0, 0, 0, 0, 0};
        testStack.add(1);
        testStack.add(2);
        testStack.add(3);
        testStack.insert(2, 100);
        Assertions.assertArrayEquals(testStack.array, expectedArray);
    }

    @Test
    public void insertExceptionTest() {
        try {
            testStack.insert(100, 0);
            Assertions.fail();
        } catch (IndexOutOfBoundsException e) {

        }
    }


    //0 1 2
    @Test
    public void setTest() {
        for (int i = 0; i < 3; i++) {
            testStack.add(i);
        }
        testStack.set(1, 100);
        Assertions.assertEquals(100, testStack.getByIndex(1));

    }

    @Test
    public void setExceptionTest() {
        try {
            testStack.set(100, 0);
            Assertions.fail();
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            testStack.set(0, 100);
            Assertions.fail();
        } catch (IndexOutOfBoundsException e) {

        }
    }

    @Test
    public void getIndexByValueTest() {
        testStack.add(1);
        testStack.add(2);
        testStack.add(3);
        Assertions.assertEquals(2, testStack.getIndexByValue(3));
    }

    @Test
    public void getIndexByValueNullTest() {
        testStack.add(1);
        testStack.add(2);
        testStack.add(3);
        Assertions.assertEquals(null, testStack.getIndexByValue(135));
    }

    @Test
    public void containsTest() {
        testStack.add(1);
        Assertions.assertEquals(true, testStack.contains(1));
        Assertions.assertEquals(false, testStack.contains(12));
    }

    @Test
    public void removeByIndexTest() {
        int[] expectedArray = {1, 2, 4, 0, 0, 0, 0, 0, 0, 0};
        testStack.add(1);
        testStack.add(2);
        testStack.add(3);
        testStack.add(4);
        testStack.removeByIndex(2);
        Assertions.assertArrayEquals(testStack.array, expectedArray);
    }

    @Test
    public void removeByValueTest() {
        int[] expectedArray = {1, 3, 4, 0, 0, 0, 0, 0, 0, 0};
        testStack.add(1);
        testStack.add(2);
        testStack.add(3);
        testStack.add(4);
        testStack.removeValue(2);
        Assertions.assertArrayEquals(testStack.array, expectedArray);
    }

    @Test
    public void toArrayTest(){
        testStack.add(1);
        testStack.add(2);
        testStack.add(3);
        int[] expected = {1,2,3};
        Assertions.assertArrayEquals(expected,testStack.toArray());
    }

    @Test
    public void sublistTest(){
        for(int i = 0; i < 5;i++){
            testStack.add(i);
        }
        int[] expected = {0,1,2};
        IntList actual = testStack.subList(0,3);

        Assertions.assertArrayEquals(expected,actual.toArray());
    }


}
