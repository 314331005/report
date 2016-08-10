package report;

public class Hex {

	public static String getHex(String dec) {
		System.out.println(dec);
		if(dec == null || dec.trim().equals("") || dec.trim().length()<8 ) {return "";}
		String hex = Long.toHexString(Long.valueOf(dec.trim()));
		char[] hexChar = hex.toCharArray();
		StringBuffer sb = new StringBuffer();
		if(hexChar.length == 7){
			//sb.append(hexChar[7]);
			sb.append(hexChar[6]);
			sb.append("");
			sb.append(hexChar[4]);
			sb.append(hexChar[5]);
			sb.append(hexChar[2]);
			sb.append(hexChar[3]);
			sb.append(hexChar[0]);
			sb.append(hexChar[1]);
		}else{
			sb.append(hexChar[6]);
			sb.append(hexChar[7]);
			sb.append(hexChar[4]);
			sb.append(hexChar[5]);
			sb.append(hexChar[2]);
			sb.append(hexChar[3]);
			sb.append(hexChar[0]);
			sb.append(hexChar[1]);
		}
		

		return String.valueOf(Long.parseLong(sb.toString(), 16));
	}
	public static void main(String[] args) {
		System.out.println(Hex.getHex("3817593919"));
	}
}
