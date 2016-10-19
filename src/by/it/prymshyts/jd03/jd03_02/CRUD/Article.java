package by.it.prymshyts.jd03.jd03_02.CRUD;

public class Article {

    private int ID;
    private String Title;
    private int Post_date;
    private String Info;
    private int FK_User;


    public Article() {}

    public Article(int ID, String title, int post_date, String info, int FK_User) {
        this.ID = ID;
        Title = title;
        Post_date = post_date;
        Info = info;
        this.FK_User = FK_User;
    }


    @Override
    public String toString() {
        return "Article{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Post_date='" + Post_date + '\'' +
                ", Info='" + Info + '\'' +
                ", FK_User=" + FK_User +
                '}';
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getPost_date() {
        return Post_date;
    }

    public void setPost_date(int post_date) {
        Post_date = post_date;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getFK_User() {
        return FK_User;
    }

    public void setFK_User(int FK_User) {
        this.FK_User = FK_User;
    }
}
