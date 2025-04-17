## Comments Made 

For an M:
- Your program needs to pass all autograder tests. Currently, it is failing a cursor movement test. Test edge cases to figure out why the cursor is going to an index that is out of bounds in certain scenarios (hint: the cursor can be out of bounds if the index is greater than or equal to the length of the buffer, but also if it goes to a negative index).
- you need to give a reasoning for the runtime of insert in addition to just the runtime itself.

For an E:
- Each character is on a newline instead of on the same line. The cursor gets stuck after the first character, not updating to the newlines with additional characters. Lastly, the program does nothing if the argument file already exists, i.e. upon saving a file, we are unable to access it through the texteditor again (you can consult PM for help on fixing the correctness of your texteditor)
- you need to ensure that the given analysis for the runtime of insert is correct

## Changes Made

Changed my Big-O from O(1) to O(n), so that it is applicable and added a justification section. I also did it for gap buffer now.  

I had a lanterna error because of working on a windows machine that was not letting the window pop up. I talked to Professor Osera about this, and he was able to fix it for me in TextEditor on lines 51-59. 

I first implemented a method checkCursor to find out where the out of bounds error was happening, and it was because I was subtracting 1 in move right when I should't have been in move right, for gapStart.

I then noticed that it was still failing one of Professor Osera's tests, as the cursor position was returning 3 when it was 4 after the very last move right. To stop the cursor from keeping moving I also put in my if statement that the cursor should not move if it is equal to size. This just means that if its already at the end it won't move right more. 

I then tried to fix the thing with each letter being on a new line instead of next to each other, and this was very simple it was just switching where rows and columns were in line 36 of the text editor! I had it as screen.setCharacter(row, col, text); and changed it to screen.setCharacter(col, row, text); and that made everything work right. 

I also implemented the cursor so that it looks right visually!

To make the file save, I noticed that I had the gapbuffer updating the gap buffer and thought this may be why it wasn't working. To fix that I turned the file into a character array and then inserted them one by one so now it works!
