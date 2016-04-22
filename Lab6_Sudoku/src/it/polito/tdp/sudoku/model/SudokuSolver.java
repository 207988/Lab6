package it.polito.tdp.sudoku.model;


public class SudokuSolver {
	private int matrix[][]=new int[9][9];
	private int ris[][]=new int[9][9];
	private boolean flag;
	
	
	public int[][] risolviSudoku(int[][] temp,int passo){
		//CONTROLLARE
		flag=false;
		matrix=temp;		
		this.ricorsione();
		return ris;
	}
	
	public void ricorsione(){
		System.out.println();
		//USCITA
		if(checkPasso()==81){
			flag=true;			
			debug();
			ris=matrix;
			return;
		}
		for(int i=0;i<9&&flag==false;i++){
			for(int j=0;j<9&&flag==false;j++){				
				//SE MANCA IL NUMERO
				if(matrix[i][j]==0){
					for(int num=1;num<=9&&flag==false;num++){					
						if(checkNumero(num,i,j)){
							matrix[i][j]=num;							
							ricorsione();
						}			
					}
					//SE E' IMPOSSIBILE ANDARE AVANTI
					if(flag==false)
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
			for(int co=(c-1);co<=c+1;co++){
				if(matrix[ri][co]==numero)
					return false;				
			}			
		}	
		return true;
	}
	
	public void debug(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public int checkPasso(){
		int check=0;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(matrix[i][j]!=0)
					check++;
			}			
		}		
		return check;
	}
}
