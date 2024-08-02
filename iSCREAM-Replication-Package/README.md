# iSCREAM
iSCREAM (suite for Smart Contract REAdability assessMent) is a tool for helping developers and researchers more easily estimating the code readability of Solidity smart contracts.
It supports the following readability metrics:
|ID | Metric| Avg | Max |
|:---:|:-------:|:-----:|:-----:|
|1 | Assignment |  X |  |                              
|2 | Blank Line |  X |  |	 							
|3 | Commas | X |  |			 						
|4 | Comments | X | |			 						
|5 | Comparisons | X | |					 			
|6 | Conditionals |   X |  | 							
|7 | Identifier Length |   X | X 	|			
|8 | Indentation | X | X |					
|9 | Keywords |   X | X |						
|10 | Line Length | X | X |					
|11 | Loops | X | |									
|12 | N. of identifiers |  X | X |			
|13 | N. of numbers | X | X |					
|14 | Operators | X | |								
|15 | Parenthesis | X |  |								
|16 | Periods | X |  |									
|17 | Spaces | X |  |									
|18 | Occurrences of any character |    | X | 			
|19 | Occurrences of any identifier |    | X | 	

## Building the tool

You can build the tool with Maven to get an executable jar file:

```
mvn package
```

## Using the tool
iSCREAM   provides   a   user-friendly   graphical   interface(GUI).  Alternatively,  it  can  also  be  used  from  the  command line.
### 1) Using via GUI
Go to folder 'target', double click on 'iSCREAM-jar-with-dependencies.jar'. When  launching  the  GUI,  a  home  screen  containing two buttons is visualized (as shown in next figure).

![Start2](https://user-images.githubusercontent.com/19287382/121712524-1fcbd500-cadc-11eb-8310-898d8c064bc2.PNG)

The button 'Upload smart contract' allows users to select a smart contract (or a set of smart  contracts) and compute the readability metrics in each function(s)  comprised  in  the selected smart contract(s).

![image](https://user-images.githubusercontent.com/19287382/121713357-1000c080-cadd-11eb-832f-c198c25657dc.png)

When click on button 'Open', the tool calculate redability metric and show result into table (as shown in next figure).

![image](https://user-images.githubusercontent.com/19287382/121713923-a9c86d80-cadd-11eb-91ec-ea0ac3479019.png)

When you click the 'Export csv' button, the results are exported to a CSV file.

### 2) Using via command line

The built jar requires two parameters:
 1) Path directory smart contracts or path single smart contract;
 2) Name of result file csv.
 
```
java -jar iSCREAM-jar-with-dependencies.jar -p <path directory smart contracts or path single smart contract> -o <choose a name of result file csv>
```

## Credits

The parser is based on the antlr4 grammar available at https://github.com/solidityj/solidity-antlr4.
