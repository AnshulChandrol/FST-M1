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
    driver.get("https://v1.training-support.net/selenium/ajax")
    pageTitle=driver.title
    print(pageTitle)
    wait=WebDriverWait(driver,20)
    driver.find_element(By.XPATH,"//button[text()='Change Content']").click();
    wait.until(EC.visibility_of_element_located(By.TAG_NAME,"h1"))
    print("message displaying in page : ",driver.find_element(By.TAG_NAME,"h1").text)
    wait.until(EC.visibility_of_element_located(By.TAG_NAME,"h3"))
    print("message displaying in page : ",driver.find_element(By.TAG_NAME,"h3").text)
    driver.close()



