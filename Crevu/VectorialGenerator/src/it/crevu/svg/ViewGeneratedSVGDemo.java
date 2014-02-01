package it.crevu.svg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;

import javax.swing.JFrame;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.svg.SVGDocument;

public class ViewGeneratedSVGDemo {

//    private static String className = XMLResourceDescriptor.getXMLParserClassName();

//    private static SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(className);
    
  public static void main(String[] args) throws Exception {
    // Create an SVG document.
//    DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
//    String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
//    SVGDocument doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);

    // Create a converter for this document.
//    SVGGraphics2D g = new SVGGraphics2D(doc);

//    // Do some drawing.
//    Shape circle = new Ellipse2D.Double(0, 0, 50, 50);
//    g.setPaint(Color.red);
//    g.fill(circle);
//    g.translate(60, 0);
//    g.setPaint(Color.green);
//    g.fill(circle);
//    g.translate(60, 0);
//    g.setPaint(Color.blue);
//    g.fill(circle);
//    g.setSVGCanvasSize(new Dimension(180, 50));

    // Populate the document root with the generated SVG content.

      File f = new File("C:\\tmp\\mdz\\testSVG.svg");
      FileReader fr = new FileReader(f);
//      FileInputStream fis = new FileInputStream(f);
      BufferedReader br = new BufferedReader(fr);
      String svgText = "";
      String line ="";
      while((line = br.readLine())!=null){
          svgText+=line;
      }
      StringReader reader = new StringReader(svgText);
      System.out.println(svgText);
//      byte[] myByteArray = IOUtils.toByteArray(fis);
      
//      Element a = null;
//      ByteArrayInputStream bais = new ByteArrayInputStream(myByteArray);
      

//      a = factory.createDocument(null, bais).getDocumentElement();
      
//      SVGDocument doc = factory.createSVGDocument("http://www.crevu.it/", bais);
      
  
      String parser = XMLResourceDescriptor.getXMLParserClassName();
      SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(parser);
      SVGDocument doc = factory.createSVGDocument("http://www.crevu.it/", reader);

      System.out.println("NODE 1_ "+doc.getFirstChild().getFirstChild().toString());
//      reader.close();
      // normalize text representation
//      doc.getDocumentElement().normalize();
            
//     Element root = doc.getDocumentElement();
    // g.getRoot(root);

     // Display the document.
     JSVGCanvas canvas = new JSVGCanvas();
     JFrame frame = new JFrame();
     frame.getContentPane().add(canvas);
     canvas.setSVGDocument(doc);
//     frame.pack();
     frame.setSize(500, 500);
     frame.setVisible(true);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}