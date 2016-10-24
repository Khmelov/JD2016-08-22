package by.it.prymshyts.jd03.jd03_01.DB_Test_Creation;

interface DB_TEST_COMMANDS {
    String CREATE_TABLE_ROLE =
            "CREATE TABLE Role (\n" +
             "  ID INT NOT NULL,\n" +
             "  Role VARCHAR(45) NULL,\n" +
             "  PRIMARY KEY (ID)) ENGINE=INNODB;";

    String CREATE_TABLE_USERS =
            "CREATE TABLE Users (\n" +
            "  ID INT NOT NULL AUTO_INCREMENT,\n" +
            "  Mail VARCHAR(45) NULL,\n" +
            "  Login VARCHAR(45) NULL,\n" +
            "  Password VARCHAR(45) NULL,\n" +
            "  FK_Role INT NULL,\n" +
            "  PRIMARY KEY (ID),\n" +
            "  FOREIGN KEY (FK_Role)\n" +
            "  REFERENCES Role(ID)\n" +
            "  ON UPDATE CASCADE\n" +
            "  ON DELETE SET NULL) ENGINE=INNODB;";

    String CREATE_TABLE_ARTICLE =
            "CREATE TABLE Article (\n" +
            "  ID INT NOT NULL AUTO_INCREMENT,\n" +
            "  Title VARCHAR(45),\n" +
            "  Post_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  Info VARCHAR(2000),\n" +
            "  FK_User INT NOT NULL,\n" +
            "  PRIMARY KEY (ID),\n" +
            "  FOREIGN KEY (FK_User)\n" +
            "  REFERENCES Users(ID)\n" +
            "  ON UPDATE CASCADE\n" +
            "  ON DELETE NO ACTION) ENGINE=INNODB;";


    String DROP_TABLE_ROLE = "DROP TABLE IF EXISTS Role;";

    String DROP_TABLE_USERS = "DROP TABLE IF EXISTS Users;";

    String DROP_TABLE_ARTICLE = "DROP TABLE IF EXISTS Article;";


    String UPDATE_TABLE_ROLE_1 =
            "INSERT INTO Role \n" +
            "  VALUES (1, 'Administrator');";
    String UPDATE_TABLE_ROLE_2 =
            "INSERT INTO Role \n" +
            "  VALUES (2, 'User');";


    String UPDATE_TABLE_USERS_1 =
            "INSERT INTO Users (\n" +
            "Mail, Login, Password, FK_Role)\n" +
            "VALUES (\n" +
            "'test1@mail.ru', 'test1', 'testpass', '1');";
    String UPDATE_TABLE_USERS_2 =
            "INSERT INTO Users (\n" +
            "  Mail, Login, Password, FK_Role)\n" +
            "  VALUES (\n" +
            "  'test2@mail.ru', 'test2', 'testpass', '2');";


    String UPDATE_TABLE_ARTICLE =
            "INSERT INTO Article (\n" +
            "Title, Post_date, Info, FK_User)\n" +
            "VALUES ('Test article title', CURRENT_TIMESTAMP, 'Test article info', 1);";


    String FK_CHECK_OFF = "SET FOREIGN_KEY_CHECKS=0;";

    String FK_CHECK_ON = "SET FOREIGN_KEY_CHECKS=1;";
}
