import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdaIndexSearch {

	public  List<Integer> targetIndices(int[] nums, int target) {
		Arrays.sort(nums);
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				indices.add(i);
			}
		}
		return indices;

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

	public void generarDatos(int n) {
		try {
			String ruta = "datos.txt";
			File fichero = new File(ruta);
			if (fichero.exists() == false)
				fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			String ruta2 = "objetivos.txt";
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

	public  ArrayList<int[]> leerArreglo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<int[]> retorno = new ArrayList<int[]>();
		int[] casos;
		try {
			archivo = new File("datos.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(" ");
				casos = new int[datos.length];
				int j = 0;
				while (j < datos.length) {
					casos[j] = Integer.parseInt(datos[j]);
					j++;
				}
				retorno.add(casos);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return retorno;
	}

	public  int[] leerObjetivo(int n) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int[] retorno = new int[n];
		try {
			archivo = new File("objetivos.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			int j = 0;
			while ((linea = br.readLine()) != null) {
				retorno[j] = Integer.parseInt(linea);
				j++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return retorno;
	}

}
