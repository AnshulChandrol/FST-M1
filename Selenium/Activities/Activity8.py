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
    wait=WebDriverWait(driver,10)
    checkbox=driver.find_element(By.ID, "dynamicCheckbox")
    checkbox_toggle = driver.find_element(By.ID, "toggleCheckbox")
    checkbox_toggle.click()
    print("Checkbox hidden")
    wait.until(EC.invisibility_of_element(checkbox))
    checkbox_toggle.click()
    print("Checkbox visible")
    checkbox.click()
    print("Checkbox selected")
    driver.close()
