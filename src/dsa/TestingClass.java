package dsa;

public class TestingClass {
	public static void main(String ...args)
	{
		SparseMatrix A= new SparseMatrix("-5r4c4, 5r1c4, 2r2c2, 5r3c1, -3r3c2, 6r4c2, -7r2c3, 3r1c1");
		SparseMatrix B= new SparseMatrix("1r4c4, 1r4c1, 1r3c3, 1r2c6, 1r2c2, 1r1c1, 1r1c5");
		SparseMatrix C = new SparseMatrix(5,6);
		SparseMatrix D = new SparseMatrix(6,5);
		SparseMatrix E = new SparseMatrix(200,200);
		SparseMatrix F = new SparseMatrix(200,1);
		SparseMatrix G = new SparseMatrix(30000,30000);

		//Initialize	
		C.initializeMatrix(5, 6);
		D.initializeMatrix(6, 5);
		E.initializeMatrix(200, 200);
		F.initializeMatrix(200, 1);
		G.initializeMatrix(30000, 30000);

		//  Print
		System.out.println("MATRIX A: ");
		A.print();
		System.out.println();
		System.out.println("MATRIX B: ");
		B.print();
		System.out.println();
		System.out.println("MATRIX C: ");
		C.print();
		System.out.println();
		System.out.println("MATRIX D: ");
		D.print();
		System.out.println();
		System.out.println("MATRIX E: ");
		E.print();
		System.out.println();
		System.out.println("MATRIX F: ");
		F.print();
		System.out.println();
		System.out.println("MATRIX G: ");
		G.print();
		System.out.println();

		//	Scalar Multiplication and Print
		System.out.println("MATRIX A after multiplying by 5:");
		SparseMatrix A5 = A.scalarMultiply(5);
		A5.print();
		System.out.println();
		System.out.println("MATRIX B after multiplying by 5:");
		SparseMatrix B5 = B.scalarMultiply(5);
		B5.print();
		System.out.println();
		System.out.println("MATRIX C after multiplying by 5:");
		SparseMatrix C5 = C.scalarMultiply(5);
		C5.print();
		System.out.println();
		System.out.println("MATRIX D after multiplying by 5:");
		SparseMatrix D5 = D.scalarMultiply(5);
		D5.print();
		System.out.println();
		System.out.println("MATRIX E after multiplying by 5:");
		SparseMatrix E5 = E.scalarMultiply(5);
		E5.print();
		System.out.println();
		System.out.println("MATRIX F after multiplying by 5:");
		SparseMatrix F5 = F.scalarMultiply(5);
		F5.print();
		System.out.println();
		System.out.println("MATRIX G after multiplying by 5:");
		SparseMatrix G5 = G.scalarMultiply(5);
		G5.print();
		System.out.println();

		//  equals method invocation	
		SparseMatrix array_of_matrices[] = new SparseMatrix[7];
		array_of_matrices[0] = A;
		array_of_matrices[1] = B;
		array_of_matrices[2] = C;
		array_of_matrices[3] = D;
		array_of_matrices[4] = E;
		array_of_matrices[5] = F;
		array_of_matrices[6] = G;


		char names[] = new char[7];
		names[0] = 'A';
		names[1] = 'B';
		names[2] = 'C';
		names[3] = 'D';
		names[4] = 'E';
		names[5] = 'F';
		names[6] = 'G';
		for(int i=0;i<7;i++)
		{	
			for(int j=0;j<7;j++)
			{
				if(array_of_matrices[i].equals(array_of_matrices[j])==true)
					System.out.println(names[i]+" is equal to "+names[j]);
				else
					System.out.println(names[i]+" is not equal to "+names[j]);
			}
		}

		System.out.println("--------------------------------STEP 2-------------------------------");
		//Adding each matrix with itself	
		System.out.println("Matrix A after adding with itself");
		long startTime = System.nanoTime();
		SparseMatrix Aplus = A.add(A);
		long endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Aplus.print();
		
		System.out.println("Matrix B after adding with itself");
		startTime = System.nanoTime();
		SparseMatrix Bplus = B.add(B);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Bplus.print();
		
		System.out.println("Matrix C after adding with itself");
		startTime = System.nanoTime();
		SparseMatrix Cplus = C.add(C);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Cplus.print();
		
		System.out.println("Matrix D after adding with itself");
		startTime = System.nanoTime();
		SparseMatrix Dplus = D.add(D);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Dplus.print();
		
		System.out.println("Matrix E after adding with itself");
		startTime = System.nanoTime();
		SparseMatrix Eplus = E.add(E);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Eplus.print();
		
		System.out.println("Matrix F after adding with itself");
		startTime = System.nanoTime();
		SparseMatrix Fplus = F.add(F);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Fplus.print();
		
		System.out.println("Matrix G after adding with itself");
		startTime = System.nanoTime();
		SparseMatrix Gplus = G.add(G);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Gplus.print();
		System.out.println();
		
		
		
		
		//Subtracting each matrix with itself	
		System.out.println("Matrix A after subtracting with itself");
		startTime = System.nanoTime();
		SparseMatrix Aminus = A.subtract(A);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Aminus.print();
		System.out.println("Matrix B after subtracting with itself");
		startTime = System.nanoTime();
		SparseMatrix Bminus = B.subtract(B);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Bminus.print();
		System.out.println("Matrix C after subtracting with itself");
		startTime = System.nanoTime();
		SparseMatrix Cminus = C.subtract(C);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Cminus.print();
		System.out.println("Matrix D after subtracting with itself");
		startTime = System.nanoTime();
		SparseMatrix Dminus = D.subtract(D);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Dminus.print();
		System.out.println("Matrix E after subtracting with itself");
		startTime = System.nanoTime();
		SparseMatrix Eminus = E.subtract(E);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Eminus.print();
		System.out.println("Matrix F after subtracting with itself");
		startTime = System.nanoTime();
		SparseMatrix Fminus = F.subtract(F);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Fminus.print();
		System.out.println("Matrix G after subtracting with itself");
		startTime = System.nanoTime();
		SparseMatrix Gminus = G.subtract(G);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Gminus.print();
		
		//Subtracting each matrix with scalar multiplication of itself	
		System.out.println("5A - A");
		startTime = System.nanoTime();
		SparseMatrix A5minus = A5.subtract(A);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		A5minus.print();
		System.out.println("5B - B");
		startTime = System.nanoTime();
		SparseMatrix B5minus = B5.subtract(B);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		B5minus.print();
		System.out.println("5C - C");
		startTime = System.nanoTime();
		SparseMatrix C5minus = C5.subtract(C);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		C5minus.print();
		System.out.println("5D - D");
		startTime = System.nanoTime();
		SparseMatrix D5minus = D5.subtract(D);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		D5minus.print();
		System.out.println("5E - E");
		startTime = System.nanoTime();
		SparseMatrix E5minus = E5.subtract(E);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		E5minus.print();
		System.out.println("5F - F");
		startTime = System.nanoTime();
		SparseMatrix F5minus = F5.subtract(F);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		F5minus.print();
		System.out.println("5G - G");
		startTime = System.nanoTime();
		SparseMatrix G5minus = G5.subtract(G);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		G5minus.print();
		
		//Multiplication
		System.out.println();
		System.out.println("B*Transpose of C" );
		SparseMatrix TC  = C.transpose();
		startTime = System.nanoTime();
		SparseMatrix BMulTC = B.multiply(TC);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		if(BMulTC!=null)
			BMulTC.print();
		System.out.println();
		System.out.println("C*D");
		startTime = System.nanoTime();
		SparseMatrix CMulD = C.multiply(D);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		if(CMulD!=null)
			CMulD.print();
		System.out.println();
		System.out.println("D*C");
		startTime = System.nanoTime();
		SparseMatrix DMulC = D.multiply(C);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		if(DMulC!=null)
			DMulC.print();
		System.out.println();
		System.out.println("E*F");
		startTime = System.nanoTime();
		SparseMatrix EMulF = E.multiply(F);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		if(EMulF!=null)
			EMulF.print();
		System.out.println();
		System.out.println("A*A");
		startTime = System.nanoTime();
		SparseMatrix AMulA = A.multiply(A);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		if(AMulA!=null)
			AMulA.print();
		System.out.println();
		System.out.println("E*E");
		startTime = System.nanoTime();
		SparseMatrix EMulE = E.multiply(E);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		if(EMulE!=null)
			EMulE.print();
		System.out.println();
		
		System.out.println("A^5");
		startTime = System.nanoTime();
		SparseMatrix Apower5 = A.power(5);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Apower5.print();
		System.out.println();
		System.out.println("A^25");
		startTime = System.nanoTime();
		SparseMatrix Apower25 = A.power(25);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Apower25.print();
		System.out.println("E^5");
		startTime = System.nanoTime();
		SparseMatrix Epower5 = E.power(5);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Epower5.print();
		System.out.println();
		System.out.println("E^25");
		startTime = System.nanoTime();
		SparseMatrix Epower25 = E.power(25);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		Epower25.print();
		System.out.println();
		
		
		System.out.println("A Transpose");
		SparseMatrix AT = A.transpose();
		AT.print();
		System.out.println();
		System.out.println("B Transpose");
		SparseMatrix BT = B.transpose();
		BT.print();
		System.out.println();
		System.out.println("C Transpose");
		SparseMatrix CT = C.transpose();
		CT.print();
		System.out.println();
		System.out.println("D Transpose");
		SparseMatrix DT = D.transpose();
		DT.print();
		System.out.println();
		System.out.println("E Transpose");
		SparseMatrix ET = E.transpose();
		ET.print();
		System.out.println();
		System.out.println("F Transpose");
		SparseMatrix FT = F.transpose();
		FT.print();
		System.out.println();
		System.out.println("G Transpose");
		SparseMatrix GT = G.transpose();
		GT.print();
		System.out.println();
		
		
		System.out.println();
		System.out.println("A*A^T");
		startTime = System.nanoTime();
		SparseMatrix AMulAT = A.multiply(AT);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		AMulAT.print();
		System.out.println();
		System.out.println("B*B^T");
		startTime = System.nanoTime();
		SparseMatrix BMulBT = B.multiply(BT);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		BMulBT.print();
		System.out.println();
		System.out.println("C*C^T");
		startTime = System.nanoTime();
		SparseMatrix CMulCT = C.multiply(CT);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		CMulCT.print();
		System.out.println();
		System.out.println("D*D^T");
		startTime = System.nanoTime();
		SparseMatrix DMulDT = D.multiply(DT);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		DMulDT.print();
		System.out.println();
		System.out.println("E*E^T");
		startTime = System.nanoTime();
		SparseMatrix EMulET = E.multiply(ET);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		EMulET.print();
		System.out.println();
		System.out.println("F*F^T");
		startTime = System.nanoTime();
		SparseMatrix FMulFT = F.multiply(FT);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		FMulFT.print();
		
		
		
		System.out.println();
		System.out.println("A^T*A");
		startTime = System.nanoTime();
		SparseMatrix ATMulA = AT.multiply(A);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		ATMulA.print();
		System.out.println();
		System.out.println("B^T*B");
		startTime = System.nanoTime();
		SparseMatrix BTMulB = BT.multiply(B);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		BTMulB.print();
		System.out.println();
		System.out.println("C^T*C");
		startTime = System.nanoTime();
		SparseMatrix CTMulC = CT.multiply(C);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		CTMulC.print();
		System.out.println();
		System.out.println("D^T*D");
		startTime = System.nanoTime();
		SparseMatrix DTMulD = DT.multiply(D);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		DTMulD.print();
		System.out.println();
		System.out.println("E^T*E");
		startTime = System.nanoTime();
		SparseMatrix ETMulE = ET.multiply(E);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		ETMulE.print();
		System.out.println();
		System.out.println("F^T*F");
		startTime = System.nanoTime();
		SparseMatrix FTMulF = FT.multiply(F);
		endTime = System.nanoTime();
		System.out.println("Time Taken = "+(endTime-startTime));
		FTMulF.print();		
		
/*		SparseMatrix examp = A.transpose();
		examp.print();*/
	}
}
