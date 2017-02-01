package edu.knoldus

import org.scalatest.FunSuite

class DatabaseTest extends FunSuite{
  val client = Client(1)
  val dept = Department(1)
  val emp = Employee(1)
  val project = Project(1)

  test("Should Insert into Client")
  {
    assert(client.insert("c01", "p01", "Shubham", "Noida") )
  }

  test("Should Insert into Department")
  {
    assert(dept.insert("d001", "Scala"))

  }

  test("Should Insert into Employee")
  {
    assert(emp.insert("e01", "Charmy", "Noida", "7483948363", "d001", "p01"))
  }

  test("Should Insert into Project")
  {
    assert(project.insert("p01", "d001", "ScalaGeek", "c01"))
  }

  test("Should get Employee By ProjectID")
  {
    assert(emp.getEmployeeByProjectID("p01"))
  }

  test("Should get Employee By DepartmentID")
  {
    assert(emp.getEmployeeByDepartmentId("d001"))
  }

  test("Should delete from Employee")
  {
    assert(emp.delete("e01"))
  }

  test("Should delete from Department")
  {
    assert(dept.delete("d001"))
  }

  test("Should delete from Project")
  {
    assert(project.delete("p01"))
  }

}
