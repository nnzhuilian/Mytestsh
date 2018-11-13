
public class FeatureExtractor {
	int windowsize;
	Data[] datas;
	int upn=0;
	int downn=0;
	int lastdown=0;
//	int datalen=0;
	public FeatureExtractor(int windowsize,Data[] datas){
		this.windowsize=windowsize;
		this.datas=datas;
	}
	public void getfeature(int a[],String featuretype,StringBuffer sb){
		boolean allpositive=true;
		boolean allnagtive=true;
		boolean allup=true;
		boolean alldown=true;
		for(int j=0;j<windowsize;j++){
			if(datas[a[0]].getSymbol()>=0){
				allnagtive=false;
			}else{
				allpositive=false;
			}
			if(datas[a[0]].getCompare()==1){
				alldown=false;
			}else{
				allup=false;
			}
			a[0]++;
			//window[j]=datas[i++];
		}
		if((allpositive==true)&&(allup==true)){
			featuretype=FeatureType.UP;
			sb.append(featuretype);
			return;
		}
		if((allpositive==true)&&(alldown==true)){
			featuretype=FeatureType.Down;
			sb.append(featuretype);
			return;
		}
		if((allpositive==false)&&(allnagtive==false)&&(allup==true)){
			featuretype=FeatureType.EXUP;
			sb.append(featuretype);
			upn++;
			return;
		}
		if((allpositive==false)&&(allnagtive==false)&&(alldown==true)){
			featuretype=FeatureType.EXDOWN;
			sb.append(featuretype);
			downn++;
			lastdown=a[0];
			return;
		}
		if((allpositive==true)&&(alldown==false)&&(allup==false)){
			featuretype=FeatureType.PEAK;
			sb.append(featuretype);
			return;
		}
		if(allnagtive==true){
			featuretype=FeatureType.VALID;
			sb.append(featuretype);
			return;
		}
		if(datas[a[0]-windowsize].symbol<0){
			featuretype=FeatureType.EXUP;
			sb.append(featuretype);
			return;
		}
		if(datas[a[0]-windowsize].symbol>0){
			featuretype=FeatureType.EXDOWN;
			sb.append(featuretype);
			return;
		}
		if(datas[a[0]-windowsize].symbol==0){
			if(datas[a[0]-windowsize+1].symbol<0){
				featuretype=FeatureType.EXDOWN;
				sb.append(featuretype);
				return;
			}
			if(datas[a[0]-windowsize+1].symbol>0){
				featuretype=FeatureType.EXUP;
				sb.append(featuretype);
				return;
			}
		}
	}
	
	public String getfeatureSequence(){
		StringBuffer sb=new StringBuffer();
		//Data[] window=new Data[windowsize];
		int b[]=new int[1];
		b[0]=0;
		int i=0;
		String featuretype="wrong";
		while((b[0]+windowsize)<datas.length){
			getfeature(b,featuretype,sb);
		}
			
		return sb.toString();
	}
	public int getUpn() {
		return upn;
	}
	public int getDownn() {
		return downn;
	}
	public int getLastdown() {
		return lastdown;
	}
	public int getDatalen() {
		return datas.length;
	}
	
}
