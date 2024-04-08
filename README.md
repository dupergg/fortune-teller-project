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

This is a sample [launch file](https://github.com/openjfx/samples/blob/master/IDE/VSCode/Non-Modular/Java/hellofx/.vscode/launch.json) that was used.

Under "Referenced Libraries", navigate to where JavaFX was installed and find the "lib" folder. Highlight and select all of the `.jar` files.

If you are using another IDE, I suggest reading over the tutorial above to set up the project.

## External Libraries
Python 3.8 is required for this project currently. This is for the chat bot that gives a fortune to the user.
The Python folder needs to be added to the PATH environment variable in Windows.

For this project, we are using a translation library name "Jep" to translate our python chat bot so the Java program can use it.
To install this run `python -m pip install jep` in Windows Powershell.

Add the `.jar` file for jep, which chan be found at `C:\Users\USER\AppData\Local\Programs\Python\Python38\Lib\site-packages\jep` to "Referenced Libraries" in Visual Studio Code.

For this version of the project, we are using a library called ChatterBot. The implementation is very basic and will be changed to another
chat bot in the future.

To install ChatterBot, use the command `python -m pip install chatterbot`

Go to `C:\Users\USER\AppData\Local\Programs\Python\Python38\Lib\site-packages\chatterbot` and open the `tagging.py` file.

Change 
```
self.nlp = spacy.load(self.language.ISO_639_1.lower())
```
to
```
if self.language.ISO_639_1.lower() == 'en':
    self.nlp = spacy.load('en_core_web_lg')
else:
    self.nlp = spacy.load(self.language.ISO_639_1.lower())
```
This is a workaround for an issue with a library that ChatterBot uses.

Next, run the command `python -m pip install spacy` and then run the command `python -m spacy download en_core_web_lg`

Lastly, put the directory paths of SpaCy and Jep into the PATH environment variable in Windows and move them up closer to the top of the list,
above the Python path.
These can be found at `C:\Users\USER\AppData\Local\Programs\Python\Python38\Lib\site-packages\jep` and `C:\Users\USER\AppData\Local\Programs\Python\Python38\Lib\site-packages\spacy`

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
