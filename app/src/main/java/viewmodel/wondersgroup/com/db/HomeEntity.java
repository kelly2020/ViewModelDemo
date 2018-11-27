package viewmodel.wondersgroup.com.db;

import org.jetbrains.annotations.NotNull;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */

@Entity
public class HomeEntity {
    @PrimaryKey
    @NotNull
    private String id;
    private String homeId;
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

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }
}
