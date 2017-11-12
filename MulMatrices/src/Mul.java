import java.util.Scanner;

public class Mul {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Filas m: ");
		int fila = sc.nextInt();
		System.out.println("Columnas n: ");
		int columna =  sc.nextInt();
		System.out.println("Columnas k: ");
		int columna2 =  sc.nextInt();
		System.out.println("Valor X: ");
		int x = sc.nextInt();
		System.out.println("Valor Y: ");
		int y =  sc.nextInt();
		int matrizA[][]= new int[fila][columna];
		int matrizB[][]= new int [columna][columna2];
		int matrizR[][]= new int [fila][columna2];
		llenar(matrizA, fila, columna,x);
		llenar(matrizB, columna, columna2,y);
		llenar(matrizR, fila, columna2,0);
		System.out.println("Matriz A");
		imprimir(matrizA, fila, columna);
		System.out.println("Matriz B");
		imprimir(matrizB, columna, columna2);
		multiplica(matrizA, matrizB, matrizR,fila,columna2,0,columna-1);
		System.out.println("Matriz Resultante");
		imprimir(matrizR, fila, columna2);
	
		
	}
	public static void multiplica(int matrizA[][],int matrizB[][],int matrizR[][], int fila,int columna2 ,int mincolumna, int maxcolumna) {
		System.out.println("minColumna: "+mincolumna+" maxColumna: "+maxcolumna);
		if(maxcolumna<=mincolumna) {
			int z=0, h=0;
			for(int k=mincolumna;k<=maxcolumna;k++) {
				matrizR[z][h]+=matrizA[z][k]*matrizB[k][h];
				if(k==maxcolumna && h<columna2-1) {
					k=mincolumna-1;
					h++;
				}
				else{
					if(z<fila-1) {
					z++;
					k=mincolumna-1;
					h=0;
					}
				}
			}
			return;
		}
		else {
			int mid = (maxcolumna+mincolumna)/2;
			multiplica(matrizA, matrizB,matrizR,fila,columna2,mincolumna,mid);
			multiplica(matrizA, matrizB,matrizR,fila,columna2,mid+1,maxcolumna);
		}
	}

	public static void llenar(int matriz[][], int fila, int columna, int numero) {
		for(int i=0;i<fila;i++){
			for(int j=0; j< columna;j++) {
				matriz[i][j]=numero;
			}
		}		
	}
	
	public static void imprimir(int matriz[][],int fila, int columna) {
		for(int i=0;i<fila;i++){
			for(int j=0; j< columna;j++) {
				System.out.print(" "+matriz[i][j]);
			}
			System.out.println("\n");
		}
	}
}

