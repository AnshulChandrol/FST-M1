from selenium import webdriver
from selenium.webdriver.chrome.service import Service as chromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import ActionChains
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.select import Select
service=chromeService(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    actions = webdriver.ActionChains(driver)
    driver.get("https://www.v1.training-support.net/selenium/selects")
    print("Page title is: ", driver.title)
    single_select = driver.find_element(By.ID, "single-select")
    dropdown = Select(single_select)
    dropdown.select_by_visible_text("Option 2")
    print("Selected option: ", dropdown.first_selected_option.text)
    dropdown.select_by_index(3)
    print("Selected option: ", dropdown.first_selected_option.text)
    dropdown.select_by_value("4")
    print("Selected option: ", dropdown.first_selected_option.text)
    select_options = dropdown.options
    for option in select_options:
        print("Option: ", option.text)
    driver.quit()