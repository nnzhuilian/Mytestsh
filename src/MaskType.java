
public class MaskType {
	public static final String PUP="010";//所有都为正，且判别符号为1
	public static final String PDown="100";//所有都为正，且判别符号为0
	public static final String PEAK="101";//所有都为正，且判别符号有0有1
	
	public static final String EXUP="110";//正负都有，且判别符号为1
	public static final String EXDOWN="011";//正负都有，且判别符号为0
	
	public static final String VUP="111";//所有都为负，且判别符号为1
	public static final String VDown="111";//所有都为负，且判别符号为0
	public static final String VALID="111";//所有都为负,且判别符号有0有1
}
///001 000