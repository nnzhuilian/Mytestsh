import java.io.File;

public class Main {
	public static void main(String args[]) throws Exception {
		File dirfile = new File("C:\\HXH软件\\JavaP\\Mytestsh\\实验数据\\data");
		File files[] = dirfile.listFiles();
		for (File file : files) {
			DataInitial ds1 = new DataInitial(
					new Readfile(file).readfile().getdata());
			Data[] resultdatas1 = ds1.getDatas();

			FeatureExtractor featureExtractor1 = new FeatureExtractor(8, resultdatas1);
			System.out.println(featureExtractor1.getfeatureSequence());
			/*
			 * for(int i=0;i<resultdatas1.length;i++){
			 * System.out.print(resultdatas1[i].getCompare()); }
			 */
			//System.out.println(" ");
			Timeround tr=new Timeround(8, resultdatas1, featureExtractor1.getLastdown(), featureExtractor1.getDownn());
			MaskSeed ms=new MaskSeed(tr.getCycle(),resultdatas1.length);
			ms.printmask(8);
		}

		/*
		 * DataInitial ds1=new DataInitial(new
		 * Readfile("").
		 * readfile().getdata()); Data[] resultdatas1=ds1.getDatas();
		 * 
		 * DataInitial ds2=new DataInitial(new
		 * Readfile("").
		 * readfile().getdata()); Data[] resultdatas2=ds2.getDatas();
		 * 
		 * FeatureExtractor featureExtractor1=new FeatureExtractor(8,
		 * resultdatas1);
		 * System.out.println(featureExtractor1.getfeatureSequence()); for(int
		 * i=0;i<resultdatas1.length;i++){
		 * System.out.print(resultdatas1[i].getCompare()); } System.out.println(
		 * " ");
		 * 
		 * FeatureExtractor featureExtractor2=new FeatureExtractor(8,
		 * resultdatas2);
		 * System.out.println(featureExtractor2.getfeatureSequence());
		 */
		/*
		 * for(int i=0;i<resultdatas2.length;i++){
		 * System.out.print(resultdatas2[i].getCompare()); }
		 */

		/*
		 * System.out.println(" "); for(int i=0;i<resultdatas1.length;i++){
		 * System.out.print(resultdatas1[i].getSymbol()); } System.out.println(
		 * " "); for(int i=0;i<resultdatas2.length;i++){
		 * System.out.print(resultdatas2[i].getSymbol()); }
		 */

	}
}
