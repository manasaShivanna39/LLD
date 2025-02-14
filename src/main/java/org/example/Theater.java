package org.example;

import java.util.List;

public class Theater {
    private String id;
    private String name;
    private String location;

    private List<Show> shows;

    public Theater(String id, String name, String location, List<Show> shows) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.shows = shows;
    }
}
