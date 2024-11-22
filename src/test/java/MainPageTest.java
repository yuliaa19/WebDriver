import org.example.LoginDialogPage;
import org.example.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPageTest {

    WebDriver driver = new EdgeDriver(); //запустить браузер/ эту 1-я часть мы создаем здесь наш объект
    //WebDriver ,который потом передается в конструктор MainPage чтобы создать наш объект первой страницы  и так же мы делаем
    //переменную MainPage чтобы сразу был этот объект и мы его не пересоздавали несколько раз,
    // WebDriver driver = new EdgeDriver() говорит о чтом,что создаю именно Edge потому тестирую в нем,если бы это был другой браузер
    //надо указывать веб драйвер для них
    MainPage mainPage;


    @BeforeEach //2-я  часть перед методом есть аннотация BeforeEach, она означает,что перед тем как запускается тест
    // сначало запускается этот метод
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        //в этом методе первой строкой добавляю путь к нашему веб драйверу для хрома
        driver.get("https://thesolver.techoriz.in/en"); // открыть сайт https://www.google.com/
        //второй строкой указываю какой сайт открыть
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //третья строка указываю время ,которое даём
        // подождать пока загрузится страница
        mainPage = new MainPage(driver); //эта строка говорит,что создаем
        // свой первый объект(класс) MainPage и записываем его в переменную/мы пишем снова слово new
        //и передаем в конструктор наш веб драйвер,т.е мы его создали один раз это WebDriver и запускаем его на все
        // страницы сайта. NEW и название класса создаю объект класса,вся JAVA построена на объектах
        //объекты взаимодействуют с другими объектами (как и в обычном мире например - человек это объект,кот - это объект ,
        // и у каждого объекта есть своя функция -ходить,сидеть,лежать, так и здесь )
    }

    @AfterEach// метод с аннотацией @AfterEach говорит,что вызовем этот метод когда наш тест закончится
    public void testFinished() {
        driver.quit();
    }

    @Test()//Сам метод тестирования, обозначается аннотацией  @Test здесь наши 3 класса взаимодействуют друг с другом
    //
//    public void checkTitle() {
//        LoginDialogPage loginDialogPage = mainPage.clickSignInButton(); //эта первая строчка говорит -сделай переменную
//        //LoginDialogPage с типом LogDialogPage.Для этого обращаемся к нашему первому объекту
//        //к стартовой страницы MainPage ,которую мы создали и записали в переменную MainPage и говорим вызови
//        //метод clickSignInButton. CTRL и наводим на clickSignInButton переводит в класс  MainPage.java (сверху вкладки)
//        // и там читаем объяснения, т.е вызывается метод , мы сначала создали этот объект и теперь просим его
//        // выполнить какой то метод ,который у него есть
//        WebElement loginTitle = loginDialogPage.getLoginTitle(); // эта вторая строчка  создаю переменную loginTitle
//        // у которой тип WebElement. Обращаюсь к объекту  loginDialogPage,который мы создавали строчкой выше ,вызови у себя метод
//        //getLoginTitle() снова нажимаю CTRL и навожу на этот метод и с мотрю,что он делает
//        //Этот метод обращается  к браузеру по айди тайтла и просто возвращает этот веб элемент
//
//        Assert.assertEquals("Login", loginTitle.getText());//третья срочка это и есть тест
//        //Assert.assetEquals это метод из библиотеки которую добавили Junit 4, он сравнивает 2 теста
//        //он принимает два параметра ,первый -ожидаемый текст Login(это параметр) ,второй тот,который есть у нас в нашем
//        // веб элементе loginTitle.getText(




public void checkTitle() {
    LoginDialogPage loginDialogPage = mainPage.clickSignInButton();
    WebElement loginTitle = loginDialogPage.getLoginTitle(); // эта вторая строчка  создаю переменную loginTitle
    Assert.assertEquals("Login", loginTitle.getText());//третья срочка это и есть первый тест, дальше текст гласит о том,что
        //нужно сравнить текст из веб элемента в диалоговом окне авторизации где написано Log in
        //в случае если тест проходит идет следующа строка 75(по этому примеру) на ней вызывается метод авторизации
    loginDialogPage.signIn(); //CTRL и навела на метод signIn показало,что произойдет
        //перекидывает в LoginDialogPage и в поля вводим логин и пароль и клик на кнопку
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//это таймаут,чтобы дать сайту время отправить запрос на сервер
        //и если данные првильные выдать токен ,если нет выдать ошибку
    mainPage.clickProfileButton(); //эта строка значит чтобы MainPage вызвал метод clickProfileButton, ctrl и навожу на
        //него,переводит в файл MainPage и там показано,что он означает
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//здесь снова таймаут 5 сек ,если вдруг слабый интернет
        //не помешал нам пройти тест
    String currentUrl = driver.getCurrentUrl(); //обращение к драйверу,чтобы он дал текущий url,
        // здесь создается локальная переменная тип string и назначение ей значение текущей url сайта
    Assert.assertEquals("https://thesolver.techoriz.in/en/product", currentUrl); // здесь происходит тест
        //снова сравнение ссылки которую ожидаем и ссылку,которую получили с браузера ,если они совпадают значит тест прошел
}
}  //это клик на кнопку профайла после авторизации

// п.с слева сбоку папочки и С в синем кружочке MainPage,LoginDialogPage это классы
//каждый класс это объект


