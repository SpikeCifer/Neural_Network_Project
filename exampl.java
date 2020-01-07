
public class exampl {
	
	public double valuex1 ;
	public double valuex2 ;
	public String category = "C1" ;
	private exampl NULL;
	public exampl center = NULL;
	
	
	public exampl(double valuex1,double valuex2) {
		this.valuex1=valuex1 ;
		this.valuex2=valuex2 ;

	}
	
	
	
	public String toString() {
		return valuex1 + "  " + valuex2 + " " + category;
	}
	 
	public double getValuex1() {
		    return valuex1;
		  }
	public double getValuex2() {
	    return valuex2;
	  }
	public String getCategory() {
		return category ;
	}
	public exampl getCenter() {
		return center ;
	}
	
	public void setValuex1(double newValue) {
		    this.valuex1 = newValue   ;
		  }
	public void setValuex2(double newValue) {
	    this.valuex2 = newValue   ;
	  }
	public void setCategory(String newCategory) {
		this.category=newCategory;
	}
	public void setCenter(exampl newExampl) {
		this.center=newExampl;
	}	
	

}
