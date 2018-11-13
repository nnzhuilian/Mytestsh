import java.io.File;

public class Main {
	public static final int CYCN=5;//周期数
	public static final int WINDOW=8;//窗口大小
	public static void main(String args[]) throws Exception {
		Masking[] com=new Masking[26];
		int cc=0;
		File dirfile = new File("C:\\HXH软件\\JavaP\\Mytestsh\\实验数据\\data");
		File files[] = dirfile.listFiles();
		for (File file : files) {
			DataInitial ds1 = new DataInitial(
					new Readfile(file).readfile().getdata());
			Data[] resultdatas1 = ds1.getDatas();//初始化数据
			int gl=new GetLength(resultdatas1,CYCN).getBitLength();//获取周期对应比特数
			
			FeatureExtractor featureExtractor1 = new FeatureExtractor(WINDOW, resultdatas1,gl);
			
			String feature=featureExtractor1.getfeatureSequence();
			//System.out.println(feature);
			/*
			 * for(int i=0;i<resultdatas1.length;i++){
			 * System.out.print(resultdatas1[i].getCompare()); }
			 */
			System.out.println(" ");
			Timeround tr=new Timeround(WINDOW, resultdatas1,CYCN,gl);
			MaskSeed ms=new MaskSeed(tr.getCycle(),gl);
			String mask=ms.printmask(WINDOW);
			/////////////////////////////////////////////////////////////////////////////
		    Masking mk=new Masking(feature, mask);
		    //System.out.println(mk.Masker());
		    com[cc++]=mk;   
		    
		    
		}	
		for(int k=0;k<13;k++){
			System.out.println(compare(com[2*k].MaskerI(),com[2*k+1].MaskerI()));
		}

	}
	public static String compare(int a[],int b[]){
		    	int i=0;
		    	int max=a.length>=b.length?b.length:a.length;
		    	for (int j=0;j<max;j++){
		    		if(a[j]==b[j]){
		    			i++;
		    		}
		    	}
		    	return i+" "+max;
		    }
		
}
