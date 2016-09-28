package com.enterprise.wrapup.wrapup;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by admin on 22.09.2016.
 */
public class MainClass  implements Serializable {
    private ArrayList<List> lists;

    public void changeList(List list, int listId){
        this.lists.set(listId, list);
    }

    public void addListToLists(List list){
        this.lists.add(list);
    }

    public void deleteList(int listId){
        this.lists.remove(listId);
    }
}
