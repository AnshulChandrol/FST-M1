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
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    pageTitle=driver.title
    print(pageTitle)
    wait=WebDriverWait(driver,20)
    checkbox=driver.find_element(By.CLASS_NAME,"willDisappear");
    removeCheckbox=driver.find_element(By.ID,"toggleCheckbox");
    print("Checkbox is visible",checkbox.is_displayed)
    removeCheckbox.click()
    wait=wait.until(EC.invisibility_of_element(driver.find_element(By.CLASS_NAME,"willDisappear")))
    print("Checkbox is visible",checkbox.is_displayed)
    removeCheckbox.click()
    print("Checkbox is visible",checkbox.is_displayed)
    driver.find_element(By.XPATH,"//input[@class='willDisappear']").click()
    driver.close()
