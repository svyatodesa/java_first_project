package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       try {
           driver.get("https://kyiv.sushi-master.ua/?gad_source=1&gclid=CjwKCAjwqf20BhBwEiwAt7dtdbkiSIgvgWUIxF6VCkzQJrrGgmkTKmY7Pyl7SSo85Do_h2pjTfuqXxoC3CYQAvD_BwE");
           driver.manage().window().maximize();

           List<WebElement> ul = driver.findElements(By.xpath("//*[@id=\"main\"]/div[2]/header/div[3]/div/div[2]/a"));
           System.out.print(ul.size());
           for (WebElement e : ul) {
               System.out.print(e.getText());
               e.click();
               Thread.sleep(2000);


               List<WebElement> pay = driver.findElements(By.xpath("//*[@id=\"main\"]/main/div/div[1]/div[2]/div"));
               int sizePay = (int)(Math.random() * 3) + 1;
               driver.findElement(By.xpath("//*[@id=\"main\"]/main/div/div[1]/div[2]/div["+sizePay+"]")).click();;

               driver.findElement(By.xpath("//*[@id=\"main\"]/main/div/div[2]/div/div[2]/div/div[3]/div[2]/div/button")).click();


           }
       }
       catch (ArithmeticException e){
           System.out.print(e);
       }
       finally {
           driver.quit();
       }

        }
}
