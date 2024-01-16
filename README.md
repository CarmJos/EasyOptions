```text
 ___               ___       _   _             
| __|__ _ ____  _ / _ \ _ __| |_(_)___ _ _  ___
| _|/ _` (_-< || | (_) | '_ \  _| / _ \ ' \(_-<
|___\__,_/__/\_, |\___/| .__/\__|_\___/_||_/__/
             |__/      |_|                     
```

README LANGUAGES [ [**English**](README.md) | [中文](README_CN.md)  ]

# EasyOptions

[![version](https://img.shields.io/github/v/release/CarmJos/EasyOptions)](https://github.com/CarmJos/EasyOptions/releases)
[![License](https://img.shields.io/github/license/CarmJos/EasyOptions)](https://www.gnu.org/licenses/lgpl-3.0.html)
[![workflow](https://github.com/CarmJos/EasyOptions/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/CarmJos/EasyOptions/actions/workflows/maven.yml)
[![CodeFactor](https://www.codefactor.io/repository/github/carmjos/EasyOptions/badge)](https://www.codefactor.io/repository/github/carmjos/EasyOptions)
![CodeSize](https://img.shields.io/github/languages/code-size/CarmJos/EasyOptions)
![](https://visitor-badge.glitch.me/badge?page_id=EasyOptions.readme)


**Easy _(to define)_ Options!** 

A lightweight, easy-to-use option definition library in Java, useful for runtime library developers.

## Development

For the latest JavaDoc release, [CLICK HERE](https://CarmJos.github.io/EasyConfiguration).

### Code Samples

```java
public interface DemoOptions {

    /**
     * Option descriptions
     */
    OptionType<String> SEPARATOR = OptionType.of(":-:");

}
```

```java
public class Sample {
  public static void main(String[] args) {
      OptionHolder holder = new OptionHolder(); // Create holder

      holder.set(DemoOptions.SEPARATOR, ":-)"); // Set value
      
      String separator = holder.get(DemoOptions.SEPARATOR); // Get value

      // Set value to default
      String previous = holder.set(DemoOptions.SEPARATOR, null);
  }
}
```

### Dependencies

#### Maven Dependency

<details>
<summary>Remote Repository Configuration</summary>

```xml

<project>
    <repositories>

        <repository>
            <!-- Using Maven Central Repository for secure and stable updates, though synchronization might be needed. -->
            <id>maven</id>
            <name>Maven Central</name>
            <url>https://repo1.maven.org/maven2</url>
        </repository>

        <repository>
            <!-- Using GitHub dependencies for real-time updates, configure required (recommended). -->
            <id>github</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/CarmJos/EasyOptions</url>
        </repository>

    </repositories>
</project>
```

</details>

<details>
<summary>Generic Native Dependency</summary>

```xml

<project>
    <dependencies>
        <dependency>
            <groupId>cc.carm.lib</groupId>
            <artifactId>easyoptions</artifactId>
            <version>[LATEST RELEASE]</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>
</project>
```

</details>

#### Gradle Dependency

<details>
<summary>Remote Repository Configuration</summary>

```groovy
repositories {

    // Using Maven Central Repository for secure and stable updates, though synchronization might be needed.
    mavenCentral()

    // Using GitHub dependencies for real-time updates, configure required (recommended).
    maven { url 'https://maven.pkg.github.com/CarmJos/EasyOptions' }

}
```

</details>

<details>
<summary>Generic Native Dependency</summary>

```groovy

dependencies {
    api "cc.carm.lib:easyoptions:[LATEST RELEASE]"
}
```

</details>

## Support and Donation

If you appreciate this plugin, consider supporting me with a donation!

Thank you for supporting open-source projects!

Many thanks to Jetbrains for kindly providing a license for us to work on this and other open-source projects.

[![](https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.svg)](https://www.jetbrains.com/?from=https://github.com/ArtformGames/EasyOptions)

## Open Source License

This project's source code is licensed under [The MIT License](https://opensource.org/licenses/MIT).
