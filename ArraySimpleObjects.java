/**
 * Created by Gorman on 2015-11-06.
 */
public class ArraySimpleObjects {

    Primitives[] pArray;

    public ArraySimpleObjects()
    {
        //default constructor
    }

    public ArraySimpleObjects(Primitives a, Primitives b, Primitives c)
    {
        pArray = new Primitives[]{a,b,c};
    }
}
