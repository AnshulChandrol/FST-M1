from selenium import webdriver
from selenium.webdriver.chrome.service import Service as chromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import ActionChains
service=chromeService(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    actions = webdriver.ActionChains(driver)
    driver.get("https://v1.training-support.net/selenium/input-events")
    pageTitle=driver.title
    print(pageTitle)
    actions.send_keys("A")
    actions.key_down(Keys.CONTROL)
    actions.send_keys("a")
    actions.send_keys("c") 
    actions.key_up(Keys.CONTROL) 
    actions.perform()