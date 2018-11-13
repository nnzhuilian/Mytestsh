
class MAfilter {
	double data[];
	public MAfilter(double[] data){
		this.data=data;
	}
	public double[] mafilter(int WinLen){
		int l=data.length;
		double[] MAdata=new double[l-WinLen+1];
		for(int i=0;i<l;i++){
			if((i+WinLen)>l){
				break;
			}
			int sum=0;
			for(int j=i;j<(i+WinLen);j++){
				sum+=data[j];
			}
			int avg=sum/WinLen;
			MAdata[i]=avg;
		}
		return MAdata;
	}
}
