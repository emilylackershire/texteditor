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
+ For the text editor I needed the screen width, so I looked up what it was. 
   https://stackoverflow.com/questions/4651012/why-is-the-default-terminal-width-80-characters
+ When trying to figure out how the screen and TextCharacter worked I looked up the stuff about the width and found this page with the screen functions and the google arhcive page about lanterna.
   https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html#setCursorPosition(com.googlecode.lanterna.terminal.TerminalPosition)
   https://code.google.com/archive/p/lanterna/wikis/UsingScreen.wiki
+ I did the changelog manually for the last one and I did not want to do this again so I read this article about how to do it. 
   https://www.freecodecamp.org/news/a-beginners-guide-to-git-what-is-a-changelog-and-how-to-generate-it/
+ Professor Osera helped me with getting lanterna to run on windows.
+ had general discussions about the assignment with Finn Rowles and Owen Block

## Analysis of SimpleStringBuffer

Relevant inputs: 
- Char ch, a character given to add to the string buffer.

Critical operations: 
- String + ch, inserting the character into the string buffer

Mathematical model for insert runtime:
Y = n

Big-O:
insert is O(n)

Justification: 
To simulate a text editor with strings, we are essentially just spliting the string up into a substrings on either side of where the cursor should be. It will have a consistent time that it will run for, which is n. It cannot get faster most of the time in the way gap buffer can. 

## Analysis of Gap Buffer

relevant inputs:
 - char ch that is being added to the gap buffer

critical operations: 
 - when a new input is added to the gap buffer and the buffer is expanded: newGapBuffer[i] = gapBuffer[i]; This will take the most possible time in the gap bufffer, when we don't have to expand it, then it will be quicker. 

Mathematical model: 
Y = x

Big-O:
O(n)

Justification: 
This is coming from the fact that sometimes we will have to expand the buffer and essentially re-insert things. This will require us to go through the whole buffer, hence O(n). Most of the time we will not have to expand the buffer, and therefore it will be faster, but I am considering the worst possible case here to be safe. 


## Changelog

commit e2ca2754256b2a8b97c0532c75f975e1ecf53c9a (HEAD -> main, origin/main, origin/HEAD)
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Apr 16 19:50:09 2025 -0500

    fixed the cursor and the file so it saves! Also updated changelog and wrote the analysis of gab buffer in the readme   

commit 50dbf101447ff1041593ab849edfe2e43f5d8b17
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Apr 16 16:03:59 2025 -0500

    fixed tests

commit 40f6a69b23ac4e04dbdda212dfeae24b564c8ee6
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Apr 16 16:00:14 2025 -0500

    fixed error in insert

commit d3cb0ef3af6d13839404f556750996c4660dd252
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Apr 16 15:29:19 2025 -0500

    one single indentation

commit b3813972a4b0cf3af4475d8bac570cdd101529a7
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Apr 16 15:26:02 2025 -0500

    style

commit a335188e687a8422360448e10b46dea741437f0f
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Apr 16 15:19:02 2025 -0500

    updated a bunch of things, including the gap buffer, added more tests for it, updating the changelog and updating the readme

commit ad032da336b6b459dcf036c39df127963691af21
Author: Emily <lackersh@grinnell.edu>
Date:   Mon Apr 14 17:20:18 2025 -0500

    fixed my tests so they were acctually right and updated readme

commit 7d33529774fbf6543997132ad1147dccd3d9d91a
Author: Emily <lackersh@grinnell.edu>
Date:   Mon Apr 14 17:04:35 2025 -0500

    updated changelog

commit 71fb54d19d78dfe05e56ce3e8315da20e177aa6d
Author: Emily <lackersh@grinnell.edu>
Date:   Mon Apr 14 17:02:53 2025 -0500

    tried to fix delete

