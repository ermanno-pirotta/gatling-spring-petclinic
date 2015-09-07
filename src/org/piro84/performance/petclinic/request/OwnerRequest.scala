package org.piro84.performance.petclinic.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
 * Contains requests related to the owners' page.
 */
object OwnerRequest {
  val ShowLanding= {
    exec(http("Navigate to owners page")
      .get("/petclinic/owners/find.html"))
  }
    
  val ListAllByLastName={
    exec(http("List owners by last name")
      .get("/petclinic/owners.html?lastName="))
  }
  
  val GetRandomOwner = {
		  exec(http("Get a random owner")
				  .get("/petclinic/owners/10.html"))
  }
}