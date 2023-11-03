<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

<!-- ABOUT THE PROJECT -->
## About The Project

Hi! This is my capstone project for course "QA engineer to Mobile QA engineer".
For my work I choose android app "FreeUnitConverter".

### Built With Maven Dependencies:

* [Appium][appiumMaven-url]
* [Junit][junitMaven-url]
* [Selenium][seleniumMaven-url]
* [Android][androidMaven-url]

<!-- GETTING STARTED -->
## Getting Started

Before download project you need to previously install Android Studio, IDEA, Java, Appium and Node.

### Prerequisites

Before download project you need to previously install Android Studio (and emulator on it), IDEA, Java, Maven, Appium and Node.

### I recommended to use:

* Pixel 2 XL with Android Lollipop (5.1 x86)
* Node v18.17.1
* Java Corretto 18.0.2 (you can download it directly in IDEA if it is needed)
* Appium 2.0.1

### Java

You can download it by [this link][java-url] or previously install IDEA and download Java 17 on it.

### Maven

You can download it by [this link][maven-url].

### Node

You can download it by [this link][node-url].


### Appium

* npm
  ```sh
  npm i --location=global appium
  ```

* After appium you need to install UiAutomator2 and Gecko:
    ```sh
    appium driver install uiautomator2
    appium driver install gecko
    ```

### Android Studio and emulator

You can download it by [this link][androidStudio-url]. After installing studio I recommended to
choose Pixel 2 XL device for emulation with Lollipop 5.1 x86. You can do it in Studio without going to any site.
Also you need to set up ANDROID_HOME variable, [official guide for it][androidHomeGuide-url].

### IDEA

You can also download it by [this link][idea-url].

## Installation

Just clone the repo and open it in IDEA.
   ```sh
   git clone https://github.com/gridu/Yaroslav-Urbanovych-QA-engineer-to-Mobile-QA-engineer
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Run tests

For run tests: just start android emulator in android studio and run free.unit.converter folder in test directory or run command:
   ```sh
   maven clean test
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Yaroslav Urbanovych - urbanovych.qa@gmail.com
LinkedIn: https://www.linkedin.com/in/yaroslav-urbanovych/

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* Andrei Dicusar for review ;)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[appiumMaven-url]: https://mvnrepository.com/artifact/io.appium/java-client
[junitMaven-url]: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
[seleniumMaven-url]: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
[androidMaven-url]: https://mvnrepository.com/artifact/com.google.android/android
[java-url]: https://www.oracle.com/java/technologies/downloads/
[maven-url]: https://maven.apache.org/download.cgi
[node-url]: https://nodejs.org/en/download
[androidStudio-url]: https://developer.android.com/studio?gclid=CjwKCAjwvfmoBhAwEiwAG2tqzD3lVgTtokChvXfWSqvGHBi4X7gHdeN6uR2vD19CFIZrNZkpNy9EcxoCZuUQAvD_BwE&gclsrc=aw.ds
[androidHomeGuide-url]: https://developer.android.com/tools/variables
[idea-url]: https://www.jetbrains.com/help/idea/installation-guide.html
