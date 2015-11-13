import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gorman on 2015-11-12.
 */
public class ArrayPrimitivesTest {

    @Test
    public void testA()
    {
        ArrayPrimitives arrayPrimitives = new ArrayPrimitives();

        arrayPrimitives.setA(1);

        assertEquals(1, arrayPrimitives.getA());
    }

    @Test
    public void testB()
    {
        ArrayPrimitives arrayPrimitives = new ArrayPrimitives();

        arrayPrimitives.setB(2);

        assertEquals(2, arrayPrimitives.getB());
    }

    @Test
    public void testC()
    {
        ArrayPrimitives arrayPrimitives = new ArrayPrimitives();

        arrayPrimitives.setC(3);

        assertEquals(3, arrayPrimitives.getC());
    }

    @Test
    public void testConstructor()
    {
        ArrayPrimitives arrayPrimitives = new ArrayPrimitives(1,2,3);

        assertEquals(1, arrayPrimitives.getA());

        assertEquals(2, arrayPrimitives.getB());

        assertEquals(3, arrayPrimitives.getC());
    }

    @Test
    public void testGetter()
    {
        ArrayPrimitives arrayPrimitives = new ArrayPrimitives(1,2,3);

        assertEquals(1, arrayPrimitives.getArray()[0]);
        assertEquals(2, arrayPrimitives.getArray()[1]);
        assertEquals(3, arrayPrimitives.getArray()[2]);
    }

}