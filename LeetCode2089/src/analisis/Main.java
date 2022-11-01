package analisis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		AdaIndexSearch ada = new AdaIndexSearch();

		Scanner sc = new Scanner(System.in);
		System.out.println("Cantidad de casos a generar");
		int cantidad = sc.nextInt();
		ada.generarDatos(cantidad);
		System.out.println("Caso a utilizar entre 1 y " + cantidad);
		int caso = sc.nextInt();
		while (caso > cantidad || caso < 1) {
			System.out.println("Caso fuera de rango");
			caso = sc.nextInt();
		}
		caso--;
		ArrayList<int[]> a = ada.leerArreglo();
		int[] temp = ada.leerObjetivo(cantidad);
		List<Integer> temp2 = ada.targetIndices(a.get(caso), temp[caso]);
		int[] b = a.get(caso);
		System.out.print("Arreglo Ordenado: ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.print("\nTarget: " + temp[caso] + "\n");
		for (int j = 0; j < temp2.size() && temp2.isEmpty() == false; j++) {
			System.out.print("índice o posición: "+temp2.get(j) + " ");
		}
	}

}