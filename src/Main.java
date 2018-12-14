import java.io.File;
import java.util.Arrays;

public class Main {
	public static final int CYCN=6;//周期数
	public static final int WINDOW=3;//窗口大小
	public static void main(String args[]) throws Exception {
		Masking[] com=new Masking[26];//加码
		String[] ff=new String[26];//不加码
		int cc=0;
		File dirfile = new File(".\\实验数据\\data");
		File files[] = dirfile.listFiles();
		for (File file : files) {
			System.out.println("////////////////-"+cc+"-begin-//////////////////////");
			DataInitial ds1 = new DataInitial(
					new Readfile(file).readfile().getdata());
			Data[] resultdatas1 = ds1.getDatas();//初始化数据----------------------------------
			Test test=new Test(resultdatas1);
			//test.print();
			System.out.println("");
			//int gl=new GetLength(resultdatas1,CYCN).getBitLength();//获取周期对应比特数
			//System.out.println("bit长度："+gl);
			
			FeatureExtractor featureExtractor1 = new FeatureExtractor(WINDOW, resultdatas1,512);//////g1
			
			//String feature=featureExtractor1.getfeatureSequence();
			String feature=featureExtractor1.getBandFeature();
			System.out.println(feature);
			ff[cc]=feature;	cc++;
			System.out.println("异或后："+Xor(feature));
			/*Timeround tr=new Timeround(WINDOW, resultdatas1,CYCN,gl);
			MaskSeed ms=new MaskSeed(tr.getCycle(),gl);
			String mask=ms.printmask(WINDOW);
			System.out.println(mask);
			
		    Masking mk=new Masking(feature, mask);
		    System.out.println(mk.Masker());*/
		    System.out.println("////////////////-"+cc+"-end-//////////////////////");
		    System.out.println(" ");
		    
		    //com[cc++]=mk;   
		}	
		/*for(int k=0;k<13;k++){
			System.out.println(k+":"+compare(com[2*k].MaskerI(),com[2*k+1].MaskerI()));
		}*/
		System.out.println(" ");
		for(int k=0;k<13;k++){
			System.out.println(k+":"+compare(StoI(ff[2*k]),StoI(ff[2*k+1])));
		}

	}
	public static String compare(int a[],int b[]){
		    	int i=0;
		    	int max=a.length>=b.length?b.length:a.length;
		    	for (int j=0;j<255;j++){
		    		if(a[j]==b[j]){
		    			i++;
		    		}
		    	}
		    	return 255-i+" "+max;
		    }
	
	public static int[] StoI(String a) {
		int mm[] = new int[a.length()];
		for (int i = 0; i < a.length(); i++) {
			mm[i] = Integer.parseInt(a.charAt(i) + "");
		}
		return mm;
	}
	
	public static String Xor(String a){
		int[] b=StoI(a);
		System.out.println(a.length());
		int[] b1=Arrays.copyOfRange(b, 0, 128);
		int[] b2=Arrays.copyOfRange(b, 128, 256);
		int mm[]=new int[128];
		for (int i = 0; i < 128; i++) {
			mm[i] = (b1[i]^b2[127-i]);
		}
		return Arrays.toString(mm);
	}
	
/*	public static int[] xor(int a[],int offset,int cycle){
		//按offset取周期，按位移异或。
	}*/
}
