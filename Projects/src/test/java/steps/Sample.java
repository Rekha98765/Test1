package steps;

public class Sample {
public static void main(String[] args) {
	int[] []arr= {{6, 42, 11, 7, 1, 42},
			      {13,13,1,6},
			      {100,63,1,6,2,13},
			      {1},
	              {1,1,1}};
	int[] xarr= {7,6,100,1,1};

	int[] yarr= {42,13,63,1,1};
	
	 for(int k=0;k<arr.length;k++) {
		 
	    int[] ar=arr[k];
		
		 int x=xarr[k];
			int y=yarr[k];
			int cntX=0;
			int cntY=0;
			int P=-1;
			
	  for(int i=0;i<ar.length;i++) {
		  
		  if(x==y) {
			  if(x==ar[i]) {
				  cntX++;
				  cntY++;} 
		  }else {
		  if(x==ar[i]) {
			  cntX++;
		  }else if(y==ar[i]) {
			  cntY++;
		  }
		  }
		  if(cntX==cntY && (cntX!=0 && cntY!=0)) {
			  P=i;
		  }
	  }
	  if(x==y) {
		  P=P-1;
	  }
	  
	  System.out.println(P);
	 }
}
}
