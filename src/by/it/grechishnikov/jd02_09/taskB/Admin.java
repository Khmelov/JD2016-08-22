package by.it.grechishnikov.jd02_09.taskB;


import javax.xml.bind.annotation.*;

@XmlType(name = "Admin")
public class Admin {
    @XmlAttribute(name = "nickname", required = true)
    private String nickname;
    @XmlAttribute(name = "password", required = true)
    private String password;
    private String email;
    private Catalog catalog = new Catalog();
    {
        Goods goods1 = new Goods();
        goods1.setDescription("car");
        goods1.setPrice(1000);
        Goods goods2 = new Goods();
        goods2.setDescription("phone");
        goods2.setPrice(200);
        catalog.getGoods().add(goods1);
        catalog.getGoods().add(goods2);
    }

    public Admin() {
    }


    public String getEmail() {
        return email;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "nick : " + nickname + ", email : " + email;
    }
}
