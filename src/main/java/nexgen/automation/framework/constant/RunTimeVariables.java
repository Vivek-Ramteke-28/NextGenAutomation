package nexgen.automation.framework.constant;


public class RunTimeVariables {

	private String variable = null;
	private String issueKey = null;
	private String methodname = null;
	
	
	public String getValue() {
		return variable;
	}

	public void setValue(String variable) {
		this.variable = variable;
	}
	
	public void issueKeySetValue(String issueKey) {
		this.issueKey = issueKey;
	}
	
	public String issueKeyGetValue() {
		return issueKey;
	}


	public void methodnameSetValue(String methodname) {
		this.methodname = methodname;
	}
	
	public String methodnameGetValue() {
		return methodname;
	}

}