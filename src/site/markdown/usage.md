# Setting up the dependencies

The project files are hosted on [Bintray][bintray]. Acquiring them just requires setting up the dependency management tool being used.

---

## Maven

To use the library on Maven the Bintray repository should be added to the repositories in the POM:

```
<repositories>
	...
	<repository>
		<snapshots>
			<enabled>false</enabled>
		</snapshots>
		<id>bintray-tabletop-toolkits</id>
		<name>Tabletop Toolkits Bintray repository</name>
		<url>http://dl.bintray.com/bernardo-mg/tabletop-toolkits</url>
	</repository>
	...
</repositories>
```

Then just add the dependency:
	
```
<dependencies>
	...
	<dependency>
		<groupId>com.wandrell.tabletop</groupId>
		<artifactId>stats</artifactId>
		<version>${tabletop.stats.version}</version>
	</dependency>
	...
</dependencies>
```

It is recommended to set the version through a property, as shown in the example.
	
## Gradle

It is possible to acquire the library through Gradle. For this, just add the repository:
	
```
repositories {
    maven {
        url  "http://dl.bintray.com/bernardo-mg/maven" 
    }
}
```

Then just add the dependency:
	
```
dependencies {
	compile(group: 'com.wandrell.tabletop', name: 'stats', version: 'x.y.z')
}
```

Of course, the 'x.y.z' version should be set to the current one for the project.

[bintray]: https://bintray.com/bernardo-mg/tabletop-toolkits/stats/view}Bintray