
public class Test {
	Data[] datas;
	public Test(Data[] datas){
		this.datas=datas;
	}
	public void print(){
		for(int i=0;i<datas.length;i++){
			if(datas[i].getSymbol()>0){
				System.out.print(datas[i].getCompare());
			}
		}
	}
	public void print2(){
		
	}
}
