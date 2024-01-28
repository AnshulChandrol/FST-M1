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
    driver.get("https://v1.training-support.net/selenium/tables")
    print(driver.title)
    rows = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tbody/tr")
    print("Number of rows: ", len(rows))
    columns = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tbody/tr[1]/td")
    print("Number of rows: ", len(columns))
    secondColValue=driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[2]")
    print("second row second column values : ",secondColValue.text)
    driver.find_element(By.XPATH,"//table[@id='sortableTable']//thead//tr//th[1]").click();
    print("second row second column values :",secondColValue.text)
    footerValues=driver.find_elements(By.XPATH,"//table[@id='sortableTable']/tfoot/tr/th");
    for row in footerValues:
        print("footer value : ",row.text)
    driver.close()

