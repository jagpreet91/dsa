package dsa;

public class MatrixEntry {
    
    private final int value;
    
    private final int row;
    private final int col;
    
    public MatrixEntry(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col =  col;
    }
     
    public int Getvalue()
    {
        return this.value;
    }
    
    public int Getrow()
    {
    	return this.row;
    }
    
    public int Getcol()
    {
    	return this.col;
    }
    // TODO: Getters and setters?
}

