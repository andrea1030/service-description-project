package readCSV;

public class SVCregData {
	private String interfaceType;
	private String serviceCode;
	private String actionId;
	private String value;
	private String serviceDescription;
	private String serviceFunctionName;
	private String targetURL;
	private String method;
	private String dataType;
	private String dataDetails;
	
	public SVCregData() {
	}
	
	public SVCregData(final String interfaceType, final String serviceCode, final String actionId, final String value, final String serviceDescription, final String serviceFunctionName, final String targetURL, final String method, final String dataType, final String dataDetails) {
//		super();
		this.interfaceType = interfaceType;
		this.serviceCode = serviceCode;
		this.actionId = actionId;
		this.value = value;
		this.serviceDescription = serviceDescription;
		this.serviceFunctionName = serviceFunctionName;
		this.targetURL = targetURL;
		this.method = method;
		this.dataType = dataType;
		this.dataDetails = dataDetails;		
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getServiceFunctionName() {
		return serviceFunctionName;
	}

	public void setServiceFunctionName(String serviceFunctionName) {
		this.serviceFunctionName = serviceFunctionName;
	}

	public String getTargetURL() {
		return targetURL;
	}

	public void setTargetURL(String targetURL) {
		this.targetURL = targetURL;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataDetails() {
		return dataDetails;
	}

	public void setDataDetails(String dataDetails) {
		this.dataDetails = dataDetails;
	}
	
	
	}
