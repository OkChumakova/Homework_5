package homework_5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlFile {

     static Node getStudent(Document doc, String surname, String course, String age) {
        Element student = doc.createElement("Student");

        student.appendChild(getStudentElements(doc, student, "surname", surname));

        student.appendChild(getStudentElements(doc, student, "course", course));

        student.appendChild(getStudentElements(doc, student, "age", age));

        return student;
    }

     static Node getStudentElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
