package it.crevu.svg;

import java.util.Iterator;
import java.util.Map;

import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.StyleHandler;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Element;

public class StyleSheetStyleHandler implements StyleHandler {

    // The CDATA section that holds the CSS stylesheet.
    private CDATASection styleSheet;

    // Build the handler with a reference to the stylesheet section.
    public StyleSheetStyleHandler(CDATASection styleSheet) {
      this.styleSheet = styleSheet;
    }

    public void setStyle(Element element, Map styleMap,
               SVGGeneratorContext generatorContext) {
      Iterator iter = styleMap.keySet().iterator();

      // Create a new class in the style sheet.
      String id = generatorContext.getIDGenerator().generateID("C");
      styleSheet.appendData("."+ id +" {");

      // Append each key/value pair.
      while (iter.hasNext()) {
        String key = (String) iter.next();
        String value = (String) styleMap.get(key);
        styleSheet.appendData(key + ":" + value + ";");
      }

      styleSheet.appendData("}\n");

      // Reference the stylesheet class on the element to be styled.
      element.setAttributeNS(null, "class", id);
    }
  }