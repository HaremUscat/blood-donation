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

        // test the edit information section
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

        [TestMethod]
        [TestCategory("Chrome")]
        public void NextDonationInformationTest()
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

            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='navbarSupportedContent']/div/ul/li[2]/a")));
            driver.FindElement(By.XPath("//*[@id='navbarSupportedContent']/div/ul/li[2]/a")).Click();

            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='headingOne']/h5/button")));

            driver.FindElement(By.XPath("//*[@id='headingOne']/h5/button")).Click();
            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='collapseOne']/div/form/div[1]/input")));

            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='collapseOne']/div/form/div[1]/input")));

            String str = driver.FindElement(By.XPath("//*[@id='collapseOne']/div/form/div[1]/input")).GetAttribute("placeholder");
            Assert.AreEqual<String>(str, "Test");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='collapseOne']/div/form/div[2]/input")).GetAttribute("placeholder"), "Test");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='collapseOne']/div/form/div[3]/input")).GetAttribute("placeholder"), "24-04-1998");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='collapseOne']/div/form/div[4]/input")).GetAttribute("placeholder"), "F");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='collapseOne']/div/form/div[5]/input")).GetAttribute("placeholder"), "2980424000000");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='collapseOne']/div/form/div[6]/input")).GetAttribute("placeholder"), "B");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='collapseOne']/div/form/div[7]/input")).GetAttribute("placeholder"), "+");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='collapseOne']/div/form/div[8]/input")).GetAttribute("placeholder"), "test@test.test");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='collapseOne']/div/form/div[9]/input")).GetAttribute("placeholder"), "0732323232");
        }

        [TestMethod]
        [TestCategory("Firefox")]
        public void FAQTest()
        {
            driver.Navigate().GoToUrl(appURL + "/");
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
            wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector(".nav-link")));
            IWebElement FAQButton = driver.FindElement(By.XPath("//*[@id='navbarSupportedContent']/div/ul/li[2]/a"));
            FAQButton.Click();
            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='root']/div/div/div[1]/div/div/div/h1")));

            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div[2]/div/div/div[2]/h3")).Text, "Q: How does age affect my ability to donate?");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div[2]/div/div/div[6]/h3")).Text, "Q: I am breastfeeding, can I donate?");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div[2]/div/div/div[8]/h3")).Text, "Q: I have just gotten a tattoo, can I donate?");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div[2]/div/div/div[10]/h3")).Text, "Q: I am a professional athlete, can I donate?");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div[2]/div/div/div[8]/p")).Text, "A: It depends if the area in which you had the tattoo done enforces strict regulations for tattoo facilities. If that is the case, then yes, you can donate blood, otherwise it would be advisable to wait up to 12 months prior to donating blood.");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div[2]/div/div/div[2]/p")).Text, "A: There is a minimum (18 years old) and maximum (60 years old) age; if you fall in-between these ages, you can donate.");
        }

        [TestMethod]
        [TestCategory("Chrome")]
        public void TestResultsTest()
        {
            driver.Navigate().GoToUrl(appURL + "/");
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
            wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector(".nav-link")));
            IWebElement LoginButton = driver.FindElement(By.XPath("//*[@id='navbarSupportedContent']/div/ul/ul/li[1]/a"));
            LoginButton.Click();

            IWebElement UserNameTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[1]/input"));
            UserNameTextBox.Clear();
            UserNameTextBox.SendKeys("Ema");

            IWebElement PasswordTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[2]/input"));
            PasswordTextBox.Clear();
            PasswordTextBox.SendKeys("pass");
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/button")).Click();

            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='navbarSupportedContent']/div/ul/li[3]")));
            driver.FindElement(By.XPath("//*[@id='navbarSupportedContent']/div/ul/li[3]")).Click();

            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='root']/div/div/div/div/div/h1")));
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div/h1")).Text, "Currently you have no blood test results.");
        }

        [TestMethod]
        [TestCategory("Chrome")]
        public void MyRequestsTest()
        {
            driver.Navigate().GoToUrl(appURL + "/");
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
            wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector(".nav-link")));
            IWebElement LoginButton = driver.FindElement(By.XPath("//*[@id='navbarSupportedContent']/div/ul/ul/li[1]/a"));
            LoginButton.Click();

            IWebElement UserNameTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[1]/input"));
            UserNameTextBox.Clear();
            UserNameTextBox.SendKeys("mariaDoctor");

            IWebElement PasswordTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[2]/input"));
            PasswordTextBox.Clear();
            PasswordTextBox.SendKeys("pass");
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/button")).Click();

            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='root']/div/div/div/div/div[1]/div/table/thead/tr/th[1]/h5")));
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[1]/div/table/thead/tr/th[1]/h5")).Text, "Request Details");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[1]/div/table/thead/tr/th[2]/h5")).Text, "Urgency Level");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[1]/div/table/thead/tr/th[3]/h5")).Text, "Status");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/ul/li[2]/a")).Text, "1");
        }

        [TestMethod]
        [TestCategory("Chrome")]
        public void NewRequestTest()
        {
            driver.Navigate().GoToUrl(appURL + "/");
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
            wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector(".nav-link")));
            IWebElement LoginButton = driver.FindElement(By.XPath("//*[@id='navbarSupportedContent']/div/ul/ul/li[1]/a"));
            LoginButton.Click();

            IWebElement UserNameTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[1]/input"));
            UserNameTextBox.Clear();
            UserNameTextBox.SendKeys("mariaDoctor");

            IWebElement PasswordTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[2]/input"));
            PasswordTextBox.Clear();
            PasswordTextBox.SendKeys("pass");
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/button")).Click();

            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='navbarSupportedContent']/div/ul/li[1]")));
            driver.FindElement(By.XPath("//*[@id='navbarSupportedContent']/div/ul/li[1]")).Click();
            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='root']/div/div/div/div/div[1]/h1")));
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[1]/h1")).Text, "New Request Form");

            driver.FindElement(By.XPath("//*[@id='groupB']")).Click();
            driver.FindElement(By.XPath("//*[@id='rhPositive']")).Click();
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form/div[1]/input")).SendKeys("30");
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form/div[2]/input")).SendKeys("30");
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form/div[3]/input")).SendKeys("30");
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form/div[4]/input")).SendKeys("1");
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form/div[5]/input")).SendKeys("strada Teodor Mihali");
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/form/div[6]/input")).SendKeys("Ema Turcu");
            driver.FindElement(By.XPath("//*[@id='urgencyHigh']")).Click();
            driver.FindElement(By.XPath("//*[@id='activeDonorYes']")).Click();
            driver.FindElement(By.XPath("//*[@id='checkedCorrectInfo']")).Click();
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/div[12]/label")).Text, "I have checked that the submitted information is correct.");
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[2]/div[12]/button")).Click();
        }

        [TestMethod]
        [TestCategory("Chrome")]
        public void PHRequest()
        {
            driver.Navigate().GoToUrl(appURL + "/");
            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
            wait.Until(ExpectedConditions.ElementToBeClickable(By.CssSelector(".nav-link")));
            IWebElement LoginButton = driver.FindElement(By.XPath("//*[@id='navbarSupportedContent']/div/ul/ul/li[1]/a"));
            LoginButton.Click();

            IWebElement UserNameTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[1]/input"));
            UserNameTextBox.Clear();
            UserNameTextBox.SendKeys("corinaPH");

            IWebElement PasswordTextBox = driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/form/div[2]/input"));
            PasswordTextBox.Clear();
            PasswordTextBox.SendKeys("pass");
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/button")).Click();

            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='root']/div/div/div/div/div[1]/div/table/tbody/tr/td[3]/button")));
            driver.FindElement(By.XPath("//*[@id='root']/div/div/div/div/div[1]/div/table/tbody/tr/td[3]/button")).Click();
            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//*[@id='root']/div/div/div[2]/div/div[3]/p/button")));
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div[2]/div/div[1]/h5")).Text, "Step 1. Diminish the Stock");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div[2]/div/div[2]/h5")).Text, "Step 2. Send the Blood");
            Assert.AreEqual<String>(driver.FindElement(By.XPath("//*[@id='root']/div/div/div[2]/div/div[3]/h5")).Text, "Step 3. Let Me Know When Done");
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