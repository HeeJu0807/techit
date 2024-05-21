package com.example.day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Movie implements Comparable<Movie> {
    private String title;
    private int year;
    private double rating;

    public Movie(String title, int year, double rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public int compareTo(Movie mv) {
        return this.title.compareTo(mv.title);
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", year=" + year + ", rating=" + rating + "]";
    }
}

// Comparator 인터페이스 구현
class RatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie mv1, Movie mv2) {
        return Double.compare(mv1.getRating(), mv2.getRating());
    }
}

class ReleaseYearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie mv1, Movie mv2) {
        return Integer.compare(mv1.getYear(), mv2.getYear());
    }
}

public class MovieManager {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Shawshank Redemption", 1994, 9.3));
        movies.add(new Movie("The Godfather", 1972, 9.2));
        movies.add(new Movie("The Dark Knight", 2008, 9.0));

        // 제목 기준 정렬 (Comparable)
        Collections.sort(movies);
        System.out.println("Sorted by title:");
        movies.forEach(System.out::println);

        // 평점 기준 정렬 (Comparator)
        Collections.sort(movies, new RatingComparator());
        System.out.println("Sorted by rating:");
        movies.forEach(System.out::println);

        // 출시 연도 기준 정렬 (Comparator)
        Collections.sort(movies, new ReleaseYearComparator());
        System.out.println("Sorted by release year:");
        movies.forEach(System.out::println);
    }
}