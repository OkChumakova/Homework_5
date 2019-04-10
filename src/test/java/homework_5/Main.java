package homework_5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

import static homework_5.Student.listOfStudents;


public class Main {


    public static void main(String[] args) {

        listOfStudents = new ArrayList <>();

        listOfStudents.add(new Student("Whilson", 3, 18));
        listOfStudents.add(new Student("Jackson", 4, 20));
        listOfStudents.add(new Student("Thompson", 5, 21));
        listOfStudents.add(new Student("Jackson", 1, 16));


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element rootElement =
                    doc.createElementNS("https://javadevblog.com/language", "Students");

            doc.appendChild(rootElement);

            for(int i = 0; i < listOfStudents.size(); i++ ){
                rootElement.appendChild(XmlFile.getStudent(doc, listOfStudents.get(i).getSurname(), String.valueOf(listOfStudents.get(i).getCourse()), String.valueOf(listOfStudents.get(i).getStudentAge())));
            }


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);


            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("C:\\test\\languages.xml"));


            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("XML creation is finished");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Student.getStudentsSorted(listOfStudents);

    }
}

