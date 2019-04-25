package homework_5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {

        ArrayList <Student> listOfStudents = new ArrayList <>();

        listOfStudents.add(new Student("Whilson", 3, 18));
        listOfStudents.add(new Student("Jackson", 4, 20));
        listOfStudents.add(new Student("Thompson", 5, 21));
        listOfStudents.add(new Student("Jackson", 1, 16));


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        File dir = new File("C:\\test");
        dir.mkdir();

        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element rootElement =
                    doc.createElementNS(null, "Students");

            doc.appendChild(rootElement);

            for(int i = 0; i < listOfStudents.size(); i++ ){
                rootElement.appendChild(XmlFile.getStudent(doc, listOfStudents.get(i).getSurname(), String.valueOf(listOfStudents.get(i).getCourse()), String.valueOf(listOfStudents.get(i).getStudentAge())));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);

            StreamResult file = new StreamResult(new File("C:\\test\\Students.xml"));

            transformer.transform(source, file);
            System.out.println("XML file creation is finished \n ");

        } catch (ParserConfigurationException e){
            System.out.println(e.getStackTrace());
        }

        catch (TransformerConfigurationException e){
            System.out.println(e.getStackTrace());
        }
        catch (TransformerException e){
            System.out.println(e.getStackTrace());
        }

        Student.getStudentsSorted(listOfStudents);

    }
}

