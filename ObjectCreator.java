import java.util.Scanner;

public class ObjectCreator {

	public ObjectCreator()
	{
        //default constructor
    }

	public Object createObject() {
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

				break;
			case "1":
				object = createSimpleObject();
				break;
			case "2":
                System.out.println("This does nothing yet");
                break;
			case "3":
                object = createSimpleObjectArray();
                break;
			case "4":
                System.out.println("This does nothing yet");
                break;
			case "5":
				//object = createObjectsCollectionObject();
                System.out.println("This does nothing yet");
				break;
            default:
                System.out.println("Please enter a number from 1 to 5.");
                break;
		}


		return object;
	}

	//Simple object with only primitives for instance variables. The user of your
	// program must also be able to set the values for these fields


	private Primitives createSimpleObject()
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
//
    private ArrayPrimitives createSimpleObjectArray()
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
//	private ObjectsCollectionObject createObjectsCollectionObject()
//	{
//
//		Vector<Object> list = new Vector<Object>();
//
//		int collectionSize = GUI.getIntInput(......);
//
//		for(int i = 0; i < collectionSize; i++) {
//			list.add(createObject());
//		}
//
//		return new ObjectsCOllectionObject(list);
//
//		}
//	}

	//an object that contains references to other objects. Of course,
	//these other objects must also be created at the same time, and their primitive
	// instance variables must be
	//settable by the user. our program must also be able to deal with circular references
	//(i.e. objects connected in a graph).


	//an object that contains an array of primitives.
	// Allow the user to set the values for the array elements to arbitrary values.

	//an object that contains an array of object references.
	// The other objects must also be created at the same time.

	//an object that uses an instance of one of Java's collection classes to
	// refer to several other objects. These objects, too, must be created at the same time.


}
