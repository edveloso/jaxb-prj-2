package br.com.caelum;

import java.io.File;
import java.math.BigDecimal;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class TesteValidacao {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Livro livro = new Livro();
		livro.setCodigo("ARQ");
		livro.setNomeAutor("jose");
		JAXBContext cxt = JAXBContext.newInstance(Livro.class);
		JAXBSource source = new JAXBSource(cxt, livro);
	 
		SchemaFactory fac = SchemaFactory
							.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema =  fac.newSchema(new File("schema.xsd"));
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new ValidationHandler());
		validator.validate(source);
		
	}

}
