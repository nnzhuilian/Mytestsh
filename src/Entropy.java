import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Entropy {
	public static double getEntropy4(char[] data,int len) {
		double[] p = new double[]{0,0,0,0,0,0,0,0};    //000,001,010,011,100,101,110,111的概率
		double[] c = new double[]{0,0,0,0,0,0,0,0};
		double entropy=0;
		int BitNum=len-1;
		for (int j = 0; j < len - 1; j++) {
			if (data[j] == '0') c[0]++;
			if (data[j] == '1') c[1]++;
			if (data[j] == '2') c[2]++;
			if (data[j] == '3') c[3]++;
			if (data[j] == '4') c[4]++;
			if (data[j] == '5') c[5]++;
			if (data[j] == '6') c[6]++;
			if (data[j] == '7') c[7]++;			
		}
		for (int i = 0; i < 8;i++) {
			if (c[i] == 0) entropy = 0;
			else {
				p[i] = c[i] / BitNum;
				entropy -= p[i] * Math.log(p[i]) / Math.log(2.0);
			}
		}
		return entropy;
	}
	public static double getEntropy3(char[] data,int len) {
		double[] p = new double[]{0,0,0,0,0,0,0,0};    //000,001,010,011,100,101,110,111的概率
		double[] c = new double[]{0,0,0,0,0,0,0,0};
		double entropy=0;
		int BitNum=len-1;
		for (int j = 0; j < len - 1; j++) {
			if ((data[j] == '0') && (data[j + 1] == '0') && (data[j + 2] == '0')) c[0]++;
			if ((data[j] == '0') && (data[j + 1] == '0') && (data[j + 2] == '1')) c[1]++;
			if ((data[j] == '0') && (data[j + 1] == '1') && (data[j + 2] == '0')) c[2]++;
			if ((data[j] == '0') && (data[j + 1] == '1') && (data[j + 2] == '1')) c[3]++;
			if ((data[j] == '1') && (data[j + 1] == '0') && (data[j + 2] == '0')) c[4]++;
			if ((data[j] == '1') && (data[j + 1] == '0') && (data[j + 2] == '1')) c[5]++;
			if ((data[j] == '1') && (data[j + 1] == '1') && (data[j + 2] == '0')) c[6]++;
			if ((data[j] == '1') && (data[j + 1] == '1') && (data[j + 2] == '1')) c[7]++;
			
		}
		for (int i = 0; i < 8;i++) {
			if (c[i] == 0) entropy = 0;
			else {
				p[i] = c[i] / BitNum;
				entropy -= p[i] * Math.log(p[i]) / Math.log(2.0);
			}
		}
		return entropy;
	}
	public static double getEntropy2(char[] data,int len) {
		double[] p = new double[]{0,0,0,0};    //000,001,010,011,100,101,110,111的概率
		double[] c = new double[]{0,0,0,0};
		double entropy=0;
		int BitNum=len-1;
		for (int j = 0; j < len - 1; j++) {
			if ((data[j] == '0') && (data[j + 1] == '0')) c[0]++;
			if ((data[j] == '0') && (data[j + 1] == '1')) c[1]++;
			if ((data[j] == '1') && (data[j + 1] == '0')) c[2]++;
			if ((data[j] == '1') && (data[j + 1] == '1')) c[3]++;
			
		}
		for (int i = 0; i < 4;i++) {
			if (c[i] == 0) entropy = 0;
			else {
				p[i] = c[i] / BitNum;
				entropy -= p[i] * Math.log(p[i]) / Math.log(2.0);
			}
		}
		return entropy;
	}
	public static double getEntropy1(char[] data,int len) {
		double[] p = new double[]{0,0};    //000,001,010,011,100,101,110,111的概率
		double[] c = new double[]{0,0};
		double entropy=0;
		int BitNum=len-1;
		for (int j = 0; j < len - 1; j++) {
			if (data[j] == '0') c[0]++;
			if (data[j] == '1') c[1]++;
			
		}
		for (int i = 0; i < 2;i++) {
			if (c[i] == 0) entropy = 0;
			else {
				p[i] = c[i] / BitNum;
				entropy -= p[i] * Math.log(p[i]) / Math.log(2.0);
			}
		}
		return entropy;
	}
	public static double getEntropy(char[] data,int len) {
		double[] p = new double[]{0,0,0,0,0,0,0,0};    //000,001,010,011,100,101,110,111的概率
		double[] c = new double[]{0,0,0,0,0,0,0,0};
		double entropy=0;
		int BitNum=len-1;
		for (int j = 0; j < len - 1; j++) {
			if (data[j] == '1') c[0]++;
			if (data[j] == '2') c[1]++;
			if (data[j] == '3') c[2]++;
			if (data[j] == '4') c[3]++;
			if (data[j] == '5') c[4]++;
			if (data[j] == '6') c[5]++;
			if (data[j] == '7') c[6]++;
			if (data[j] == '0') c[7]++;
			
		}
		for (int i = 0; i < 8;i++) {
			if (c[i] == 0) entropy = 0;
			else {
				p[i] = c[i] / BitNum;
				entropy -= p[i] * Math.log(p[i]) / Math.log(2.0);
			}
		}
		return entropy;
	}

	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader(new File("C:\\HXH软件\\论文\\论文\\生物认证\\握手实验\\data\\temp1.txt"));
		BufferedReader br=new BufferedReader(fr);
		String line=null;
		int k=0;
		double entropy=0;
		while((line=br.readLine())!=null){
			char[] c=new char[line.length()];
			c=line.toCharArray();
			k++;
			double e=getEntropy4(c, c.length);
			//System.out.println(e);
			entropy+=e;
		}
		br.close();
		entropy=entropy/k;
        System.out.println(entropy);
        /*for(int p=0;k<32;k++){
        	System.out.println((int)(Math.random()*8));
        }*/
	}

}
