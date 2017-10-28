import java.util.Scanner;
public class ahp {
	
	
	  public double[][] comparision_matrix(double[] arr,int length){

	        double[][] matrixarray=new double[length][length];
	        int k=0;

	        for(int i=0;i<length;i++)
	        {
	             for(int j=0; j<length;j++)
        {
            if(i==j)
                matrixarray[i][j]=1;
            else if(i<j)
            {

                matrixarray[i][j]=arr[k];
                k++;
            }

            else if(i>j)
                matrixarray[i][j]=1/(matrixarray[j][i]);
        }
	        }
	        return matrixarray;
	    }
	  
	  
	  public double[] priority(double[][] arr,int a){
	        double[] sum=new double[a];
	        double[] b=new double[a];
	        double s=0;



	        for(int i=0;i<a;i++){
	            for(int j=0;j<a;j++){
	                sum[i]=0;
	                sum[i]+=arr[j][i];

	            }
	        }

	        for(int k=0;k<a;k++){
	            for(int l=0;l<a;l++){
	                arr[l][k]/=sum[k];
	            }
	        }

	        for(int m=0;m<a;m++){
	            for(int n=0;n<a;n++){
	                s+=arr[m][n];


	            }
	            b[m]=s/a;
	            s=0;
	        }
	        return b;

	    }
	  
	  
	    public int indexOfMax(double[] arr) {
                double max = arr[0];
	        int maxIndex = 0;

	        for (int i = 1; i < arr.length; i++) {
	            if (arr[i] > max) {
	                maxIndex = i;
	                max = arr[i];
	            }
	        }

	        return maxIndex;
	    }
	
	
	
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		ahp ah=new ahp();
		
		String [] crit_level1=new String[3];
		String [] crit_level21=new String[3];
		String [] crit_level22=new String[3];
		String [] crit_level23=new String[4];
		
		crit_level1[0]="Work Factors";
		crit_level1[1]="Academic Factors";
		crit_level1[2]="Individual Factors";
		
		
		crit_level21[0]="Confidence";
		crit_level21[1]="Compatibility";
		crit_level21[2]="Age";
		
		crit_level22[0]="Experience";
		crit_level22[1]="Technical Knowledge";
		crit_level22[2]="Published Research Papers";
		
		
		crit_level23[0]="Aggregate in UG (MORE THAN 75%)";
		crit_level23[1]="Aggregate in PG (MORE THAN 75%)";
		crit_level23[2]="Communicational Skills";
		crit_level23[3]="Presentation Skills";
		
		double [] p1=new double[3];
		double [] p21=new double[3];
		double [] p22=new double[3];
		double [] p23=new double[6];
		
    System.out.println("Enter the comparison :");
        int m=0; 
        for(int i=0; i<3;i++)
        {
            for(int j=i+1; j<3;j++)
            {
                System.out.println("Compare "+crit_level1[i]+" with "+crit_level1[j]+":");
                p1[m]=sc.nextDouble();
                m++;
            }
        }
        
        System.out.println("Enter the comparison :");
        m=0; 
        for(int i=0; i<3;i++)
        {
            for(int j=i+1; j<3;j++)
            {
                System.out.println("Compare "+crit_level21[i]+" with "+crit_level21[j]+":");
                p21[m]=sc.nextDouble();
                m++;
            }
        }
        
        System.out.println("Enter the comparison :");
        m=0; 
        for(int i=0; i<3;i++)
        {
            for(int j=i+1; j<3;j++)
            {
                System.out.println("Compare "+crit_level22[i]+" with "+crit_level22[j]+":");
                p22[m]=sc.nextDouble();
                m++;
            }
        }
        
        System.out.println("Enter the comparison :");
        m=0; 
        for(int i=0; i<4;i++)
        {
            for(int j=i+1; j<4;j++)
            {
                System.out.println("Compare "+crit_level23[i]+" with "+crit_level23[j]+":");
                p23[m]=sc.nextDouble();
                m++;
            }
        }
		
