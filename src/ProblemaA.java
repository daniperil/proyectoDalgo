//package proyecto;
//Autores Camilo Salinas y Daniel Perilla
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ProblemaA {

	public static void main(String[] args) throws Exception {
		ProblemaA instancia = new ProblemaA();
		try ( 
				InputStreamReader is= new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(is);
				) { 
			String line = br.readLine();

			while(line!=null && line.length()>0 && !"0".equals(line)) {

				final String [] dataStr = line.split(" ");
				final int[] numeros = Arrays.stream(dataStr).mapToInt(f->Integer.parseInt(f)).toArray();
				String respuesta = instancia.reDigit(numeros);
//				System.out.println(Arrays.toString(numeros));
				System.out.println(respuesta);
				line = br.readLine();
			}
		}
	}


	public String reDigit(int [] nyd)
	{
		String resp = "a";
		int N = nyd[0];
		int d = nyd[1];
		int x;

//		System.out.println(""+N+"");
//		System.out.println(""+d+"");

		if(N==0 & d==0)
		{
			System.exit(0);
		}

		if(N%2==0 && d%2!=0)
		{
			resp = "*";
//			System.out.println("EntraPar");
			return resp;
		}

		if(N==5 && d!=5)
		{
			resp = "*";
//			System.out.println("Entra5");
			return resp;
		}


		for (int i = 0; i < Integer.MAX_VALUE; i++) 
		{

			x = N*i;
			String temp = Integer.toString(x);
			//System.out.println(temp);
			int[] arrNumeros = new int[temp.length()];
			int contador1=0;


			int n = 0;
			while(n != temp.length())
			{
				char a = temp.charAt(n);
				int c = Character.getNumericValue(a);
				arrNumeros[n]=c;
				n++;
//				System.out.println("Se meten valores multiplicación a arreglo");
			}
				

//				for(int b : arrNumeros) if(!(b==d)) break;
//				if(contador1 !=0)
//				{
//					contador2=
//				};
//					const allEqual = arr => arr.every( v => v === arr[0] )
//							allEqual( [1,1,1,1] ) 	

				for (int j = 0; j < temp.length(); j++) 
				{
					int h = arrNumeros[j];

					if(h!=d)
					{
						//System.out.println("Entra2");

						break;
					}

					if(h == d)
					{
						contador1++;
//						System.out.println(contador1);
//						System.out.println(temp.length());
						if(contador1==temp.length())
						{
							resp = Integer.toString(contador1);
//							System.out.println("Entra existe respuesta");
						}
					}
			}

			//System.out.println(temp.length());
		}

		return resp;
	}


}
