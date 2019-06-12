package org.demo.demo;

import org.xml.sax.*;
import org.xml.sax.ext.LexicalHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
 
public class Test {
 
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
 
            SAXParser saxParser = factory.newSAXParser();
 
            File file = new File("D:\\apache-tomcat-7.0.93\\conf/server.xml");
 
            InputSource input = new InputSource(new FileInputStream(file));
 
            XMLReader reader = saxParser.getXMLReader();
            
            reader.setContentHandler(new UserContentHandler());
            reader.setDTDHandler(new UserDTDHandler());
            reader.setEntityResolver(new UserEntityResolver());
            reader.setErrorHandler(new UserErrorHandler());
            reader.setProperty(
                    "http://xml.org/sax/properties/lexical-handler", new UserLexicalHandler());
            
            reader.parse(input);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
 
    private static class UserLexicalHandler implements LexicalHandler{
 
        @Override
        public void startDTD(String name, String publicId, String systemId) throws SAXException {
            System.out.println("startDTD:" + publicId + "---" + systemId + "---" + name);
            
        }
 
        @Override
        public void endDTD() throws SAXException {
            System.out.println("endDTD:");
            
        }
 
        @Override
        public void startEntity(String name) throws SAXException {
            System.out.println("startEntity:" + name);
            
        }
 
        @Override
        public void endEntity(String name) throws SAXException {
            System.out.println("endEntity:" + name);
            
        }
 
        @Override
        public void startCDATA() throws SAXException {
            System.out.println("startCDATA:" );
            
        }
 
        @Override
        public void endCDATA() throws SAXException {
            System.out.println("endCDATA:" );
            
        }
 
        @Override
        public void comment(char[] ch, int start, int length) throws SAXException {
            //System.out.println("comment:" + new String(ch,start,length));//Digester的comment方法是空的
            
        }
        
    }
    private static class UserErrorHandler implements ErrorHandler{
 
        @Override
        public void warning(SAXParseException exception) throws SAXException {
            System.out.println("warning");
            
        }
 
        @Override
        public void error(SAXParseException exception) throws SAXException {
            System.out.println("error");
            
        }
 
        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            System.out.println("fatalError");
            
        }
        
    }
    private static class UserEntityResolver implements EntityResolver{
 
        @Override
        public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
            System.out.println("resolveEntity:" + publicId + "---" + systemId );
            return null;
        }
        
    }
    private static class UserDTDHandler implements DTDHandler{
 
        @Override
        public void notationDecl(String name, String publicId, String systemId) throws SAXException {
            System.out.println("notationDecl:" + name + "---" + publicId + "----"+ systemId );
        }
 
        @Override
        public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName)
                throws SAXException {
            System.out.println("unparsedEntityDecl:" + name + "---" + publicId + "----"+ systemId + "---" + notationName);
        }
        
    }
    private static class UserContentHandler implements ContentHandler{
 
        @Override
        public void setDocumentLocator(Locator locator) {
            System.out.println("setDocumentLocator:" +locator);
            
        }
 
        @Override
        public void startDocument() throws SAXException {
            System.out.println("startDocument:");
            
        }
 
        @Override
        public void endDocument() throws SAXException {
            System.out.println("endDocument:");
        }
 
        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            System.out.println("startPrefixMapping:" +prefix + "---" + uri);
            
        }
 
        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            System.out.println("endPrefixMapping:" +prefix);
            
        }
 
        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            System.out.println("startElement:" + uri + "---" + localName + "----"+ qName);
        }
 
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("endElement:" + uri + "---" + localName + "----"+ qName);
            
        }
 
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("characters:" + new String(ch,start,length));
            
        }
 
        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            System.out.println("ignorableWhitespace:" + new String(ch,start,length));
        }
 
        @Override
        public void processingInstruction(String target, String data) throws SAXException {
            System.out.println("processingInstruction:" + target + "---" + data);
            
        }
 
        @Override
        public void skippedEntity(String name) throws SAXException {
            System.out.println("skippedEntity:" + name);
        }
        
    }
 
}
