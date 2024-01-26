from selenium import webdriver
from selenium.webdriver.chrome.service import Service as chromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
service=chromeService(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/target-practice")
    print("Webpage title : ",driver.title)
    text=driver.find_element(By.XPATH,"//h3[@id='third-header']").text
    print("3rd hearder text: ",text)
    colour=driver.find_element(By.XPATH,"//h5[text()='Fifth header']").value_of_css_property("colour")
    print("Colour of 5th header: ",colour)
    violet_class=driver.find_element(By.XPATH,"//button[text()='Violet']").get_attribute("class")
    print("classes of violet button : ",violet_class)
    greyColourText=driver.find_element(By.XPATH,"//button[@class='ui grey button']").text
    print("Grey colour button text : ",greyColourText)
    driver.close()