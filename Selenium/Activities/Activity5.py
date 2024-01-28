from selenium import webdriver
from selenium.webdriver.chrome.service import Service as chromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
service=chromeService(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    actions = webdriver.ActionChains(driver)
    driver.get("https://www.v1.training-support.net/selenium/input-events")
    print("Page title is: ", driver.title)
    actions.click().perform()
    active_side = driver.find_element(By.CLASS_NAME, "active")
    print("Active side number after left click: ", active_side.text)
    actions.double_click().perform()
    active_side = driver.find_element(By.CLASS_NAME, "active")
    print("Active side number after double click: ", active_side.text)
    actions.context_click().perform()
    active_side = driver.find_element(By.CLASS_NAME, "active")
    print("Active side number after right click: ", active_side.text)