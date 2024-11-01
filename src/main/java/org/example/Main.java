package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;


public class Main {//это первый класс(объект)в нем происходит вся работа, main всегда главный
    public static String EMAIL = "";
    public static String PASSWORD ="";

    public static void main(String[] args) {//это второй метод (функция) это точка входа в программу
        System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        runTheSolver();
    }

    public static void runTheSolver() { //это третий метод (функция)в которой пишем свою логику
        WebDriver driver = new EdgeDriver();//запустить браузер
        driver.get("https://thesolver.techoriz.in/en");//открыть сайт https://thesolver.techoriz.in/en
        driver.findElement(By.className("nav-user-img")).click(); //клик кнопки открывает диалог авторизации,найди это
        driver.findElement(By.id("email")).sendKeys(EMAIL);//в консоли ищу названия
        // полей,ctrl f подходящие названия "email",находит и выделяет их, нажать RUN, автотест ввел email
        driver.findElement(By.id("password-field")).sendKeys(PASSWORD);//то же самое сделать,
        //автотест нашел поле,
//        driver.findElement(By.cssSelector("button.btn-primary")).click();//найти названия кнопки //
        // в коде с помощью ctr+f ищу log in, click потому что кликаем ,а не вводим текст, этот способ и нижний
        // id подходят, ctrl+/ перед строкой -делает ее неактивной как комментарии,автотест ее не читает, ctrl+z
        // возвращает на предыдущее состояние,найти кнопку без id - найти в интернете,переведя в гугл переводчике
        // добавить selenium java, ответы на сайте stackoverflow.com
        driver.findElement(By.cssSelector("button.pop-login")).click();//ввела полность класс кнопки
        // btn btn-primary pop-login НЕ сработало, добавила btn-primary сработало, и попробовала button.pop-login
        //тоже сработало (кнопка начинается с тега button) если на комментрариях нажать ctrl+/ комментарии
        // становятся активны как код



    }


public static void runGoogle(){
        //код запускающий сайт гугл и вводящий в поиск слово Rabbit
    WebDriver driver = new EdgeDriver();//запустить браузер
    driver.get("https://www.google.com/"); //открыть сайт https://www.google.com/
    driver.manage().window().minimize(); //это кнопка "свернуть в окно" браузера
    driver.findElement(By.name("q")).sendKeys("Rabbit", Keys.ENTER);
    driver.manage().window().maximize();
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("Kitty", Keys.ENTER);
}

}








