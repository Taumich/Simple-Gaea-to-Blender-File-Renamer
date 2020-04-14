# Simple-Gaea-to-Blender-File-Renamer

This is a simple script in Java that converts the naming format of Gaea tiles into Blender UDIM tile names.

Examples:
*_y000_x001 converts to *_1002
"Color_y000_x001.png" converts to "Color_1002.png"

This program runs through the CLI or Terminal using the following commands:

To compile the script, use the following command:
```
javac GaeaToBlender.java
```

To run the script, use the following command, where <file_name> is "Color" for files named Color_y000_x001:
```
java G2B_rename <file_name>
```


The renaming conventions can be modified by using commands that can be found by typing
```
java G2B_rename -h
```

The responded commands are the following:
```
Commands:
 -i, -inspect
 -r, -rev, -reverse
 -o <name>, -out <name>, -output <name>
 -f <filetype>, -type <filetype>, -filetype <filetype>

End
```
