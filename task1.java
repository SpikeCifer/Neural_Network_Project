import java.util.*;

public class task1 {

	public static void main(String[] args) {
	

		exampl [] training = new exampl[300];
		for (int i = 0; i < 300; i ++){
			randomexamples z =new randomexamples ();
			double x = z.random1() ;
			x =z.round(x, 3);
			double y = z.random1() ;
			y =z.round(y, 3);		
			exampl q = new exampl (x,y);
			training[i]=q;			
		}	

		exampl [] check = new exampl[300];
		for (int i = 0; i < 300; i ++){
			randomexamples z =new randomexamples ();
			double x = z.random1() ;
			x =z.round(x, 3);
			double y = z.random1() ;
			y =z.round(y, 3);		
			exampl q = new exampl (x,y);
			check[i]=q;			
		}

	
/*
		for (int i = 0; i < 300; i ++){
			System.out.println(check[i].toString());
		}
			System.out.println();
	
*/			
			
			
			
		for (int i = 0; i < 300; i ++){
			double x1t = training[i].getValuex1();
			double x2t = training[i].getValuex2();
			double x1c = training[i].getValuex1();
			double x2c = training[i].getValuex2();

			
			double train1=(Math.pow((x1t -1), 2)+Math.pow((x2t -1), 2));
			double chec1=(Math.pow((x1c -1), 2)+Math.pow((x2c -1), 2));
			
			if(train1<=0.49) {
				training[i].setCategory("C2");
			}
			if(chec1<=0.49) {
				check[i].setCategory("C2");
			}
		
			double train2=(Math.pow((x1t +1), 2)+Math.pow((x2t +1), 2));
			double chec2=(Math.pow((x1c +1), 2)+Math.pow((x2c +1), 2));
			if(train2<=0.49) {
				training[i].setCategory("C2");
			}
			if(chec2<=0.49) {
				check[i].setCategory("C2");
			}
			double train3=(Math.pow((x1t +1), 2)+Math.pow((x2t -1), 2));
			double chec3=(Math.pow((x1c +1), 2)+Math.pow((x2c -1), 2));
			if(train3<=0.49) {
				training[i].setCategory("C3");
			}
			if(chec3<=0.49) {
				check[i].setCategory("C3");
			}
			double train4=(Math.pow((x1t -1), 2)+Math.pow((x2t +1), 2));
			double chec4=(Math.pow((x1c -1), 2)+Math.pow((x2c +1), 2));
			if(train4<=0.49) {
				training[i].setCategory("C3");
			}
			if(chec4<=0.49) {
				check[i].setCategory("C3");
			}
			
		}
	
		
		for (int i = 0; i < 10; i ++){
			if(!(training[i].getCategory()=="C1")) {
				randomexamples y =new randomexamples ();
				int x = y.random1(10) ;
				if(x==1) {
					training[i].setCategory("C1");

				}
			}
			if(!(check[i].getCategory()=="C1")) {
				randomexamples y =new randomexamples ();
				int x = y.random1(10) ;
				if(x==1) {
					check[i].setCategory("C1");

				}
			}
		}
		kmeans k0 = new kmeans();
		kmeans k1 = new kmeans();
		kmeans k2 = new kmeans();
		kmeans k3 = new kmeans();
		kmeans k4 = new kmeans();
		
		double [] grouperror = new double [5];
		grouperror[0]=k0.kmeansalgorithm(check);		
		grouperror[1]=k1.kmeansalgorithm(check);		
		grouperror[2]=k2.kmeansalgorithm(check);		
		grouperror[3]=k3.kmeansalgorithm(check);		
		grouperror[4]=k4.kmeansalgorithm(check);		
		
		double  min_group_error=grouperror[0];
		int position1 =0;
		for(int i =0;i<5;i++) {
			if(grouperror[i]<=min_group_error) {
				min_group_error=grouperror[i];
				position1 =i;
			}
		}
		System.out.println("min_group_error = " + min_group_error);

		
		
	}
}














