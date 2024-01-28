from selenium import webdriver
from selenium.webdriver.chrome.service import Service as chromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import ActionChains
service=chromeService(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    actions = webdriver.ActionChains(driver)
    driver.get("https://www.v1.training-support.net/selenium/drag-drop")
    pageTitle=driver.title
    print(pageTitle)
    football =driver.find_element(By.XPATH,"//img[@id='draggable']");
    dropzone1 =driver.find_element(By.ID,"droppable");
    dropzone2 =driver.find_element(By.ID,"dropzone2");
    actions.drag_and_drop(football,dropzone1).perform()
    actions.drag_and_drop(football,dropzone2).perform()
    driver.close()