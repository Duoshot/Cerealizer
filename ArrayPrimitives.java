/**
 * Created by Gorman on 2015-11-05.
 */
public class ArrayPrimitives {

    private int[] myIntArray;

    public ArrayPrimitives()
    {
        //default constructor
        myIntArray = new int[3];
    }

    public ArrayPrimitives(int a, int b, int c)
    {
        myIntArray = new int[]{a, b, c};
    }

    public void setA(int a)
    {
        myIntArray[0] = a;
    }

    public void setB(int b)
    {
        myIntArray[1] = b;
    }

    public void setC(int c)
    {
        myIntArray[2] = c;
    }

    public int[] getArray()
    {
        return myIntArray;
    }

    public int getA()
    {
        return myIntArray[0];
    }

    public int getB()
    {
        return myIntArray[1];
    }

    public int getC()
    {
        return myIntArray[2];
    }
}
