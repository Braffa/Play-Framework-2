package models.chapter04c

/**
 * Created by david.a.brayfield on 13/04/2015.
 */

case class User (var firstName: String,
                 var lastName: String,
                 age: Int,
                 female:Boolean,
                 address: Address,
                 friends: Seq[User],
                 spouse: Option[User]) {

  firstName  = capitalise(firstName)
  lastName = capitalise(lastName)

  def isDefined : Boolean = {if (firstName == "" && lastName == "")
                                  false
                                  else true}

  def capitalise(name: String) = {
    name.toLowerCase.split(" ").map(_.capitalize).mkString(" ").split("-").map(_.capitalize).mkString("-")
  }
}