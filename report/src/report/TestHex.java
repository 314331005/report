package report;



import org.junit.Test;

public class TestHex {
	
	public String dec = "3817593919";
	
	@Test
	public void toCardNO() {
		
		System.out.println("this is Hex value ..." + Long.toHexString(Long.valueOf(dec)));
		
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
		
		System.out.println("this is after Hex value ...." + sb.toString());
		System.out.println("this is after Dec value ...." + Long.parseLong(sb.toString(), 16));
		
	}
	
}
