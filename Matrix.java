
class Matrix extends Sequence{

  private int rowSize = 0; //row and cols of matrix
  private int colSize = 0;

  public int getRow(){ return rowSize;} //return dimension
  public int getCol(){ return colSize;}

  public Matrix(int rowsize, int colsize){ //construct the matrix using sequences
	rowSize = rowsize;
	colSize = colsize;

	Sequence pointing = this;

	for (int i = 0; i < rowsize; i++){
	Sequence temp = new Sequence();
	pointing.Set(temp);
	pointing.setLength(rowsize - i);
		for ( int j = 0; j < colsize; j++){
			temp.Set(new MyInteger(0));
			temp.SetNext(new Sequence());
			temp.setLength(colsize -j);
			temp = temp.GetNext();
		}	
	pointing.SetNext(new Sequence());
	pointing = pointing.GetNext();	
	}

  }

  public void Set(int rowsize, int colsize, int value){ //set element inside sequence
	MyInteger val = ((MyInteger)((Sequence)index(rowsize)).index(colsize));
	val.Set(value);
  }

  public int Get(int rowsize, int colsize){ //return int from the matrix

	MyInteger val = ((MyInteger)((Sequence)index(rowsize)).index(colsize));
	return val.Get();
  }

  public Matrix Sum(Matrix mat){ //return sum of matrix

	if( this.rowSize != mat.getRow() || this.colSize != mat.getCol()){
		System.out.println("Could not get sum, not matching size of matrix.");
		return null;
	}

	Matrix sumArray = new Matrix(rowSize, colSize);

	for (int i = 0; i < rowSize; i++){
		for(int j = 0; j < colSize; j++){
			sumArray.Set(i, j, Get(i, j) + mat.Get(i, j));
		}
	}
	
	return sumArray;

  }


  public Matrix Product(Matrix mat){ //return product of matrix

	Matrix productArray = new Matrix(this.rowSize, mat.getCol());

	if( this.colSize != mat.getRow()){
		System.out.println("Matrix dimensions incompatible for Product");
		System.exit(0);
	}
	
	int sum = 0;

	for (int i = 0; i < this.rowSize; i++){
		for (int j = 0; j < mat.getCol(); j++){
			for ( int k = 0; k < this.colSize; k++){
				sum += Get(i, k) * mat.Get(k, j);
			}
			productArray.Set(i, j, sum);
			sum = 0;	 
		}
	}
	
	return productArray;

  }

  public void Print(){ //print the matrix

	
	for (int i = 0; i < rowSize; i++){
		System.out.print("[");
		for ( int j = 0; j < colSize; j++){
		System.out.print(" " +  ((MyInteger)((Sequence)index(i)).index(j)).Get()  );
		}
		System.out.println(" ]");
	}

  }

}
