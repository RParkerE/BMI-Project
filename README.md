# BMI Calculator and Table

This is a Java based program that reads in an `ArrayList` containing last names, first names, heights, and weights of people. 
A separate `class` is designated to each `Person` who will know their name, height and weight, as well as their BMI which 
will be calculated within the inner `class`. This information is then displayed in a `JTable` and able to be sorted by any of 
the five columns, in ascending or descending order. You can also add entries into the `JTable`,  however you
cannot edit entries once they are in the `JTable`. I am also working on a way to delete entries, I have this mostly completed,
but am still currently debugging this feature. To use this application, simply insert the necessary parameters for each
person and run the .java file. You could also  simply run the `.java` file and using the Add button (in beta) to add each entry 
individually. The Add button fills the fields by default with a John Doe, in order to show the proper inputs for each field. 
There is also a button to indicate in which order to sort the entries. There is also a menu in order to select which column to
sort on. The last feature is a remove button. This button will remove all selected entries from the `JTable`.

## CONTENTS

- [HOW TO START THE APPLICATION](#how-to-download-and-start-the-application)
- [MINIMUM SYSTEM REQUIREMENTS](#minimum-system-requirements)
- [API Guide](#api-guide)
- [CONTRIBUTORS](#contributors)
- [LICENSE](#license)



## HOW TO DOWNLOAD AND START THE APPLICATION

### Windows

- Download the .zip file
- Click on "My Computer".
- Click on "Downloads"
- Click on the .zip file you just downloaded
- `Extract All`
- Go into the "BMI-Project" folder
- Run bmicalculator.java

### Macintosh

- Download the .zip file
- Go to "Downloads"
- - Click on the .zip file you just downloaded
- `Extract All`
- Go into the "BMI-Project" folder
- Run bmicalculator.java

### Unix

- `sudo apt-get install git-core`
- `git clone https://github.com/RParkerE/BMI-Project.git`
- `javac bmicalculator.java`
- `java bmicalculator`

## MINIMUM SYSTEM REQUIREMENTS 

### Windows
- Java 7,8


### Macintosh
- Mac 10.3.9 on
- Java 7, 8

### Unix
- Ubuntu, Gentoo, Fedora, Suse, OLPC, archlinux, Debian, FreeBSD, OpenBSD
- Java 7, 8

## API GUIDE

### Java
- http://docs.oracle.com/javase/7/docs/api/
- https://docs.oracle.com/javase/8/docs/api/

## Contributors

Parker Ellwanger

## LICENSE

Apache 2.0
