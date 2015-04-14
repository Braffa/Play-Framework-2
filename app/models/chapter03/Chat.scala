package models.chapter03

/**
 * Created by david.a.brayfield on 13/04/2015.
 */

import org.joda.time.DateTime;

case class Chat(date:DateTime,
                occurrence:Int,
                items:Seq[Item])
