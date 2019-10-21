
public class exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int sum=0;
		for(int i=0;i<32;i++){
			int num=(int)(Math.random()*16)+10;
			sum+=num;
			System.out.println(i+":"+sum+":"+num);
		}*/
		String s1="00001010001000111011111011010110010100011011111011110111010100001010100011010101001010101111010100011000110001000000111101100000";
				
		String s2="00000000001000011011111111010101010100001010111111010101010010101010111111010100001110001111001000011110110000111010110101011010";
		int num=0;
		for(int i=0;i<128;i++){
			if(s1.charAt(i)!=s2.charAt(i)){
				num++;
			}
		}
		System.out.println(num);
	}

}
