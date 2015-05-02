package com.carlosb.chuletillas;

/**
 * @author Carlos Belmonte Ceniza
 * Chuletillas App for Android
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Environment;

public class IOFileChuletas {
	
	static String nombreCarpetaChuletas = "/Chuletillas";

	public static void crearEjemplos() throws IOException {
		
		final File dir = new File(Environment.getExternalStorageDirectory().getPath() + nombreCarpetaChuletas);
		
		// Si el directorio no existe (App ejecutada por primera vez, lo creamos y metemos las dos chuletas de ejemplo)
		if(dir.exists()==false){
			dir.mkdirs();
			
			Chuleta chuleta1 = crearChuletaEjemplo1(0);
			Chuleta chuleta2 = crearChuletaEjemplo1(1);
			
			escrbirChuletaFile(chuleta1);
			escrbirChuletaFile(chuleta2);
		}
    }

	private static void escrbirChuletaFile(Chuleta chuletaEjemplo) throws FileNotFoundException {
		
		String ficheroChuleta = "/" + chuletaEjemplo.getTitulo() + ".txt";
		
		File outputFile = new File(Environment.getExternalStorageDirectory().getPath() + nombreCarpetaChuletas, ficheroChuleta);
		FileOutputStream outputStream = new FileOutputStream(outputFile);
		
		try {

			  outputStream.write(chuletaEjemplo.getContenido().getBytes());
			  outputStream.close();
		} catch (Exception e) {
			  System.out.print("ERROR AL CREAR LA CHULETA DE EJEMPLO -- " + e);
		}
	}
	
	public static Chuleta crearChuletaEjemplo1(int tipoChuleta) {
		
		String tituloChuleta = "Chuleta de Ejemplo";
		String contenidoChuleta = "Texto Chuleta de Ejemplo";
		
		
		if(tipoChuleta == 0){
			 tituloChuleta = "Los Reyes Católicos";
			 contenidoChuleta = "Los Reyes Católicos fue la denominación que recibieron los esposos Fernando II de Aragón e Isabel I de Castilla, soberanosde la Corona de Castilla (1474-1504) y de la Corona de Aragón (1479-1516).\n"
							+ "Los Reyes accedieron al trono de Castilla tras la Guerra de Sucesión Castellana (1475-1479) contra los partidarios de laprincesa Juana la Beltraneja, hija del rey Enrique IV de Castilla. En 1479 Fernando heredó el trono de Aragón al morir su padre, el rey Juan II de Aragón. Isabel y Fernando reinaron juntos hasta la muerte de ella en 1504. Entonces Fernando quedó únicamente como rey de Aragón, pasando Castilla a su hija Juana, apodada \"la Loca\", y a su marido Felipe de Austria, apodado \"el Hermoso\", Archiduque de Austria, duque de Borgoña y conde de Flandes. Sin embargo Fernando no renunció a controlar Castilla y, tras morir Felipe en 1506 y ser declarada Juana incapaz, consiguió ser nombrado regente del reino hasta su muerte en 1516.\n"
							+ "La historiografía española considera el reinado de los Reyes Católicos como la transición de la Edad Media a la Edad Moderna. Con su enlace matrimonial se unieron provisionalmente, en la dinastía de los Trastámara, dos coronas: la Corona de Castilla y la Corona de Aragón dando nacimiento a la Monarquía Hispánica y, apoyados por las ciudades y la pequeña nobleza, establecieron una monarquía fuerte frente a las apetencias de poder de eclesiásticos y nobles. Con la conquista del Reino nazarí de Granada, del Reino de Navarra, de Canarias, de Melilla y de otras plazas africanas consiguieron la unión territorial bajo una sola corona de la totalidad de los territorios que hoy forman España —exceptuando Ceuta y Olivenza que entonces pertenecían a Portugal—, que se caracterizó por ser personal, ya que se mantuvieron las soberanías, normas e instituciones propias de cada reino y corona.\n "
							+ "Los Reyes establecieron una política exterior común marcada por los enlaces matrimoniales con varias familias reales de Europa que resultaron en la hegemonía de los Habsburgo durante los siglos XVI y XVII.\n "
							+ "Por otra parte, el descubrimiento de América, en 1492, modificó profundamente la historia mundial.\n\n"
							+ "Fuente: es.wikipedia.org \n";
		}else{
			tituloChuleta = "Clasificación de los minerales";
			contenidoChuleta = "1 - Elementos nativos: Elementos nativos son los elementos que aparecen sin combinarse con los átomos de otros elementos como por ejemplo oro (Au), plata (Ag), cobre (Cu), azufre (S), diamante (C). Aparte de la clase de los elementos nativos los minerales se clasifican de acuerdo con el carácter del ion negativo (anión) o grupo de los aniones, los cuales están combinados con iones positivos.\n\n"
					+ "2 - Sulfuros: incluido compuestos de selenio (Selenide), arsenurios (Arsenide), telururos (Telluride), antimoniuros (Antimonide) y compuestos de bismuto (Bismutide). Los sulfuros se distinguen con base en su proporción metal:azufre según el proposito de STRUNZ (1957, 1978). Ejemplos son galena PbS, esfalerita ZnS, pirita FeS2, calcopirita CuFeS2, argentita Ag2S, Löllingit FeAs2.\n\n"
					+ "3 - Haluros: Los aniones característicos son los halógenos F, Cl, Br, J, los cuales están combinados con cationes relativamente grandes de poca valencia, por ejemplo halita NaCl, silvinita KCl, fluorita CaF2.\n\n"
					+ "4 - Óxidos y Hidróxidos: Los oxidos son compuestos de metales con oxígeno como anión. Por ejemplo cuprita Cu2O, corindón Al2O3, hematita Fe2O3, cuarzo SiO2, rutilo TiO2, magnetita Fe3O4. \nLos hidroxidos están caracterizados por iones de hidroxido (OH-) o moleculas de H2O-, p.ej. limonita FeOOH: goethita *-FeOOH, lepidocrocita *-FeOOH.\n\n"
					+ "5 - Carbonatos: El anión es el radical carbonato (CO3)2-, por ejemplo calcita CaCO3, dolomita CaMg(CO3)2, malaquita Cu2[(OH)2/CO3].\n\n"
					+ "6 - Sulfatos, Wolframatos, Molibdatos y Cromatos: En los sulfatos el anión es el grupo (SO4)2- en el cual el azufre tiene una valencia 6+, p.ej. en la barita BaSO4, en el yeso CaSO4*2H2O. \nEn los wolframatos el anión es el grupo wolframato (WO4)4-, p.ej. scheelita o bien esquilita CaWO4.\n\n"
					+ "7 - Fosfatos, Arseniatos y Vanadatos: En los fosfatos el complejo aniónico (PO4)3- es el complejo principal, como en el apatito Ca5[(F, Cl, OH)/PO4)3]los arseniatos contienen (AsO4)3- y los vanadatos contienen (VO4)3- como complejo aniónico.\n\n"
					+ "8 - Silicatos: Es el grupo más abundante de los minerales formadores de rocas donde el anión está formado por grupos silicatos del tipo (SiO4)4-.\n\n"
					+ "Fuente: geovirtual.es \n";
		}

		Chuleta chuletEjemplo = new Chuleta(null, tituloChuleta, tituloChuleta, contenidoChuleta);
		
		return chuletEjemplo;
	}
	
}
