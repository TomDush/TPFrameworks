package net.yvesrocher.training.frameworks;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Classe de lancement de l'application...
 *
 * @author Thomas Duchatelle
 */
public class Launcher {

	private static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// ** SPRING
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/books-context.xml", "spring/books-daomock.xml");

		// TODO Ecrire le code ici...

		LOGGER.info("Done.");
	}


}
