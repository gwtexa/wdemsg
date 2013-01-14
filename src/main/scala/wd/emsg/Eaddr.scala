package wd.emsg

case class Eaddr(email: String, personal: String) {
}

object Eaddr {
  def apply(email: String) = new Eaddr(email, "")
  def apply() = new Eaddr("", "")
  /**
   * Parse email address or rfc822 personal/email
   * We don't throw exceptions. In case of bad format return empty Eaddr and log parsing problem
   */
  def parse(addr: String): Eaddr = {
    val reg = """(?i)\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b""".r
    val email = reg.findAllIn(addr).toList.lastOption match {
      case Some(e) => e
      //TODO log parsing problem
      case None => ""
    }
    if (email.isEmpty) {
      Eaddr()
    } else {
      if (addr.count( _ == '<') == 1 && addr.count( _ == '>') == 1 && addr.contains("<" + email + ">")) {
        Eaddr(email, addr.takeWhile( _ != '<').trim)
      } else {
        Eaddr(email)
      } 
    }
  }
}