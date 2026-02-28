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
is `JDK 17`. The whole applicaton is split up into several parts, which needs to be call individually. For example: search Application,
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
    1. to clone the project, type in `git clone https://github.com/tangsinglun/AI.git`
    2. Move to the root folder `\AI`. type in the command `javac -d ./build/ ./AI-Java-Framework/**/*.java` to build the application.

## Run-Application

 * To run the application, move to the /build root folder, base on the application you want, type
   the below command to run the application.
    1. java search.SearchApp
    2. java rule.RuleApp
    3. java learn.LearnApp
    4. java pamanager.PAManagerApp
    5. java infofilter.InfoFilterApp
    6. java marketplace.MarketplaceApp

* Code References
    * [GitHub](https://github.com/)
    * [WSL](https://learn.microsoft.com/en-us/windows/wsl/install)
    * [Amazon Books Store Search "Constructing Intelligent Agents Using Java"](https://www.amazon.com/-/zh_TW/Constructing-Intelligent-Agents-Using-Java/dp/047139601X/ref=sr_1_1?crid=2DSU3KBOQGQR9&dib=eyJ2IjoiMSJ9.uTU-9e122MntKggTfsrrQQ.VUY0w36GGaNnBXF1wJpP514S6rgE1pAPufHjqzlIm28&dib_tag=se&keywords=Constructing+Intelligent+Agents+Using+Java&qid=1763245199&sprefix=constructing+intelligent+agents+using+java%2Caps%2C258&sr=8-1)




    
