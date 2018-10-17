# EDAF60_OMD_XL

This is the report for

 + Elias Rudberg, `el0032ru-s`
 + Sofi Flink, `bmp13sfl`
 + Martin Gottlander , `bte15mgo`
 + Viktor Joelsson, `vi0842jo-s`

## Användarfall
When the user starts the program a window with a matrix is shown with different possible functionalities.

### Adding number 9 to cell A2.
The user adds a number to a cell when pressing and thereby selecting it. Pressing the A2 cell will result
in the cell turning yellow, thereby representing the cell as being the selected one. After that the user
will press the editor textfield and then entering number 9 through the keyboard. Pressing enter or any
other action will result in the cell updating and showing the number in the corresponding selected cell.

Trying to write the number in letters will simply not work.

### Adding an expression to a cell
If the user now also adds number 1 to cell A1, we can try and test if it works adding an expression to a cell.
The user selects B3 and writes "A1 + A2", this will result in the cell displaying 10. Selecting the cell will
result in the editor representing the expretion in the editor text field instead of the vaule combining the
two cells, but B3 will represent the value of the sum of the 2 cells, 10.

It will not make any difference if you use small letters, that is a1 instead of A1.

If the user tries to call on the cell itself nothing will happen. For example, trying to change the expression
in B3 from A1 + A2 to A1 + B3, nothing will happen, the cell won't update to the new expression. Selecting B3
again will result in the expression A1 + A2 showing in the editor textfield.

Trying to write 1 + B3 in the cell B3 will result in the value 0 being represented in cell A1, but the expression
won't be saved.

### Adding a comment to the cell
The user writes a comment when adding a # before the text in the text editor. In the cell the text will be
represented without the "#" but in the editor textfield when selecting the cell the text + the # will be
shown.

Writing text without the # won't work, nothing will be added to the cell.

Nothing happens when trying to operate on a cell with a comment. For example, 1 + #hej will result in the cell
representing only 1. Since the text does not hold any value.


### Saving an XL sheet
The user presses the "File" button and then "Save". The user can then decide what to name the file and what
location to save it, ending with .xl. This saves the file.

### Loading an XL sheet
The user presses the "File" button and then "Load". This opens the directory of the program, the user can then
locate the .xl file and by selecting it the file will load and show the previous saved data.

###  Printing an XL sheet
The user presses the "File" button, and then "Print". This opens a regular print window. A print screen of the
XL sheet will be possible to print out.

### Opening a new XL sheet
The user presses the "File" button, and then "New". This opens a new window with an XL sheet, the window will
be called Untitled-n, n is a counter starting from 0 counting up towards how many new XL sheets you are opening
for the session.

### Closing the program
The user presses the "File" button, and then close. The program will close.

It is also possible closing the program when pressing the "X" in the upper right corner.

### Clearing a cell
The user presses the "Edit" button and then "Clear" after selecting the cell the user wishes to clear.
This results in the cell turning empty.

It is not possible to clear a cell by deleting information in editor.

### Clearing an XL sheet
The user presses the "Edit" button and then "Clear all". This results in the whole sheet being emptied from
data.

## Klassdiagram

The model is in the file [`Package util class diagram.png`](UTIL.png):

<center>
    <img src="Package util class diagram.png" width="80%">
</center>

The model is in the file [`Package menu class diagram.png`](MENU.png):

<center>
    <img src="Package menu class diagram.png" width="80%">
</center>

The model is in the file [`Package gui class diagram.png`](GUI.png):

<center>
    <img src="Package gui class diagram.png" width="80%">
</center>

The model is in the file [`Package expr class diagram.png`](expr.png):

<center>
    <img src="Package expr class diagram.png" width="80%">
</center>

The model is in the file [`Package model class diagram.png`](model.png):

<center>
    <img src="Package model class diagram.png" width="80%">
</center>
