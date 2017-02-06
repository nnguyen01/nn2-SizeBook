package nathan.sizebook;

import java.io.Serializable;

/**
 * Created by nathan on 31/01/17.
 */

/**
 * This class is used for the bulk of the program to make entries
 * and to keep track of the data per entry that the user
 * inputs.
 */
public class Person implements Serializable {
    private String name;
    private String date;
    private float neck;
    private float bust;
    private float chest;
    private float waist;
    private float hip;
    private float inseam;
    private String comments;

    /**
     * Person constructor.
     * @param name
     * @param date
     * @param neck
     * @param bust
     * @param chest
     * @param waist
     * @param hip
     * @param inseam
     * @param comments
     */
    public Person(String name, String date, float neck, float bust, float chest, float waist, float hip, float inseam, String comments) {
        this.name = name;
        this.date = date;
        this.neck = neck;
        this.bust = bust;
        this.chest = chest;
        this.waist = waist;
        this.hip = hip;
        this.inseam = inseam;
        this.comments = comments;
    }

    /**
     * Getters and Setters
     */
    @Override
    public String toString() {
        return date.toString() + "\n" + this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getDate() {
        return date;
    }

    public float getNeck() {
        return neck;
    }

    public float getBust() {
        return bust;
    }

    public float getChest() {
        return chest;
    }

    public float getHip() {
        return hip;
    }

    public float getInseam() {
        return inseam;
    }

    public String getComments() {
        return comments;
    }

    public float getWaist() { return waist; }
}
