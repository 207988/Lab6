package it.polito.tdp.sudoku.model;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {
	private int matrix[][]=new int[9][9];
	//NON USATO PER ORA
	private List<ArrayList<Integer>> sudoku=new ArrayList<ArrayList<Integer>>();
	
	
	public int[][] risolviSudoku(int[][] temp,int passo){
		//CONTROLLARE
		matrix=temp;		
		this.ricorsione(passo);
		
		return matrix;
	}
	
	public void ricorsione(int passo){
		System.out.println(passo);
		//USCITA
		if(passo==81)
			return;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				//SE MANCA IL NUMERO
				if(matrix[i][j]==0){
					for(int num=1;num<=9;num++){					
						if(checkNumero(num,i,j)){
							matrix[i][j]=num;
							passo++;
							ricorsione(passo);
						}					
						
					}
					//SE E' IMPOSSIBILE ANDARE AVANTI
					passo--;
					matrix[i][j]=0;
					return;
				}
					
			
			}		
		}
	}
	
	public boolean checkNumero(int numero,int riga,int colonna){
		//CONTROLLO RIGA
		for(int i=0;i<9;i++){
			if(matrix[i][colonna]==numero)
				return false;
		}
		
		//CONTROLLO COLONNA
		for(int i=0;i<9;i++){
			if(matrix[riga][i]==numero)
				return false;
		}
		
		//CONTROLLO QUADRATO
		int r=riga;
		int c=colonna;
		if(riga==0||riga==3||riga==6)
			r++;
		if(riga==2||riga==5||riga==8)
			r--;
		if(colonna==0||colonna==3||colonna==6)
			c++;
		if(colonna==2||colonna==5||colonna==8)
			c--;
		
		for(int ri=(r-1);ri<=r+1;ri++){
			for(int co=(c-1);co<=c;co++){
				if(matrix[ri][co]==numero)
					return false;
				
			}
			
		}		
		
		
		
		
		
		return true;
	}

}
