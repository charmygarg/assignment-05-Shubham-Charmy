package edu.knoldus

import java.sql.DriverManager

case class Project(x:Int)
{
  Class.forName("com.mysql.jdbc.Driver");
  val connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/knoldusdb","root",null);

  def insert(id:String,depid:String,name:String,clientid:String):Boolean=
  {

    val statement = connection.prepareStatement("insert into project values (?,?,?,?)")

    statement.setString(1,id)
    statement.setString(2,depid)
    statement.setString(3,name)
    statement.setString(4,clientid)


    val status=statement.executeUpdate();


    if(status>0) true else false // retuning true or false

  }
  def delete(id:String):Boolean=
  {
    val statement = connection.prepareStatement("delete  from project where ID=?");
    statement.setString(1,id)
    statement.executeUpdate();
    val statement1 = connection.prepareStatement("update employee set Project_ID=null where  Project_ID=? ")
    val statement2 = connection.prepareStatement("delete from client  where Project_ID=?")
    statement1.setString(1,id)
    statement2.setString(1,id)
    statement1.executeUpdate();
    val status = statement2.executeUpdate();
    if(status>0) true else false // retuning true or false
  }

}
