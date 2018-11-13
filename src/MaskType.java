
public class MaskType {
	public static final String PUP="000";//所有都为正，且判别符号为1
	public static final String PDown="001";//所有都为正，且判别符号为0
	public static final String PEAK="101";//所有都为正，且判别符号有0有1
	
	public static final String EXUP="010";//正负都有，且判别符号为1
	public static final String EXDOWN="011";//正负都有，且判别符号为0
	
	public static final String VUP="100";//所有都为负，且判别符号为1
	public static final String VDown="110";//所有都为负，且判别符号为0
	public static final String VALID="111";//所有都为负,且判别符号有0有1
}
