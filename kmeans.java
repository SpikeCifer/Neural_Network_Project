import java.util.*;

public class kmeans {

	private int M = 4 ;
	public ArrayList<exampl> Mcenters = new ArrayList<exampl> ();
	public double grouperror = 0;
	
	public kmeans() {
		// TODO Auto-generated constructor stub
	}
	
	public double kmeansalgorithm (exampl[] positions ) {
		
		double [] avgcenterx1 = new double [M];		
		double [] avgcenterx2 = new double [M];		
		int [] centersize = new int [M];
		
		int cent =0 ;
		int z ;

		while (cent <M) {
			randomexamples y =new randomexamples ();
			z=y.randomcenter(positions.length);
			if(!(Mcenters.contains(positions[z]))) {
				cent=cent+1;;
				Mcenters.add(positions[z]);			
			}
		}
/*
		for(int j = 0 ; j<M;j++) {
			System.out.println(Mcenters.get(j));
		}
*/

		System.out.println();

		for(int i = 0; i<positions.length;i++) {
			double[] distance=new double [M]; ;
			int r = 0 ;
			while(r<M) {
				double x1 = positions[i].getValuex1()-Mcenters.get(r).getValuex1() ;
				double x2 = positions[i].getValuex2()-Mcenters.get(r).valuex2;
				distance [r] = Math.sqrt(Math.pow((x1), 2) + (Math.pow((x2), 2) )) ; 
				r=r+1;
		   }
		   
		  int positionmin=0;
		  double min = distance[0];
		  for(int j = 0; j<M;j++) {
			  if(distance[j]<=min) {
				  min = distance[j];
				  positionmin=j;
			  }
		  }
		  
		  positions[i].setCenter(Mcenters.get(positionmin));
		 

		}
		
		for(int i = 0; i<positions.length;i++) {
			for(int j = 0 ; j<M;j++) {
				if(positions[i].getCenter()==Mcenters.get(j)) {
					avgcenterx1[j]=avgcenterx1[j]+positions[i].getValuex1();
					avgcenterx2[j]=avgcenterx2[j]+positions[i].getValuex2();
					centersize[j]= centersize[j]+1;
				}

			}
		}
		for(int j = 0 ; j<M;j++) {
			randomexamples zz =new randomexamples ();
			double x1=zz.round(avgcenterx1[j]/centersize[j], 3);
			double x2=zz.round(avgcenterx2[j]/centersize[j], 3);
			exampl newcenter = new exampl (x1,x2);
			Mcenters.set(j,newcenter);
		}
/*
		for(int j = 0 ; j<M;j++) {
			System.out.println(Mcenters.get(j));
		}
*/		
		
		
		int end=0;
		while(end==0) {
			
			for(int i = 0; i<positions.length;i++) {
				double[] distance=new double [M]; ;
				int r = 0 ;
				while(r<M) {
					double x1 = positions[i].getValuex1()-Mcenters.get(r).getValuex1() ;
					double x2 = positions[i].getValuex2()-Mcenters.get(r).valuex2;
					distance [r] = Math.sqrt(Math.pow((x1), 2) + (Math.pow((x2), 2) )) ; 
					r=r+1;
			   }
			   
			  int positionmin=0;
			  double min = distance[0];
			  for(int j = 0; j<M;j++) {
				  if(distance[j]<=min) {
					  min = distance[j];
					  positionmin=j;
				  }
			  }
			  
			  positions[i].setCenter(Mcenters.get(positionmin));
			 

			}
			
			
			
			
			for(int i = 0; i<positions.length;i++) {
				for(int j = 0 ; j<M;j++) {
					if(positions[i].getCenter()==Mcenters.get(j)) {
						avgcenterx1[j]=avgcenterx1[j]+positions[i].getValuex1();
						avgcenterx2[j]=avgcenterx2[j]+positions[i].getValuex2();
						centersize[j]= centersize[j]+1;
					}

				}
			}
			
			
			
			int countend = 0 ;
			for(int j = 0 ; j<M;j++) {
				randomexamples zz =new randomexamples ();
				if(((Mcenters.get(j).getValuex1())== zz.round(avgcenterx1[j]/centersize[j] ,3))&&(Mcenters.get(j).getValuex2()==zz.round(avgcenterx2[j]/centersize[j],3))){
					countend=countend+1;
				}
			}
			if(countend==M) {
				end=1;
			}

			for(int j = 0 ; j<M;j++) {
				randomexamples zz =new randomexamples ();
				double x1=zz.round(avgcenterx1[j]/centersize[j], 3);
				double x2=zz.round(avgcenterx2[j]/centersize[j], 3);
				exampl newcenter = new exampl (x1,x2);
				Mcenters.set(j,newcenter);
			}


		}
		
		System.out.println("kmeans ends");
		
		
		
		for(int i = 0; i<positions.length;i++) {
				double x1 = positions[i].getValuex1()- positions[i].getCenter().getValuex1();
				double x2 = positions[i].getValuex2()- positions[i].getCenter().getValuex2();
				double distance = Math.sqrt(Math.pow((x1), 2) + (Math.pow((x2), 2) )) ;	
				grouperror=grouperror+distance;
		}

		return grouperror ;
	}
}
