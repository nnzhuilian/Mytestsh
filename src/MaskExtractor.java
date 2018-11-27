
public class MaskExtractor {

	int windowsize;
	Data[] datas;
	int length;
	public MaskExtractor(int windowsize,Data[] datas,int length){
		this.windowsize=windowsize;
		this.datas=datas;
		this.length=length;
	}
	public String getfeature(int a[],String featuretype){
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
			featuretype=MaskType.PUP;
			return featuretype;
		}
		if((allpositive==true)&&(alldown==true)){
			featuretype=MaskType.PDown;
			return featuretype;
		}
		if((allpositive==false)&&(allnagtive==false)&&(allup==true)){
			featuretype=MaskType.EXUP;
			return featuretype;
		}
		if((allpositive==false)&&(allnagtive==false)&&(alldown==true)){
			featuretype=MaskType.EXDOWN;
			return featuretype;
		}
		if((allpositive==true)&&(alldown==false)&&(allup==false)){
			featuretype=MaskType.PEAK;
			return featuretype;
		}
		if(allnagtive==true&&(alldown==false)&&(allup==false)){
			featuretype=MaskType.VALID;
			return featuretype;
		}
		if((allnagtive==true)&&(allup==true)){
			featuretype=MaskType.VUP;
			return featuretype;
		}
		if((allnagtive==true)&&(alldown==true)){
			featuretype=MaskType.VDown;
			return featuretype;
		}
		return featuretype;
	}
	
	public String getfeatureSequence(){
		StringBuffer sb=new StringBuffer();
		//Data[] window=new Data[windowsize];
		int b[]=new int[1];
		b[0]=0;
		int i=0;
		String featuretype="wrong";
		while((b[0]+windowsize)<length){
			sb.append(getfeature(b,featuretype));
			//b[0]=b[0]-windowsize+2;
		}
			
		return sb.toString();
	}
	public String getBandFeature(){
		StringBuffer sb=new StringBuffer();
		//Data[] window=new Data[windowsize];
		int b[]=new int[1];
		b[0]=0;
		int i=0;
		String featuretype="wrong";
		boolean flag=true;
		while((b[0]+windowsize)<length){
			if(flag==true){
			sb.append(getfeature(b,featuretype));
			flag=false;
			}else{
				getfeature(b,featuretype);
				flag=true;
			}
		}
			
		return sb.toString();
	}
}

