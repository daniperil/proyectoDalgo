
//Autores Camilo Salinas y Daniel Perilla
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ProblemaB {


	static int X = 0;
	static int Y = 0;

	public static void main(String[] args) throws Exception {
		ProblemaB instancia = new ProblemaB();
		try ( 
				InputStreamReader is= new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(is);
				) { 


			//			final String FILENAME = "C:\\Users\\Daniel\\Documents\\Proyecto\\proyectoDalgo\\src\\proyecto\\DatosEntradaProblemaB.txt";
			//			BufferedReader br1 = new BufferedReader(new FileReader(FILENAME));

			String line = br.readLine();

			ArrayList<int []> csArray = new ArrayList<int []>();
//			System.out.println("Entra While");


			while(!"0".equals(line)) 
			{
				final String [] dataStr = line.split(" ");
				final int[] numeros = Arrays.stream(dataStr).mapToInt(f->Integer.parseInt(f)).toArray();
				//				for (int i : numeros) 
				//				{
				//					System.out.println(i);
				//				}
				csArray.add(numeros);
				line = br.readLine();

			}

			int[][] respuesta = instancia.construccionMatriz(csArray);

			int solucion = encontrarSub(respuesta);
			System.out.println(solucion);
			//			br1.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int[][] construccionMatriz(ArrayList<int []> entrada)
	{
//		System.out.println("Entra a m�todo");
		int N = 0;
		int M = 0;

		int[][] respuesta = null;

		for (int i = 0; i < entrada.size(); i++) {
			if(i==0)
			{
				N = entrada.get(i)[0];
				M = entrada.get(i)[1];
				if(N ==0 && M==0)
				{
					break;
				}
//				System.out.println(N);
//				System.out.println(M);
				respuesta = new int[N][M];
				X = entrada.get(i)[2];
				Y = entrada.get(i)[3];
//				System.out.println(X);
//				System.out.println(Y);
			}
			else 
			{
				for (int j = 0; j < M; j++) 
				{
					respuesta[i-1][j]= entrada.get(i)[j];
				}
			}

		}

		return respuesta;
	}


	public static int encontrarSub(int[][] respuesta) 
	{
		int resp = 0;
		int Px1 = 0;
		int Px2 = 0;
		int Py1= 0;
		int Py2 = 0;
		
		if(respuesta[respuesta.length-1][respuesta[0].length-1] < X)
		{
//			System.out.println(resp);
			return resp;
		}
		if(respuesta[0][0]>Y)
		{
//			System.out.println(resp);
			return resp;
		}
		else {
//			System.out.println("Entra");
			
			int max = 0;

				for (int i = 0; i < respuesta.length; i++) 
				{
					for (int j = 0; j < respuesta[0].length; j++) {
						if(respuesta[i][j] >= X)
						{
							Px1 = i;
							Py1= j;
//							System.out.println(Px1);
//							System.out.println(Py1);
//							System.out.println(respuesta[0][3]);
//							System.out.println(X);
							while(i<respuesta.length || j<respuesta[0].length)
							{
								if(respuesta[i][j] > Y)
								{
									
									Px2 = i-1;
									Py2= j-1;
//									System.out.println("Entra if");
//									System.out.println(Px2-Px1);
//									System.out.println(Py2-Py1);
									if((Px2-Px1)==(Py2-Py1))
									{
										max = (Px2-Px1)+1;
										if(max > resp)
										{
											resp = max;
										}
										return resp;
									}
								}
								i++;
								j++;
							}
							
						}
					}	
				}

//		outerloopbackwards:
//			for (int i = respuesta.length-1; i == 0; i--) 
//			{
//				for (int j = respuesta[0].length-1; j ==0; j--) {
//					if(respuesta[i][j] <= Y)
//					{
//						Px2 = i;
//						Py2= j;
//						break outerloopbackwards;
//					}
//				}	
//			}
//				
//				if((Px2-Px1)==(Py2-Py1))
//				{
//					resp = (Px2-Px1);
//				}

				return resp;
		}
	}

} 