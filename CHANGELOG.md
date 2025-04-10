## Comments Made 

For an M:
- Your program needs to pass all autograder tests. Currently, it is failing a cursor movement test. Test edge cases to figure out why the cursor is going to an index that is out of bounds in certain scenarios (hint: the cursor can be out of bounds if the index is greater than or equal to the length of the buffer, but also if it goes to a negative index).
- you need to give a reasoning for the runtime of insert in addition to just the runtime itself.

For an E:
- Each character is on a newline instead of on the same line. The cursor gets stuck after the first character, not updating to the newlines with additional characters. Lastly, the program does nothing if the argument file already exists, i.e. upon saving a file, we are unable to access it through the texteditor again (you can consult PM for help on fixing the correctness of your texteditor)
- you need to ensure that the given analysis for the runtime of insert is correct

## Changes Made

