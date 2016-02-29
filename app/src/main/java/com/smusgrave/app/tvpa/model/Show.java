package com.smusgrave.app.tvpa.model;

import java.util.ArrayList;
import java.util.List;

public class Show {

    public int id;
    public String url;
    public String name;
    public String type;
    public String language;
    public List<String> genres = new ArrayList<>();
    public String status;
    public int runtime;
    public String premiered;
    public Schedule schedule;
    public Rating rating;
    public int weight;
    public Network network;
    public Object webChannel;
    public Externals externals;
    public Image image;
    public String summary;
    public int updated;
    public Links Links;

}
