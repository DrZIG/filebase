package entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * full path
 * size
 * do not process
 * device
 * save to storage
 * ...
 */
@Entity
public class File {
    @Id
    @GeneratedValue
    private Long id;

    private String fullPath;

    private long size;

    private boolean doNotProcess;

    private int deviceId;

    private boolean saveToStorage;

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

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isSaveToStorage() {
        return saveToStorage;
    }

    public void setSaveToStorage(boolean saveToStorage) {
        this.saveToStorage = saveToStorage;
    }
}
