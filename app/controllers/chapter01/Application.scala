package controllers.chapter01

import play.api.mvc._

import play.api.libs.json.{JsObject, JsString}

object Application extends Controller {

  def index = Action {
    Ok(views.html.chapter01.index("Hey Dave It Really Works!"))
  }

  def jason = Action {
     Ok(JsObject(
        Seq("message" -> JsString("Json - hey Dave It Really Works !!"
          )
        )
      ))
  }
}