import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class ObjectCreator {

    public ObjectCreator()
    {
        //default constructor
    }

    public Object createObject() throws IOException {
        // TODO Auto-generated method stub

        System.out.println("Select an object to create by entering the corresponding number");
        System.out.println("0) Quit");
        System.out.println("1) Simple object with only primitives for instance variables");
        System.out.println("2) Object that contains references to other objects.");
        System.out.println("3) Array of primitives");
        System.out.println("4) Array of objects");
        System.out.println("5) Java collection of objects");

        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine();

        Object object = null;

        switch(selection) {
            case "0":
                Sender.connected = false;
                Sender.exit();
                break;
            case "1":
                object = createSimplePrimitive();
                break;
            case "2":
                object = createSimpleObject();
                break;
            case "3":
                object = createSimplePrimitiveArray();
                break;
            case "4":
                object = createSimpleObjectArray();
                break;
            case "5":
                object = createObjectsCollectionObject();
                break;
            default:
                System.out.println("Please enter a number from 1 to 5.");
                break;
        }


        return object;
    }

    //Simple object with only primitives for instance variables. The user of your
    // program must also be able to set the values for these fields


    private Primitives createSimplePrimitive()
    {
        //int a = GUI.getIntInput("enter value for field \ "a\":");
        //int b = GUI..........................;
        Scanner primScan = new Scanner(System.in);


        System.out.println("Enter an integer for A: ");
        String primA = primScan.nextLine();
        int a = Integer.parseInt(primA);

        System.out.println("Enter an integer for B: ");
        String primB = primScan.nextLine();
        int b = Integer.parseInt(primB);

        System.out.println("Enter an integer for C: ");
        String primC = primScan.nextLine();
        int c = Integer.parseInt(primC);

        Primitives primitives = new Primitives(a,b,c);

        return primitives;
    }

    private SimpleObjects createSimpleObject()
    {
        Scanner objScan = new Scanner(System.in);

        System.out.println("Creating two primitive objects");

        Primitives a = new Primitives();
        Primitives b = new Primitives();
        String input;

        System.out.println("Getting user input for object 1");
        System.out.print("\tEnter an Integer for A: ");
        input = objScan.nextLine();
        a.setA(Integer.parseInt(input));

        System.out.print("\tEnter an Integer for B: ");
        input = objScan.nextLine();
        a.setB(Integer.parseInt(input));

        System.out.print("\tEnter an Integer for C: ");
        input = objScan.nextLine();
        a.setC(Integer.parseInt(input));

        System.out.println("Getting user input for object 2");
        System.out.print("\tEnter an Integer for A: ");
        input = objScan.nextLine();
        b.setA(Integer.parseInt(input));

        System.out.print("\tEnter an Integer for B: ");
        input = objScan.nextLine();
        b.setB(Integer.parseInt(input));

        System.out.print("\tEnter an Integer for C: ");
        input = objScan.nextLine();
        b.setC(Integer.parseInt(input));

        SimpleObjects simpleObjects = new SimpleObjects(a,b);

        return simpleObjects;

    }
//
    private ArrayPrimitives createSimplePrimitiveArray()
    {
        Scanner arrayPrimScan = new Scanner(System.in);

        //ArrayPrimitives arrayPrims = new ArrayPrimitives();
        System.out.println("Enter an integer for array element 1");
        String elem1 = arrayPrimScan.nextLine();
        int a = Integer.parseInt(elem1);

        System.out.println("Enter an integer for array element 2");
        String elem2 = arrayPrimScan.nextLine();
        int b = Integer.parseInt(elem2);

        System.out.println("Enter an integer for array element 3");
        String elem3 = arrayPrimScan.nextLine();
        int c = Integer.parseInt(elem3);

        ArrayPrimitives arrayPrimitives = new ArrayPrimitives(a,b,c);

        return arrayPrimitives;
    }

    private ArraySimpleObjects createSimpleObjectArray()
    {
        //todo
        Scanner ArrayObjectScan = new Scanner(System.in);
        String input;

        System.out.println("Creating an array of Primitives Objects");
        System.out.println("Creating three primitive objects");

        Primitives a = new Primitives();
        Primitives b = new Primitives();
        Primitives c = new Primitives();


        //setting a
        System.out.println("Getting input for object 1");
        System.out.print("\tEnter an Integer for A: ");
        input = ArrayObjectScan.nextLine();
        a.setA(Integer.parseInt(input));

        System.out.print("\tEnter an Integer for B: ");
        input = ArrayObjectScan.nextLine();
        a.setB(Integer.parseInt(input));

        System.out.print("\tEnter an Integer for C: ");
        input = ArrayObjectScan.nextLine();
        a.setC(Integer.parseInt(input));

        //setting b
        System.out.println("Getting input for object 2");
        System.out.print("\tEnter an Integer for A: ");
        input = ArrayObjectScan.nextLine();
        b.setA(Integer.parseInt(input));

        System.out.print("\tEnter an Integer for B: ");
        input = ArrayObjectScan.nextLine();
        b.setB(Integer.parseInt(input));

        System.out.print("\tEnter an Integer for C: ");
        input = ArrayObjectScan.nextLine();
        b.setC(Integer.parseInt(input));

        //setting c
        System.out.println("Getting input for object 3");
        System.out.print("\tEnter an Integer for A: ");
        input = ArrayObjectScan.nextLine();
        c.setA(Integer.parseInt(input));

        System.out.print("\tEnter an Integer for B: ");
        input = ArrayObjectScan.nextLine();
        c.setB(Integer.parseInt(input));

        System.out.print("\tEnter an Integer for C: ");
        input = ArrayObjectScan.nextLine();
        c.setC(Integer.parseInt(input));

        ArraySimpleObjects arraySimpleObjects = new ArraySimpleObjects(a,b,c);
        return arraySimpleObjects;
    }
  private ObjectsCollectionObject createObjectsCollectionObject()
  {

      ArrayList<Primitives> list = new ArrayList<Primitives>();
      Scanner collectionScan = new Scanner(System.in);
      String input;

      int collectionSize;

      System.out.println("How big do you want the collection to be?");
      input = collectionScan.nextLine();

      collectionSize = Integer.parseInt(input);

      for(int i = 0; i < collectionSize; i++) {
          Primitives obj = createSimplePrimitive();
          list.add(obj);
      }

      ObjectsCollectionObject objectsCollectionObject = new ObjectsCollectionObject(list);

      return objectsCollectionObject;

  }

}
