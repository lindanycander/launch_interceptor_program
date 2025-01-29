# Launch Interceptor Program: DECIDE

DECIDE is a program that simulates a hypothetical anti-ballistic missle system. The program is designed to generate a boolean signal which determines wheter an interceptor should be launched to intercept incoming missle. Depending on the input of this program and which combinations of the Launch Interceptor Conditions (LIC's) are relevant to the immediate situation, the progrma will output a boolean signal to determine if an interceptor should be launched.

## Prerequisites

This project requires:

- Maven (see [Installing Apache Maven](https://maven.apache.org/install.html) or use your package manager).
- Java 17 or later (refer to your package manager).
- JUnit 5 (included in the Maven dependencies).
- Git (refer to your package manager).

## Installation

Clone the repository locally using `git clone`.

You can then use Maven to compile, test and package the project. The Maven project is located in the `lic` subfolder, so navigate to that folder before running any Maven commands (`cd lic`).

To compile the project, run:

```bash
mvn compile
```

To run the tests, run:

```bash
mvn test
```

To package the project, run:

```bash
mvn package
```

`mvn package` will compile and run the tests before packaging the project.

Once compiled, there will be a `.jar` file in the `target` folder. You can run the program using:

```bash
java -jar target/decide-1.0-SNAPSHOT.jar
```

## Statement of Contributions

### Vilhelm Prytz

- [#28: fix: update .gitignore for Maven as well](https://github.com/lindanycander/launch_interceptor_program/pull/28)
- [#40: feat: add method for LIC 1 along with tests](https://github.com/lindanycander/launch_interceptor_program/pull/40)
- [#41: ci: add initial GitHub actions config for maven](https://github.com/lindanycander/launch_interceptor_program/pull/41)
- [#50: style: add vscode settings that force auto format](https://github.com/lindanycander/launch_interceptor_program/pull/50)
- [#56: feat: implement LIC 4 and corresponding tests](https://github.com/lindanycander/launch_interceptor_program/pull/56)
- [#63: feat: implement LIC 8 and tests for it](https://github.com/lindanycander/launch_interceptor_program/pull/63)
- [#65: refactor: restructure project to adhere to naming conventions better](https://github.com/lindanycander/launch_interceptor_program/pull/65)

### Elin Fransholm

- [#48: feat: implement LIC5 along with their tests](https://github.com/lindanycander/launch_interceptor_program/pull/48)
- [#53: feat: implement lic11](https://github.com/lindanycander/launch_interceptor_program/pull/53)
- [#55: bug: Added plugin to pom file](https://github.com/lindanycander/launch_interceptor_program/pull/55)

### Linda Nycander

- [#18: feat: Create files](https://github.com/lindanycander/launch_interceptor_program/pull/18)
- [#25: Feat: Update gitignore](https://github.com/lindanycander/launch_interceptor_program/pull/25)
- [#32: feat: implement lic2 and some tests for it](https://github.com/lindanycander/launch_interceptor_program/pull/32)
- [#42: feat: implement lic6](https://github.com/lindanycander/launch_interceptor_program/pull/42)
- [#49: feat: Implement lic12](https://github.com/lindanycander/launch_interceptor_program/pull/49)
- [#52: feat: Implement lic14](https://github.com/lindanycander/launch_interceptor_program/pull/52)
- [#58: fix: Fix the lic-methods that handles "intervening points" incorrectly](https://github.com/lindanycander/launch_interceptor_program/pull/58)
- [#59: feat: Implement lic13](https://github.com/lindanycander/launch_interceptor_program/pull/59)

### Philip Ågren-Jahnsson

- [#20: fix: Change test file name](https://github.com/lindanycander/launch_interceptor_program/pull/20)
- [#24: feat: Add global variables](https://github.com/lindanycander/launch_interceptor_program/pull/24)
- [#26: feat: Add LIC0 method and added maven project for tests.](https://github.com/lindanycander/launch_interceptor_program/pull/24)
- [#29: feat: Add lic3() method](https://github.com/lindanycander/launch_interceptor_program/pull/29)
- [#30: feat: Add method lic7()](https://github.com/lindanycander/launch_interceptor_program/pull/30)
- [#39: feat: Add lic9()](https://github.com/lindanycander/launch_interceptor_program/pull/39)
- [#60: feat: Add lic10()](https://github.com/lindanycander/launch_interceptor_program/pull/60)

## Way of Working

Our way of working, according to the [Essence standard](https://www.omg.org/spec/Essence/1.2/PDF), is in the "in place" state. The tools we use are Java, Maven, Git and GitHub issues. The practices we use are for example the standardized way of writing commit messages ([see this](https://www.conventionalcommits.org/en/v1.0.0/#specification)), and the use of pull requests for code reviews. All team members use these practices and tools and have access to them to perform their work. New changes to the way we work have been discussed and agreed upon by the team, meaning that the whole team is involved in the adaption and inspection of our way-of-working.

The obstacles for us to get to the next state is for the team members to be more comfortable with the practices so that we apply them natually without thinking about it. We also would have to continually tune our use of our practices and tools.

# Motivation for P+
