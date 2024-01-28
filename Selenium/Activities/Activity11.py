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
    print(driver.title)
    wait=WebDriverWait(driver,20)
    checkbox = driver.find_element(By.CSS_SELECTOR, "input.willDisappear")
    checkbox.click()
    print("Checkbox is selected: ", checkbox.is_selected())
    checkbox.click()
    print("Checkbox is selected: ", checkbox.is_selected())
    driver.close()