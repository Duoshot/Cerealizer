import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gorman on 2015-11-12.
 */
public class PrimitivesTest {

    @Test
    public void testA()
    {
        Primitives primitives = new Primitives();
        primitives.setA(1);

        assertEquals(1,primitives.getA());
    }

    @Test
    public void testB()
    {
        Primitives primitives = new Primitives();
        primitives.setB(2);

        assertEquals(2,primitives.getB());
    }

    @Test
    public void testC()
    {
        Primitives primitives = new Primitives();
        primitives.setC(3);

        assertEquals(3,primitives.getC());
    }

    @Test
    public void testConstructor()
    {
        Primitives primitives = new Primitives(1,2,3);

        assertEquals(1, primitives.getA());

        assertEquals(2, primitives.getB());

        assertEquals(3, primitives.getC());
    }


}