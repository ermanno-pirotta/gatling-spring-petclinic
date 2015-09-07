package org.piro84.performance.petclinic.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
 * Contains requests related to visits.
 */
object VisitRequest {
  val NavigateToNewVisitForm = {
		  exec(http("Navigate to the new visit form")
				  .get("/petclinic/owners/10/pets/13/visits/new"))
  }

  val AddNewVisit = {
		  exec(http("Add a new visit")
				  .post("/petclinic/owners/10/pets/13/visits/new")
				  .formParam("date", "2015/09/09")
				  .formParam("description", "test visit")
				  .formParam("petId", "13"))
  }
}