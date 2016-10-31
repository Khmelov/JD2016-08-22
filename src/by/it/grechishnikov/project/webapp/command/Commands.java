package by.it.grechishnikov.project.webapp.command;

public enum Commands {
    INDEX("/index.jsp"), LOGIN("/login.jsp"), SIGN_UP("/signup.sjp"), CATALOG("/catalog.jsp"),
    ERROR("/error.jsp"), SEARCH("/search.jsp"), ADMIN("/admin.jsp"), CONTACTS("/contacts.jsp"),
    GO_TO_LOGIN("goToLogin"), GO_TO_SIGN_UP("goToSignUp") ,MY("/my.jsp");

    public String message;

    Commands(String path) {
        this.message = path;
    }
}
