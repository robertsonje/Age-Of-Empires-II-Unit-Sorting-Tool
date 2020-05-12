# Age-Of-Empires-II-Unit-Sorting-Tool
Online sorting tool for units from the game Age of Empires II, using Java Springboot and AJAX

## Table of Contents

- Description
- How to Build
- How to Use
- More Information

## Description

This is a program to sort out data within a local server to display to a web page using Java, Spring boot, JavaScript, and AJAX. It can be run locally.

## How to Build

To build this program, you need Java JDK 14, Java Runtime Environment, Maven, and Spring Boot. the JAVA_HOME environment variable also needs to be set to the JDK folder (usually "C:\Program Files\Java\jdk-14.0.1", it can be set using SETX JAVA_HOME -m path where path is the JDK path ). Once everything is set up, head into the root folder of the project and run "mvnw spring-boot:run" in the command line.

## How to Use

To run locally, build the program in the folder ("mvnw spring-boot:run") and connect locally (enter "localhost:8080" in your browser). Use the search bar to search for unit names (for example, use "man" to search for units with "man" in the name, "archer" to search for archers, "elite" to search for elite castle units, etc.)

## More Information

[Age Of Empires II](https://en.wikipedia.org/wiki/Age_of_Empires_II) - Wikipedia article on the game itself

[Age Of Empires II API](https://age-of-empires-2-api.herokuapp.com/docs/) - The API used for this app
