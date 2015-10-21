# ramses-simulator
A Ramses-architecture signal simulator.


It processes the entry of a series of Ramses microinstructions and simulates de data flow inside the Ramses circuit, electronic element by electronic element.
The input format is as follows, in order:

- Charge register A, Charge Register B, Charge Register X, Set select 1 value, Set select 2 value, ALU operation (3 bits), Charge N flag, Charge C flag, Charge C flag,  Set select 5 value, Increment PC, Charge PC, Set select 3 value, Set select 4 value, Charge register RI, Charge REM, Activate read operation, Activate write operation, Charge RDM.


Another archive containing the computer's initial memory should be created, with one number per line, from the range -128 to 127 since we're dealing with a 8-bit architecture.


