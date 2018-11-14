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
			Data[] resultdatas1 = ds1.getDatas();//初始化数据
			int gl=new GetLength(resultdatas1,CYCN).getBitLength();//获取周期对应比特数
			System.out.println("bit长度："+gl);
			
			FeatureExtractor featureExtractor1 = new FeatureExtractor(WINDOW, resultdatas1,gl);
			
			//String feature=featureExtractor1.getfeatureSequence();
			String feature=featureExtractor1.getBandFeature();
			System.out.println(feature);
			ff[cc]=feature;
			//System.out.println(feature);
			/*
			 * for(int i=0;i<resultdatas1.length;i++){
			 * System.out.print(resultdatas1[i].getCompare()); }
			 */
			Timeround tr=new Timeround(WINDOW, resultdatas1,CYCN,gl);
			MaskSeed ms=new MaskSeed(tr.getCycle(),gl);
			String mask=ms.printmask(WINDOW);
			System.out.println(mask);
			/////////////////////////////////////////////////////////////////////////////
		    Masking mk=new Masking(feature, mask);
		    System.out.println(mk.Masker());
		    System.out.println("////////////////-"+cc+"-end-//////////////////////");
		    System.out.println(" ");
		    
		    com[cc++]=mk;   
		}	
		for(int k=0;k<13;k++){
			System.out.println(k+":"+compare(com[2*k].MaskerI(),com[2*k+1].MaskerI()));
		}
		System.out.println(" ");
		for(int k=0;k<13;k++){
			System.out.println(k+":"+compare(StoI(ff[2*k]),StoI(ff[2*k+1])));
		}

	}
	public static String compare(int a[],int b[]){
		    	int i=0;
		    	int max=a.length>=b.length?b.length:a.length;
		    	for (int j=0;j<128;j++){
		    		if(a[j]==b[j]){
		    			i++;
		    		}
		    	}
		    	return i+" "+max;
		    }
	
	public static int[] StoI(String a) {
		int mm[] = new int[a.length()];
		for (int i = 0; i < a.length(); i++) {
			mm[i] = Integer.parseInt(a.charAt(i) + "");
		}
		return mm;
	}
	
	
		
}
