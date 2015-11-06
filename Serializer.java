import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.ArrayList;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.lang.reflect.Array;
import java.lang.reflect.*;


public class Serializer
{
  private Document doc = null;
  private Element root;

  private Integer referenceID = 0;
  private java.util.HashMap<Object, Integer> referenceMap = new HashMap<Object, Integer>();

  private int currentElement = 0;
  private ArrayList<Object> serializedObjects = new ArrayList<Object>();

  public Serializer()
  {}

  public Document serialize(Object object)
  {
    if(!serializedObjects.contains(object))
    {

      serializedObjects.add(object);

      if(currentElement++ == 0){
        doc = new Document();
        root = new Element("serialized");
        doc.setRootElement(root);
      }

      Class<?> c = object.getClass();
      Integer id = getID(object);

      Element objectElement = new Element("object");
      objectElement.setAttribute(new Attribute("class", c.getName()));
      objectElement.setAttribute(new Attribute("id", id.toString()));
      doc.getRootElement().addContent(objectElement);

      if(c.isArray())
      { // Array of Objects
        Object array = object;
        objectElement.setAttribute(new Attribute("length", Integer.toString(Array.getLength(array))));

        // Need to check the type of the object
        if(c.getComponentType().isPrimitive()) {
          for (int i = 0; i < Array.getLength(array); i++) {
            Element value = new Element("value");
            objectElement.addContent(value);
            value.setText(Array.get(array, i).toString());
          }
        }
        else{
          for(int j=0; j < Array.getLength(array); j++){
            Element ref = new Element("referenceHigh");
            id = getID(Array.get(array, j));
            if(id != -1){
              ref.setText(id.toString());
              objectElement.addContent(ref);
            }

            for(int k = 0; k < Array.getLength(array); k++){
              serialize(Array.get(array, k));
            }


          }
        }


      }else{
        Class<?> tmpClass = c;
        while(tmpClass != null){
          Field[] fields = tmpClass.getDeclaredFields();
          ArrayList<Element> fieldXML = serializeFields(fields, object);
          for(Element element : fieldXML)
              objectElement.addContent(element);
          tmpClass = tmpClass.getSuperclass();
        }

      }

      if(currentElement == 0)
      {
        serializedObjects.clear();
        referenceID = 0;
      }

    }
    return doc;
  }

  private ArrayList<Element> serializeFields(Field[] fields, Object object){
      ArrayList<Element> elements = new ArrayList<Element>();
      for(int i = 0; i < fields.length; i++){ // Transient and Final Fields DO NOT need to be serialized, just skip them
          if(Modifier.isTransient(fields[i].getModifiers()) || Modifier.isFinal(fields[i].getModifiers()))
            continue;

          try{

            Field field = fields[i];
            if(!field.isAccessible())
              field.setAccessible(true);
            Element element = new Element("field");
            element.setAttribute(new Attribute("name", field.getName()));
            element.setAttribute(new Attribute("declaringclass", object.getClass().getName()));

            if(field.getType().isPrimitive()){ // Primitive Types
              System.out.println("This is primitive");
              Element value = new Element("value");
              element.addContent(value);
              value.setText(field.get(object).toString());


            }else{ // Object Types. If the field reference is another object, that should also be serialized. Call recursively!
              Integer id = getID(field.get(object));
              Element reference = new Element("reference");
              element.addContent(reference);
              reference.setText(id.toString());

              serialize(field.get(object));
            }

            elements.add(element);

          }catch(IllegalAccessException e){

          }

      }
    return elements;
  }

  private int getID(Object object){
    Integer id = referenceID;

    if(referenceMap.containsKey(object))
      id = referenceMap.get(object);
    else{
      referenceMap.put(object, id);
      referenceID++;
    }

    return id;
  }

}

