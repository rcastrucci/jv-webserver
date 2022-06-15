# Java Web Server
**Building your own web server with Java**

First go to your temrminal and check if you have java 17 installed by typing:

    java --version
    
You should get something like this:

    java 17.0.2 2022-01-18 LTS
    Java(TM) SE Runtime Environment (build 17.0.2+8-LTS-86)
    Java HotSpot(TM) 64-Bit Server VM (build 17.0.2+8-LTS-86, mixed mode, sharing)
    
Otherwise you can [download here](https://www.oracle.com/java/technologies/downloads/)

## Test
To test the web server, clone this repository, find the main class callled Main.java and type in your temrinal
    
    java Main.java

That's it!
Your java web server is running and you can go to your browser and type 

    http://localhost:8080

And you'll see a java logo image! ;)

![java image](https://github.com/rcastrucci/jv-webserver/blob/main/src/com/java/webserver/java.jpg "Java image")

It is also implemented another response with a get parameter responding with a Hello World!
Type in your browser:

    http://localhost:8080/hello
    
And you will see a text Hello World!
