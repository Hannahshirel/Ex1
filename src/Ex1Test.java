import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1101b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 13);
        String s10 = "1101bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "10b2", "01b3", "456bA", "BBbG", "0bF"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b3", "3b1", "1H3bG", " CbG", "0bbF", "xyB", "!@b4", "Z", "1bb3"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {
        assertEquals("0b2", Ex1.int2Number(0, 2));
        assertEquals("111b2", Ex1.int2Number(7, 2));
        assertEquals("345b10", Ex1.int2Number(345, 10));
        assertEquals("B2b16", Ex1.int2Number(178, 16));
        assertEquals("3E8b16", Ex1.int2Number(1000, 16));
        assertEquals("", Ex1.int2Number(-5, 12));
        assertEquals("", Ex1.int2Number(15, 1));
        assertEquals("", Ex1.int2Number(20, 18));
    }

    @Test
    void maxIndexTest() {
        String[] validArray = {"110b2", "111b2", "101b2"};
        assertEquals(1, Ex1.maxIndex(validArray));
        String[] duplicateMaxArray = {"1024b10", "400bG", "400bG", "1000b10"};
        assertEquals(0, Ex1.maxIndex(duplicateMaxArray));
        String[] mixedArray = {"-1", "200bZ", "1b10", "AA2bG"};
        assertEquals(3, Ex1.maxIndex(mixedArray));
        String[] invalidArray = {"-1", "200bZ", "ZZbG"};
        assertEquals(-1, Ex1.maxIndex(invalidArray));

    }
    @Test
    void equalsTest() {
        assertTrue(Ex1.equals("11b2", "3b10"));
        assertFalse(Ex1.equals("11b2", "def"));
        assertFalse(Ex1.equals(null, "11b2"));
        assertFalse(Ex1.equals("11b2", "12b2"));
        assertTrue(Ex1.equals("11b2", "11b2"));
        assertFalse(Ex1.equals("", "11b2"));
    }
}
