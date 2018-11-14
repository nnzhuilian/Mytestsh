import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Readfile {
	File file;
	double data[];
	public Readfile(File file){
		this.file=file;
	}
	public Readfile readfile() throws IOException{
	//File fir= new File(file);
	FileReader FR=new FileReader(file);
	BufferedReader BR=new BufferedReader(FR);
	data= new double[1000];
	int i=0;
	String str=null;
	while(((str=BR.readLine())!=null)&&(i<data.length)){
		data[i++]=Double.parseDouble(str);
	}
	BR.close();
	return this;
	}
	
	public double[] getdata(){
		return data;
	}
	
	/*public static void main(String args[]) throws Exception{
		Readfile rf=new Readfile("C:\\HXH软件\\论文\\论文\\生物认证\\握手实验2\\data\\MA1.txt");
		rf.readfile();
		double[] a=rf.getdata();
		System.out.println(a[10]);
	}*/
	
}
