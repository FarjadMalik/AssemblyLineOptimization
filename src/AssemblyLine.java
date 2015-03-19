import java.io.IOException;


public class AssemblyLine {
	public CarStationGui myGui;
	public int f;
	public int l;
	
	public void fastest_way(int[][] a,int[][] t,int[] e,int[] x,int n){
		int[] l1= new int[n];
		int[] l2= new int[n];
		int[] f1 = new int[n];
		int[] f2 = new int[n];
		int[] path = new int[n];
		
		f1[0]=e[0] + a[0][0];
		f2[0]=e[1] + a[1][0];
		
		for(int j=1;j<n;j++){
			if(f1[j-1] + a[0][j] <= f2[j-1]+t[1][j-1]+a[0][j]){
				f1[j] = f1[j-1] + a[0][j];
				l1[j] = 1;
			}else{
				f1[j] = f2[j-1]+t[1][j-1]+a[0][j];
				l1[j] = 2;
			}
			
			if(f2[j-1] + a[1][j] <= f1[j-1] + t[0][j-1] + a[1][j]){
				f2[j] = f2[j-1] + a[1][j];
				l2[j] = 2;
			}else{
				f2[j] = f1[j-1] + t[0][j-1] + a[1][j];
				l2[j] = 1;				
			}
		}
		
		if(f1[n-1] + x[0] <= f2[n-1] + x[1] ){
			f = f1[n-1] + x[0];
			l = 1;
			path=l1;
		}
		else{
			f = f2[n-1] + x[1];
			l = 2;
			path=l2;
		}
		/*for(int i=0;i<n;i++){
			System.out.println("i : "+i+" Line 1 value : "+f1[i]);

			System.out.println("i : "+i+" Line 2 value : "+f2[i]);
			
			
		}*/
		System.out.println("Path : ");
		for(int i=0;i<n;i++){
			/*if(i==n){
				path[i]=1;
			}else{
				path[i]=l1[i];
			}*/
			System.out.printf(path[i]+" ");
		}
		System.out.printf(l+"");
		StartGui(a, t, e, x, n,path,l);
	}

	private void StartGui(int[][] a,int[][] t,int[] e,int[] x,int n,int[] path,int l) {
		for(int i=0; i<2; i++)
        {
       	 for(int j=0; j<n; j++)
       	 {
       		
       		 if(i==0)
       		 {
       			 if(j==n-1){
       				 myGui.line1Labels[j].setText("Station time : " + a[i][j]);
       			 }
       			 else{
       				myGui.line1Labels[j].setText("Station time : " + a[i][j] + " Transfer Time:" + t[i][j]);
       			 }
       	
       		 }
       		 else
       		 {
       			if(j==n-1){
       				myGui.line2Labels[j].setText("Station time: "+ a[i][j]);
      			 }
      			 else{
      				myGui.line2Labels[j].setText("Station time: "+ a[i][j] + " Transfer Time:" + t[i][j]);
      			 }       			 
       		 }
       	 }
        }
		
		for(int i=1;i<n;i++){
			if(path[i]==1){
				myGui.line1Labels[i-1].setText("Included in Path");
			}else{
				myGui.line2Labels[i-1].setText("Included in Path");
			}
		}
		if(l==1){
			myGui.line1Labels[n-1].setText("Included in Path");
		}else{
			myGui.line2Labels[n-1].setText("Included in Path");
		}
		
	}

	public static void main(String[] args) {
		int e[] = {15, 17};
		int x[] = {5, 10};
		int n= 4;
		int a[][] = {{2, 9, 8, 1},
	                {1, 1, 7, 10}};
	    int t[][] = {{0, 3, 9},
	                {0, 7, 6}};
		
		AssemblyLine A = new AssemblyLine();
		try {
			A.myGui = new CarStationGui(n);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    A.fastest_way(a, t, e, x, n);
	    A.myGui.textField.setText("Time: "+A.f);
	    System.out.println();
	    System.out.println("Time: "+A.f);
	    //System.out.println("Exit point: "+A.l);

	}

}
