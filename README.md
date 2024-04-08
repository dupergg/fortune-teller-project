## Getting Started

To start working on the project, you will need to download JavaFX from this [website](https://gluonhq.com/products/javafx/) Make sure you are using JavaFX version 21.0.2.
Otherwise, the dependencies that are necessary for the project are in the `lib` directory.

Also, make sure you are using at least Java 17.

I (Bryce) used this [tutorial](https://openjfx.io/openjfx-docs/#install-javafx) to set up my project.
You will not need to create a new one from scratch, just clone the repository from GitHub. I suggest
using the GitHub Desktop app for ease of use.

## Launching the Application

If you are using Visual Studio Code, you will need to change your JavaFX path in the `launch.json` under the
`.vscode` folder.

This is found under "vmaArgs".

If you are using another IDE, I suggest reading over the tutorial above to set up the project.

## External Libraries

For this project, we are using a translation library name "Jep" to translate our python chat bot so the Java program can use it.


## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
