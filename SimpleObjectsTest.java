import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gorman on 2015-11-12.
 */
public class SimpleObjectsTest {

    private Primitives a;
    private Primitives b;
    private SimpleObjects simpleObjects;


    @Test
    public void testPrimConstruct()
    {
        a = new Primitives(1,2,3);
        b = new Primitives(4,5,6);
        simpleObjects = new SimpleObjects(a,b);

        assertEquals(1, simpleObjects.getPrimObjA().getA());
        assertEquals(2, simpleObjects.getPrimObjA().getB());
        assertEquals(3, simpleObjects.getPrimObjA().getC());

        assertEquals(4, simpleObjects.getPrimObjB().getA());
        assertEquals(5, simpleObjects.getPrimObjB().getB());
        assertEquals(6, simpleObjects.getPrimObjB().getC());
    }

    @Test
    public void testSetters()
    {
        a = new Primitives(1,2,3);
        b = new Primitives(4,5,6);
        simpleObjects = new SimpleObjects();

        simpleObjects.setPrimObjA(a);
        simpleObjects.setPrimObjB(b);

        assertEquals(1, simpleObjects.getPrimObjA().getA());
        assertEquals(2, simpleObjects.getPrimObjA().getB());
        assertEquals(3, simpleObjects.getPrimObjA().getC());

        assertEquals(4, simpleObjects.getPrimObjB().getA());
        assertEquals(5, simpleObjects.getPrimObjB().getB());
        assertEquals(6, simpleObjects.getPrimObjB().getC());
    }

}