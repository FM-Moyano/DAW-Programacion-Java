package gestisimal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;




public class Almacen {

  private List<Articulo> articulo = new ArrayList<>(); 

  void add (String nombre, String marca, double precioCompra, double precioVenta, int unidades, 
      int stockSeguridad, int stockMaximo) throws ExcepcionNumeroNegativo {
    Articulo art = new Articulo(nombre, marca, precioCompra, precioVenta, unidades,stockSeguridad, stockMaximo);
    if(articulo.contains(art)) {
      throw new IllegalArgumentException("Este articulo ya existe");
    }
    articulo.add(art);
  }

  void add (String nombre, String marca, double precioCompra, double precioVenta, int unidades, 
      int stockSeguridad) throws ExcepcionNumeroNegativo {
    Articulo art = new Articulo(nombre, marca, precioCompra, precioVenta, unidades,stockSeguridad);
    if(articulo.contains(art)) {
      throw new IllegalArgumentException("Este articulo ya existe");
    }
    articulo.add(art);
  }

  void add (String nombre, String marca, double precioCompra, double precioVenta, int unidades) throws ExcepcionNumeroNegativo {
    Articulo art = new Articulo(nombre, marca, precioCompra, precioVenta, unidades);
    if(articulo.contains(art)) {
      throw new IllegalArgumentException("Este articulo ya existe");
    }
    articulo.add(art);
  }

  void remove(int codigo) {
    articulo.removeIf(articulo -> articulo.getCodigo() == codigo);
  }