		double[][] result_p1=new double[3][3];
		double[][] result_p21=new double[3][3];
		double[][] result_p22=new double[3][3];
		double[][] result_p23=new double[4][4];
		
		
		result_p1=ah.comparision_matrix(p1,3);
		result_p21=ah.comparision_matrix(p21,3);
		result_p22=ah.comparision_matrix(p22,3);
		result_p23=ah.comparision_matrix(p23,4);
		
		    double[] loc_prio_lev1=new double[3];
	        double[] loc_prio_lev21=new double[3];
	        double[] loc_prio_lev22=new double[3];
	        double[] loc_prio_lev23=new double[4];
	        
	        loc_prio_lev1=ah.priority(result_p1,3);
	        loc_prio_lev21=ah.priority(result_p21,3);
	        loc_prio_lev22=ah.priority(result_p22,3);
	        loc_prio_lev23=ah.priority(result_p23,4);
	        
	        double[] glob_prio_lev1=new double[3];
	        double[] glob_prio_lev21=new double[3];
	        double[] glob_prio_lev22=new double[3];
	        double[] glob_prio_lev23=new double[4];
	        
	        for(int i=0;i<3;i++)
	        {
				glob_prio_lev1[i]=loc_prio_lev1[i];
			}
				
				for(int i=0;i<3;i++)
	        {
				glob_prio_lev21[i]=loc_prio_lev21[i]*glob_prio_lev1[0];
			}
			
			for(int i=0;i<3;i++)
	        {
				glob_prio_lev22[i]=loc_prio_lev22[i]*glob_prio_lev1[1];
			}
			
			for(int i=0;i<3;i++)
	        {
				glob_prio_lev23[i]=loc_prio_lev23[i]*glob_prio_lev1[2];
			}
	        

		
		
		
		System.out.println("Enter the number of applicants");
		int count=sc.nextInt();
		int [][] result=new int[count][10];
		
		String[] person=new String[count];
		
		System.out.println("Fill in the form by choosing the correct option");
		for(int i=0;i<count;i++){
		     int temp=i+1;
			System.out.println("Enter the name of applicant no." + temp +" is:");
		    String name=sc.next();
		    person[i]=name;
		    int t=0;
		    for(int j=0;j<3;j++)
		    {
	        System.out.println(crit_level21[j]);
	        
		    System.out.println("1. Yes\n2. No");
		    int option=sc.nextInt();
		    switch(option){
		    case 1:
		    	result[i][j]=1;
		    	break;
		    case 2:
		    	result[i][j]=0;
		    	break;
		    }
		    }
		    t=0;
		    for(int j=3;j<6;j++)
		    {
	        System.out.println(crit_level22[t]);
	        t++;
		    System.out.println("1. Yes\n2. No");
		    int option=sc.nextInt();
		    switch(option){
		    case 1:
		    	result[i][j]=1;
		    	break;
		    case 2:
		    	result[i][j]=0;
		    	break;
		    }
		    }
		    
		    t=0;
		    for(int j=6;j<10;j++)
		    {
	        System.out.println(crit_level23[t]);
	        t++;
		    System.out.println("1. Yes\n2. No");
		    int option=sc.nextInt();
		    switch(option){
		    case 1:
		    	result[i][j]=1;
		    	break;
		    case 2:
		    	result[i][j]=0;
		    	break;
		    }
		    }
		    
		    
		   
		    
		}
		
		
		 sc.close();
		 
		 double[] final_result=new double[count];
		 
		 for(int i=0;i<count;i++)
		 {
	        final_result[i]=0;
	        
	     }   
	       for(int i=0;i<count;i++)
	       {
			   for(int j=0;j<3;j++)
			   {
			   final_result[i]+=result[i][j]*glob_prio_lev21[j]; 
		       }
		       int t=0;
		       for(int j=3;j<6;j++)
			   {
			   final_result[i]+=result[i][j]*glob_prio_lev22[t]; 
			   t++;
		       }
		       t=0;
		       for(int j=6;j<10;j++)
			   {
			   final_result[i]+=result[i][j]*glob_prio_lev23[t]; 
			   t++;
		       }
		   }    
	        
	        
	        int index_first=ah.indexOfMax(final_result);
	        String selected=person[index_first];
	        
	        System.out.println("The selected employee is: " + selected);
	        
	        
	        
	        
	}
	

}
