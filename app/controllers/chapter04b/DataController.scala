package controllers.chapter04b

/**
 * Created by david.a.brayfield on 13/04/2015.
 */
import models.chapter04b.User

import play.api.Logger
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object DataController extends Controller {

  val userForm = Form(
    mapping("firstName" -> text, "lastName" -> text)
      (User.apply)(User.unapply))

  def show = Action {
    Logger.info("DataController show")

    val user = userForm.bind(Map("firstName"->"","lastName"->"")).get

    Ok(views.html.chapter04b.data(user))
  }

  def post = Action { implicit request =>
    Logger.info("DataController post")
    val user = userForm.bindFromRequest.get

    Logger.info(user.firstName + " " + user.lastName)

    Ok(views.html.chapter04b.data(user))
  }
}
