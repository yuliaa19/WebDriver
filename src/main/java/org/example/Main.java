package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;

import java.util.List;


public class Main {//это первый класс(объект)в нем происходит вся работа, main всегда главный
    public static String EMAIL = "te258710s43t@gmail.com";
    public static String PASSWORD ="d871ca2ff3w"; //здесь нужно было вставить после скрытия свой логин и пароль в " "

//    public static void main(String[] args) {//это второй метод (функция) это точка входа в программу
//        System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//        runTheSolver();
//    }

//    public static void runTheSolver() { //это третий метод (функция)в которой пишем свою логику
//        WebDriver driver = new EdgeDriver();//запустить браузер
//        driver.get("https://thesolver.techoriz.in/en");//открыть сайт https://thesolver.techoriz.in/en
//        driver.findElement(By.className("nav-user-img")).click(); //клик кнопки открывает диалог авторизации,найди это
//        driver.findElement(By.id("email")).sendKeys(EMAIL);//в консоли ищу названия
//        // полей,ctrl f подходящие названия "email",находит и выделяет их, нажать RUN, автотест ввел email
//        driver.findElement(By.id("password-field")).sendKeys(PASSWORD);//то же самое сделать,
//        //автотест нашел поле,
////        driver.findElement(By.cssSelector("button.btn-primary")).click();//найти названия кнопки //
//        // в коде с помощью ctr+f ищу log in, click потому что кликаем ,а не вводим текст, этот способ и нижний
//        // id подходят, ctrl+/ перед строкой -делает ее неактивной как комментарии,автотест ее не читает, ctrl+z
//        // возвращает на предыдущее состояние,найти кнопку без id - найти в интернете,переведя в гугл переводчике
//        // добавить selenium java, ответы на сайте stackoverflow.com
//        driver.findElement(By.cssSelector("button.pop-login")).click();//ввела полность класс кнопки
//        //ввела полностью класс кнопки
//        // btn btn-primary pop-login НЕ сработало, добавила btn-primary сработало, и попробовала button.pop-login
//        //тоже сработало (кнопка начинается с тега button) если на комментрариях нажать ctrl+/ комментарии
//        // становятся активны как код
//        driver.findElement(By.className("nav-link")).click(); //нажать на кнопку Products,
//        // открываем на этой кнопке правой кнопкой мыши "проверить", driver.findElement(By.className("nav-link")).click();
//        //не сработал, ответ на List <WebElement> navlist = driver.findElements(By.cssSelector("ul.d-md-down-none.nav.navbar-nav.mr-auto li>a")); [1](https://stackoverflow.com/questions/50212534/how-to-click-in-nav-bar-and-choose-item-from-a-list-in-selenium-java)
//        //for (WebElement elem : navlist) {
//        //    if (elem.getAttribute("innerHTML").contains("Sources")) {
//        //        elem.click()
//        //    }
//        //}
////        List<WebElement> navlist = driver.findElements(By.cssSelector(".navbar-nav.navbar-items-solver.me-auto.mb-2.mb-lg-0"));//
//        //если нажать ctrl и на метод findElements в этом коде перекинет в класс библиотеки селениум и видим там где тип List<WebElement> перед методом,
//        //который вызываем пишется тип,который этот метод вернет
//        //List список чего либо , WebElement в данном случае это какой либо элемент на сайте, driver.findElements это сайт,браузер
//        //найди мне список элементов, By.cssSelector - это говорит по какому типу и значению искать, здесь по css если бы было By.className
//        //искалось бы по имени  класса
////        navlist.get(0).findElement(By.linkText("Products")).click();//navlist это список веб элементов,который мы попросили найти
//        // get(0) означает,что мы обращаемся к списку к первому элементу в этом списке
//        // findElement найди элемент, By.linkText найди по тексту, navlist это список navbar-nav элементов, обращаюсь к 1му
//        //т.к чаще всего будет один такой элемент на сайте,если из нескольких -возможно нужно обращаться не к первому
//        //но в данном примере обращение к первому элементу т.к список из одного элемента , обратились к navbar и просим
//        //найти вьюшку с текстои Products , находим и делаем клик на него, если язык не меняется на сайте, если сайт переведем на русский язык
//        //то тест не пройдет
//        //Products указываем название кнопки,на которую надо кликнуть (это ПЕРВЫЙ способ, возможно неправильный т.к
//        // при смене языка ничего не получится? в первом способе просто обращаюсь к первому элементу из списка,в первом примере мы обращались)
//        //к тексту кнопки. Есть правило нельзя писать 2 раза одну и ту же переменную ,т.к navlist повторяется и во втором способе
//        // светит ошибку,поэтому первый способ 2 строки закомментировала - перед строками ctrl /
//
//        //Второй способ
//        List<WebElement> navlist = driver.findElements(By.cssSelector(".navbar-nav.navbar-items-solver.me-auto.mb-2.mb-lg-0"));
//        //List список чего либо , WebElement в данном случае это какой либо элемент на сайте, driver.findElements это сайт,браузер
//        //найди мне список элементов, By.cssSelector - это говорит по какому типу и значению искать, здесь по css если бы было
//        // By.className искалось бы по имени  класса
//        for (WebElement elem : navlist) //For значит начало цикла ,в этом ВТОРОМ способе мы проходим каждый элемент из списка
//            //т.е беру какой то список и поочередно что то с ним делаю ,перебираю его данные и возможно что то выбираю
//            // из этого списка
//            //во втором способе обращаюсь к href .
//            if (elem.getAttribute("innerHTML").contains("https://thesolver.techoriz.in/en/product")) //это строка
//                // блок if это блок условий,беру список
//        //веб элементов ,всех какие есть в нашем navbar, там есть кнопка Home ,профайл и корзина, if проверяет по очереди
//        //он запрашивает у каждого параметр attribute с именем innerHtml (href?)
//        // конструкция у блока if такая If(1>0){
//        //}Else{
//                //}
//                //там проверяется условие ,если 1 больше 0тогда выполняется код в скобках после If,если эти условия
//                //НЕ удовлетворяются тогда в блок Else,здесь блока Else нет,значит если условия не проходят тогда не
//                // выполняется ничего ,это true/false
//                //ctrl и нажать на elem.getAttribute видно String, этот метод возвращает строку , запрашиваешь имя
//                // атрибута,вписываешь "innerHtml" если он есть,то он возвращает тебе строку ,дальше эту строку используешь
//                //для сравнения ,дальше метод .CONTAINS он применяется к строке и говорит есть ли в этой строке
//                //место в котором есть комбинация символов "Sources" (сюда вставили ссылку href с html если
//                // такая комбинация есть то наше условие выполнилось TRUE
//                //и мы попадаем в скобки elem.click() т.е берешь у вьюшки из списка атрибут- ссылку href и сравниваешь
//                //с той которую ты указал ,если совпадает тогда делается клик,если не совпадает не делается ничего
//                //.CONTAINS еще значит -имеет в себе, есть еще метод equals ,что значит полное совпадение
//            {
//                elem.click();
//                break;
//            }
//                // если нет данных используешь -один способ.
//
//    }


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








