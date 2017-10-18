package mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author saidn
 */
public class MergeSort {
	//sort initialize for create aux[]
	public void sort(Comparable a[], int div){
		Comparable [] aux =  new Comparable[a.length];
		sort(a,aux,0,a.length-1, div);
	}
	//sort
	public void sort(Comparable []a, Comparable[] aux, int low, int hi, int div)throws NullPointerException{

	//Get middle element as in Binary Search
		if((hi-low)<div){
			return ;	
		}else{
			int division = (int) Math.floor((hi-low+1)/div)-1;
			System.out.println("divi: "+division);
			int min_aux = low;
			int auxTop[] = new int [div];
			for(int i = 0; i < div; i++){
				if(i == div-1){
					auxTop[i] = hi;
					break;
				}
				auxTop[i] = (min_aux+division);
				min_aux = auxTop[i] + 1;
			}
			for(int x:auxTop){
				System.out.println("top:"+x);
			}
			min_aux = low;
			for(int counter = 0; counter < div; counter++){
				System.out.println("auxTop: "+ auxTop[counter]+"hi: "+hi+"counter: "+counter);
				if(auxTop[counter] == hi || auxTop[counter] == hi-1){
					System.out.println("aqui low: "+min_aux+"hi: "+hi+"counter: "+counter);
					sort(a,aux,min_aux,hi,div);
					break;
				}else{
					System.out.println("low: "+min_aux+"hi: "+auxTop[counter]+"counter: "+counter);
					sort(a,aux,min_aux,auxTop[counter],div);
				}
				min_aux = auxTop[counter]+1;
		}
		
	//Finally merge all
		merge(a,aux,low,hi,div);
	}}
	//merge
	public void merge(Comparable []a, Comparable[] aux, int low, int hi, int div)throws NullPointerException{
		//copy to aux
		System.out.println("aux size:"+aux.length);
		for(int i = low; i<= hi; i++)
			aux[i] = a[i];
		int division = (int) Math.floor((hi-low)/div);
		//System.out.println("divi: "+division);
		int min_aux = low;
		int auxTop[] = new int [div];
		for(int i = 0; i < div; i++){
			if(i == hi-1){
				auxTop[i] = hi;
				break;
			}
			auxTop[i] = (min_aux+division);
			min_aux = auxTop[i] + 1;
		}
		/*for(int x:auxTop){
			System.out.println("size"+auxTop.length);
		}*/
		//i,j pointers for halves
		int aux1, aux2;
		for(int k=low; k<=hi;k++){
			for(int z = 0; z < div;z++){
				//Validate one of the 2 halves is fully use
				int min, max;
				if(z==0){
					min = low;
					max = auxTop[z]+1;
					aux1=(int) aux[min];
					aux2= (int) aux[max];
				}else if(z==(div-1)){
					min = low;
					max = (int) auxTop[auxTop.length-1];
					aux1= (int) aux[min];
					aux2= (int) aux[max];
				}else{
					min = auxTop[z]+1;
					max = auxTop[z+1]+1;
					aux1= (int) aux[min];
					aux2= (int) aux[max];
				}
				
				System.out.println("min: "+min+" max:"+max+"z:"+z);
				int min_ax = min;
				int max_ax = max;
				while(min < max){
					if(less(aux1,aux2)){
						a[k] = aux[min_ax];
					}
					else{                
						a[k] = aux[max_ax];
					}
					if(min_ax<=max){
						min_ax++;
					}
					if(max_ax<=max){
						max_ax++;
					}
					//cambio
					aux1 = (int)aux[min_ax];
					aux2 = (int)aux[max_ax];
					min++;
				}
				
			}
		}
	}

	private boolean less(Comparable a, Comparable b){
		if(a != null && b!= null){
		//System.out.println("a:"+a+"b:"+b);
		return a.compareTo(b)<0;
		}
		else{
			return false;
		}
	}

	//Test
	public static void main(String [] args){
		Random rdn =  new Random();
		Scanner sc = new Scanner(System.in);
		int n; //100 millions in 2 minutes, need more memory for java to continue
		int division;
		System.out.println("Longitud: ");
		n = sc.nextInt();
		System.out.println("División: ");
		division = sc.nextInt();
		
		Integer [] array = new Integer[n];
		for(int i = 0; i<n;i++){
			array[i] = rdn.nextInt(100);
		}
		System.out.println("filled");
		List<Integer> arrayL = new ArrayList<>();
		for(int a:array){
			arrayL.add(a);
			System.out.println(a+" ");
		}
		
		try{
		
		MergeSort merge =  new MergeSort();
		merge.sort(array,division);
		}catch (Exception e) {
		}
		
		System.out.println("Sorted");
		for(int a:arrayL){
			System.out.println(a+" ");
		}
	}
    
}
