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
    wait=WebDriverWait(driver,20)
    driver.get("https://www.v1.training-support.net/selenium/popups")
    print("Page title is: ", driver.title)
    signin_button = driver.find_element(By.CLASS_NAME, "orange")
    ActionChains(driver).move_to_element(signin_button).perform()
    tooltip_text = signin_button.get_attribute("data-tooltip")
    print("Button tooltip text: ", tooltip_text)
    signin_button.click()
    username = driver.find_element(By.ID, "username")
    password = driver.find_element(By.ID, "password")
    username.send_keys("admin")
    password.send_keys("password")
    driver.find_element(By.XPATH, "/html/body/div[4]/div/div[2]/div/div/button").click()
    message = driver.find_element(By.ID, "action-confirmation")
    print("Confirmation message: ", message.text)
    driver.quit()