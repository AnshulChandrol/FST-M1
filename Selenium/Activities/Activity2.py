from selenium import webdriver
from selenium.webdriver.chrome.service import Service as chromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
service=chromeService(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/login-form")
    print(driver.title)
    driver.find_element(By.NAME,"Username").send_keys("admin")
    driver.find_element(By.ID,"password").send_keys("password")
    driver.find_element(By.XPATH,"//button[text()='Log in']").click()
    driver.close()