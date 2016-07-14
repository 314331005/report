package report;

public class Hex {

	public static String getHex(String dec) {

		String hex = Long.toHexString(Long.valueOf(dec));
		char[] hexChar = hex.toCharArray();
		StringBuffer sb = new StringBuffer();
		sb.append(hexChar[6]);
		sb.append(hexChar[7]);
		sb.append(hexChar[4]);
		sb.append(hexChar[5]);
		sb.append(hexChar[2]);
		sb.append(hexChar[3]);
		sb.append(hexChar[0]);
		sb.append(hexChar[1]);

		return String.valueOf(Long.parseLong(sb.toString(), 16));
	}
	public static void main(String[] args) {
		System.out.println(Hex.getHex("3817593919"));
	}
}
