package by.it.aborisenok.JD01_08;

/**
 * Created by Лёша on 12.09.2016.
 */
public class Wikipedia extends Encyclopedia {

    private String articleLink;

    public Wikipedia(String articleName, int pageSize, String articleLink){
        super(articleName, pageSize);
        this.articleLink = articleLink;
    }


    @Override
    public void listBook() {
        if (isBookOpen()){
            System.out.println("Листаем страницы экране...");
        } else {
            System.out.println("Не могу листать, сразу нужно зайти на сайт");
        }
    }

    @Override
    public void doRemark() {
        if (isBookOpen()){
            System.out.println("Добавляем страницу в закладки...");
        } else {
            System.out.println("Не могу пометить, сразу нужно сразу зайти на сайт");
        }
    }

    @Override
    public void readBook() {
        if (isBookOpen()){
            System.out.println("Читаем с экрана...");
        } else {
            System.out.println("Не могу читать, сразу нужно зайти на сайт");
        }

    }

    public void textCopy(){
        if (isBookOpen()){
            System.out.println("Копируем текст...");
        } else {
            System.out.println("Не могу копировать, сразу нужно зайти на сайт");
        }
    }

    public String getArticleLink(){
        return articleLink;
    }

    @Override
    public void lendBook() {
        System.out.println("Скинуть другу ссылку  - " + getArticleLink());
    }

    @Override
    public String toString() {
        return super.toString() + " | " + "Article link - " + getArticleLink();
    }


}
