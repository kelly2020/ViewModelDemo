package viewmodel.wondersgroup.com.mode;

import java.util.List;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class HomeData {
    private int code;
    private String desc;
    private List<HomeBody> body;

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

    public List<HomeBody> getBody() {
        return body;
    }

    public void setBody(List<HomeBody> body) {
        this.body = body;
    }

    public class HomeBody {
        private String id;
        private String serviceType;
        private String permissionName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getPermissionName() {
            return permissionName;
        }

        public void setPermissionName(String permissionName) {
            this.permissionName = permissionName;
        }
    }


}
