package edu.knoldus

import java.sql.DriverManager

case class Client(x:Int)
{
    Class.forName("com.mysql.jdbc.Driver");
    val connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/knoldusdb","root",null);

    def insert(id:String,projid:String,name:String,address:String):Boolean=
    {

      val statement = connection.prepareStatement("insert into client values (?,?,?,?)")

      statement.setString(1,id)
      statement.setString(2,projid)
      statement.setString(3,name)
      statement.setString(4,address)


      val status = statement.executeUpdate();
      if(status>0) true else false // retuning true or false

    }
    def delete(id:String):Boolean=
    {
      val statement = connection.prepareStatement("delete  from client where ID=?");
      statement.setString(1,id)
      statement.executeUpdate();
      val statement1 = connection.prepareStatement("update project set Client_ID=null where  Client_ID=? ")
      statement1.setString(1,id)
      val status = statement1.executeUpdate();
      if(status>0) true else false // retuning true or false
    }

}

