package contact_list;

/**
 * @author fmmoyç
 * 
 * Tiene dos constructores:
◦ El primero sin parámetros, simplemente crea una agenda vacía.
◦ El segundo recibe un fichero XML con información de contactos. Lanza excepción si
  hay problemas con el fichero.
• Alta de contacto (recibe los datos del contacto, no un objeto). Añade un contacto a la
  agenda. Lanza una excepción si se sobrepasa el máximo de contactos (100).
• Baja de contacto (por nombre). Lanza una excepción si el contacto a borrar no existe.
• Busca un contacto. Devuelve el contacto (objeto) que coincida con el nombre, en caso de no
  encontrar coincidencia se devuelve un valor nulo.
• Exporta a fichero XML. Lanza una excepción si no podemos escribir en el fichero.
 * 
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



public class Agenda {
  private List<Contact> agenda = new ArrayList<>();

  Agenda(){

  }

  Agenda(String fileXMl ) throws SAXException, IOException, ParserConfigurationException, InvalidAddressException, InvalidPhoneException, InvalidMailException{
    XMlReading(fileXMl);
  }

  void XMlReading(String fileXMl) throws SAXException, IOException, ParserConfigurationException, InvalidAddressException, InvalidPhoneException, InvalidMailException {
    
 // Creamos documento XML
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(new File(fileXMl + ".xml"));  // este objeto hará todo el trabajo
    
    document.getDocumentElement() // Accede al nodo raíz del documento
            .normalize();         // Elimina nodos vacíos y combina adyacentes en caso de que los hubiera

    // Accedemos a la lista de nodos Artículo
    NodeList nodes = document.getElementsByTagName("Contacto"); 
    
    for (int i = 0; i < nodes.getLength(); i++) {

      // Nodo Artículo 
      Node node = nodes.item(i);
      Element contact = (Element) node;
      
   // Campos del artículo (teniendo en cuenta que conocemos la estructura y etiquetas utilizadas)
      String name = contact.getAttribute("name");
      String phone = contact.getElementsByTagName("phone").item(0).getTextContent();
      String address = contact.getElementsByTagName("address").item(0).getTextContent();
      String mail = contact.getElementsByTagName("mail").item(0).getTextContent();

      // Añadimos a la lista
      agenda.add(new Contact(name, phone, mail, address));
    }
    
  }

  void add(String name, String phone, String email) throws InvalidAddressException, InvalidPhoneException, InvalidMailException, ExceptionAgendaSize{
    if(agenda.size() >=100) {
      throw new ExceptionAgendaSize("ERROR: Ha llegado al máximo de contactos");
    }
    Contact contac = new Contact(name, phone, email);
    agenda.add(contac);

  }

  void add(String name, String phone, String email, String address) throws InvalidAddressException, InvalidPhoneException, InvalidMailException, ExceptionAgendaSize{
    if(agenda.size() >=100) {
      throw new ExceptionAgendaSize("ERROR: Ha llegado al máximo de contactos");
    }
    Contact contac = new Contact(name, phone, email, address);
    agenda.add(contac);

  }

  void remove(String name) throws ExceptionContacNotExist {
    throwExceptionContacNotExist(name);
    agenda.removeIf(agenda -> name.equals(agenda.getName()));

  }

  private void throwExceptionContacNotExist(String name) throws ExceptionContacNotExist {
    if(!agenda.contains(get(name))) {
      throw new ExceptionContacNotExist("No existe contacto con el nombre " + name);
    }

  }

  Contact get(String name) {
    for(Contact contact: agenda) {
      if(contact.getName().equals(name)) {
        return contact;
      }
    }
    return null;

  }

  void exportXML(String fileXML) throws TransformerException, ParserConfigurationException, IOException {
    
      // Creación del documento XML 
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.newDocument(); // este objeto hará todo el trabajo

      // Nodo raíz 
      Element root = document.createElement("Agenda");
      document.appendChild(root);  

      for (Contact contact : agenda) {
        // Nodo Agenda (contiene los elementos)
        Element elementArt = document.createElement("Contacto");
        root.appendChild(elementArt);
      
      
      // El Nombre es un atributo del nodo Contacto
      Attr attrName = document.createAttribute("name");
      attrName.setValue(contact.getName());
      elementArt.setAttributeNode(attrName);

      // Nodo Telefono
      Element elementTfno = document.createElement("phone");
      elementTfno.appendChild(document.createTextNode(contact.getPhone()));
      elementArt.appendChild(elementTfno);
      
      // Nodo Direccion
      Element elementAddress = document.createElement("address");
      elementAddress.appendChild(document.createTextNode(contact.getAddress()));
      elementArt.appendChild(elementAddress);
      
   // Nodo Mail
      Element elementMail = document.createElement("mail");
      elementMail.appendChild(document.createTextNode(contact.getEmail()));
      elementArt.appendChild(elementMail);
      
   // Guardar XML en fichero
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(document);
      StreamResult result = new StreamResult(new FileWriter(fileXML +".xml"));
      transformer.transform(source, result);
      System.out.println("Creado " + fileXML + ".xml");
      
      }
  }

  @Override
  public String toString() {
    String str = "----Agenda----\n";
    for(Contact agenda: agenda) {
      str += agenda;
    }
    return str;
  }


}
