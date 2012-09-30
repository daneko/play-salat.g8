package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import models._
import com.mongodb.casbah.Imports.ObjectId

object TaskController extends Controller {
  val taskForm = Form("label" -> nonEmptyText)

  def index = Action {
    Ok(views.html.tasks.index(Task.all, taskForm))
  }

  def newTask = Action {
    implicit request =>
      taskForm.bindFromRequest.fold(
        errors => BadRequest(views.html.tasks.index(Task.all, errors)),
        label => {
          Task.create(label)
          Redirect(routes.TaskController.index)
        })
  }

  def deleteTask(id: ObjectId) = Action{
    Task.delete(id)
    Redirect(routes.TaskController.index)
  }
}