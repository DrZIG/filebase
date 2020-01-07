import common.Settings;
import controllers.FileDatabseWithHibernate;
import entities.Device;
import entities.File;

public class Main {
    private static Settings settings = Settings.getSettings();

    public static void main(String[] args) {
        // TODO: get current device name
        var testDevice = new Device();
        testDevice.setName("Test");

        // TODO: need some kind of queue. Some thread parsing files from disk. Another thread get already parsed files
        //  and put them to the databse. Parsing can be done by parallel operation with {number_of_physical_disks} threads
        var testFile = new File();
        testFile.setFullPath("C:\\2\\_Done\\Turilli Lione Rhapsody - Zero Gravity Rebirth and Evolution - Metal-Tracker.com.torrent");
        testFile.setSize(11_912);
        testFile.setDoNotProcess(true);
        testFile.setDevice(testDevice);
        testFile.setSaveToStorage(true);

//        var sqlController = new JPA(settings);
        var sqlController = new FileDatabseWithHibernate(settings);
        sqlController.addDevice(testDevice);
        sqlController.addFile(testFile);
    }

}
