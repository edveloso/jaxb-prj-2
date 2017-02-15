package br.com.caelum;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class TestUnmarshal {
	
	public static void main(String[] args) throws Exception {
		
		JAXBContext cont = JAXBContext.newInstance(Livro.class);
		Unmarshaller un = cont.createUnmarshaller();
		
		Livro livro = (Livro)un.unmarshal(new File("livro.xml"));
		System.out.println(livro);
		
	}

}
