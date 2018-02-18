package pe.anthony.androidcoverflowclic.Model;

/**
 * Created by ANTHONY on 10/12/2017.
 */

public class Movie {

    private String title,sumary,url;

    public Movie(String title, String sumary, String url) {
        this.title = title;
        this.sumary = sumary;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSumary() {
        return sumary;
    }

    public void setSumary(String sumary) {
        this.sumary = sumary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
