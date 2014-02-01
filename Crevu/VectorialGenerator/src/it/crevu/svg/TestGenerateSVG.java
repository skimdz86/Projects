package it.crevu.svg;

import java.awt.*;
import java.awt.geom.*;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.swing.*;

import org.apache.batik.swing.*;
import org.apache.batik.svggen.*;
import org.apache.batik.dom.svg.SVGDOMImplementation;

import org.w3c.dom.*;
import org.w3c.dom.svg.*;

//QUESTO VA, il mio NO
public class TestGenerateSVG {

  public static void main(String[] args) throws Exception {
    // Create an SVG document.
    DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
    String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
    SVGDocument doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);

    // Create a converter for this document.
    SVGGraphics2D g = new SVGGraphics2D(doc);

    // Do some drawing.
    Shape circle = new Ellipse2D.Double(0, 0, 50, 50);
    g.setPaint(Color.red);
    g.fill(circle);
    g.translate(60, 0);
    g.setPaint(Color.green);
    g.fill(circle);
    g.translate(60, 0);
    g.setPaint(Color.blue);
    g.fill(circle);
    g.setSVGCanvasSize(new Dimension(180, 50));

    // Populate the document root with the generated SVG content.
    Element root = doc.getDocumentElement();
    g.getRoot(root);

    Writer out = new OutputStreamWriter(System.out, "UTF-8");
    g.stream(out, true);
    
    // Display the document.
    JSVGCanvas canvas = new JSVGCanvas();
    JFrame f = new JFrame();
    f.getContentPane().add(canvas);
    canvas.setSVGDocument(doc);
    f.pack();
    f.setVisible(true);
  }
}