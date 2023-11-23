package io.anaz.services;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class Db {
    
    public List<String> list;

    public Db() {
        this.list = new ArrayList<>();
    }

    public List<String> listAll() {
        return list;
    }

    public void addData(String data) {
        list.add(data);
    }

    public void deleteData(String data) {
        list.remove(data);
    }
}
