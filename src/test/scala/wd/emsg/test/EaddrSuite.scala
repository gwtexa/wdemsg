package wd.emsg.test

import org.scalatest.FunSuite
import wd.emsg.Eaddr
import org.scalatest.matchers.ShouldMatchers
 
class EaddrSuite extends FunSuite with ShouldMatchers {
 
  test("Eaddr parse plain email") {
    val ea = Eaddr.parse("user@email.com")
    assert(ea.email === "user@email.com")
    assert(ea.personal === "")
  }
 
  test("Eaddr parse rfc822 personal <email>") {
    val ea = Eaddr.parse("Personal Name <user@email.com>")
    assert(ea.email === "user@email.com")
    assert(ea.personal === "Personal Name")
  }
}