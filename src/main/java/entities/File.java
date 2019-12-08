package entities;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * full path
 * size
 * do not process
 * device
 * save to storage
 * ...
 */
@Entity
@Table(name = "files", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"}, name = "file_id")})
public class File implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String fullPath;

    private long size;

    private boolean doNotProcess;

    private boolean saveToStorage;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name="deviceid")
    private Device device;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isDoNotProcess() {
        return doNotProcess;
    }

    public void setDoNotProcess(boolean doNotProcess) {
        this.doNotProcess = doNotProcess;
    }

//    @Column(name = "deviceid", nullable = false)
//    public int getDeviceId() {
//        return device.getId();
//    }

//    public void setDeviceId(int deviceId) {
//        this.deviceId = deviceId;
//    }

    public boolean isSaveToStorage() {
        return saveToStorage;
    }

    public void setSaveToStorage(boolean saveToStorage) {
        this.saveToStorage = saveToStorage;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fullPath='" + fullPath + '\'' +
                ", size=" + size +
                ", doNotProcess=" + doNotProcess +
                ", saveToStorage=" + saveToStorage +
                ", device=" + device +
                '}';
    }
}
