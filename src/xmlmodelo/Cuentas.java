/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlmodelo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sujetos.Usuario;

/**
 *
 * @author peperony
 */
public class Cuentas {
    
    public Cuentas () {
    }
    
    public void agregarCuenta (String nombre, String apellido1, String apellido2, String correo, String contrasenia) {
        try {
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(getClass().getResource("/xml/Cuentas.xml").getPath());
            
            Element root = doc.getDocumentElement();
            Element newCount = doc.createElement("Cuenta");
            Element eNombre = doc.createElement("Nombre");
            eNombre.appendChild(doc.createTextNode(nombre));
            Element eApellido1 = doc.createElement("Apellido1");
            eApellido1.setTextContent(apellido1);
            Element eApellido2 = doc.createElement("Apellido2");
            eApellido2.setTextContent(apellido2);
            Element eCorreo = doc.createElement("Correo");
            eCorreo.setTextContent(correo);
            Element eContrasenia = doc.createElement("Contraseña");
            Element eGanadas = doc.createElement("Ganadas");
            eGanadas.appendChild(doc.createTextNode("0"));
            Element eEmpatadas = doc.createElement("Empatadas");
            eEmpatadas.appendChild(doc.createTextNode("0"));
            Element ePerdidas = doc.createElement("Perdidas");
            ePerdidas.appendChild(doc.createTextNode("0"));
            eContrasenia.setTextContent(contrasenia);
            
            newCount.appendChild(eNombre);
            newCount.appendChild(eApellido1);
            newCount.appendChild(eApellido2);
            newCount.appendChild(eCorreo);
            newCount.appendChild(eContrasenia);
            newCount.appendChild(eGanadas);
            newCount.appendChild(eEmpatadas);
            newCount.appendChild(ePerdidas);
            
            root.appendChild(newCount);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(getClass().getResource("/xml/Cuentas.xml").getPath());
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            ex.printStackTrace();
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            ex.printStackTrace();
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
public void registrarVillano(String nombre, String apellido1, String apellido2, String correo, String contrasenia) {
        try {
            //registrarPersonaje(pNombre, pEdad, pSexo, pAltura, pCiudadOrigen,pOcupacion,pOrientacionSexual,a,pImg,pID);
            //File fXmlFile = new File("Data.xml");
            File fXmlFile = new File(getClass().getResource("/xml/Cuentas.xml").getPath());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(fXmlFile);
            Element root=doc.getDocumentElement();
            NodeList nList = doc.getElementsByTagName("Cuentas");
          
            Element personajeRaiz=doc.createElement("Cuentas"); //esto es solo para instanciar el elemento fuera del for para poder utilizar la variable
            int cont=0;
            //buscando la etiqueta en el archivo
            while(cont!=nList.getLength()) {
                Node nNode = nList.item(cont);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    if (nNode.getNodeName().equals("Cuentas")) {
                        personajeRaiz=(Element) nNode;
                        cont=nList.getLength();
                    }
                    else cont++;
                }
            }
            //creo elementos
            Element Cuenta=doc.createElement("Cuenta");
            Element eNombre=doc.createElement("Nombre");
            eNombre.appendChild(doc.createTextNode(nombre));
            Element eApellido1=doc.createElement("Apellido1");
            //pego elementos en las etiquetas especificas
            eApellido1.appendChild(doc.createTextNode(apellido1));
            Cuenta.appendChild(eNombre);
            Cuenta.appendChild(eApellido1);
            personajeRaiz.appendChild(Cuenta);
            if (nList.getLength()==0) root.appendChild(personajeRaiz); //esta validacion la puede omitir


            //guardo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(getClass().getResource("/xml/Cuentas.xml").getPath());
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cambiarNombre(String pNombreNuevo, String pContrasenia) {
        try {
            File fXmlFile = new File(getClass().getResource("/xml/Cuentas.xml").getPath());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Cuenta");
            Element ciudad=doc.createElement("Actual");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");
                NodeList contrasenia = temp.getElementsByTagName("Contraseña");
                
                if (contrasenia.item(0).getTextContent().equals(pContrasenia)) {
                    nombre.item(0).setTextContent(pNombreNuevo);
                }  
            }
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           StreamResult result = new StreamResult(getClass().getResource("/xml/Cuentas.xml").getPath());
           DOMSource source = new DOMSource(doc);
           transformer.transform(source, result);
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiarApellido1(String nNuevoApellido, String nContrasenia) {
        try {
            File fXmlFile = new File(getClass().getResource("/xml/Cuentas.xml").getPath());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Cuenta");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Apellido1");
                NodeList contrasenia = temp.getElementsByTagName("Contraseña");
                
                if (contrasenia.item(0).getTextContent().equals(nContrasenia)) {
                    nombre.item(0).setTextContent(nNuevoApellido);
                }  
            }
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           StreamResult result = new StreamResult(getClass().getResource("/xml/Cuentas.xml").getPath());
           DOMSource source = new DOMSource(doc);
           transformer.transform(source, result);
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiarApellido2(String nNuevoApellido, String nContrasenia) {
        try {
            File fXmlFile = new File(getClass().getResource("/xml/Cuentas.xml").getPath());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Cuenta");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Apellido2");
                NodeList contrasenia = temp.getElementsByTagName("Contraseña");
                
                if (contrasenia.item(0).getTextContent().equals(nContrasenia)) {
                    nombre.item(0).setTextContent(nNuevoApellido);
                }  
            }
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           StreamResult result = new StreamResult(getClass().getResource("/xml/Cuentas.xml").getPath());
           DOMSource source = new DOMSource(doc);
           transformer.transform(source, result);
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiarCorreo(String nNuevoCorreo, String nContrasenia) {
        try {
            File fXmlFile = new File(getClass().getResource("/xml/Cuentas.xml").getPath());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Cuenta");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Correo");
                NodeList contrasenia = temp.getElementsByTagName("Contraseña");
                
                if (contrasenia.item(0).getTextContent().equals(nContrasenia)) {
                    nombre.item(0).setTextContent(nNuevoCorreo);
                }  
            }
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           StreamResult result = new StreamResult(getClass().getResource("/xml/Cuentas.xml").getPath());
           DOMSource source = new DOMSource(doc);
           transformer.transform(source, result);
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiarContrasenia(String nNuevaContrasenia, String nContrasenia) {
        try {
            File fXmlFile = new File(getClass().getResource("/xml/Cuentas.xml").getPath());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Cuenta");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList contrasenia = temp.getElementsByTagName("Contraseña");
                
                if (contrasenia.item(0).getTextContent().equals(nContrasenia)) {
                    contrasenia.item(0).setTextContent(nNuevaContrasenia);
                }  
            }
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           StreamResult result = new StreamResult(getClass().getResource("/xml/Cuentas.xml").getPath());
           DOMSource source = new DOMSource(doc);
           transformer.transform(source, result);
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean existeContrasenia(String nContrasenia) {
        try {
            File fXmlFile = new File(getClass().getResource("/xml/Cuentas.xml").getPath());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Cuenta");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList contrasenia = temp.getElementsByTagName("Contraseña");
                
                if (contrasenia.item(0).getTextContent().equals(nContrasenia)) {
                    return false;
                }  
            }
           return true;
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean existeCorreo(String nCorreo) {
        try {
            File fXmlFile = new File(getClass().getResource("/xml/Cuentas.xml").getPath());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Cuenta");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList contrasenia = temp.getElementsByTagName("Correo");
                
                if (contrasenia.item(0).getTextContent().equals(nCorreo)) {
                    return false;
                }  
            }
           return true;
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean existeCuenta (String nNombre, String nContrasenia) {
        try {
            File fXmlFile = new File(getClass().getResource("/xml/Cuentas.xml").getPath());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Cuenta");
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");
                NodeList contrasenia = temp.getElementsByTagName("Contraseña");
                
                if (nombre.item(0).getTextContent().equals(nNombre) && contrasenia.item(0).getTextContent().equals(nContrasenia)) {
                    return true;
                }  
            }
           return false;
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Usuario crearUsuario (String nNombre, String nContrasenia) {
        try {
            File fXmlFile = new File(getClass().getResource("/xml/Cuentas.xml").getPath());
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(fXmlFile);
            NodeList rootCiudad=doc.getElementsByTagName("Cuenta");
            Usuario usuario = null;
           for (int i=0;i!=rootCiudad.getLength();i++) {
                Element temp =(Element) rootCiudad.item(i);
                NodeList nombre = temp.getElementsByTagName("Nombre");
                NodeList contrasenia = temp.getElementsByTagName("Contraseña");
                
                if (nombre.item(0).getTextContent().equals(nNombre) && contrasenia.item(0).getTextContent().equals(nContrasenia)) {
                    String uNombre = nombre.item(0).getTextContent();
                    String uContrasenia = contrasenia.item(0).getTextContent();
                    String uApellido1 = temp.getElementsByTagName("Apellido1").item(0).getTextContent();
                    String uApellido2 = temp.getElementsByTagName("Apellido2").item(0).getTextContent();
                    usuario = new Usuario(uNombre, uContrasenia, uApellido1, uApellido2);
                }  
            }
           return usuario;
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
