package edu.ccrm.service;

import java.io.IOException;

public interface Persistable {
    void save() throws IOException;
    void load() throws IOException;
}