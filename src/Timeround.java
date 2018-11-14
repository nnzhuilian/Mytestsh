
public class Timeround {
	int windowsize;
	Data[] datas;
	int cycnumbers;
	int length;
	public Timeround(int windowsize,Data[] datas,int cycnumbers,int length){
		this.windowsize=windowsize;
		this.datas=datas;
		this.cycnumbers=cycnumbers;
		this.length=length;
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
		System.out.println("��ʼ��������:"+x1+","+x2);
		return (-y1*(x2-x1))/(y2-y1)+x1;
	}
	private double getLastDown(){
		boolean flag=true;
		int i=length-1;
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
		System.out.println("������������:"+x1+","+x2);
		return (-y1*(x2-x1))/(y2-y1)+x1;
	}
	public double getCycle(){
		double fd=getFirstDown();
		double ld=getLastDown();
		System.out.println("���ڼ��㿪ʼλ�ã�"+fd);
		System.out.println("���ڼ������λ�ã�"+ld);
		System.out.println("������ʱ�䣺"+(ld-fd));
		System.out.println("���䳤�ȣ�"+((ld-fd)/cycnumbers));
		return (ld-fd)/cycnumbers;
	}
	
}