  void xml() {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.newDocument();

      //Nodo Raiz 
      Element root = document.createElement("Almacen");
      document.appendChild(root);

      for(Articulo articulo : articulo) {
        //Nodo articulo que contiene los elementos
        Element elementArt = document.createElement("Articulo");
        root.appendChild(elementArt);

        // creamos los atributos del nodo Articulo
        Attr attrCod = document.createAttribute("código");
        attrCod.setValue(Integer.toString(articulo.getCodigo()));
        elementArt.setAttributeNode(attrCod);

        //Seguimos creando elementos
        Element elementNombre = document.createElement("Nombre");
        elementNombre.appendChild(document.createTextNode(articulo.getNombre()));
        elementArt.appendChild(elementNombre);

        Element elementMarca = document.createElement("Marca");
        elementMarca.appendChild(document.createTextNode(articulo.getMarca()));
        elementArt.appendChild(elementMarca);

        Element elementPrecioCompra = document.createElement("PrecioDeCompra");
        elementPrecioCompra.appendChild(document.createTextNode(Double.toString(articulo.getPrecioDeCompra())));
        elementArt.appendChild(elementPrecioCompra);

        Element elementPrecioVenta = document.createElement("PrecioDeVenta");
        elementPrecioVenta.appendChild(document.createTextNode(Double.toString(articulo.getPrecioDeVenta())));
        elementArt.appendChild(elementPrecioVenta);

        Element elementUnidades = document.createElement("NumeroDeUnidades");
        elementUnidades.appendChild(document.createTextNode(Integer.toString(articulo.getNumeroDeUnidades())));
        elementArt.appendChild(elementUnidades);

        Element elementStockSeguridad = document.createElement("StockDeSeguridad");
        elementStockSeguridad.appendChild(document.createTextNode(Integer.toString(articulo.getStockDeSeguridad())));
        elementArt.appendChild(elementStockSeguridad);

        Element elementStockMaximo = document.createElement("StockMaximo");
        elementStockMaximo.appendChild(document.createTextNode(Integer.toString(articulo.getStockMaximo())));
        elementArt.appendChild(elementStockMaximo);

      }
      //Instaciar las clases
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(document);
      StreamResult result = new StreamResult(new FileWriter("almacen.xml"));
      transformer.transform(source, result);



    } catch (ParserConfigurationException e) {

      e.printStackTrace();
    } catch (TransformerConfigurationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (TransformerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  void json() {
    try {
      String json = new Gson().toJson(articulo);

      BufferedWriter file = new BufferedWriter(new FileWriter("almacen.json"));
      file.write(json);
      file.close();

      System.out.println("Creado almacen.json");

    }catch(IOException e){
      System.err.println("error al crear JSON:" );
      e.printStackTrace();
    }

  }
  
  void leerXML() {
    
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(new File("almacen.xml"));
      
      document.getDocumentElement().normalize();
      NodeList nodes = document.getElementsByTagName("Articulo");
      
      //recorro los nodos articulo
      for(int i = 0; i< nodes.getLength(); i++) {
        
        //Nodo articulo
        Node node = nodes.item(i);
        Element articulo2= (Element) node;
        
        // Campos del articulo
        //int codigo = Integer.parseInt(articulo2.getAttribute("código"));
        String nombre = articulo2.getElementsByTagName("Nombre").item(0).getTextContent();
        String marca = articulo2.getElementsByTagName("Marca").item(0).getTextContent();
        double precioDeCompra = Double.parseDouble(articulo2.getElementsByTagName("PrecioDeCompra").item(0).getTextContent());
        double precioDeVenta = Double.parseDouble(articulo2.getElementsByTagName("PrecioDeVenta").item(0).getTextContent());
        int numeroDeUnidades = Integer.parseInt(articulo2.getElementsByTagName("NumeroDeUnidades").item(0).getTextContent());
        int stockDeSeguridad = Integer.parseInt(articulo2.getElementsByTagName("StockDeSeguridad").item(0).getTextContent());
        int stockMaximo = Integer.parseInt(articulo2.getElementsByTagName("StockMaximo").item(0).getTextContent());

        //Añadimos la lista
        articulo.add(new Articulo (nombre,marca,precioDeCompra,precioDeVenta,numeroDeUnidades,stockDeSeguridad,stockMaximo));
        
        
      }
      
    } catch (ParserConfigurationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SAXException e) {
      System.err.println("El fichero no se encuentra.");
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ExcepcionNumeroNegativo e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  
  void leerJson() {
    try {
      
      //Extraer el JSON del archivo
      String json = Files.readString(Paths.get("almacen.json"));
      
      //Convertir JSON en un ArrayList
      Gson gson = new Gson();
      Type ArticlesListType = new TypeToken<ArrayList<Articulo>>() {}.getType();
      List<Articulo> articulos = gson.fromJson(json, ArticlesListType);
      
      for(Articulo a: articulos) {
        articulo.add(a);
      }
    }catch (IOException e) {
      System.err.println("Error de lectura: " + e.getMessage());
      e.printStackTrace();
    }
  }


  //metodo por crear
  public void increaseStock(int codigo, int unidades) {
    for(Articulo articulo : articulo) {
      if(articulo.getCodigo() == codigo) {
        articulo.incrementar(unidades);
      }
    }
  }

  public void decreaseStock(int codigo, int unidades){
    for(Articulo articulo: articulo) {
      if(articulo.getCodigo() == codigo) {
        try {
          articulo.decrementar(unidades);
        } catch (ArticleIllegalErrorArgumentException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }


  public void modify(int codigo, String nombre, String marca, int unidades, double precioCompra, double precioVenta,
      int stockSeguridad, int stockMaximo) throws WarehouseArticleNotExistsException, ExcepcionNumeroNegativo {
    Articulo article = get(codigo);
    article.setNombre(nombre);
    article.setMarca(marca);
    article.setNumeroDeUnidades(unidades);
    article.setPrecioDeCompra(precioCompra);
    article.setPrecioDeVenta(precioVenta);
    article.setStockDeSeguridad(stockSeguridad);
    article.setStockMaximo(stockMaximo);


  }

  @Override
  public String toString() {
    return "Almacen [articulo=" + articulo + "]";
  }

  public Articulo get(int codigo) throws WarehouseArticleNotExistsException {

    for(Articulo articulo: articulo) {
      if(articulo.getCodigo() == codigo) {
        return articulo;
      }
    }
    throw new WarehouseArticleNotExistsException("El articulo no existe");
  }
}
