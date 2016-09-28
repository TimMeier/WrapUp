package com.enterprise.wrapup.wrapup;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by admin on 22.09.2016.
 */
public class MainClass  implements Serializable {
    private ArrayList<List> lists;
    private ArrayList<String> lists_String;

    public MainClass(){
        if (lists == null)
            return;
        for(List list : this.lists){
            this.lists_String.add(list.getName());
        }
    }

    public ArrayList<List> getLists() {
        return lists;
    }

    public void changeList(List list, int listId){
        this.lists.set(listId, list);
    }

    public void addListToLists(List list){
        this.lists.add(list);
    }

    public void deleteList(int listId){
        this.lists.remove(listId);
    }

    public void save(ArrayList<List> lists){
        FileManager manager = new FileManager();
        manager.exportFile(manager.toJson(lists));
    }

    public void mappToBackend(ArrayList<String> names, ArrayList<String> numbers, ArrayList<Boolean> bools){
        int i = 0;
        List list = new List();
        for (String name : names){
            Product product = new Product();
            product.setName(name);
            list.addProductToList(product);
            i++;
        }

        int g = 0;
        for (String number : numbers){
            Product product = list.getProducts().get(g);
            product.setNumber(number);
            list.getProducts().set(g, product);
            g++;
        }

        int y = 0;
        for (String number : numbers){
            Product product = list.getProducts().get(y);
            product.setNumber(number);
            list.getProducts().set(y, product);
            g++;
        }

        this.lists.add(list);
    }

    public void mappBackendToFrontEnd(ArrayList<Product> list){
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<Boolean> bools = new ArrayList<>();

        for(Product product:list){
            names.add(product.getName());
            numbers.add(product.getNumber());
            bools.add(product.getBuyed());
        }
    }

    public ArrayList<String> getLists_String() {
        return lists_String;
    }
}
