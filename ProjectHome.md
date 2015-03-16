## About ##
There are a few ways to get a timestamp in your maven build. Unfortunately most of them make you jump through giant hoops. This maven plugin makes it as simple as 1-2-3 to create a timestamp at your disposal.

Also, it enables you to use the syntax of [SimpleDateFormat](http://java.sun.com/javase/6/docs/api/java/text/SimpleDateFormat.html) to form custom formatted dates.

**This plugin is maintained for legacy reasons only. The current versions of maven have a property called maven.build.timestamp that has the exact feature set of this plugin. See http://maven.apache.org/guides/introduction/introduction-to-the-pom.html**

As of Jan 2012 the maven-timestamp-plugin is available in the central repository.

### Usage Example ###
```
<build>
 ...
 <plugins>
  <plugin>
   <groupId>com.keyboardsamurais.maven</groupId>
   <artifactId>maven-timestamp-plugin</artifactId>
   <version>1.0</version>
   <configuration>
    <propertyName>timestamp</propertyName>
    <timestampPattern>dd.MM.yyyy HH:mm</timestampPattern>
   </configuration>
   <executions>
    <execution>
     <goals>
      <goal>create</goal>
     </goals>
    </execution>
   </executions>
  </plugin>
  ...
  <plugin>
   <groupId>org.apache.maven.plugins</groupId>
   <artifactId>maven-jar-plugin</artifactId>
   <version>2.2</version>
   <configuration>
    <archive>
     <manifestEntries>
      <Main-Class>com.myproject.Main</Main-Class>
      <buildtime>${timestamp}</buildtime>
     </manifestEntries>
    </archive>
   </configuration>
  </plugin>
...
 </plugins>
</build>
```


---



Nevertheless, if you are looking for an alternative solution to timestamping and don't want to integrate yet another plugin - that's fine, have a look at these links:

http://commons.ucalgary.ca/projects/maven-buildnumber-plugin/index.html

http://www.gadberry.com/aaron/2007/05/28/inject-build-time-timestamp-property-using-maven/

http://pteropus.blogspot.com/2007/03/from-maven-to-mvn-part-5.html