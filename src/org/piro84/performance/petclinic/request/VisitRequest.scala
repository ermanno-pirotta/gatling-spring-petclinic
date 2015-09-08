package org.piro84.performance.petclinic.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck

/**
 * Contains requests related to visits.
 */
object VisitRequest {

  def extractIdFromUrl(): String = {
    val urlElements="${visitLink}".split("/")
    urlElements.get(urlElements.length)
  }
  
  
  val NavigateToNewVisitForm = {
    exec(http("Navigate to the new visit form")
      .get("${visitLink}"))
  }

  val AddNewVisit = {
    exec(http("Add a new visit")
      .post("${visitLink}")
      .formParam("date", "2015/09/09")
      .formParam("description", "test")
      .formParam("petId", extractIdFromUrl))
  }
}