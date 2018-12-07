package viewmodel.wondersgroup.com.mode;

import java.util.List;

/**
 * 申请记录列表
 */
public class ApplyRecordResultModel {

    /**
     * code : 200
     * desc : success
     * body : {"applyTotal":1,"applyRecords":[{"id":"8a828e14673a2ef301673a3972730003","applicantId":"2c9180825f4d966d015f52918a39000a","applyTotal":35,"applyDesc":"教学使用","applyTime":1543437335000,"state":0,"operatorId":null,"provideTime":1542996900000,"repulseCause":null}],"awaitNum":1}
     */

    private int code;
    private String desc;
    private BodyBean body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * applyTotal : 1
         * applyRecords : [{"id":"8a828e14673a2ef301673a3972730003","applicantId":"2c9180825f4d966d015f52918a39000a","applyTotal":35,"applyDesc":"教学使用","applyTime":1543437335000,"state":0,"operatorId":null,"provideTime":1542996900000,"repulseCause":null}]
         * awaitNum : 1
         */

        private int applyTotal;
        private int awaitNum;
        private List<ApplyRecordsBean> applyRecords;

        public int getApplyTotal() {
            return applyTotal;
        }

        public void setApplyTotal(int applyTotal) {
            this.applyTotal = applyTotal;
        }

        public int getAwaitNum() {
            return awaitNum;
        }

        public void setAwaitNum(int awaitNum) {
            this.awaitNum = awaitNum;
        }

        public List<ApplyRecordsBean> getApplyRecords() {
            return applyRecords;
        }

        public void setApplyRecords(List<ApplyRecordsBean> applyRecords) {
            this.applyRecords = applyRecords;
        }

        public static class ApplyRecordsBean {
            /**
             * id : 8a828e14673a2ef301673a3972730003
             * applicantId : 2c9180825f4d966d015f52918a39000a
             * applyTotal : 35
             * applyDesc : 教学使用
             * applyTime : 1543437335000
             * state : 0
             * operatorId : null
             * provideTime : 1542996900000
             * repulseCause : null
             */

            private String id;
            private String applicantId;
            private int applyTotal;
            private String applyDesc;
            private long applyTime;
            private int state;
            private Object operatorId;
            private long provideTime;
            private Object repulseCause;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getApplicantId() {
                return applicantId;
            }

            public void setApplicantId(String applicantId) {
                this.applicantId = applicantId;
            }

            public int getApplyTotal() {
                return applyTotal;
            }

            public void setApplyTotal(int applyTotal) {
                this.applyTotal = applyTotal;
            }

            public String getApplyDesc() {
                return applyDesc;
            }

            public void setApplyDesc(String applyDesc) {
                this.applyDesc = applyDesc;
            }

            public long getApplyTime() {
                return applyTime;
            }

            public void setApplyTime(long applyTime) {
                this.applyTime = applyTime;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public Object getOperatorId() {
                return operatorId;
            }

            public void setOperatorId(Object operatorId) {
                this.operatorId = operatorId;
            }

            public long getProvideTime() {
                return provideTime;
            }

            public void setProvideTime(long provideTime) {
                this.provideTime = provideTime;
            }

            public Object getRepulseCause() {
                return repulseCause;
            }

            public void setRepulseCause(Object repulseCause) {
                this.repulseCause = repulseCause;
            }
        }
    }
}