commit 619a3c400e96aec257cf7a9f2255bef8fe6c44b7
Author: Emily <lackersh@grinnell.edu>
Date:   Mon Apr 14 14:54:25 2025 -0500

    got the words  to print right

commit 8a8cc0e2849667eabe36420b28fc680d440f0ae5
Author: Emily <lackersh@grinnell.edu>
Date:   Fri Apr 11 16:32:50 2025 -0500

    implemented check cursor to find whereit was going out of bounds

commit 36e0cca256277c9d82a42dbebd2227c82f266a9e
Author: Emily <lackersh@grinnell.edu>
Date:   Fri Apr 11 16:18:44 2025 -0500

    got help from professor Osera to make the lanterna terminal work!

commit 37d5ba7629611f7b0358aba5d4a2c5075f21cfc7
Author: Emily <lackersh@grinnell.edu>
Date:   Thu Apr 10 15:39:45 2025 -0500

    created changelog and started to work on things

commit 639bf83b98c97b6a908e051ad0fe0352badd1d37 (HEAD -> main)
Author: Emily <lackersh@grinnell.edu>
Date:   Sun Feb 23 17:21:50 2025 -0600

    updated readme and added changelog

commit 7a3820bfde827e4eae56ad4d945e0f0937fcffbe (HEAD -> main, origin/main, origin/HEAD)
Author: Emily <lackersh@grinnell.edu>
Date:   Sun Feb 23 17:00:26 2025 -0600

    finished implementing filr IO stuff in TextEditor, added a practice file named file.txt

commit 6b38b5292149b203f8ca523e9688a5d4f1950d3c
Author: Emily <lackersh@grinnell.edu>
Date:   Sun Feb 23 11:48:43 2025 -0600

    more style

commit cf6daaa60368d694c47c58f6447fa93695c94f09
Author: Emily <lackersh@grinnell.edu>
Date:   Sun Feb 23 11:46:41 2025 -0600

    updates style

commit d0f0ee84985bf0aa56281c59a347555e1713e7ff
Author: Emily <lackersh@grinnell.edu>
Date:   Sun Feb 23 11:38:00 2025 -0600

    Implemented most of the TextEditor

commit df668e1150039aa7cc146417149643cf9d65b79c
Author: Emily <lackersh@grinnell.edu>
Date:   Thu Feb 20 23:01:29 2025 -0600

    updates style

commit 715e26ec45b3f3a9f0bc7065ab4cfc404ce4d7ca
Author: Emily <lackersh@grinnell.edu>
Date:   Thu Feb 20 22:55:09 2025 -0600

    fixed move left and move right on the gapbuffer so the cursor works right

commit 8159bf385d73818f8fb6cb0147e862edef66fb4f
Author: Emily <lackersh@grinnell.edu>
Date:   Thu Feb 20 21:45:08 2025 -0600

    fixed errors for gradescope

commit d0faad95a957c622f67f4d68251edc9c62faf051
Author: Emily <lackersh@grinnell.edu>
Date:   Thu Feb 20 19:59:14 2025 -0600

    Added some more tests

commit 934bcae47902f32983b92ec23dd44c7976a2361a
Author: Emily <lackersh@grinnell.edu>
Date:   Thu Feb 20 19:49:48 2025 -0600

    trying to fix cursor movement range error

commit 58553c7e995c2a9aabc378e26accf51d72e75e8d
Author: Emily <lackersh@grinnell.edu>
Date:   Thu Feb 20 19:47:05 2025 -0600

    fixed both delete methods so they should not be able to attempt to delete from the start

commit fcbfee8d704600c63e6b935232d3ac5e410ec6ac
Author: Emily <lackersh@grinnell.edu>
Date:   Thu Feb 20 19:40:50 2025 -0600

    fixed where there was accidentially some gap buffers in the string buffer tests

commit 178c38bb3999d8f9fa3ae61c26badf8d90f6289c
Author: Emily <lackersh@grinnell.edu>
Date:   Thu Feb 20 19:33:07 2025 -0600

    hopefully fixed delete front error

