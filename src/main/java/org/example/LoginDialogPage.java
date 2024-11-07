package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginDialogPage {

    public static String EMAIL = "";
    public static String PASSWORD = ""; //1)пароль и email которые подставим полям email и пароль на сайте

    //2)это наш класс webDriver, emailField,passwordField,LoginInButton? это локальные переменные ,которым мы назначаем
    //наши поля с диалога окна , т.е создаю переменную с именем logInButton
    private WebDriver webDriver;
    private WebElement emailField;
    private WebElement passwordField;//вот она объявляется в коде и тип этой переменной WebElement(тип)
    // т.е это любой элемент на сайте, тип может быть - WebElement,string, int.
    private WebElement logInButton;//вот она объявляется в коде и тип этой переменной LogIButton

    public LoginDialogPage(WebDriver driver) {//  3) это КОНСТРУКТОР, он нужен для создания объекта ,
        //по сути это тот же метод ,только для инициализации класса, он пишется как и название класса ,
        // в {} скобках в нем создается все необходимые для работы элементы ,в скобках () WebDriver driver - это
        //значит ,что для создания этого класса нужно в него передать объект WebDriver - такой ингридиент для того
        //чтобы можно было пользоваться этим классом
        webDriver = driver; //WebDriver это браузер
        emailField = webDriver.findElement(By.id("email"));
        passwordField = webDriver.findElement(By.id("password-field"));
        logInButton = webDriver.findElement(By.cssSelector("button.pop-login"));
        //вот она объявляется в коде и тип этой переменной LogInButton,эта строчка назначаю
        // переменной конкретный объект на сайте -нашу вьюшку. В данном случае -кнопка log in
        //строчка logInButton = webDriver.findElement говорит о том,что ищем на странице вьюшку с названием класса
        //button.pop-login и обращаясь к переменной logInButton сразу знаю,что это та нопка и ее не надо искать повторно
        //теперь можно использовать ее сколько угодно раз
    }

    public void signIn(){
        emailField.sendKeys(EMAIL);
        passwordField.sendKeys(PASSWORD);
        clickLogInButton();
    }

    public void clickLogInButton(){ //4)здесь обращаюсь к уже назначенной переменной
        logInButton.click();
    }
    //здесь пример использования и не пишу снова WebDriver.findElement ,а сразу пишем logInButton.click()
    //т.е  обращаемся к кнопке логина и просим клик
    //В JAVA принятый синтаксис когда пишем имя переменной или метода ,класса НЕ делать пробелы ,следующее слово пишем
    //с большой буквы без пробела
    //

    public WebElement getLoginTitle(){
        WebElement title = webDriver.findElement(By.id("exampleModalLabel"));
        return title;
    }
}
// есть 2 класса MainPage и LoginDialogPage
//у каждого класса есть конструктор ,выглядит он так
//Public MainPage(WebDriver){
//}
//или Public LoginDialogPage (WebDriver driver) {
//}
