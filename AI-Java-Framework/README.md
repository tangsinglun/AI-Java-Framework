# Artificial Intelligence Application (Java Framework) Base on the book "Constructing Intelligent Agents Using Java"
# Written By Joseph P. Bigus and Jennifer Bigus

## Table of Contents

* [OverView](#OverView)
* [Setup Environment](#Setting-Environment)
* [Compiling the Source Code](#Compile-SourceCode)
* [Run the Application](#Run-Application)
* [Project Reference Sources Or Links](#references)

## OverView

This AI project is base on the source code which comes from the book `Constructing Intelligent Agents Using Java`, written
by `Joseph P. Bigus and Jennifer Bigus`. The code has been revamped so that it can support the latest Java Framework, currently
is `JDK 11`. The whole applicaton is split up into several parts, which needs to be call individually. For example: search Application,
Rule base application or even neural network...etc.

## Setting-Environment

 * Operating System
    1. This project is built from Windows 11 Operating System.
 * Integrated Development Environment
    1. we will be using Visual Source Code for our IDE.
    2. To download Visual Source Code, please go to the link `https://code.visualstudio.com/download`.
    3. Install `Windows Subsystem for Linux`, for details how to setup, please visit this link `https://learn.microsoft.com/en-us/windows/wsl/install`.
    4. Install jdk for the linux enviroment. To install jdk, please follow the below steps:
        a. sudo apt update
        b. sudo apt install openjdk-x-jre (where x belongs to version number such as 8, 11, 17, or 18) 
        c. sudo apt install openjdk-x-jdk (where x belongs to version number such as 8, 11, 17, or 18) 

## Compile-SourceCode

 * clone the project
    1. to clone the project, type in `git clone https://github.com/tangsinglun/AI-Java-Framework.git`
    2. type in the command `javac -d ./build/ ./AI-Java-Framework/**/*.java` to build the application.

## Run-Application

 * To run the application, I will be using microsoft command prompt with administrative privilleges. As said the application is split up into sub applications. You need to call each application seperately.
    1. java search.SearchApp
    2. java rule.RuleApp
    3. java learn.LearnApp
    4. java pamanager.PAManagerApp
    5. java infofilter.InfoFilterApp
    6. java marketplace.MarketplaceApp

 * You need data for training. the data files required has an .dfn and .dat file extension.
   All the data files resides in the AI-JAVA-FRAMEWORK folder. For specific application, for example if you are running the `Learn` application, all data files will be at the /AI-JAVA-FRAMEWORK/learn folder.

* Code References
    * [GitHub](https://github.com/)
    * [WSL](https://learn.microsoft.com/en-us/windows/wsl/install)
    * [Amazon Books Store Search "Constructing Intelligent Agents Using Java"](www.amazon.com)




    
