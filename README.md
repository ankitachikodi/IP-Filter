# IP-Filter
 
# Testing
JUnit testing was performed covering all the test scenarios and test cases.
input.csv file contains different test cases as input to JUnit testing.

# Design
To keep the design clean, reusable and scalable, I have divided the code based on classes such as Firewall, IP Address, Port and Rule. The program is optimized with  minimal code to increase performance.

# Program Details
- Firewall class contains two main methods:
    1. Accepts and writes rules to an Arraylist
    2. Acccepts incoming packets and checks against rules returning true if the packet passes all rules

- IpAddress, Port and Rule classes contain parser and filter methods to parse port and Ip ranges and check them against the firewall rules provided.


# Refinements
In case of large number of rules, the files can be run on multiple threads parallely to handle the bulk data.

# Teams
Platform team
