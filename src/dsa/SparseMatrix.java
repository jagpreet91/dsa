package dsa;


public class SparseMatrix {

	private MatrixEntry [] array;
	private int numEntries;

	private final int m;
	private final int n;
	public SparseMatrix(int passed_values[],int passed_row[],int passed_col[],int m,int n)
	{
		this.m = m;
		this.n = n;
		this.array = new MatrixEntry[passed_values.length];
		for(int i=0;i<this.array.length;i++)
		{
			this.array[i] = new MatrixEntry(passed_values[i],passed_row[i],passed_col[i]);
		}
		mergesort(this.array);
	}
	public SparseMatrix(int m, int n) {
		this.m = m;
		this.n = n;
		// You will need to "grow" the array efficiently 
		// as more values are added.
	}
	public void initializeMatrix(int m,int n)
	{
		int counter=0;
		//Matrix C
		if((m==5)&&(n==6))
		{
			//RUBAL_START: Get the size of Matrix entry in counter variable
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<6;j++)
				{
					if((((i+1)+(j+1))%2)==0)
					{
						counter++;
					}
				}
			}
			//RUBAL_END: 
			//RUBAL_START: Initialize the MatrixEntry array with corresponding values
			this.array = new MatrixEntry[counter];
			int temp=0;
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<6;j++)
				{
					if((((i+1)+(j+1))%2)==0)
					{
						this.array[temp] = new MatrixEntry((i+1)*(j+1),(i+1),(j+1));
						temp++;
					}
				}
			}
			//RUBAL_END:
		}
		//Matrix D
		if((m==6)&&(n==5))
		{
			//RUBAL_START: Get the size of Matrix entry in counter variable
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if((((i+1)*(j+1))%4)==0)
					{
						counter++;
					}
				}
			}
			//RUBAL_END: 
			//RUBAL_START: Initialize the MatrixEntry array with corresponding values
			this.array = new MatrixEntry[counter];
			int temp=0;
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if((((i+1)*(j+1))%4)==0)
					{
						this.array[temp] = new MatrixEntry((i+1)+(j+1),(i+1),(j+1));
						temp++;
					}
				}
			}
			//RUBAL_END:
		}
		//Matrix E
		if((m==200)&&(n==200))
		{
			//RUBAL_START: Get the size of Matrix entry in counter variable
			for(int i=0;i<m;i++)
			{
				if(((i+1)%10)==0)
				{
					counter++;
				}
			}
			//RUBAL_END: 
			//RUBAL_START: Initialize the MatrixEntry array with corresponding values
			this.array = new MatrixEntry[n*counter];
			int temp=0;
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(((i+1)%10)==0)
					{
						this.array[temp] = new MatrixEntry((i+1)+(2*(j+1)),(i+1),(j+1));
						temp++;
					}
					else
					{
						break;
					}
				}
			}
			//RUBAL_END:
		}
		//Matrix F
		if((m==200)&&(n==1))
		{
			//RUBAL_START: Get the size of Matrix entry in counter variable
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(((i+1)%5)==0)
					{
						counter++;
					}
				}
			}
			//RUBAL_END: 
			//RUBAL_START: Initialize the MatrixEntry array with corresponding values
			this.array = new MatrixEntry[counter];
			int temp=0;
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(((i+1)%5)==0)
					{
						this.array[temp] = new MatrixEntry((5*(i+1)),(i+1),(j+1));
						temp++;
					}
				}
			}
			//RUBAL_END:
		}

		//Matrix G
		if((m==30000)&&(n==30000))
		{
			//RUBAL_START: Get the size of Matrix entry in counter variable
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(((i+1)%(j+1))==0)
					{
						counter++;
					}
				}
			}
			//RUBAL_END: 
			//RUBAL_START: Initialize the MatrixEntry array with corresponding values
			this.array = new MatrixEntry[counter];
			int temp=0;
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(((i+1)%(j+1))==0)
					{
						this.array[temp] = new MatrixEntry(((i+1)+(j+1)),(i+1),(j+1));
						temp++;
					}
				}
			}
			//RUBAL_END:
			/*for(int i=0;i<this.array.length;i++)
						System.out.println(this.array[i].Getvalue()+"   "+this.array[i].Getrow()+"   "+this.array[i].Getcol());*/
		}
		this.numEntries = this.array.length;
	}
	public SparseMatrix(String str) {
		String row_value = new String();
		String col_value = new String();
		String val_value = new String();
		str=str.replace(" ","");
		String[] lineSplit = str.split(",");

		int tabular_value[] = new int[lineSplit.length];
		int tabular_row[] = new int[lineSplit.length];
		int tabular_col[] = new int[lineSplit.length];

		//Rubal_Start: evaluates n,row,column values in a string
		for(int i=0;i<lineSplit.length;i++)
		{
			int j=0;
			while(((lineSplit[i].charAt(j))!='r')&&(j<lineSplit[i].length()))
			{
				val_value+=lineSplit[i].charAt(j);
				j++;
			}
			tabular_value[i] = Integer.parseInt(val_value);
			val_value="";


			int k =j+1;
			while(((lineSplit[i].charAt(k))!='c')&&(k<lineSplit[i].length()))
			{
				row_value+=lineSplit[i].charAt(k);
				k++;
			}
			tabular_row[i] = Integer.parseInt(row_value);
			row_value="";


			int l =k+1;
			while((l<lineSplit[i].length()))
			{
				col_value+=lineSplit[i].charAt(l);
				l++;
			}
			tabular_col[i] = Integer.parseInt(col_value);
			col_value="";
		}
		//Rubal_End
		//Rubal_Start: puts all the row values in an array in order to find the maximum row and column , i.e "m" & "n"

		int row_m=tabular_row[0];
		int col_m=tabular_col[0];
		for(int i=1;i<tabular_row.length;i++)
		{
			if(row_m<tabular_row[i])
				row_m = tabular_row[i];
		}
		for(int i=1;i<tabular_col.length;i++)
		{
			if(col_m<tabular_col[i])
				col_m = tabular_col[i];
		}
		m = row_m;
		n = col_m;
		this.array = new MatrixEntry[lineSplit.length];
		if(m>=n)
		{
			for(int i=0;i<tabular_row.length;i++)
			{
				this.array[i] = new MatrixEntry(tabular_value[i],tabular_row[i],tabular_col[i]);
			}
		}
		else
		{
			for(int i=0;i<tabular_col.length;i++)
			{
				this.array[i] = new MatrixEntry(tabular_value[i],tabular_row[i],tabular_col[i]);
			}
		}
		mergesort(this.array);
		/*for(int i=0;i<this.array.length;i++)
		System.out.println(this.array[i].Getvalue()+"   "+this.array[i].Getrow()+"   "+this.array[i].Getcol());*/
	}
	public static void merge(MatrixEntry l_arr[],MatrixEntry r_arr[],MatrixEntry arr[])
	{
		int i=0,j=0,k=0;
		while((i<l_arr.length)&&(j<r_arr.length))
		{
			if(l_arr[i].Getrow()<r_arr[j].Getrow())
			{
				arr[k] = l_arr[i];
				i++;
				k++;
			}
			else if(l_arr[i].Getrow()==r_arr[j].Getrow())
			{
				if(l_arr[i].Getcol()>r_arr[j].Getcol())
				{
					arr[k] = r_arr[j];
					j++;
					k++;
				}
				else
				{
					arr[k] = l_arr[i];
					i++;
					k++;
				}
			}
			else
			{
				arr[k] = r_arr[j];
				j++;
				k++;
			}
		}
		while(i<l_arr.length)
		{
			arr[k]=l_arr[i];
			k++;
			i++;
		}
		while(j<r_arr.length)
		{
			arr[k]=r_arr[j];
			k++;
			j++;
		}

	}
	public static void mergesort(MatrixEntry arr[])
	{
		int length = arr.length;
		if(length<2)
			return;
		MatrixEntry left_arr[]=new MatrixEntry[length/2];
		MatrixEntry right_arr[]=new MatrixEntry[length-left_arr.length];
		for(int i=0;i<left_arr.length;i++)
			left_arr[i]=arr[i];
		for(int i=0;i<right_arr.length;i++)
			right_arr[i]=arr[i+left_arr.length];
		mergesort(left_arr);
		mergesort(right_arr);
		merge(left_arr,right_arr,arr);
	}
	public static int BinarySearch_col(MatrixEntry a[],int low,int high,int col_element)
	{
		if(low==high)
			return -1;
		int mid=(low+high)/2;
		if(a[mid].Getcol()==col_element)
			return mid;
		else if(a[mid].Getcol()<col_element)
			return BinarySearch_col(a,mid+1,high,col_element);
		else
			return BinarySearch_col(a,low,mid,col_element);
	}
	public void print() 
	{
		if(this.array == null)
		{
			System.out.println("Error: Sparse Matrix has not been initialized");
			return;
		}
		boolean flag1 = false;
		boolean flag2 = false;
		int temp=0,temp_row_1=0,temp_row_2=0,temp_col_1=0;
		if((m<=6)&&(n<=6))
		{
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if((temp)<this.array.length)
					{
						if((this.array[temp].Getrow()==i+1)&&(this.array[temp].Getcol()==j+1))
						{
							System.out.print(this.array[temp].Getvalue()+"   ");
							temp++;
						}
						else
							System.out.print("0   ");
					}
					else
						System.out.print("0   ");
				}
				System.out.println(" ");
			}
		}
		else if(m<=6)
		{
			//No matrix given			
		}
		else if(n<=6)
		{
			int top_half[] = new int[2*n];
			int bottom_half[] = new int [2*n];

			//top_half array
			temp_row_1 = -1;
			//check if row1 exists
			for(int i=0;i<this.array.length;i++)
			{
				if(this.array[i].Getrow() == 1)
				{
					temp_row_1 = i;
					break;
				}
			}
			if(temp_row_1==-1)
			{
				for(int i=0;i<top_half.length/2;i++)
					top_half[i] = 0;
			}
			else
			{
				int store=temp_row_1;
				while(this.array[store].Getrow()==1)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				for(int i=0;i<top_half.length/2;i++)
				{
					temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,i+1);
					if(temp_col_1==-1)
						top_half[i] = 0;
					else
						top_half[i] =  this.array[temp_col_1].Getvalue();
				}
			}
			temp_row_1 = -1;
			//check if row2 exists
			for(int i=0;i<this.array.length;i++)
			{
				if(this.array[i].Getrow() == 2)
				{
					temp_row_1 = i;
					break;
				}
			}
			if(temp_row_1==-1)
			{
				for(int i=top_half.length/2;i<top_half.length;i++)
					top_half[i] = 0;
			}
			else
			{
				int store=temp_row_1;
				while(this.array[store].Getrow()==2)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				for(int i=top_half.length/2;i<top_half.length;i++)
				{
					temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,i);
					if(temp_col_1==-1)
						top_half[i] = 0;
					else
						top_half[i] =  this.array[temp_col_1].Getvalue();
				}
			}
			//bottom_half_array
			temp_row_1 = -1;
			//check if row m-1 exists
			for(int i=0;i<this.array.length;i++)
			{
				if(this.array[i].Getrow() == m-1)
				{
					temp_row_1 = i;
					break;
				}
			}
			if(temp_row_1==-1)
			{
				for(int i=0;i<bottom_half.length/2;i++)
					bottom_half[i] = 0;
			}
			else
			{
				int store=temp_row_1;
				while(this.array[store].Getrow()==m-1)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				for(int i=0;i<bottom_half.length/2;i++)
				{
					temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,i+1);
					if(temp_col_1==-1)
						bottom_half[i] = 0;
					else
						bottom_half[i] =  this.array[temp_col_1].Getvalue();
				}
			}
			temp_row_1 = -1;
			//check if row m exists
			for(int i=0;i<this.array.length;i++)
			{
				if(this.array[i].Getrow() == m)
				{
					temp_row_1 = i;
					break;
				}
			}
			if(temp_row_1==-1)
			{
				for(int i=bottom_half.length/2;i<bottom_half.length;i++)
					bottom_half[i] = 0;
			}
			else
			{
				int store=temp_row_1;
				while(this.array[store].Getrow()==m)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				for(int i=bottom_half.length/2;i<bottom_half.length;i++)
				{
					temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,i);
					if(temp_col_1==-1)
						bottom_half[i] = 0;
					else
						bottom_half[i] =  this.array[temp_col_1].Getvalue();
				}
			}
			for(int i=0;i<top_half.length/2;i++)
			{
				System.out.print(top_half[i] +" ");
			}
			System.out.println();
			for(int i=top_half.length/2;i<top_half.length;i++)
			{
				System.out.print(top_half[i] +" ");
			}
			System.out.println();
			for(int i=0;i<n;i++)
			{
				System.out.println(".");
				System.out.println(".");
				System.out.println(".");
			}
			for(int i=0;i<bottom_half.length/2;i++)
			{
				System.out.print(bottom_half[i]);
			}
			System.out.println();
			for(int i=bottom_half.length/2;i<bottom_half.length;i++)
			{
				System.out.print(bottom_half[i] +" ");
			}
			System.out.println();
		}
		else
		{
			//TOP_LEFT ARRAY
			temp_row_1=-1;
			int top_left[] = new int[4];
			int top_right[] = new int[4];
			int bottom_left[] = new int[4];
			int bottom_right[]= new int[4];
			int index=0;

			//check if row1 exists
			for(int i=0;i<this.array.length;i++)
			{
				if(this.array[i].Getrow() == 1)
				{
					temp_row_1 = i;
					break;
				}
			}
			if(temp_row_1==-1)
			{
				top_left[0] = 0;
				top_left[1] = 0;
			}
			else
			{
				int store=temp_row_1;
				while(this.array[store].Getrow()==1)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,1);
				if(temp_col_1==-1)
					top_left[0] = 0;
				else
					top_left[0] =  this.array[temp_col_1].Getvalue();
				store=temp_row_1;
				while(this.array[store].Getrow()==1)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,2);
				if(temp_col_1==-1)
					top_left[1] = 0;
				else
					top_left[1] =  this.array[temp_col_1].Getvalue();
			}
			temp_row_1 = -1;
			//check if row2 exists
			for(int i=0;i<this.array.length;i++)
			{
				if(this.array[i].Getrow() == 2)
				{
					temp_row_1 = i;
					break;
				}
			}
			if(temp_row_1==-1)
			{
				top_left[2] = 0;
				top_left[3] = 0;
			}
			else
			{
				int store=temp_row_1;
				while(this.array[store].Getrow()==2)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,1);
				if(temp_col_1==-1)
					top_left[2] = 0;
				else
					top_left[2] =  this.array[temp_col_1].Getvalue();
				store=temp_row_1;
				while(this.array[store].Getrow()==2)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,2);
				if(temp_col_1==-1)
					top_left[3] = 0;
				else
					top_left[3] =  this.array[temp_col_1].Getvalue();
			}

			temp_row_1 = -1;
			//TOP_RIGHT ARRAY
			//check if row1 exists
			for(int i=0;i<this.array.length;i++)
			{
				if(this.array[i].Getrow() == 1)
				{
					temp_row_1 = i;
					break;
				}
			}
			if(temp_row_1==-1)
			{
				top_right[0] = 0;
				top_right[1] = 0;
			}
			else
			{
				int store=temp_row_1;
				while(this.array[store].Getrow()==1)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,n-1);
				if(temp_col_1==-1)
					top_right[0] = 0;
				else
					top_right[0] =  this.array[temp_col_1].Getvalue();
				store=temp_row_1;
				while(this.array[store].Getrow()==1)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,n);
				if(temp_col_1==-1)
					top_right[1] = 0;
				else
					top_right[1] =  this.array[temp_col_1].Getvalue();
			}
			temp_row_1 = -1;
			//check if row2 exists
			for(int i=0;i<this.array.length;i++)
			{
				if(this.array[i].Getrow() == 2)
				{
					temp_row_1 = i;
					break;
				}
			}
			if(temp_row_1==-1)
			{
				top_right[2] = 0;
				top_right[3] = 0;
			}
			else
			{
				int store=temp_row_1;
				while(this.array[store].Getrow()==2)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,n-1);
				if(temp_col_1==-1)
					top_right[2] = 0;
				else
					top_right[2] =  this.array[temp_col_1].Getvalue();
				store=temp_row_1;
				while(this.array[store].Getrow()==2)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,n);
				if(temp_col_1==-1)
					top_right[3] = 0;
				else
					top_right[3] =  this.array[temp_col_1].Getvalue();
			}
			temp_row_1 = -1;
			//BOTTOM_LEFT ARRAY
			//check if row m-1 exists
			for(int i=0;i<this.array.length;i++)
			{
				if(this.array[i].Getrow() == m-1)
				{
					temp_row_1 = i;
					break;
				}
			}
			if(temp_row_1==-1)
			{
				bottom_left[0] = 0;
				bottom_left[1] = 0;
				flag1 = true;
			}
			else
			{
				int store=temp_row_1;
				while(this.array[store].Getrow()==m-1)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,1);
				if(temp_col_1==-1)
					bottom_left[0] = 0;
				else
					bottom_left[0] =  this.array[temp_col_1].Getvalue();
				store=temp_row_1;
				while(this.array[store].Getrow()==m-1)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,2);
				if(temp_col_1==-1)
					bottom_left[1] = 0;
				else
					bottom_left[1] =  this.array[temp_col_1].Getvalue();
			}
			//check if row m exists
			for(int i=0;i<this.array.length;i++)
			{
				if(this.array[i].Getrow() == m)
				{
					temp_row_2 = i;
					break;
				}
			}
			if(temp_row_2==-1)
			{
				bottom_left[2] = 0;
				bottom_left[3] = 0;
				flag2 = true;
			}
			else
			{
				int store=temp_row_2;
				while(this.array[store].Getrow()==m)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_2,store,1);
				if(temp_col_1==-1)
					bottom_left[2] = 0;
				else
					bottom_left[2] =  this.array[temp_col_1].Getvalue();
				store=temp_row_2;
				while(this.array[store].Getrow()==m)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_2,store,2);
				if(temp_col_1==-1)
					bottom_left[3] = 0;
				else
					bottom_left[3] =  this.array[temp_col_1].Getvalue();
			}

			//BOTTOM RIGHT ARRAY
			if(flag1 == false)
			{
				int store=temp_row_1;
				while(this.array[store].Getrow()==m-1)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,n-1);
				if(temp_col_1==-1)
					bottom_right[0] = 0;
				else
					bottom_right[0] =  this.array[temp_col_1].Getvalue();
				store=temp_row_1;
				while(this.array[store].Getrow()==m-1)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_1,store,n);
				if(temp_col_1==-1)
					bottom_right[1] = 0;
				else
					bottom_right[1] =  this.array[temp_col_1].Getvalue();
			}
			if(flag2== false)
			{
				int store=temp_row_2;
				while(this.array[store].Getrow()==m)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_2,store,n-1);
				if(temp_col_1==-1)
					bottom_right[2] = 0;
				else
					bottom_right[2] =  this.array[temp_col_1].Getvalue();
				store=temp_row_2;
				while(this.array[store].Getrow()==m)
				{
					store++;
					if(store==this.array.length)
						break;
				}
				temp_col_1 = BinarySearch_col(this.array,temp_row_2,store,n);
				if(temp_col_1==-1)
					bottom_right[3] = 0;
				else
					bottom_right[3] =  this.array[temp_col_1].Getvalue();
			}
			if((this.m>200)&&(this.n>200))
			{
				System.out.println(top_left[0]+"       "+top_left[1]+"    ...      "+top_right[0]+"       "+top_right[1]);
				System.out.println(top_left[2]+"       "+top_left[3]+"    ...      "+top_right[2]+"       "+top_right[3]);
				System.out.println(".       .    ...      .       .");
				System.out.println(".       .    ...      .       .");
				System.out.println(bottom_left[0]+"   "+bottom_left[1]+"    ...      "+bottom_right[0]+"   "+bottom_right[1]);
				System.out.println(bottom_left[2]+"   "+bottom_left[3]+"...      "+bottom_right[2]+"    "+bottom_right[3]);
			}
			else
			{

				System.out.println(top_left[0]+"       "+top_left[1]+"  ...  "+top_right[0]+"       "+top_right[1]);
				System.out.println(top_left[2]+"       "+top_left[3]+"  ...  "+top_right[2]+"       "+top_right[3]);
				System.out.println(".       .       .       .");
				System.out.println(".       .       .       .");
				System.out.println(bottom_left[0]+"       "+bottom_left[1]+"  ...  "+bottom_right[0]+"       "+bottom_right[1]);
				System.out.println(bottom_left[2]+"     "+bottom_left[3]+"...  "+bottom_right[2]+"     "+bottom_right[3]);	
			}
		}
	}

	public boolean equals(SparseMatrix m) {
		if(this.array == null)
		{
			System.out.println("Error: Sparse Matrix has not been initialized");
			return false;
		}
		boolean flag = false;
		if((m.m == this.m)&&(m.n == this.n))
		{
			if(m.array.length == this.array.length)
			{
				for(int i=0;i<array.length;i++)
				{
					if((m.array[i].Getcol()!=this.array[i].Getcol())||(m.array[i].Getrow()!=this.array[i].Getrow())||(m.array[i].Getvalue()!=this.array[i].Getvalue()))
					{
						flag =  true;
					}
				}
				if(flag == false)
					return true;
				else 
					return false;
			}
		}
		return false;
	}

	public SparseMatrix scalarMultiply(int c) {
		if(this.array == null)
		{
			System.out.println("Error: Sparse Matrix has not been initialized");
			return new SparseMatrix(m,n);
		}
		int i=0;
		int values_array[] = new int[this.array.length];
		int row_array[] = new int[this.array.length];
		int col_array[] = new int[this.array.length];
		while(i<this.array.length)
		{
			values_array[i] = this.array[i].Getvalue()*c;
			row_array[i] = this.array[i].Getrow();
			col_array[i] = this.array[i].Getcol();
			i++;
		}
		return new SparseMatrix(values_array,row_array,col_array,m,n);
	}

	public SparseMatrix add(SparseMatrix m) {
		if((this.m!=m.m)||(this.n!=m.n))
		{
			System.out.println("the matrices are not of the same length");
			return null;
		}
		else
		{
			int values_array[] = new int[this.array.length];
			int row_array[] = new int[this.array.length];
			int col_array[] = new int[this.array.length];
			for(int i=0;i<this.array.length;i++)
			{
				values_array[i] = this.array[i].Getvalue()+m.array[i].Getvalue();
				row_array[i] = this.array[i].Getrow();
				col_array[i] = this.array[i].Getcol();
			}
			return new SparseMatrix(values_array,row_array,col_array,m.m,m.n);
		}
	}

	public SparseMatrix subtract(SparseMatrix m) {
		if((this.m!=m.m)||(this.n!=m.n))
		{
			System.out.println("the matrices are not of the same length");
			return null;
		}
		else
		{
			int values_array[] = new int[this.array.length];
			int row_array[] = new int[this.array.length];
			int col_array[] = new int[this.array.length];
			for(int i=0;i<this.array.length;i++)
			{
				values_array[i] = this.array[i].Getvalue()-m.array[i].Getvalue();
				row_array[i] = this.array[i].Getrow();
				col_array[i] = this.array[i].Getcol();
			}
			return new SparseMatrix(values_array,row_array,col_array,m.m,m.n);
		}
	}

	public SparseMatrix multiply(SparseMatrix m) {
		if(this.n!=m.m)
		{
			System.out.println("Error: the number of columns in the 1st matrix must be equal to the number of rows in the 2nd matrix");
			return null;
		}
		else
		{
			//SparseMatrix tempo = m.transpose();
			MatrixEntry temp1[] = new MatrixEntry[this.m*this.n];
			MatrixEntry temp2[] = new MatrixEntry[m.m*m.n];
			MatrixEntry temp3[] = new MatrixEntry[m.m*m.n];
			int cnt = 0;
			int iter = 0;
			int cnt1 = 0;
			int iter1 = 0;
			for(int i=0;i<this.m;i++)
			{
				for(int j=0;j<this.n;j++)
				{
					if((cnt<this.array.length)&&(this.array[cnt].Getrow()==i+1)&&(this.array[cnt].Getcol()==j+1))
					{

						//System.out.println(this.array[cnt].Getrow()+"   "+this.array[cnt].Getcol()+"    "+this.array[cnt].Getvalue() );
						temp1[iter]=new MatrixEntry(this.array[cnt].Getvalue(),this.array[cnt].Getrow(),this.array[cnt].Getcol());
						cnt++;

					}
					else
					{
						//System.out.println((i+1)+"   "+(j+1)+"   "+ 0);
						temp1[iter]=new MatrixEntry(0,i+1,j+1);
					}
					iter++;
				}
			}

			for(int i=0;i<m.m;i++)
			{
				for(int j=0;j<m.n;j++)
				{
					if((cnt1<m.array.length)&&(m.array[cnt1].Getrow()==i+1)&&(m.array[cnt1].Getcol()==j+1))
					{

						//System.out.println(m.array[cnt1].Getrow()+"   "+m.array[cnt1].Getcol()+"    "+m.array[cnt1].Getvalue() );
						temp2[iter1]=new MatrixEntry(m.array[cnt1].Getvalue(),m.array[cnt1].Getrow(),m.array[cnt1].Getcol());
						cnt1++;

					}
					else
					{
						//System.out.println((i+1)+"   "+(j+1)+"   "+ 0);
						temp2[iter1]=new MatrixEntry(0,i+1,j+1);
					}
					iter1++;
				}
			}
			//SparseMatrix examp = .transpose();
			//mergesort(temp2);
			for(int i=0;i<temp2.length;i++)
				temp3[i]=new MatrixEntry(temp2[i].Getvalue(),temp2[i].Getcol(),temp2[i].Getrow());
			mergesort(temp3);
/*			int x=0;
    		for(int i=0;i<m.m;i++)
    		{
    			for(int j=0;j<m.n;j++)
    			{
    				System.out.println(temp3[x].Getrow()+"   "+temp3[x].Getcol()+"    "+temp3[x].Getvalue());
    				x++;
    			}
    		}*/
			int sum=0;
			int trav1=0;
			int trav2=0;
			int valarr[] = new int [this.m*m.n];
			int rowarr[] = new int [this.m*m.n];
			int colarr[] = new int [this.m*m.n];
			int val=0;
			for(int i=0;i<this.m;i++)
			{
				trav1=i*this.n;
				for(int j=0;j<m.n;j++)
				{
					trav2=j*m.m;
					for(int k=0;k<this.n;k++)
					{
						sum+=temp1[trav1].Getvalue()*temp3[trav2].Getvalue();
						//System.out.println(temp1[trav1].Getvalue()+"  *   "+temp3[trav2].Getvalue());
						trav2++;
						trav1++;
					}
					//System.out.println(sum);
					valarr[val] = sum;
					rowarr[val] = i+1;
					colarr[val] = j+1;
					sum=0;
					val++;
					trav1=i*this.n;
				}
			}

			//int counter=0;
			/*    		for(int i=0;i<rowarr.length;i++)
    		{
    			System.out.println(rowarr[i]+"    "+colarr[i]+"    "+valarr[i]);
    		}*/

			return new SparseMatrix(valarr,rowarr,colarr,this.m,m.n);
			//return null;
		}
	}

	public SparseMatrix power(int p) {
		SparseMatrix temp=this.multiply(this);
		if(p>2)
		{
			for(int i=0;i<p-2;i++)
			{
				temp = temp.multiply(this);
			}
			return temp;
		}
		else if(p==2)
			return temp;
		else if(p==1)
			return this;
		else
		{
			System.out.println("Can't have power of 1");
			return null;
		}
	}

	public SparseMatrix transpose() {
		int values_array[] = new int[this.array.length];
		int row_array[] = new int[this.array.length];
		int col_array[] = new int[this.array.length];
		for(int i=0;i<this.array.length;i++)
		{
			values_array[i] = this.array[i].Getvalue();
			row_array[i] = this.array[i].Getcol();
			col_array[i] = this.array[i].Getrow();
		}
		//mergesort(this.array);
		return new SparseMatrix(values_array,row_array,col_array,this.n,this.m);
	}

}
