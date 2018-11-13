import java.util.Arrays;

public class Masking {
	String a;
	String b;

	public Masking(String a, String b) {
		this.a = a;
		this.b = b;
	}

	public String Masker() {
		int mm[] = new int[a.length()];
		for (int i = 0; i < a.length(); i++) {
			mm[i] = (Integer.parseInt(a.charAt(i) + ""))^(Integer.parseInt(b.charAt(i) + ""));
		}
		return Arrays.toString(mm);
	}
	public int[] MaskerI() {
		int mm[] = new int[a.length()];
		for (int i = 0; i < a.length(); i++) {
			mm[i] = (Integer.parseInt(a.charAt(i) + ""))^(Integer.parseInt(b.charAt(i) + ""));
		}
		return mm;
	}
}
