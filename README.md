# JAVA Advanced Concepts
### File System
- File Input Strean , File Output stream
- File Reader , File Writer
- Buffered Input Strean , Buffered Output stream
- Buffered Reader , Buffered Writer
- File class and Built-in methods in File class
  
### Serialization and Deserialization
- Object OutputStream , Object Input Stream
- transient Keyword
- Serial Version UID
### Socket Based Programming
**Client**
- A client socket gets created
- A request for connection will be sent to the server
-  Data to be transmitted is collected output stream which is associated with Data output stream is created
-  The data transmitted on to the stream
**Server**
- Gets the connect Request from client
- Listner will accept the request & redirect it to another socket
- Input stream which is associated with Data Input Stream is created
- It will accept the data from the streams
- The data gets collect on the Server
### JDBC Connection
- Load the driver
- Establish the conection
- prepare the sql query
- convert sql query into java based statement
- capture the results
- close all the active connections
### JDBC Topics
- Statement Interface : createStatement() (We use this when we don't take input from the user)
- Prepared Statement  : prepareStatement() (We use this when we wannatake input fro the user for the sql query)
- executeQuery()      : DQL
- executeUpdate()     : DDL ,DML
- ResultSet           : To store results of the sql (DQL) query
- Transation Managemet , Batch Commits


  
  
