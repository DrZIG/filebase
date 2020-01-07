package controllers;

import entities.Device;
import entities.File;
import exceptions.NotImplementedException;

public interface WorkWithFilesDatabase {
    default void addFile(File file) throws NotImplementedException {
        throw new NotImplementedException("This method is not implemented");
    }

    default void addDevice(Device device) throws NotImplementedException {
        throw new NotImplementedException("This method is not implemented");
    }
}
