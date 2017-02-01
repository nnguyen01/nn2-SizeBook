package nathan.sizebook;

import android.app.DownloadManager;

import java.util.Date;
import java.util.jar.Attributes;

/**
 * Created by nathan on 31/01/17.
 */

public class Person {
    private String name;
    private String date;
    private float neck;
    private float bust;
    private float chest;
    private float hip;
    private float inseam;
    private String comments;

    public Person(String name, String date, float neck, float bust, float chest, float hip, float inseam, String comments) {
        this.name = name;
        this.date = date;
        this.neck = neck;
        this.bust = bust;
        this.chest = chest;
        this.hip = hip;
        this.inseam = inseam;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getNeck() {
        return neck;
    }

    public void setNeck(float neck) {
        this.neck = neck;
    }

    public float getBust() {
        return bust;
    }

    public void setBust(float bust) {
        this.bust = bust;
    }

    public float getChest() {
        return chest;
    }

    public void setChest(float chest) {
        this.chest = chest;
    }

    public float getHip() {
        return hip;
    }

    public void setHip(float hip) {
        this.hip = hip;
    }

    public float getInseam() {
        return inseam;
    }

    public void setInseam(float inseam) {
        this.inseam = inseam;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}