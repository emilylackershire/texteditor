# CSC 207: Text Editor

**Author**: Emily Lackershire

## Resources Used

+ Java 17
+ Visual Studio Code
+ Instructions provided from Professor Osera of Grinnell College, accessed through his website: 
  https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html
+ Used the oracle Java docs to find functions that may be helpful to write the ones in the simple string buffer, accesed online:  
   https://docs.oracle.com/javase/8/docs/api///?java/util/function/Function.html
+ In my gap buffer delete, I replace the deleted things with null, because it wouldn't let me do the empty character '', and this won't let me pass my tests with delete, so I was wondering if there was a way I could replace all of the null values with '', and there is!
   https://stackoverflow.com/questions/26090906/how-do-you-get-rid-of-null-in-a-string-in-java

## Analysis of SimpleStringBuffer

Relevant inputs: 
- character given to add to the string buffer

Critical operations: 
- inserting the character 
- increasing cursor position 
- increasing size

Mathematical model for insert runtime:
Y = n

Big-O:
insert is O(1)

## Changelog

_(TODO: fill me in with a log of your committed changes)_
