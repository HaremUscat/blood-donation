using System;
using System.Text;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.IE;
using OpenQA.Selenium.Support.UI;

namespace SeleniumBingTests
{

    [TestClass]
    public class MySeleniumTests
    {
        private TestContext testContextInstance;
        private IWebDriver driver;
        private string appURL;

        public MySeleniumTests()
        {
        }

        [TestMethod]
        [TestCategory("Chrome")]
        public void ApplicationStartedTest()
        {
            driver.Navigate().GoToUrl(appURL + "/");
        }

 
        // Tests the sign up flow
        [TestMethod]
        [TestCategory("Chrome")]
        public void SignUpTest()
        {
            driver.Navigate().GoToUrl(appURL + "/");
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
            wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector(".nav-link")));
            IWebElement SignUpButton = driver.FindElement(By.XPath("//button[.='SIGN ME UP']"));
            SignUpButton.Click();

            //wait until the page is displayed
            IWebElement UserNameTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[1]/input"));
            UserNameTextBox.Clear();
            UserNameTextBox.SendKeys("TESTARELOL2");

            IWebElement EmailTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[2]/input"));
            EmailTextBox.Clear();
            EmailTextBox.SendKeys("automation@gmail.com");

            IWebElement PasswordTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[3]/input"));
            PasswordTextBox.Clear();
            PasswordTextBox.SendKeys("pass");

            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/button")).Click();
            //wait.Until(ExpectedConditions.ElementIsVisible(By.XPath("//*[@id='navbarSupportedContent']/div/ul/li[2]")));
        }

        // Tests the login - happy flow
        [TestMethod]
        [TestCategory("Chrome")]
        public void LoginTest()
        {
            driver.Navigate().GoToUrl(appURL + "/");
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
            wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector(".nav-link")));
            IWebElement LoginButton = driver.FindElement(By.XPath("//*[@id='navbarSupportedContent']/div/ul/ul/li[1]/a"));
            LoginButton.Click();

            IWebElement UserNameTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[1]/input"));
            UserNameTextBox.Clear();
            UserNameTextBox.SendKeys("TESTARELOL2");

            IWebElement PasswordTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[2]/input"));
            PasswordTextBox.Clear();
            PasswordTextBox.SendKeys("pass");

            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/button")).Click();
        }

        [TestMethod]
        [TestCategory("Chrome")]
        public void EditMyInformationTest()
        {
            driver.Navigate().GoToUrl(appURL + "/");
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
            wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector(".nav-link")));
            IWebElement LoginButton = driver.FindElement(By.XPath("//*[@id='navbarSupportedContent']/div/ul/ul/li[1]/a"));
            LoginButton.Click();

            IWebElement UserNameTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[1]/input"));
            UserNameTextBox.Clear();
            UserNameTextBox.SendKeys("TESTARELOL2");

            IWebElement PasswordTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[2]/input"));
            PasswordTextBox.Clear();
            PasswordTextBox.SendKeys("pass");

            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/button")).Click();

            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='navbarSupportedContent']/div/ul/li[4]/a")));
            driver.FindElement(By.XPath("//*[@id='navbarSupportedContent']/div/ul/li[4]/a")).Click();

            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form[1]/div[1]/input")));
            IWebElement FirstNameTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form[1]/div[1]/input"));
            FirstNameTextBox.Clear();
            FirstNameTextBox.SendKeys("Test");

            IWebElement LastNameTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form[1]/div[2]/input"));
            LastNameTextBox.Clear();
            LastNameTextBox.SendKeys("Test");

            IWebElement BirthdayTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form[1]/div[3]/input"));
            BirthdayTextBox.Clear();
            BirthdayTextBox.SendKeys("24-04-1998");

            IWebElement GenderTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form[1]/div[4]/input"));
            GenderTextBox.Clear();
            GenderTextBox.SendKeys("F");

            IWebElement CNPTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form[1]/div[5]/input"));
            CNPTextBox.Clear();
            CNPTextBox.SendKeys("2980424000000");

            IWebElement EmailTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form[1]/div[6]/input"));
            EmailTextBox.Clear();
            EmailTextBox.SendKeys("test@test.test");

            IWebElement NumberTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form[1]/div[7]/input"));
            NumberTextBox.Clear();
            NumberTextBox.SendKeys("0732323232");

            driver.FindElement(By.XPath("//*[@id='groupB']")).Click();
            driver.FindElement(By.XPath("//*[@id='rhPositive']")).Click();

            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/div[13]/button")).Click();
        }

        public TestContext TestContext
        {
            get
            {
                return testContextInstance;
            }
            set
            {
                testContextInstance = value;
            }
        }

        [TestInitialize()]
        public void SetupTest()
        {
            appURL = "http://localhost:3000/home";

            string browser = "Chrome";
            switch (browser)
            {
                case "Chrome":
                    driver = new ChromeDriver();
                    break;
                case "Firefox":
                    driver = new FirefoxDriver();
                    break;
                case "IE":
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    driver = new ChromeDriver();
                    break;
            }

        }

        [TestCleanup()]
        public void MyTestCleanup()
        {
            driver.Quit();
        }
    }
}