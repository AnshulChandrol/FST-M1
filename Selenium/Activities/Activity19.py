from selenium import webdriver
from selenium.webdriver.chrome.service import Service as chromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import ActionChains
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.alert import Alert
service=chromeService(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    actions = webdriver.ActionChains(driver)
    driver.get("https://v1.training-support.net/selenium/javascript-alerts")
    print("Page title is: ", driver.title)

    driver.find_element(By.XPATH,"//button[@id='confirm']").click()
    alertText=driver.switch_to.alert.text
    print("Text of alert : "+alertText)
    driver.switch_to.alert.accept()
    driver.find_element(By.XPATH,"//button[@id='confirm']").click();
    driver.switch_to.alert.dismiss()
    driver.close();
