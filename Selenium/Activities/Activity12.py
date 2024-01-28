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
    textbox = driver.find_element(By.ID, "input-text")
    textbox_toggle = driver.find_element(By.ID, "toggleInput")
    print("Text box is enabled: ", textbox.is_enabled())
    textbox_toggle.click()
    print("Text box is enabled: ", textbox.is_enabled())
    textbox.send_keys("Test text")
    driver.close()