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

You can then use Maven to compile, test and package the project. The Maven project is located in the `decide` subfolder, so navigate to that folder before running any Maven commands (`cd decide`).

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

Each person has contributed to the project by creating issues, particpating in assigning issues among the group, writing code and creating pull requests, and reviewing other group members' pull requests. Reviews have been divided among the group members in a way that everyone has reviewed a fair share of the PRs and in a way that all group members have a solid knowledge of the codebase.

### Vilhelm Prytz

- [#28: fix: update .gitignore for Maven as well](https://github.com/lindanycander/launch_interceptor_program/pull/28)
- [#40: feat: add method for LIC 1 along with tests](https://github.com/lindanycander/launch_interceptor_program/pull/40)
- [#41: ci: add initial GitHub actions config for maven](https://github.com/lindanycander/launch_interceptor_program/pull/41)
- [#50: style: add vscode settings that force auto format](https://github.com/lindanycander/launch_interceptor_program/pull/50)
- [#56: feat: implement LIC 4 and corresponding tests](https://github.com/lindanycander/launch_interceptor_program/pull/56)
- [#63: feat: implement LIC 8 and tests for it](https://github.com/lindanycander/launch_interceptor_program/pull/63)
- [#65: refactor: restructure project to adhere to naming conventions better](https://github.com/lindanycander/launch_interceptor_program/pull/65)
- [#67: docs: update README, initial structure](https://github.com/lindanycander/launch_interceptor_program/pull/67)
- [#68: refactor: reorder the LIC methods in LaunchInterceptor class](https://github.com/lindanycander/launch_interceptor_program/pull/68)
- [#69: test: remove unnecessary System.out.println statements](https://github.com/lindanycander/launch_interceptor_program/pull/69)
- [#71: fix: add maven-jar-plugin to our pom.xml to make jar exec](https://github.com/lindanycander/launch_interceptor_program/pull/69)
- [#84: docs: add javadoc comments to all methods](https://github.com/lindanycander/launch_interceptor_program/pull/84)
- [#93: docs: update statement of contributions in README](https://github.com/lindanycander/launch_interceptor_program/pull/93)

### Elin Fransholm

- [#48: feat: implement LIC5 along with their tests](https://github.com/lindanycander/launch_interceptor_program/pull/48)
- [#53: feat: implement lic11](https://github.com/lindanycander/launch_interceptor_program/pull/53)
- [#55: bug: Added plugin to pom file](https://github.com/lindanycander/launch_interceptor_program/pull/55)
- [#78: feat: Added function for FUV and tests](https://github.com/lindanycander/launch_interceptor_program/pull/78)
- [#85: feat: Add decide function, corresponding tests and main entry point](https://github.com/lindanycander/launch_interceptor_program/pull/85)
- [#88: docs: removed redundant comment in testFUV_true()](https://github.com/lindanycander/launch_interceptor_program/pull/88)

### Linda Nycander

- [#18: feat: Create files](https://github.com/lindanycander/launch_interceptor_program/pull/18)
- [#25: Feat: Update gitignore](https://github.com/lindanycander/launch_interceptor_program/pull/25)
- [#32: feat: implement lic2 and some tests for it](https://github.com/lindanycander/launch_interceptor_program/pull/32)
- [#42: feat: implement lic6](https://github.com/lindanycander/launch_interceptor_program/pull/42)
- [#49: feat: Implement lic12](https://github.com/lindanycander/launch_interceptor_program/pull/49)
- [#52: feat: Implement lic14](https://github.com/lindanycander/launch_interceptor_program/pull/52)
- [#58: fix: Fix the lic-methods that handles "intervening points" incorrectly](https://github.com/lindanycander/launch_interceptor_program/pull/58)
- [#59: feat: Implement lic13](https://github.com/lindanycander/launch_interceptor_program/pull/59)
- [#66: feat: add and fix comments for tests](https://github.com/lindanycander/launch_interceptor_program/pull/66)
- [#73: fix: fix how lic7 handles intervening points](https://github.com/lindanycander/launch_interceptor_program/pull/73)
- [#74: feat: add test case for lic7](https://github.com/lindanycander/launch_interceptor_program/pull/74)
- [#79: feat: add exceptions for all lic-methods](https://github.com/lindanycander/launch_interceptor_program/pull/79)
- [#82: feat: add a test for lic5](https://github.com/lindanycander/launch_interceptor_program/pull/82)
- [#94: docs: remove duplicate comment and add missing javadoc comments](https://github.com/lindanycander/launch_interceptor_program/pull/94)

### Philip Ågren-Jahnsson

- [#20: fix: Change test file name](https://github.com/lindanycander/launch_interceptor_program/pull/20)
- [#24: feat: Add global variables](https://github.com/lindanycander/launch_interceptor_program/pull/24)
- [#26: feat: Add LIC0 method and added maven project for tests.](https://github.com/lindanycander/launch_interceptor_program/pull/24)
- [#29: feat: Add lic3() method](https://github.com/lindanycander/launch_interceptor_program/pull/29)
- [#30: feat: Add method lic7()](https://github.com/lindanycander/launch_interceptor_program/pull/30)
- [#39: feat: Add lic9()](https://github.com/lindanycander/launch_interceptor_program/pull/39)
- [#60: feat: Add lic10()](https://github.com/lindanycander/launch_interceptor_program/pull/60)
- [#81: fix: Implement CMV & PUM tests](https://github.com/lindanycander/launch_interceptor_program/pull/81)
- [#92: fix: Implement all CMV tests](https://github.com/lindanycander/launch_interceptor_program/pull/92)

## Way of Working

Our way of working, according to the [Essence standard](https://www.omg.org/spec/Essence/1.2/PDF), is in the "in place" state. The tools we use are Java, Maven, Git and GitHub issues. The practices we use are for example the standardized way of writing commit messages ([see this](https://www.conventionalcommits.org/en/v1.0.0/#specification)), and the use of pull requests for code reviews. All team members use these practices and tools and have access to them to perform their work. New changes to the way we work have been discussed and agreed upon by the team, meaning that the whole team is involved in the adaption and inspection of our way-of-working.

The obstacles for us to get to the next state is for the team members to be more comfortable with the practices so that we apply them natually without thinking about it. We also would have to continually tune our use of our practices and tools.

## Motivation for P+

We believe that the group has fulfilled the requirements for P+.

- Nearly all commits are linked to an issue that describes the feature / commit.
- The group has worked well togehter in a proactive and creative way. Each group member is proud of the work that has been done.
