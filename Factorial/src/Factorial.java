import java.util.Scanner;

public class Factorial {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Factorial de: ");
		int numero = sc.nextInt();
		System.out.println("Divisiones: ");
		int division =  sc.nextInt();
		
		int n[] = new int[numero];
		for(int a = 1; a <= numero;a++){
			n[a-1] = a;
		}
		
		int r = factorial(n, division, 0, n.length-1);
		System.out.println("Resultado: "+r);
	}
	public static int factorial(int[] n, int div, int low, int hi){
		
		if((hi-low)<div || div==1){
			int retorno = 1;
			int i=low;
			for(int z = 0; z <=(hi-low); z++, i++){
				System.out.println("n: "+n[i]+"retorno: "+retorno);
				retorno *= n[i];
				//System.out.println("retorno: "+retorno);
			}
			System.out.println("retorno: "+retorno);
			return retorno;
		}else {
			System.out.println("entre");
			int subarreglo_aux = (int) Math.floor((hi-low+1)/div)-1;
			System.out.println("divi: "+subarreglo_aux);
			int min = low;
			
			int auxTop[] = new int [div];
			for(int h = 0; h < div; h++){
				//El ultimo es el mayor
				if(h == div-1){
					auxTop[h] = hi;
					break;
				}
				auxTop[h] = (min+subarreglo_aux);
				min = auxTop[h] + 1;
			}
			
			for(int x:auxTop){
				System.out.println("top:"+x);
			}
			min = low;
			int factorial = 1;
			for(int k = 0; k < div; k++){//modificar min, max
				if(auxTop[k]==hi || auxTop[k]==hi-1){
					//System.out.println("FacTotal: "+factorial);
					factorial *= factorial(n,div, min, hi);
				}else{
					//System.out.println("FacTotal: "+factorial);
					factorial *= factorial(n,div, min, auxTop[k]); 
				}
				System.out.println("FacTotal: "+factorial);
				min = auxTop[k]+1;
			}
			return factorial;
		}
	}
}
