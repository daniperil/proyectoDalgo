package proyecto;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import java.util.ArrayList;
//Autora: Vilma Tirado Gómez
public class ProblemaC {

	public static ArrayList<Integer> maximo(int[][] servicios, int equipos, Stack<ArrayList<Integer>> st, ArrayList<Integer> actual, ArrayList<Integer> max){

		int sumaMax = ganancia(servicios, max);
		int sumaActual=ganancia(servicios, actual);
		if(sumaActual>=sumaMax){
			if(fechas(servicios, actual, equipos)){
				max=actual;
			}
		}
		if(!actual.isEmpty()){
			int ultimo= actual.get(actual.size()-1);
			for (int i = ultimo+1; i < servicios.length; i++) {
				ArrayList<Integer> copia= (ArrayList<Integer>) actual.clone();
				copia.add(i);
				st.add(copia);
			}
		}
		else{
			for (int i = 0; i < servicios.length; i++) {
				ArrayList<Integer> copia= (ArrayList<Integer>) actual.clone();
				copia.add(i);
				st.add(copia);
			}
		}
		if(!st.isEmpty()){
			max=maximo(servicios, equipos, st, st.pop(),max);
		}

		return max;
	}

	public static int ganancia(int[][] servicios, ArrayList<Integer> actual ){
		int suma =0;
		for (int i = 0; i < actual.size(); i++) {
			int k = actual.get(i);
			suma += servicios[k][3];
		}
		return suma;
	}

	public static boolean fechas(int[][] servicios,ArrayList<Integer> actual,int equipos){
		boolean val = true;
		int dia = dia(servicios);
		for (int i = 0; i <= dia; i++) {
			int numeroEquipos=0;
			for (int j = 0; j < actual.size(); j++) {
				int[] evento1=servicios[actual.get(j)];
				if((evento1[1]<=i&&evento1[2]>=i)||(evento1[1]==evento1[2]&&evento1[2]==i)){
					numeroEquipos++;
					if(numeroEquipos>equipos){
						return false;
					}
				}
			}
		}
		return val;
	}

	public static int dia(int[][] servicios){
		int dia = primerDia(servicios);
		int diaMax = dia;
		for (int i = 0; i < servicios.length; i++) {
			int temp =diaMax;
			diaMax = Math.max(servicios[i][2], dia);
			if(diaMax!=temp){
				dia=temp;
			}
		}
		return dia;
	}

	public static int primerDia(int[][]servicios){
		int diaMax = 0;
		for (int i = 0; i < servicios.length; i++) {
			diaMax = Math.max(servicios[i][1], diaMax);
		}
		return diaMax;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		int equipos;
		int numServicios;
		String data[][];
		while (true)
		{																	
			linea = br.readLine();
			if (linea.equals("0 0"))
				return;

			equipos = Integer.parseInt(linea.split(" ")[1]);;
			numServicios = Integer.parseInt(linea.split(" ")[0]);; 
			int[][] dataNum=new int[numServicios][4];
			data = new String[numServicios][4];

			for (int i = 0; i < numServicios; i++) {
				data[i] = br.readLine().split(" ");
				for (int j = 0; j < data[i].length; j++) {
					dataNum[i][j]=Integer.parseInt(data[i][j]);
				}
			}

			ArrayList<Integer> max=maximo(dataNum, equipos, new Stack<ArrayList<Integer>>(), new ArrayList<Integer>(),new ArrayList<Integer>());
			System.out.println(ganancia(dataNum, max));



		}

	}


}