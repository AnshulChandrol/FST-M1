from selenium import webdriver
from selenium.webdriver.chrome.service import Service as chromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import ActionChains
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
service=chromeService(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    actions = webdriver.ActionChains(driver)
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    print(driver.title)

    driver.find_element(By.XPATH,"//input[contains(@class,'-username')]").send_keys("anshul");
    driver.find_element(By.XPATH,"//input[contains(@class,'-password')]").send_keys("password");
    driver.find_element(By.XPATH,"//label[text() = 'Confirm Password']/following-sibling::input").send_keys("password");
    driver.find_element(By.XPATH,"//label[contains(text(), 'mail')]/following-sibling::input").send_keys("abc@gmail.com");
    driver.find_element(By.XPATH,"//button[contains(text(), 'Sign Up')]").click();
    loginMessage = driver.find_element(By.ID,"action-confirmation").text;
    print("Login message: " + loginMessage);
    driver.quit();