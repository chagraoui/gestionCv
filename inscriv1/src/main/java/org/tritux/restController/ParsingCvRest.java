package org.tritux.restController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.tritux.cvparsing.CV;
import org.xml.sax.SAXException;

@CrossOrigin
@RestController
public class ParsingCvRest {

	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	public CV handleFileUpload(@RequestParam("file") MultipartFile file)
			throws IOException, SAXException, TikaException {

		InputStream cv = file.getInputStream();

		// ParseContext Used to pass context information to Tika parsers.
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		// ParseContext Used to pass context information to Tika parsers.
		ParseContext pcontext1 = new ParseContext();

		// convertir pdf to text
		PDFParser pdfparser = new PDFParser();
		pdfparser.parse(cv, handler, metadata, pcontext1);
		cv.close();
		System.out.println("Contents of the PDF :" + handler.toString());

		// remlpir le fichier text
		String oout = "cv.txt";
		FileOutputStream outputStream = new FileOutputStream(new File(oout));
		outputStream.write(handler.toString().getBytes());
		outputStream.close();

		CV cvfinale = new CV(oout);
		System.out.println(cvfinale);

		return cvfinale;
	}
}
