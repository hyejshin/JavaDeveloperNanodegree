package edu.udacity.java.nano.chatroom;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ChatroomApplicationTests2 {
    WebDriver driver;

    @Test
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/shins/Documents/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void loginTest() {
        //init();
        driver.get("http://localhost:8080");
        WebElement inputElement = driver.findElement(By.name("username"));
        inputElement.sendKeys("HyeJung");
        pause(2000);
        inputElement.submit();
        WebElement usernameElement = driver.findElement(By.id("username"));
        Assert.assertEquals(usernameElement.getText(), "HyeJung");
        //driver.quit();
    }

    @Test
    public void userJoinTest() {
        //loginTest();
        WebElement chatNumElement = driver.findElement(By.className("chat-num"));
        Assert.assertEquals(chatNumElement.getText(), "1");
        //driver.quit();
    }

    @Test
    public void sendMessageTest() {
        String msg = "Hi! I am HyeJung :)";
        WebElement sendTextElement = driver.findElement(By.id("msg"));
        sendTextElement.sendKeys(msg);
        WebElement sendButton = driver.findElement(By.id("sendButton"));
        pause(2000);
        sendButton.click();
        pause(1000);
        WebElement usernameElement = driver.findElement(By.id("username"));
        WebElement message = driver.findElement(By.className("message-content"));
        String ans = usernameElement.getText() + "：" + msg;
        Assert.assertEquals(message.getText(), ans);
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}