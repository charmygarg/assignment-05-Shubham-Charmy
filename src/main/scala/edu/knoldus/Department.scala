package edu.knoldus

import java.sql.DriverManager

case class Department (x:Int)
{
  Class.forName("com.mysql.jdbc.Driver");
  val connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/knoldusdb","root",null);

  def insert(id:String,name:String):Boolean=
  {

    val statement = connection.prepareStatement("insert into department values (?,?)")

    statement.setString(1,id)
    statement.setString(2,name)


    val status = statement.executeUpdate();
    if(status>0) true else false // retuning true or false

  }
  def delete(id:String):Boolean=
  {
    val statement = connection.prepareStatement("delete  from department where ID=?");
    statement.setString(1,id)
    statement.executeUpdate();


    val statement1 = connection.prepareStatement("update employee set Dept_ID=null where  Dept_ID=? ")
    statement1.setString(1,id)
    val statement2 = connection.prepareStatement("update Project set Dept_ID=null where  Dept_ID=? ")
    statement2.setString(1,id)
    statement1.executeUpdate();
    val status=statement2.executeUpdate();

    if(status>0) true else false // retuning true or false


  }

}













