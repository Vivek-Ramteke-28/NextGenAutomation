package nexgen.automation.framework.zephyr;

public class ExecutionObject {

	
	private String issueId;
	 private String executionId;
	 private int totalCount;
	 private String cycleId;
	 private String status;
	 private String folderName;
	 private String testCaseId;
	 
	 public ExecutionObject(String issueId, String testCaseId, String executionId, int totalCount, String cycleId, String status) {
	  this.issueId = issueId;
	  this.testCaseId = testCaseId;
	  this.executionId = executionId;
	  this.totalCount = totalCount;
	  this.cycleId = cycleId;
	  this.status = status;
	 }

	 public String getCycleId() {
	  return cycleId;
	 }
	 public void setCycleId(String cycleId) {
	  this.cycleId = cycleId;
	 }
	 public String getStatus() {
	  return status;
	 }
	 public void setStatus(String status) {
	  this.status = status;
	 }
	 public String getIssueId() {
	  return issueId;
	 }
	 public void setIssueId(String issueId) {
	  this.issueId = issueId;
	 }
	 public String getExecutionId() {
	  return executionId;
	 }
	 public void setExecutionId(String executionId) {
	  this.executionId = executionId;
	 }
	 public int getTotalCount() {
	  return totalCount;
	 }
	 public void setTotalCount(int totalCount) {
	  this.totalCount = totalCount;
	 }
	 public String getFolderName(){
	  return folderName;
	 }

	public String getTestCaseId() {
		return testCaseId;
	}

	@Override
	public String toString() {
		return "ExecutionObject [issueId=" + issueId + ", executionId=" + executionId + ", totalCount=" + totalCount
				+ ", cycleId=" + cycleId + ", status=" + status + ", folderName=" + folderName + ", testCaseId="
				+ testCaseId + "]";
	}
	
	
	
	

}
