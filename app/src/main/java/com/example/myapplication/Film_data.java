package com.example.myapplication;

public class Film_data {

    private String TITLE ;
    private String  YEAR ;
    private String DIRECTOR ;
    private String CASTING ;
    private String  RATING ;
    private String REVIEW ;
    private boolean FEV ;

    public Film_data(String TITLE, String  YEAR, String DIRECTOR, String CASTING, String RATING, String REVIEW, boolean FEV) {
        this.TITLE = TITLE;
        this.YEAR = YEAR;
        this.DIRECTOR = DIRECTOR;
        this.CASTING = CASTING;
        this.RATING = RATING;
        this.REVIEW = REVIEW;
        this.FEV = FEV;
    }
    public  Film_data(){

    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String  getYEAR() {
        return YEAR;
    }

    public void setYEAR(String  YEAR) {
        this.YEAR = YEAR;
    }

    public String getDIRECTOR() {
        return DIRECTOR;
    }

    public void setDIRECTOR(String DIRECTOR) {
        this.DIRECTOR = DIRECTOR;
    }

    public String getCASTING() {
        return CASTING;
    }

    public void setCASTING(String CASTING) {
        this.CASTING = CASTING;
    }

    public String getRATING() {
        return RATING;
    }

    public void setRATING(String RATING) {
        this.RATING = (RATING);
    }

    public String getREVIEW() {
        return REVIEW;
    }

    public void setREVIEW(String REVIEW) {
        this.REVIEW = REVIEW;
    }

    public boolean isFEV() {
        return FEV;
    }

    public void setFEV(boolean FEV) {
        this.FEV = FEV;
    }

    @Override
    public String toString() {
        return "Film_data{" +
                "TITLE='" + TITLE + '\'' +
                ", YEAR=" + YEAR +
                ", DIRECTOR='" + DIRECTOR + '\'' +
                ", CASTING='" + CASTING + '\'' +
                ", RATING=" + RATING +
                ", REVIEW='" + REVIEW + '\'' +
                ", FEV=" + FEV +
                '}';
    }
}
