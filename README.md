# Questionnaire
Solutions for Quistionnaire interview_question_set2.pdf


## Getting Started

These instructions will help you to get project up and running on your local machine for development and testing purposes. 

### Prerequisites

What things you need to install the software and how to install them

```
Java8
```


### Setup Environment

The project contains one folder, namely 'src' . The 'src' folder contains the source code for 2 java files i.e. 'DAGraph.java' and 'Sentence.java', which are solutions to problem 1 and 2 respectively and the 'resources' folder.

The 'resources' folder contains two files, 'input1.txt' and 'input2.txt' which are sample input for problem 1 and problem 2 respectively. The programs by default have


## Running the programs

Follow these points to run the programs

### For Problem1(DAGraph.java)

Compile the java file

```
>javac DAGraph.java
```
Run the program without a file path (in this case it will pickup '/resources/input1.txt')

```
>java DAGraph
```

Run the program with custom file path(put the absolute path of the file in place of your_file_path)
```
>java DAGraph your_file_path
```
Follow the format of input in the 'input1.txt' in 'resources' folder to create your testcases.

### For Problem2(Sentence.java)

Compile the java file

```
>javac Sentence.java
```
Run the program without a file path (in this case it will pickup '/resources/input2.txt')

```
>java Sentence
```

Run the program with custom file path(put the absolute path of the file in place of your_file_path)
```
>java Sentence your_file_path
```
You can create an English Paragraph as per your choice. The code can handle basic abbreviations with embedded points as in the scope of ```java.text.BreakIterator```.

## Authors

* **Saurav Mishra** - *Initial work* - [joker-git](https://github.com/joker-git)



