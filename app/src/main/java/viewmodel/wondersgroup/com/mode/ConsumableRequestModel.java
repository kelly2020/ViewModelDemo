package viewmodel.wondersgroup.com.mode;

import java.util.Map;

/**
 *请求参数
 */
public class ConsumableRequestModel {

    /**
     * accountId : string
     * addNum : 0
     * applicantId : string
     * applyDesc : string
     * consumblesId : string
     * consumblesMap : {}
     * consumblesName : string
     * consumblesNum : 0
     * length : 0
     * measureUnit : string
     * recordId : string
     * repulseCause : string
     * schoolId : string
     * searchTime : string
     * start : 0
     * state : 0
     */

    private String accountId;
    private int addNum;
    private String applicantId;
    private String applyDesc;
    private String consumblesId;
    private Map<String ,Integer> consumblesMap;
    private String consumblesName;
    private int consumblesNum;
    private int length;
    private String measureUnit;
    private String recordId;
    private String repulseCause;
    private String schoolId;
    private String searchTime;
    private int start;
    private int state;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getAddNum() {
        return addNum;
    }

    public void setAddNum(int addNum) {
        this.addNum = addNum;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplyDesc() {
        return applyDesc;
    }

    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc;
    }

    public String getConsumblesId() {
        return consumblesId;
    }

    public void setConsumblesId(String consumblesId) {
        this.consumblesId = consumblesId;
    }

    public Map<String, Integer> getConsumblesMap() {
        return consumblesMap;
    }

    public void setConsumblesMap(Map<String, Integer> consumblesMap) {
        this.consumblesMap = consumblesMap;
    }

    public String getConsumblesName() {
        return consumblesName;
    }

    public void setConsumblesName(String consumblesName) {
        this.consumblesName = consumblesName;
    }

    public int getConsumblesNum() {
        return consumblesNum;
    }

    public void setConsumblesNum(int consumblesNum) {
        this.consumblesNum = consumblesNum;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRepulseCause() {
        return repulseCause;
    }

    public void setRepulseCause(String repulseCause) {
        this.repulseCause = repulseCause;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(String searchTime) {
        this.searchTime = searchTime;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
