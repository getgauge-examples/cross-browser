## Cross-browser

[![Build Status](https://travis-ci.org/getgauge-examples/cross-browser.svg?branch=master)](https://travis-ci.org/getgauge-examples/cross-browser)

This is an example to set up [Selenium Grid](http://www.seleniumhq.org/docs/07_selenium_grid.jsp)(for cross browser) on [Travis CI](https://travis-ci.org/). This is a [Gauge](https://getgauge.io/) project that uses [Selenium](http://www.seleniumhq.org/) as the webdriver.

**Working of the Travis configuration**

On ubuntu OS, we have
* Docker(https://docs.docker.com/engine/installation/#supported-platforms)
* JDK(http://www.oracle.com/technetwork/java/javase/downloads/index.html)

`Before the installation` Selenium hub and nodes are initialized
* docker run -d -p 4446:4444 --name selenium-hub -P selenium/hub
* docker run -d -P -e no_proxy=localhost -e HUB_ENV_no_proxy=localhost --link selenium-hub:hub selenium/node-chrome
* docker run -d -P -e no_proxy=localhost -e HUB_ENV_no_proxy=localhost --link selenium-hub:hub selenium/node-firefox

In the `Install` section
Gauge(https://docs.getgauge.io/) is installed 

**Run on various environments**
Gauge is run using `mvn clean test` for every env. Here it is on 2 different browsers i.e
- BROWSER=chrome
- BROWSER=firefox

**[Known issues]**
* Separate reports will be generated for each browser run.
* The screenshots will be available only if the browsers are run in the headless mode - HTML-report.
