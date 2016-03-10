package com.smusgrave.app.tvpa.model;

public class Links {

    private Self self;
    private Previousepisode previousepisode;
    private Nextepisode nextepisode;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Previousepisode getPreviousepisode() {
        return previousepisode;
    }

    public void setPreviousepisode(Previousepisode previousepisode) {
        this.previousepisode = previousepisode;
    }

    public Nextepisode getNextepisode() {
        return nextepisode;
    }

    public void setNextepisode(Nextepisode nextepisode) {
        this.nextepisode = nextepisode;
    }
}
