package controllers.chapter04a

/**
 * Created by david.a.brayfield on 13/04/2015.
 */
import models.chapter04a.User

import play.api.mvc._
import play.api.data.Forms._

import play.api.data._

object DataController extends Controller {

  def test = Action {

    val userForm = Form(
      mapping("firstName" -> text, "lastName" -> text)
        (User.apply)(User.unapply))

    val user = userForm.bind(Map("firstName"->"Rachel","lastName"->"Scott")).get

    Ok(views.html.chapter04a.data(user))
  }
}
