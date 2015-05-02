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
			 tituloChuleta = "Los Reyes Cat�licos";
			 contenidoChuleta = "Los Reyes Cat�licos fue la denominaci�n que recibieron los esposos Fernando II de Arag�n e Isabel I de Castilla, soberanosde la Corona de Castilla (1474-1504) y de la Corona de Arag�n (1479-1516).\n"
							+ "Los Reyes accedieron al trono de Castilla tras la Guerra de Sucesi�n Castellana (1475-1479) contra los partidarios de laprincesa Juana la Beltraneja, hija del rey Enrique IV de Castilla. En 1479 Fernando hered� el trono de Arag�n al morir su padre, el rey Juan II de Arag�n. Isabel y Fernando reinaron juntos hasta la muerte de ella en 1504. Entonces Fernando qued� �nicamente como rey de Arag�n, pasando Castilla a su hija Juana, apodada \"la Loca\", y a su marido Felipe de Austria, apodado \"el Hermoso\", Archiduque de Austria, duque de Borgo�a y conde de Flandes. Sin embargo Fernando no renunci� a controlar Castilla y, tras morir Felipe en 1506 y ser declarada Juana incapaz, consigui� ser nombrado regente del reino hasta su muerte en 1516.\n"
							+ "La historiograf�a espa�ola considera el reinado de los Reyes Cat�licos como la transici�n de la Edad Media a la Edad Moderna. Con su enlace matrimonial se unieron provisionalmente, en la dinast�a de los Trast�mara, dos coronas: la Corona de Castilla y la Corona de Arag�n dando nacimiento a la Monarqu�a Hisp�nica y, apoyados por las ciudades y la peque�a nobleza, establecieron una monarqu�a fuerte frente a las apetencias de poder de eclesi�sticos y nobles. Con la conquista del Reino nazar� de Granada, del Reino de Navarra, de Canarias, de Melilla y de otras plazas africanas consiguieron la uni�n territorial bajo una sola corona de la totalidad de los territorios que hoy forman Espa�a �exceptuando Ceuta y Olivenza que entonces pertenec�an a Portugal�, que se caracteriz� por ser personal, ya que se mantuvieron las soberan�as, normas e instituciones propias de cada reino y corona.\n "
							+ "Los Reyes establecieron una pol�tica exterior com�n marcada por los enlaces matrimoniales con varias familias reales de Europa que resultaron en la hegemon�a de los Habsburgo durante los siglos XVI y XVII.\n "
							+ "Por otra parte, el descubrimiento de Am�rica, en 1492, modific� profundamente la historia mundial.\n\n"
							+ "Fuente: es.wikipedia.org \n";
		}else{
			tituloChuleta = "Clasificaci�n de los minerales";
			contenidoChuleta = "1 - Elementos nativos: Elementos nativos son los elementos que aparecen sin combinarse con los �tomos de otros elementos como por ejemplo oro (Au), plata (Ag), cobre (Cu), azufre (S), diamante (C). Aparte de la clase de los elementos nativos los minerales se clasifican de acuerdo con el car�cter del ion negativo (ani�n) o grupo de los aniones, los cuales est�n combinados con iones positivos.\n\n"
					+ "2 - Sulfuros: incluido compuestos de selenio (Selenide), arsenurios (Arsenide), telururos (Telluride), antimoniuros (Antimonide) y compuestos de bismuto (Bismutide). Los sulfuros se distinguen con base en su proporci�n metal:azufre seg�n el proposito de STRUNZ (1957, 1978). Ejemplos son galena PbS, esfalerita ZnS, pirita FeS2, calcopirita CuFeS2, argentita Ag2S, L�llingit FeAs2.\n\n"
					+ "3 - Haluros: Los aniones caracter�sticos son los hal�genos F, Cl, Br, J, los cuales est�n combinados con cationes relativamente grandes de poca valencia, por ejemplo halita NaCl, silvinita KCl, fluorita CaF2.\n\n"
					+ "4 - �xidos y Hidr�xidos: Los oxidos son compuestos de metales con ox�geno como ani�n. Por ejemplo cuprita Cu2O, corind�n Al2O3, hematita Fe2O3, cuarzo SiO2, rutilo TiO2, magnetita Fe3O4. \nLos hidroxidos est�n caracterizados por iones de hidroxido (OH-) o moleculas de H2O-, p.ej. limonita FeOOH: goethita *-FeOOH, lepidocrocita *-FeOOH.\n\n"
					+ "5 - Carbonatos: El ani�n es el radical carbonato (CO3)2-, por ejemplo calcita CaCO3, dolomita CaMg(CO3)2, malaquita Cu2[(OH)2/CO3].\n\n"
					+ "6 - Sulfatos, Wolframatos, Molibdatos y Cromatos: En los sulfatos el ani�n es el grupo (SO4)2- en el cual el azufre tiene una valencia 6+, p.ej. en la barita BaSO4, en el yeso CaSO4*2H2O. \nEn los wolframatos el ani�n es el grupo wolframato (WO4)4-, p.ej. scheelita o bien esquilita CaWO4.\n\n"
					+ "7 - Fosfatos, Arseniatos y Vanadatos: En los fosfatos el complejo ani�nico (PO4)3- es el complejo principal, como en el apatito Ca5[(F, Cl, OH)/PO4)3]los arseniatos contienen (AsO4)3- y los vanadatos contienen (VO4)3- como complejo ani�nico.\n\n"
					+ "8 - Silicatos: Es el grupo m�s abundante de los minerales formadores de rocas donde el ani�n est� formado por grupos silicatos del tipo (SiO4)4-.\n\n"
					+ "Fuente: geovirtual.es \n";
		}

		Chuleta chuletEjemplo = new Chuleta(null, tituloChuleta, tituloChuleta, contenidoChuleta);
		
		return chuletEjemplo;
	}
	
}
