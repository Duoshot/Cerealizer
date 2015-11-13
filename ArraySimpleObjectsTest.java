import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gorman on 2015-11-12.
 */
public class ArraySimpleObjectsTest {

    @Test
    public void testConstructors()
    {
        Primitives a = new Primitives(1,2,3);
        Primitives b = new Primitives(4,5,6);
        Primitives c = new Primitives(7,8,9);

        ArraySimpleObjects arraySimpleObjects = new ArraySimpleObjects(a,b,c);

        assertEquals(1,arraySimpleObjects.getPrim1().getA());
        assertEquals(2,arraySimpleObjects.getPrim1().getB());
        assertEquals(3,arraySimpleObjects.getPrim1().getC());

        assertEquals(4,arraySimpleObjects.getPrim2().getA());
        assertEquals(5,arraySimpleObjects.getPrim2().getB());
        assertEquals(6,arraySimpleObjects.getPrim2().getC());

        assertEquals(7,arraySimpleObjects.getPrim3().getA());
        assertEquals(8,arraySimpleObjects.getPrim3().getB());
        assertEquals(9,arraySimpleObjects.getPrim3().getC());
    }

    @Test
    public void testSetters()
    {
        Primitives a = new Primitives(1,2,3);
        Primitives b = new Primitives(4,5,6);
        Primitives c = new Primitives(7,8,9);

        ArraySimpleObjects arraySimpleObjects = new ArraySimpleObjects();

        arraySimpleObjects.setPrim1(a);
        arraySimpleObjects.setPrim2(b);
        arraySimpleObjects.setPrim3(c);

        assertEquals(1,arraySimpleObjects.getPrim1().getA());
        assertEquals(2,arraySimpleObjects.getPrim1().getB());
        assertEquals(3,arraySimpleObjects.getPrim1().getC());

        assertEquals(4,arraySimpleObjects.getPrim2().getA());
        assertEquals(5,arraySimpleObjects.getPrim2().getB());
        assertEquals(6,arraySimpleObjects.getPrim2().getC());

        assertEquals(7,arraySimpleObjects.getPrim3().getA());
        assertEquals(8,arraySimpleObjects.getPrim3().getB());
        assertEquals(9,arraySimpleObjects.getPrim3().getC());
    }

    @Test
    public void testArraySetters()
    {
        Primitives a = new Primitives(1,2,3);
        Primitives b = new Primitives(4,5,6);
        Primitives c = new Primitives(7,8,9);

        ArraySimpleObjects arraySimpleObjects = new ArraySimpleObjects();

        Primitives[] pArr = new Primitives[]{a,b,c};

        arraySimpleObjects.setpArray(pArr);

        assertEquals(1,arraySimpleObjects.getPrim1().getA());
        assertEquals(2,arraySimpleObjects.getPrim1().getB());
        assertEquals(3,arraySimpleObjects.getPrim1().getC());

        assertEquals(4,arraySimpleObjects.getPrim2().getA());
        assertEquals(5,arraySimpleObjects.getPrim2().getB());
        assertEquals(6,arraySimpleObjects.getPrim2().getC());

        assertEquals(7,arraySimpleObjects.getPrim3().getA());
        assertEquals(8,arraySimpleObjects.getPrim3().getB());
        assertEquals(9,arraySimpleObjects.getPrim3().getC());
    }

}