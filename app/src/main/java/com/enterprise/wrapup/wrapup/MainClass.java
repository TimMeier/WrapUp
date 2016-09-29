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
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> numbers = new ArrayList<>();
    ArrayList<Boolean> bools = new ArrayList<>();

    public MainClass(){
        if (lists == null){
            lists = new ArrayList<List>();

        }

        if(lists_String == null){
            this.lists_String = new ArrayList<String>();
        }

//        for(List list : this.lists){
//            this.lists_String.add(list.getName());
//        }
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

//    public void save(ArrayList<List> lists){
//        FileManager manager = new FileManager();
//        manager.exportFile(manager.toJson(lists));
//    }

    public void mappToBackend(ArrayList<String> names, ArrayList<String> numbers, ArrayList<Boolean> bools, String listname, int index){

        List list = new List();
        list.setName(listname);
        for (String name : names){
//            if (!name.equals("")){
                Product product = new Product();
                product.setName(name);
                list.addProductToList(product);
//            }

        }

        int g = 0;
        for (String number : numbers){
//            if(!number.equals("")){
                Product product = list.getProducts().get(g);
                product.setNumber(number);
                list.getProducts().set(g, product);

//            }
            g++;
        }

//        int y = 0;
//        for (String number : numbers){
//            Product product = list.getProducts().get(y);
//            product.setNumber(number);
//            list.getProducts().set(y, product);
//            g++;
//        }
        if(list.size() > 0){
            if (index == -1){
                this.lists.add(list);
            }else{
                this.lists.set(index, list);
            }
        }


    }

    public void mappBackendToFrontEnd(ArrayList<Product> list){
        names.clear();
        numbers.clear();
        bools.clear();

        for(Product product:list){
            names.add(product.getName());
            numbers.add(product.getNumber());
            bools.add(product.getBuyed());
        }
    }

    public ArrayList<String> getLists_String() {
        return lists_String;
    }

    public void setLists(ArrayList<List> import_list){

        this.lists = import_list;
        this.lists_String.clear();
        for(List list : this.lists){
            this.lists_String.add(list.getName());
        }
    }

    public ArrayList<String> getItems(int index){
        mappBackendToFrontEnd(lists.get(index).getProducts());
        return this.names;
    }

    public  ArrayList<String> getMenge(){
        return this.numbers;
    }
    public  ArrayList<Boolean> getBools(){
        return this.bools;
    }
}
