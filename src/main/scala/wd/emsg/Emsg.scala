package wd.emsg

/**
 * One message can be stored in many folders under different UIDs. How to prevent duplicates?
 * Is mboxEaddr, folder and uid a property of the Emsg?
 * Value object or entity? Let's make it an entity
 * 
 * TODO add attachment handling
 */

case class Emsg(
    //Emsg location params	
    mboxEaddr: Eaddr,
    folder: String, //folder fullName
    uid: Long,
    //Emsg header params
    fromEaddr: Eaddr,
    subject: String,
    //Emsg body. Can be None for lazy loading
    body: Option[String] = None
)





