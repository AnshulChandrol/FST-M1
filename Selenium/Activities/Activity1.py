from selenium import webdriver
from selenium.webdriver.chrome.service import Service as chromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
service=chromeService(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    driver.get("https://v1.training-support.net")
    print("Webpage title : ",driver.title)
    driver.find_element(By.ID,"about-link").click()
    print("2nd Webpage title : ",driver.title)
    driver.quit()