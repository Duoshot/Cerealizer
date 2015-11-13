/**
 * Created by Gorman on 2015-11-06.
 */
public class ArraySimpleObjects {

    Primitives[] pArray;

    public ArraySimpleObjects()
    {
        pArray = new Primitives[3];
    }

    public ArraySimpleObjects(Primitives a, Primitives b, Primitives c)
    {
        pArray = new Primitives[]{a,b,c};
    }

    public Primitives getPrim1()
    {
        return pArray[0];
    }

    public Primitives getPrim2()
    {
        return pArray[1];
    }

    public Primitives getPrim3()
    {
        return pArray[2];
    }

    public void setpArray(Primitives[] p)
    {
        pArray = p;
    }

    public void setPrim1(Primitives a)
    {
        pArray[0] = a;
    }

    public void setPrim2(Primitives b)
    {
        pArray[1] = b;
    }

    public void setPrim3(Primitives c)
    {
        pArray[2] = c;
    }

}
