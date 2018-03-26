1) web.xml: This file contains the Jersey servlet dispatcher that maps url requests to the Java Class End point methods.
2) HyperWallet: This is the complete Project folder with source files HyperWalletWS.java, ToDoTask.java and Jersey library files.
3) The various Uris for accessing the webervice methods are:
  a) http://localhost:8080/com.hyperwallet/HyperWalletToDoProject/create?Title=<Title>&Description=<Description> : To create a ToDo Item.
  b) http://localhost:8080/com.hyperwallet/HyperWalletToDoProject/delete?Type=<Type>&Value=<Value> : To Delete a ToDo Item.
  c) http://localhost:8080/com.hyperwallet/HyperWalletToDoProject/update?Title=<Title>&Description=<Description>&Completed=<Completed>: To  Update a ToDo Item.
  d) http://localhost:8080/com.hyperwallet/HyperWalletToDoProject/find?Type=<Type>&Value=<Value>: To retrieve a ToDo Item. 
