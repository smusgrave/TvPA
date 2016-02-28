package com.smusgrave.app.tvpa.model;

import java.util.ArrayList;
import java.util.List;

public class Show {

    public Integer id;
    public String url;
    public String name;
    public String type;
    public String language;
    public List<String> genres = new ArrayList<String>();
    public String status;
    public Integer runtime;
    public String premiered;
    public Schedule schedule;
    public Rating rating;
    public Integer weight;
    public Network network;
    public Object webChannel;
    public Externals externals;
    public Image image;
    public String summary;
    public Integer updated;
    public Links Links;

}
