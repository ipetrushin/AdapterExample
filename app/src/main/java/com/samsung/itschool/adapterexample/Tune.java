package com.samsung.itschool.adapterexample;

public class Tune {
    public Tune(String artist, String title, int year, int duration ) {
        this.artist = artist;
        this.duration = duration;
        this.title = title;
        this.year = year;
    }

    String title, artist;
    int year, duration;

    @Override
    public String toString() {
        return "Tune{" +
                "artist='" + artist +
                ", title='" + title +
                ", year=" + year +
                ", duration=" + duration +
                '}';
    }
}
