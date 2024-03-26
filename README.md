# TuiMobileAppTests

# Short description
This project is a testing framework of Android mobile app.
It has a set of configuration classes and set of tests verifying
"appiumChallenge.apk" application functionalities. This is a framework concept that can be easily
developed in order to support e.g. iOS mobile app testing. It was created with an idea to 
support testing Android and iOS native apps. 

# Technological stack
Project uses following tech stack:
- maven (project build and configuration tool - pom.xml file contains all project dependencies)
- java (version 21, main coding language)
- cucumber (gherkin is used to create tests scenarios)
- appium (UI automation library for mobile apps)
- selenium (UI automation library)
- spring (used for dependency injection)
- assertJ (assertion library)
- lombok (library used to simplify code)

# How to set up the project
In order to set up the project it is necessary to:
1. Install Appium server, Android Studio, git, maven and java
2. Set following environment variables
```
   export JAVA_HOME="{path to java sdk}"
   export M2_HOME="{path to maven}"
   export ANDROID_HOME="{path to android sdk}"
   export PATH="$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools:$JAVA_HOME:$M2_HOME/bin:$PATH"
```
3. Create Android emulator in Android Studio (Tools -> Device Manager). appiumChallenge may not support latest Android versions. 
I suggest to user Android 9.0
4. Go to https://github.com/wojtasDr/TuiMobileAppTests and clone or download the project.
5. Import project to any Java IDE (I recommend IntelliJ). Maven dependencies should be downloaded automatically.
 
# How to run tests 
In order to run the tests it is necessary to:
1. Make full setup described in section "How to set up the project"
2. Download "appiumChallenge.apk" file from https://1drv.ms/u/s!AieteSmEHij6h3ViiemdoYl5rzfE?e=aGBzSs
3. Go to _/TuiMobileAppTests/src/test/resources/application.properties_ file and set apk.file.url property (paste path to appiumChallenge.apk)
4. Open terminal and run Appium server with
```sh
appium --no-cors
```
5. Start your Android Emulator
6. Go to _/TuiMobileAppTests/src/test/java/tuimobileapptests/springconfig/AndroidAppiumDriverFactory.java_ class 
and set _appium:platformVersion_ (android version of your emulator) and _appium:deviceName_ (your emulator name).
In order to get list of available emulator names use following command in the terminal
```sh
adb devices
```
7. In order to run the tests send following maven command
```sh
mvn clean verify -Dspring.profiles.active=android
```
All tests should be executed and passed. Tests progress can
be observed in Android emulator.

# Tests results
As a result of tests run cucumber report is generated. Each run overwrites the report.
Cucumber report can be found here _/TuiMobileAppTests/target/cucumber-report_.
To show the report open _cucumber.html_ file in the browser.
Please note that _snapshot_ section is added under each failed scenario.

# Tests development - locate mobile app elements with appium inspector.
1. Go to https://inspector.appiumpro.com/
2. Set _Remote Host_ to 127.0.0.1 and _Remote Port_ to 4732
3. Set following capabilities
```
   {
   "appium:platformVersion": "9.0",
   "appium:automationName": "UiAutomator2",
   "appium:deviceName": "emulator-5554",
   "platformName": "Android",
   "appium:app": "{path to appiumChallenge.apk file}"
   }
```   
4. Start Session. 
In order to start session successfully start appium server and Android Emulator first
```sh
appium --no-cors
```