commit ec0fb62afbc954ef187a38de5726559d4bdb8e59
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Feb 19 23:03:32 2025 -0600

    i'm back - fixed more style

commit 07542daae3a1c05c04c0e488eaa8121ed94e8a38
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Feb 19 22:59:56 2025 -0600

    Fixed style - hopefully all of it if not i'll be back

commit d4a572c72e244e61b31ad8582a8208507394655b
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Feb 19 22:51:30 2025 -0600

    Updated some things based on gradesope

commit 85228655edb72638261f50c43c5d038b03e5bc35
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Feb 19 22:37:39 2025 -0600

    Updates javadoc

commit 8c6d31ec9cda876a30561bff086ae2c5bb4b8676
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Feb 19 22:31:52 2025 -0600

    Updates tests to account for some more edge cases

commit 481a9e0b8688582f0fb660ffd2a27c3f04bb7bb2
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Feb 19 22:21:35 2025 -0600

    Finished implementing gap buffer! Also, fixed some of the gap buffer tes
ts and noticed something to fix in the string buffer test. Also updated readme to reflect resource used.

commit 090d1cf445e5b061e2266a87356b3e58264816f7
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Feb 19 17:00:31 2025 -0600

    Made a bunch of variables private since they were just nothing before   

commit 555ae8b0387d3de88d63fe77a6dfbb496f4d8431
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Feb 19 16:56:18 2025 -0600

    Implemented gap buffer tests

commit 4692c3aa118eb651ed1c59be77b415b33034f3e7
Author: Emily <lackersh@grinnell.edu>
Date:   Wed Feb 19 16:51:22 2025 -0600

    Updated simple string buffer and the tests after seeing some of them were not working properly. Also started on gap buffer.

commit 2a2a869de56e0a689cd2aceefa04dd76c3bfa1ba
Author: Emily <lackersh@grinnell.edu>
Date:   Sun Feb 16 14:22:37 2025 -0600

    Analyzed simple string buffer for part two

commit ac96c0040c880d98babd638438065467f95a3682
Author: Emily <lackersh@grinnell.edu>
Date:   Sun Feb 16 14:17:25 2025 -0600

    fiexed delete so it is acctually implemented

commit bddb732f415eeed20359c223e5157737e95139f8
Author: Emily <lackersh@grinnell.edu>
Date:   Sun Feb 16 14:07:47 2025 -0600

    Updated readme

commit a5ba5de979b64c5b24299ba842b709e3a44436b9
Author: Emily <lackersh@grinnell.edu>
Date:   Sun Feb 16 14:05:29 2025 -0600

    Added the property test

commit 9fdcc509f49e982ab962b6105a0d0c46c64846ff
Author: Emily <lackersh@grinnell.edu>
Date:   Sun Feb 16 13:27:55 2025 -0600

    Wrote the tests for the simple string buffer

commit fbc998f0fc63d318f2a55878bc8a3a93bebd3e69
Author: Emily <lackersh@grinnell.edu>
Date:   Sat Feb 15 21:26:11 2025 -0600

    Wrote the functions in SimpleStringBuffer

commit b0d2af81a14cad61fa3d79ee170c8b7b9684c7eb
Author: Emily <lackersh@grinnell.edu>
Date:   Sat Feb 15 20:06:29 2025 -0600

    Updated readme

commit 32a90495f40bd92ce905d4d78fbdab4dbaa6d5f9 (upstream/main, upstream/HEAD)
Author: Peter-Michael Osera <osera@cs.grinnell.edu>
Date:   Thu Feb 13 12:40:05 2025 -0600

    Project files

commit 02dc92144ecc088bcefb4a9798df0934efe300c1
Author: Peter-Michael Osera <osera@cs.grinnell.edu>
Date:   Thu Feb 13 12:39:53 2025 -0600

    initial commit
