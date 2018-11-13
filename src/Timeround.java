
public class Timeround {
	int windowsize;
	Data[] datas;
	int lastdown;
	int downs;
	int i=0;
	public Timeround(int windowsize,Data[] datas,int lastdown,int downs){
		this.windowsize=windowsize;
		this.datas=datas;
		this.lastdown=lastdown;
		this.downs=downs;
	}
	
	private int getCNumbers(){
		boolean flag=true;//前一个符号，true为正，flase为负
		for(int j=0;j<(datas.length/windowsize)*windowsize;j++){
			if(datas[j].symbol>0&&flag==true){
				
			}
			if(datas[j].symbol<=0&&flag==true){
				flag=false;
				i++;
			}
			if(datas[j].symbol>0&&flag==false){
				flag=true;
			}
			if(datas[j].symbol<=0&&flag==false){
				
			}
		}
		return i-1;
	}

	private double getFirstDown(){
		boolean flag=true;
		int i=0;
		double x1=0;
		double y1=0;
		double x2=0;
		double y2=0;
		while(flag){
			if(datas[i].getValue()>=0){
				y1=datas[i].getValue();
				x1=i;
				i++;
			}
			else{
				y2=datas[i].getValue();
				x2=i;
				flag=false;
			}
		}
		return (-y1*(x2-x1))/(y2-y1)+x1;
	}
	private double getLastDown(){
		boolean flag=true;
		int i=datas.length-1;
		double x1=0;
		double y1=0;
		double x2=0;
		double y2=0;
		while(flag){
			if(datas[i].getValue()<=0){
				y1=datas[i].getValue();
				x1=i;
				i--;
			}
			else{
				y2=datas[i].getValue();
				x2=i;
				flag=false;
			}
		}
		return (-y1*(x2-x1))/(y2-y1)+x1;
	}
	public double getCycle(){
		return (getLastDown()-getFirstDown())/getCNumbers();
	}
	
}
