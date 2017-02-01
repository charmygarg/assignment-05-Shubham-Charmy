package edu.knoldus

import java.sql.DriverManager

case class Employee(x:Int)
{
  Class.forName("com.mysql.jdbc.Driver");
  val connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/knoldusdb","root",null);

  def insert(empid:String,ename:String,address:String,phone:String,departid:String,projid:String):Boolean=
  {

    val statement = connection.prepareStatement("insert into employee values (?,?,?,?,?,?)")

    statement.setString(1,empid)
    statement.setString(2,ename)
    statement.setString(3,address)
    statement.setString(4,phone)
    statement.setString(5,departid)
    statement.setString(6,projid)

    val status = statement.executeUpdate();
    if(status>0) true else false // retuning true or false

  }
  def delete(empid:String):Boolean=
  {
    val statement = connection.prepareStatement("delete  from employee where ID=?");
    statement.setString(1,empid)
    val status = statement.executeUpdate();
    if(status>0) true else false // retuning true or false
  }

  def getEmployeeByDepartmentId(depid:String):Boolean=
  {
    val statement = connection.prepareStatement("select * from employee where Dept_ID=Dept_ID");
    val result = statement.executeQuery();
    if (!result.next() )
    {
      false  //returning status
    } else
    {

      do {
        println(result.getString(1)+" , "+result.getString(2)+", "+result.getString(3)+" , "+result.getString(4));
      } while (result.next());

      true // returning status
    }


  }



  def getEmployeeByProjectID(projid:String):Boolean=
  {
    val statement = connection.prepareStatement("select * from employee where Project_ID=Project_ID");
    val result = statement.executeQuery();
    if (!result.next() )
    {
      false  //returning status
    } else
    {

      do {
        println(result.getString(1)+" , "+result.getString(2)+", "+result.getString(3)+" , "+result.getString(4));
      } while (result.next());

      true // returning status
    }
  }

}