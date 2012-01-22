Author      : Juan Antonio Agudo 
Homepage    : http://keyboardsamurais.de
Contact     : tag at gmx dot de
Project url : http://code.google.com/p/maven-timestamp-plugin/

Info        : A plugin that provides customized timestamps for maven builds.


There are a few ways to get a timestamp in your maven build. 
Unfortunately most of them make you jump through giant hoops. 
This maven plugin makes it as simple as 1-2-3 to create a timestamp at your 
disposal.

Also, it enables you to use the syntax of SimpleDateFormat to form custom 
formatted dates.

Note that the plugin is currently not available in the central repository and 
you will have to use the provided repository as shown below, or download and 
install it manually

Usage Example
<build>
 ...
 <plugins>
  <plugin>
   <groupId>com.keyboardsamurais.maven</groupId>
   <artifactId>maven-timestamp-plugin</artifactId>
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
...
<repositories>
  <repository>
        <id>maven-timestamp</id>
          <url>
              http://maven-timestamp-plugin.googlecode.com/svn/trunk/repository
          </url>
  </repository>
</repositories>
...
</build>

Nevertheless, if you are looking for an alternative solution to timestamping and
don't want to integrate yet another plugin - that's fine, have a look at these
links:

http://commons.ucalgary.ca/projects/maven-buildnumber-plugin/index.html

http://www.gadberry.com/aaron/2007/05/28/inject-build-time-timestamp-property-using-maven/

http://pteropus.blogspot.com/2007/03/from-maven-to-mvn-part-5.html