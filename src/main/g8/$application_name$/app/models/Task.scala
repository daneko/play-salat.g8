package models

import play.api.Play.current
import com.novus.salat._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._
import salatcontext._

case class Task(
  id: ObjectId = new ObjectId,
  label: String)

object Task extends ModelCompanion[Task, ObjectId] {

  val collection = mongoCollection("tasks")
  val dao = new SalatDAO[Task, ObjectId](collection = collection) {}
  
  def all = findAll.toList
  
  def create(label:String) = insert(Task(label = label))
  
  def delete(id:ObjectId) = removeById(id)
}
