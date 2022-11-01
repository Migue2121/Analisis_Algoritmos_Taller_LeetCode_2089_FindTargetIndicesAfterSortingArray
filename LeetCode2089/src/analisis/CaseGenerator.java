package analisis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class CaseGenerator {
	
	public void generarDatos() {
		try {
			String ruta = "Arrays.txt";
			int n =100;
			File fichero = new File(ruta);
			if (fichero.exists() == false)
				fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			String ruta2 = "Target.txt";
			File fichero2 = new File(ruta2);
			if (fichero2.exists() == false)
				fichero.createNewFile();
			FileWriter fw2 = new FileWriter(fichero2);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			for (int i = 0; i < n; i++) {
				int index = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
				int[] datos = new int[index];
				for (int j = 0; j < index; j++) {
					datos[j] = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
				}
				for (int j = 0; j < index; j++) {
					String texto = String.valueOf(datos[j]);
					bw.write(texto + " ");
				}
				if (i != n - 1) {
					bw.write("\n");
				}
				bw2.write(generarObjetivo(datos) + "\n");
			}

			bw.close();
			bw2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  int generarObjetivo(int[] list) {
		boolean objetivo = false;
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for (int j = 0; j < list.length; j++) {
			lista.add(list[j]);
		}
		int index = 0;
		while (objetivo == false) {
			index = (int) (Math.random() * (100 - 1 + 1) + 1);
			if (lista.contains(index)) {
				objetivo = true;
			}

		}
		return index;
	}

}
