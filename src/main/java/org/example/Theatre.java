package org.example;

import java.util.List;

public class Theatre {
    private int id;
    private String name;
    private String location;

    private List<Show> shows;

    public Theatre(int id, String name, String location, List<Show> shows) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.shows = shows;
    }
}
