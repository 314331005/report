package report;

public class Data {
	
	private String idNumber;
	private String cardId;
	private String userName;
	private String idserial;
	private String cardNo;

	public Data() {
	}

	public Data(String idNumber, String cardId, String userName) {
		super();
		this.idNumber = idNumber;
		this.cardId = cardId;
		this.userName = userName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdserial() {
		return idserial;
	}

	public void setIdserial(String idserial) {
		this.idserial = idserial;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	

	
}
