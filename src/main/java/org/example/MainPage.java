package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//Есть 2 класса MainPage LoginDialogPage ,MainPage это стартовая страница сайта, нужно найти кнопку  окна
//для открытия логин диалога ,вот метод,который отвечает за нахождение этой кнопки public LoginDialogPage
// clickSignInButton(){
//  WebElement signInButton = webDriver.findElement(By.className("nav-user-img"));
// signInButton.click();
public class MainPage {

    private WebDriver webDriver; //private значит,что его просто не увидешь


    public MainPage(WebDriver driver) { //public значит,что можно обратиться к этой переменной или методу
        //за пределами класса. ЭТО КОНСТРУКТОР ,он нужен для того чтобы создать класс,чтобы им могли пользоваться другие
        //есть конструктор дефолтный -он без параметров, а есть с параметрами
        //PublicMainPage(){} -это дефолтный
        //Public MainPage(Web Driver driver) {} - это с параметрами
        //Wеb Driver driver в данном случае параметр для создания класса
        //Если без параметров ,значит ,что классу не нужны никакие объекты для работы передавать ,все есть внутри этого
        //класса, в этом  случае конструктор с параметрами -потому что чтобы найти какой то элемент на сайте
        //нужно обратиться к веб драйверу ,вызвать у него МЕТОД findElement и указать какой то id или имя
        //или название класса
        webDriver = driver; //WebDriver это браузер ,для создания класса MainPAge необходимо передать в него WebDriver
    }

    public LoginDialogPage clickSignInButton() { //каждый метод возвращается какой то объект в ответ либо
        // не возвращает ничего ,тут мы пишем какой тип объекта возвращается
        WebElement signInButton = webDriver.findElement(By.className("nav-user-img"));//эта строчка находит
        // nav кнопку на странице ,далее строка делает клик по этой кнопке
        signInButton.click();
        return new LoginDialogPage(webDriver);
    }//т.е этот метод делает клик и при этом создается объект логин диалога,чтобы мы могли с ним взаимодействовать
    //строчка последняя return new LoginDialogPage(webDriver) , return - вернуть, каждый метод,который что то
    // возвращает в конце своей работы заканчивается словом return ,слово new - создает объект ,наш класс диалога
    //LoginDialogPage. Метод - какая то определенная часть кода,которая выполняет какие то действия ,
    //класс - содержит в себе несколько методов , здесь класс MAINPAGE содержит в себе метод,который кликает на кнопку
    //не пишу каждый раз один и тот же код, его внесла в отдельное место и мону пользоваться всего одной строчкой ,вместо тех
    //5-10 которые там есть. В этом методе  нажала на кнопку и переводит на окно диалог,
    //в этом окне видим тайтл(или хедер) где написано слово Login, справа крестик закрыть ,есть 2 поля для ввода
    //Есть 2 поля для ввода -логин и пароль, и кнопка авторизации , снизу еще какой то текст с ссылками
    //т.е мы используем тайтл, поле логин, поле пароль и кнопка Log in, потому нужно прописать их в классе
    //LoginDialogPage
    //здесь создавала класс LoginDialogPage писали new ,имя класса ,которым хотим создать
    // и передавали в него этот необходимый для его работы 'ингредиент'


    public void clickProfileButton() {
        List<WebElement> navlist = webDriver.findElements(By.cssSelector(".navbar-nav.navbar-items-solver.me-auto.mb-2.mb-lg-0"));
        for (WebElement elem : navlist)
            if (elem.getAttribute("innerHTML").contains("https://thesolver.techoriz.in/en/profile")) {
                elem.click();
                break;
            }
    }
}