## Project Video
Since we cannot build our project, we want to show that the program does in fact work.
This YouTube [video](https://youtu.be/UejwqvaXFiw) shows our project working.

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

This is found under "vmArgs".

This is a sample [launch file](https://github.com/openjfx/samples/blob/master/IDE/VSCode/Non-Modular/Java/hellofx/.vscode/launch.json) that was used.

To have the music work for the project, add "javafx.media" to the vmArgs.

Under "Referenced Libraries", navigate to where JavaFX was installed and find the "lib" folder. Highlight and select all of the `.jar` files.

If you are using another IDE, I suggest reading over the tutorial above to set up the project.

## External Libraries
Python 3.8 is required for this project currently. This is for the chat bot that gives a fortune to the user.
The Python folder needs to be added to the PATH environment variable in Windows.

Our Python script to generate fortunes for the user when they give it a prompt requires a few libraries be downloaded.
Three libraries, `transformers`, `torch`, and `flask` must be downloaded for the generator to work.
The three following commands will download the libraries.

```
python -m pip install transformers

python -m pip install torch

python -m pip install flask
```

## How to Use/Launch the Project

If everything is all set up following the above instructions, you should be able to press the "Launch App"
button in VSCode. For the Fortune Teller part of the project to actually generate responses, you must run
the "chatty.py" python script while the application is running. Do not stop it until you are done with the
application.

The programs may freeze while running the script, just wait for it to continue.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
