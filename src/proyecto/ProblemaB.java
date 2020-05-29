package proyecto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//Autora: Vilma Tirado Gómez
public class ProblemaB {

	static int count = 0; 

	public void DFS(int grafo[][], boolean marcados[], 
			int n, int vert, int ini, int v) { 

		// marca el vertice como visitado 
		marcados[vert] = true; 

		// si encuentro el camino 
		if (n == 0) { 

			// desmarca el vertice 
			marcados[vert] = false; 

			// Revisa que termine donde empezo 
			if (grafo[vert][ini] == 1) { 
				count++; 
				return; 
			} else
				return; 
		} 

		// Busca cada camino posible (k-1)
		for (int i = 0; i < v; i++) 
			if (!marcados[i] && grafo[vert][i] == 1) 

				// DFS 
				DFS(grafo, marcados, n-1, i, ini,v); 

		// Desmarca el vertice  
		marcados[vert] = false; 
	} 

	// Cuenta los ciclos. 
	public  int contarCircuitos(int grafo[][], int k, int v) { 

		// Array de vertices  
		boolean marked[] = new boolean[v]; 


		for (int i = 0; i < v - (k - 1); i++) { 
			DFS(grafo, marked, k-1, i, i,v); 

			// marca vertices 
			marked[i] = true; 
		} 

		return count / 2;  
	} 
	
	

	public static void main(String[] args) { 
		
		try {
			InputStreamReader is= new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is); 

			//valores iniciales del grafo
			
			String line = br.readLine();
			String [] in = line.split(" ");
			int n=Integer.parseInt(in[0]);
			int k= Integer.parseInt(in[1]);
			
			while(n!=0&&k!=0)
			{
				analizar(n,k,br);
				count=0;
				line = br.readLine();
				in = line.split(" ");
				n=Integer.parseInt(in[0]);
				k= Integer.parseInt(in[1]);

			}
			


		} 
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}



	public static void analizar(int n, int k ,BufferedReader br)
	{
		try {
		int grafo[][]= new int[n][n];
		String line = br.readLine();
		String [] dataStr = line.split(" ");
			for(int i=1; i<=n ; i++) {
				
				dataStr = line.split(" ");
				for (int j=1; j<dataStr.length; j++)
				{
					//Valor de la columna 
					int c= Integer.parseInt(dataStr[j]);
					grafo[i-1][c-1]=1;
					grafo[c-1][i-1]=1;
				}
				if(i!=n)
				{
					line = br.readLine();	
				}
			}
			ProblemaB instancia = new ProblemaB();
			int respuesta = instancia.contarCircuitos(grafo,k,n);
			System.out.println(respuesta);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}