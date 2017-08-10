## Cross-browser

[![Build Status](https://travis-ci.org/getgauge-examples/cross-browser.svg?branch=master)](https://travis-ci.org/getgauge-examples/cross-browser)

This is an example to set up Selenium Grid(for cross browser) on CI for a Gauge project that uses Selenium as the driver to interact with a web browser.

The CI configuration used is the travis configuration. The set up uses docker for starting the selenium hub and registering nodes to it.

**[Known issues]**
* Separate reports will be generated for each browser run.
* The screenshots will be available only if the browsers are run in the headless mode - HTML-report.
