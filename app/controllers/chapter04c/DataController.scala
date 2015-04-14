package controllers.chapter04c

/**
 * Created by david.a.brayfield on 13/04/2015.
 */
import models.chapter04c.User
import models.chapter04c.Address

import play.api.Logger
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._

object DataController extends Controller {

  lazy val userMapping: Mapping[User] =
    mapping(
      "firstName" -> nonEmptyText,
      "latsName" -> nonEmptyText,
      "age" -> number(min=0, max=150),
      "female" -> boolean,
      "address" -> addressMapping,
      "friends" -> ignored(Seq():Seq[User]),
      "spouse" -> ignored(None:Option[User])
    )(User.apply)(User.unapply)

  lazy val addressMapping =
    mapping(
      "fullStreet" -> nonEmptyText,
      "county" -> nonEmptyText,
      "country" -> nonEmptyText
    )(Address.apply)(Address.unapply)

  val userForm = Form[User](userMapping)

  def show = Action {
    Logger.info("DataController show")

    //val user = userForm.bind(Map("firstName"->"","lastName"->"")).get

    Ok(views.html.chapter04c.data(userForm))
  }

  def post = Action { implicit request =>
    Logger.info("DataController post")

    //val user = userForm.bindFromRequest.get

    //Logger.info(user.firstName + " " + user.lastName)

    Ok(views.html.chapter04c.data(userForm.bindFromRequest))
  }
}
