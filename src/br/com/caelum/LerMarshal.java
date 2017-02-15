package br.com.caelum;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class LerMarshal {

	public static void main(String[] args) throws Exception {

		Livro livro = new Livro();
		livro.setCodigo("ARQ");
		livro.setNomeAutor("Paulo Silveira");
		livro.setTipo("Arquitetura Java");
		livro.setValor(new BigDecimal(190.00));
		livro.setCategoria(new Categoria("ebook"));
		
		JAXBContext cxt = JAXBContext.newInstance(Livro.class);
		cxt.generateSchema(new SchemaOutputResolver() {
			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName)
					throws IOException {
				StreamResult result = new StreamResult(new File("schema.xsd"));
				return result;
			}
		});
		
		Marshaller mars = cxt.createMarshaller();
		mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		mars.marshal(livro, new FileOutputStream("livro.xml"));
		
		
	}
}
